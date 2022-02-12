package databaseManagement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import admin.Admin;
import start.Welcome;

/**
 * This class can upload , download user's registration information.
 * <p>
 * Complete profile along with events can be deleted by using this class.
 * 
 * @author Muhammad Obaid Ullah , Syed Adil Ehsan , Rao Shahan Naveed
 *
 */

public class UserInformation {
	static PreparedStatement stmt;
	static Statement stmt1;

	/**
	 * This function uploads user's data in regitser_user table of the database
	 * @param usrN     username entered by user
	 * @param fN       first name of the user
	 * @param lN       last name of the user
	 * @param email    email address of the user
	 * @param password password entered by the user
	 * @throws SQLException Sql connectivity and command errors will be checked
	 */
	public void uploadInfo(String usrN, String fN, String lN, String email, String password) throws SQLException {

		stmt = Welcome.con.prepareStatement("INSERT INTO register_user VALUES (?,?,?,?,?)");
		stmt.setString(1, usrN);
		stmt.setString(2, fN);
		stmt.setString(3, lN);
		stmt.setString(4, email);
		stmt.setString(5, password);

		stmt.execute();

	}
/**
 * This function can read user's information from the database and put it in the required table in GUI.
 * @throws SQLException Sql connectivity and command errors will be checked
 */
	public void downloadInformation() throws SQLException {
		stmt1 = Welcome.con.createStatement();
		String username, firstname, lastname, email, password;
		DefaultTableModel tableModel = (DefaultTableModel) Admin.table_1.getModel();
		ResultSet rs = stmt1.executeQuery("select * from register_user");
		while (rs.next()) {
			username = rs.getString(1);
			firstname = rs.getString(2);
			lastname = rs.getString(3);
			email = rs.getString(4);
			password = rs.getString(5);
			tableModel.addRow(new Object[] { username, firstname, lastname, email, password });
		}

	}
/**
 * This function finds the profile from database that is to be deleted.
 * @param username profile id of the user that is to be deleted.
 * @throws SQLException Sql connectivity and command errors will be checked
 */ 
	public void deleleProfile(String username) throws SQLException {

		int id;
		stmt1 = Welcome.con.createStatement();
		ResultSet rs = stmt1.executeQuery("select * from event_schedule where username = '" + username + "'");
		while (rs.next()) {
			id = rs.getInt(1);
			delete_from_file(id);
			delete_from_participants(id);
		}
		delete_from_events(username);
		delete_from_users(username);

	}
/**
 * This function deletes the events booked on given username 
 * @param username user's profile id that is to be deleted
 * @throws SQLException Sql connectivity and command errors will be checked
 */
	public void delete_from_events(String username) throws SQLException {
		stmt = Welcome.con.prepareStatement("DELETE from event_schedule where username=(?)");
		stmt.setString(1, username);
		stmt.executeUpdate();
	}
	/**
	 * This function deletes the user data of given username 
	 * @param username user's profile id that is to be deleted
	 * @throws SQLException Sql connectivity and command errors will be checked
	 */
	public void delete_from_users(String username) throws SQLException {
		stmt = Welcome.con.prepareStatement("DELETE from register_user where username=(?)");
		stmt.setString(1, username);
		stmt.executeUpdate();
	}
	/**
	 * This function deletes the files uploaded on all events of given id 
	 * @param id event id 
	 * @throws SQLException Sql connectivity and command errors will be checked
	 */
	public void delete_from_file(int id) throws SQLException {
		stmt = Welcome.con.prepareStatement("DELETE from file where event_id=(?)");
		stmt.setInt(1, id);
		stmt.executeUpdate();
	}
	/**
	 * This function deletes all participants added on given id 
	 * @param id event id
	 * @throws SQLException Sql connectivity and command errors will be checked
	 */
	public void delete_from_participants(int id) throws SQLException {
		stmt = Welcome.con.prepareStatement("DELETE from participants where event_schedule_id=(?)");
		stmt.setInt(1, id);
		stmt.executeUpdate();
	}
/**
 * This function updates an already existing profile
 * @param username Profile's username
 * @param firstname Profile's first name
 * @param lastname Profile's first name
 * @param email Profile's email
 * @param password Profile's password
 * @throws SQLException Sql connectivity and command errors will be checked
 */ 
	public void update_info(String username, String firstname, String lastname, String email, String password)
			throws SQLException {
		stmt = Welcome.con.prepareStatement("update register_user set firstname=(?) , lastname =(?)  , "
				+ " email =(?) , password = (?) where username =(?)");
		stmt.setString(1, firstname);
		stmt.setString(2, lastname);
		stmt.setString(3, email);
		stmt.setString(4, password);
		stmt.setString(5, username);

		stmt.executeUpdate();
	}
}
