package databaseManagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFileChooser;

import start.Welcome;
/**
 * This class can read and write a file from / to database.
 * @author Muhammad Obaid Ullah , Syed Adil Ehsan , Rao Shahan Naveed
 *
 */
public class FileManagement {
	Statement stmt;
	PreparedStatement pstmt;
/**
 * This function write a file in the database. 
 * @param file File that will be uploaded in database
 * @param eventID id of the event to which the file is attached
 * @param fileName name of the file 
 * @throws SQLException Sql connectivity and command errors will be checked
 * @throws FileNotFoundException errors in file reading etc
 */
	public void upload_file_in_database(File file, int eventID, String fileName)
			throws SQLException, FileNotFoundException {
		int id = read_previous_file_id(eventID);
		id++;
		pstmt = Welcome.con.prepareStatement("insert into file values(?,?,?,?)");
		FileReader readFile = new FileReader(file);
		pstmt.setInt(1, id);
		pstmt.setInt(2, eventID);
		pstmt.setString(3, fileName);
		pstmt.setCharacterStream(4, readFile, file.length());
		pstmt.executeUpdate();
	}
/**
 * This function reads the last file id 
 * @param eventID id of the event to which the file is attached
 * @return returns the last file id
 * @throws SQLException Sql connectivity and command errors will be checked
 */
	public int read_previous_file_id(int eventID) throws SQLException {
		int number = 0;
		stmt = Welcome.con.createStatement();

		ResultSet rs = stmt.executeQuery("select * from file" + "  where id = (select MAX(id) from file)");
		while (rs.next()) {
			number = rs.getInt("id");

		}

		return number;
	}
/**
 * This function reads the file from the database.
 * @param filename Name of the file that is to be read.
 * @param eventID id of the event to which the file is attached.
 * @throws SQLException Sql connectivity and command errors will be checked
 * @throws IOException Input Output file exceptions
 */
	public void read_file_database(String filename, int eventID) throws SQLException, IOException {
		stmt = Welcome.con.createStatement();
		ResultSet rs = stmt.executeQuery(
				"select * from file where event_id = '" + eventID + "'" + "and file_name = '" + filename + "'");
		while (rs.next()) {
			Clob clb = rs.getClob("file");
			Reader read = clb.getCharacterStream();
			JFileChooser filepath = new JFileChooser();
			filepath.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int x = filepath.showSaveDialog(null);
			String path;
			if (x == JFileChooser.APPROVE_OPTION) {
				path = filepath.getSelectedFile().getPath() + "\\" + filename;
				FileWriter writer = new FileWriter(path);
				int i;
				while ((i = read.read()) != -1) {
					writer.write((char) i);
				}
				writer.close();
			}

		}
	}
}
