package databaseManagement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import start.Welcome;

/**
 * This class can upload and download the secret key of each profile to database
 * 
 * @author Muhammad Obaid Ullah , Syed Adil Ehsan , Rao Shahan Naveed
 *
 */
public class SecretKeyManager {
	/**
	 * This function uploads the secret key to the database.
	 * 
	 * @param key      the two digit number used as secret key.
	 * @param username profile's username , to which the secret key belongs
	 * @throws SQLException Sql connectivity and command errors will be checked
	 */
	public void upload_secretkey(int key, String username) throws SQLException {

		PreparedStatement stmt = Welcome.con.prepareStatement("INSERT INTO secret_key VALUES (?,?)");
		stmt.setString(1, username);
		stmt.setInt(2, key);
		stmt.execute();
	}

	/**
	 * 
	 * @param username profile's username , to which the secret key belongs.
	 * @return returns the two digit secret key
	 * @throws SQLException Sql connectivity and command errors will be checked
	 */
	public int download_secretkey(String username) throws SQLException {
		Statement stmt = Welcome.con.createStatement();
		int seckey = 0;

		ResultSet rs = stmt.executeQuery("select * from secret_key where username='" + username + "'");
		while (rs.next()) {
			seckey = rs.getInt("secret_key");
		}
		return seckey;
	}
}
