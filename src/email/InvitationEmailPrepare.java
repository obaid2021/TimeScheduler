package email;

import warnings.Error;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.mail.MessagingException;

import encryption.Decrypt;
import start.Welcome;

/**
 * This Class reads the participants from the database and sends each
 * participant an invitation via email.
 * 
 * @author Muhammad Obaid Ullah , Syed Adil Ehsan , Rao Shahan Naveed
 *
 */
public class InvitationEmailPrepare {
	boolean isvalid = false;

	/**
	 * This functions reads the participants of a particular event from the
	 * database. Each participant will get an email.
	 * 
	 * @param eventID  eventId of the event, of which an invitation will be sent.
	 * @param username profile id of the user that is logged in.
	 * @throws SQLException       error message during sql commands execution.
	 * @throws MessagingException errors during connection with mail server.
	 */

	public void event_creation_email(int eventID, String username) throws SQLException, MessagingException {
		Statement stmt;
		stmt = Welcome.con.createStatement();
		EmailValidity check = new EmailValidity();
		String email, name;
		ResultSet rs = stmt.executeQuery("select * from participants where event_schedule_id = '" + eventID + "'");

		while (rs.next()) {
			email = rs.getString("email");
			name = rs.getString("name");
			isvalid = check.isValidEmailAddress(email);
			if (isvalid) {
				send_email_invitation(email, name, eventID, username);
			} else {
				Error err = new Error();
				err.errorMessage(email + " is not valid");
			}
		}

	}

	public void event_deleteion_email(int eventID, String username) throws SQLException, MessagingException {
		Statement stmt;
		stmt = Welcome.con.createStatement();
		EmailValidity check = new EmailValidity();
		String email, name;
		ResultSet rs = stmt.executeQuery("select * from participants where event_schedule_id = '" + eventID + "'");

		while (rs.next()) {
			email = rs.getString("email");
			name = rs.getString("name");
			isvalid = check.isValidEmailAddress(email);
			if (isvalid) {
				send_email_cancellation(email, name, eventID, username);
			} else {
				Error err = new Error();
				err.errorMessage(email + " is not valid");
			}
		}

	}

	/**
	 * 
	 * @param email    particpant's email read from database.
	 * @param name     particiapnt's name read from database.
	 * @param eventID  event id of the event.
	 * @param username Profile of the user who is logged in.
	 * @throws SQLException       error messages during sql commands execution.
	 * @throws MessagingException errors during connection with mail server.
	 */
	public void send_email_invitation(String email, String name, int eventID, String username)
			throws SQLException, MessagingException {
		Statement stmt = Welcome.con.createStatement();
		String subject = "Invitation to Event";
		String msg, nameOfEvent = null, enddate = null, startdate = null, startTime = null, endTime = null,
				location = null, priority = null;
		String invitationFirstname = null, invitationSecondName = null;

		ResultSet rs = stmt.executeQuery("select * from event_schedule where id='" + eventID + "'");
		while (rs.next()) {

			nameOfEvent = rs.getString(3);
			startdate = rs.getString(4);
			enddate = rs.getString(5);
			startTime = rs.getString(6);
			endTime = rs.getString(7);
			location = rs.getString(8);
			priority = rs.getString(9);

		}
		rs = stmt.executeQuery("select * from register_user where username='" + username + "'");
		while (rs.next()) {
			invitationFirstname = rs.getString(2);
			invitationSecondName = rs.getString(3);
		}
		int secKey = 0;
		rs = stmt.executeQuery("select * from secret_key where username='" + username + "'");
		while (rs.next()) {
			secKey = rs.getInt("secret_key");
		}
		invitationFirstname = Decrypt.decrypt(invitationFirstname, secKey);
		msg = "Dear " + name + "\n" + invitationFirstname + " has invited you to the following event."
				+ "\n Name Of Event: " + nameOfEvent + "\n Start Date: " + startdate + "\n End Date: " + enddate
				+ "\n Starts at: " + startTime + "\n Ends at: " + endTime + "\n Location: " + location + "\n Priority: "
				+ priority;
		SendEmail sendEmail = new SendEmail();
		sendEmail.send_email(email, subject, msg);
	}

	public void send_email_cancellation(String email, String name, int eventID, String username)
			throws SQLException, MessagingException {
		Statement stmt = Welcome.con.createStatement();
		String subject = "Cancellation to Event";
		String msg, nameOfEvent = null, enddate = null, startdate = null, startTime = null, endTime = null,
				location = null, priority = null;
		String invitationFirstname = null, invitationSecondName = null;

		ResultSet rs = stmt.executeQuery("select * from event_schedule where id='" + eventID + "'");
		while (rs.next()) {

			nameOfEvent = rs.getString(3);
			startdate = rs.getString(4);
			enddate = rs.getString(5);
			startTime = rs.getString(6);
			endTime = rs.getString(7);
			location = rs.getString(8);
			priority = rs.getString(9);
		}
		rs = stmt.executeQuery("select * from register_user where username='" + username + "'");
		while (rs.next()) {
			invitationFirstname = rs.getString(2);
			invitationSecondName = rs.getString(3);
		}

		msg = "Dear " + name + "\n The following event has been cancelled." + "\n Name Of Event: " + nameOfEvent
				+ "\n Start Date: " + startdate + "\n End Date: " + enddate + "\n Starts at: " + startTime
				+ "\n Ends at: " + endTime + "\n Location: " + location + "\n Priority: " + priority;
		SendEmail sendEmail = new SendEmail();
		sendEmail.send_email(email, subject, msg);
	}
}
