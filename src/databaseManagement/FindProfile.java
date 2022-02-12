package databaseManagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import encryption.Decrypt;
import start.Login;
import start.Welcome;
 
import userInterface.ViewMonth;
import warnings.Error;
/**
 * This class finds the profile in the database.
 * @author Muhammad Obaid Ullah , Syed Adil Ehsan , Rao Shahan Naveed
 *
 */
public class FindProfile {
	/**
	 * This functions finds the entered username in the database.If a username is matched,
	 * it will further check if the password matches with the entered string.
	 * @param username entered username in login window
	 * @param password entered password in login window
	 * @throws SQLException Sql connectivity and command errors will be checked
	 */
	public void profileExists(String username, String password) throws SQLException {
		Statement stmt2 = Welcome.con.createStatement();

		ResultSet rs = stmt2.executeQuery("select * from register_user where username = '" + username + "'");
		String username1 = "";
		String password1 = "";
		while (rs.next()) {

			username1 = rs.getString("username");
			password1 = rs.getString("password");
			
		}
		SecretKeyManager getkey = new SecretKeyManager();
		int key = getkey.download_secretkey(username1);
	 
		password1 = Decrypt.decrypt(password1, key);
		Error window = new Error();
		if (username.equals(username1) && password.equals(password1)) {
			ViewMonth window2 = new ViewMonth();
			window2.view_month(username1);
		} else {
			window.errorWarning("Wrong Username or Password");
			Login window1 = new Login();
			window1.login();
		}
	}
}
