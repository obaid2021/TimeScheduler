package databaseManagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.mail.MessagingException;

import email.EmailValidity;
import email.SendEmail;
import start.Welcome;
import utilities.StringIntTime;
import warnings.Error;

public class ReminderEmails extends Thread {
	private static String reminderTime;

	public void run() {
		String reminder = "", startDate = "", startTime = "", time = "";
		String date1, time1, date2, time2, username;
		StringIntTime format = new StringIntTime();
		Statement stmt;
		int eventID;
		try {
			stmt = Welcome.con.createStatement();

			int i = 0;
			while (true) {
				i++;
			 

					ResultSet rs = stmt.executeQuery("select * from event_schedule");
					while (rs.next()) {

						startDate = rs.getString("start_date");
						startTime = rs.getString("start_time");
						reminderTime = rs.getString("reminder");
						eventID = rs.getInt("id");
						username = rs.getString("username");

						reminder = format.date_format_change(startDate, startTime);

						time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
						try {
							date1 = reminder.substring(0, 8);
							time1 = reminder.substring(8, 12);

							date2 = time.substring(0, 8);
							time2 = time.substring(9, 13);
							check_reminder(date2, time2, date1, time1, reminder, eventID, username);

							 
						} catch (Exception e) {

						}
						 
						// System.out.print("\n "+date1 +" "+time1+" "+date2+" "+time2);

					}
					Thread.sleep(60*1000);
				}

			 
		} catch (SQLException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void check_reminder(String date, String time, String date1, String time1, String reminder, int id,
			String username) throws MessagingException, SQLException {
		StringIntTime format = new StringIntTime();
		int timeDifference = 0;

		date = date1;
		System.out.print("\n " + time + "  " + date + "  " + time1 + " " + date1);
		timeDifference = format.time_difference(time, time1);
		if (date.equals(date1)) {
			System.out.print("\n "+reminderTime+" "+timeDifference);
			if (reminderTime.equals("1 minute") && timeDifference==1) {
				  System.out.print("One Minute left");
				 	send_email_reminder(id, username, "one minute.");
			}
			if (timeDifference == 60) {
				 
			}

		}
		else {
			
		}
	}

	public void send_email_reminder(int eventID, String username, String time) throws MessagingException, SQLException {
		System.out.print("\n HERE");
		boolean isvalid = false;

		Statement stmt;
		stmt = Welcome.con.createStatement();
		EmailValidity check = new EmailValidity();
		String email, name, subject = "Reminder Email";
		String msg = null;
		SendEmail mail = new SendEmail();
		ResultSet rs = stmt.executeQuery("select * from participants where event_schedule_id = '" + eventID + "'");

		while (rs.next()) {
			email = rs.getString("email");
			name = rs.getString("name");
			msg = "Dear " + name + "\nYou have a meeting in " + time;
			isvalid = check.isValidEmailAddress(email);
			if (isvalid) {
				mail.send_email(email, subject, msg);
			} else {
				Error err = new Error();
				err.errorMessage(email + " is not valid");
			}
		}
	}
}
