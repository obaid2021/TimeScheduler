package databaseManagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import start.Welcome;
/**
 * This class reads the booked appointments from the database.it can also read the priorities of the appointments
 * @author Muhammad Obaid Ullah, Syed Adil Ehsan, Rao Shahan Naveed
 *
 */

public class CheckAppointment {
	String checkDate;
/**
 * This function checks if an appointment is booked on a particular day for the logged in user.
 * @param date date on which the appointment will be checked.
 * @param username profile that is logged in.
 * @return if the appointment exists it returns true else false.
 * @throws SQLException Sql connectivity and command errors will be checked.
 */
	public boolean check_appointment_of_month(String date, String username) throws SQLException {
		Statement stmt = Welcome.con.createStatement();

		ResultSet rs = stmt.executeQuery("select * from event_schedule where username= '" + username + "'");

		while (rs.next()) {
			checkDate = rs.getString("start_date");

			if (date.equals(checkDate)) {
				return true;
			}
		}
		return false;
	}
/**
 * This function reads the end date from the database for a given event name.
 * @param date starting date of the event.
 * @param username profile which is logged in.
 * @param title title of the event.
 * @return returns the end date of the event.
 * @throws SQLException Sql connectivity and command errors will be checked.
 */
	public String check_end_appointment_day(String date, String username, String title) throws SQLException {
		Statement stmt = Welcome.con.createStatement();

		ResultSet rs = stmt.executeQuery("select * from event_schedule where username= '" + username
				+ "' and start_date = '" + date + "'" + "and name_of_event = '" + title + "'");

		while (rs.next()) {
			checkDate = rs.getString("end_date");

		}
		return checkDate;
	}
/**
 * This function checks if there is any appointment booked on the selected day.
 * @param username profile that is logged in.
 * @param date start date of the event.
 * @param checkDate the date that is to be checked.
 * @return returns the priority of the event.
 * @throws SQLException Sql connectivity and command errors will be checked.
 */
	public String check_middle_date(String username, String date, String checkDate) throws SQLException {
		String priority = "empty";
		Statement stmt = Welcome.con.createStatement();
		ResultSet rs = stmt.executeQuery(
				"select * from event_schedule where username= '" + username + "' and start_date = '" + date + "'");
		int start, end, check;
		String endDate;
		while (rs.next()) {
			endDate = rs.getString("end_date");

			if (!date.substring(5, 6).equals(",")) {
				start = Integer.parseInt(date.substring(4, 6));
			} else {
				start = Integer.parseInt(date.substring(4, 5));
			}
			if (!endDate.substring(5, 6).equals(",")) {
				end = Integer.parseInt(endDate.substring(4, 6));
			} else {
				end = Integer.parseInt(endDate.substring(4, 5));
			}
			if (!checkDate.substring(5, 6).equals(",")) {
				check = Integer.parseInt(checkDate.substring(4, 6));
			} else {
				check = Integer.parseInt(checkDate.substring(4, 5));
			}
			if (check > start && check < end) {
				priority = rs.getString("priority");
				return priority;
			}
		}

		return priority;
	}
/**
 * This function returns the end date of the event whose start date is given.
 * @param date this is the start date of the event.
 * @param username profile which is logged in.
 * @return returns the end date of the event.
 * @throws SQLException Sql connectivity and command errors will be checked.
 */
	public String get_end_date(String date, String username) throws SQLException {
		Statement stmt = Welcome.con.createStatement();

		ResultSet rs = stmt.executeQuery(
				"select * from event_schedule where username= '" + username + "' and start_date = '" + date + "'");

		while (rs.next()) {
			checkDate = rs.getString("end_date");

		}
		return checkDate;
	}
/**
 * this function reads the title of an event from the database
 * @param date start date of the event
 * @param username profile which is logged in
 * @param time start time of the event
 * @return returns the title of the event
 * @throws SQLException Sql connectivity and command errors will be checked
 */
	public String get_title(String date, String username, String time) throws SQLException {
		String checkTime;
		Statement stmt = Welcome.con.createStatement();
		String title = " ";
		ResultSet rs = stmt.executeQuery("select * from event_schedule where username= '" + username + "' and "
				+ " start_date= '" + date + "' ");

		while (rs.next()) {
			checkDate = rs.getString("start_date");
			checkTime = rs.getString("start_time");
			title = rs.getString("name_of_event");
			if (time.equals(checkTime.substring(0, 3))) {
				return title;
			}
		}
		return " ";
	}
/**
 * This function returns the end time of the event for a title.
 * @param username profile which is logged in.
 * @param title name of the event.
 * @return  returns the ending time of the event.
 * @throws SQLException Sql connectivity and command errors will be checked.
 */
	public String get_end_time_title(String username, String title) throws SQLException {
		String endTime = "";
		String usernameDatabase;
		Statement stmt = Welcome.con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from event_schedule where username= '" + username + "' and "
				+ " name_of_event= '" + title + "' ");
		while (rs.next()) {
			endTime = rs.getString("end_time");
			usernameDatabase = rs.getString("username");
			if (username.equals(usernameDatabase)) {
				return endTime;
			}
		}
		return endTime;
	}
/**
 * This function returns the end time of the event for the given end date.
 * @param username profile that is logged in.
 * @param endDate ending date of the event .
 * @return returns the end time of the event.
 * @throws SQLException Sql connectivity and command errors will be checked.
 */
	public String get_endtime(String username, String endDate) throws SQLException {
		String endTime = "";
		Statement stmt = Welcome.con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from event_schedule where username= '" + username + "' and "
				+ " end_date= '" + endDate + "' ");
		while (rs.next()) {
			endTime = rs.getString("end_time");

		}
		return endTime;
	}
/**
 * This function reads the priority of an event from the database for a given end time and end date
 * @param username profile which is logged in.
 * @param date end date of an event.
 * @param endTime end time of an event.
 * @return returns the priority of an event.
 * @throws SQLException Sql connectivity and command errors will be checked.
 */
	public String get_priority_end(String username, String date, String endTime) throws SQLException {
		String priority = "white";
		Statement stmt = Welcome.con.createStatement();
		String checkTime;
		ResultSet rs = stmt.executeQuery("select * from event_schedule where username= '" + username + "' and "
				+ " end_date= '" + date + "'   ");

		while (rs.next()) {
			priority = rs.getString("priority");

			if (priority.equals("high")) {
				return "h ";
			}
			if (priority.equals("medium")) {
				return "m ";
			}
			if (priority.equals("low")) {
				return "l ";

			}

		}
		return "f ";

	}
/**
 * This function reads the priority of the event from the database for the start date and start time.
 * @param username profile which is logged in.
 * @param date start date of the event.
 * @param startTime start time of the event.
 * @return returns the priority of an event.
 * @throws SQLException Sql connectivity and command errors will be checked.
 */
	public String get_priority_start(String username, String date, String startTime) throws SQLException {

		String priority = "white";
		Statement stmt = Welcome.con.createStatement();
		String checkTime;
		ResultSet rs = stmt.executeQuery("select * from event_schedule where username= '" + username + "' and "
				+ " start_date= '" + date + "' ");

		while (rs.next()) {
			priority = rs.getString("priority");
			checkTime = rs.getString("start_time");
			if (startTime.equals(checkTime.substring(0, 3))) {
				if (priority.equals("high")) {
					return "h ";
				}
				if (priority.equals("medium")) {
					return "m ";
				}
				if (priority.equals("low")) {
					return "l ";
				}
			}

		}
		return "f ";
	}
}
