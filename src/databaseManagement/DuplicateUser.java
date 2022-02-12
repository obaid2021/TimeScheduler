package databaseManagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import start.Welcome;

/**
 * This class finds the duplicate entries in the database of user profiles.
 * 
 * @author Muhammad Obaid Ullah , Syed Adil Ehsan , Rao Shahan Naveed
 *
 */
public class DuplicateUser {
/**
 * This function goes throw all the entries of user profiles in the database and check if a username or email<p>
 * already exists. If it does , boolean value true will be returned else false will be returned.
 * @param username username of the profile 
 * @param email email of the profile
 * @return true if duplicate is found else false.
 * @throws SQLException Sql connectivity and command errors will be checked
 */
	public boolean check_duplicate_in_database(String username, String email) throws SQLException {
		boolean ret = false;
		Statement stmt = Welcome.con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from register_user where username= '" + username + "'");

		String input = "";
		while (rs.next()) {
			input = rs.getString("username");
			ret = true;
		}
		rs = stmt.executeQuery("select * from register_user where email= '" + email + "'");

		while (rs.next()) {
			input = rs.getString("email");
			ret = true;
		}
		return ret;
	}
}
