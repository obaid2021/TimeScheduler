package userInterface;

import java.sql.SQLException;
import databaseManagement.CheckAppointment;
/**
 * This function gets the data of booked appointments from the database and stores it in variables.
 * @author Muhamamd Obaid Ullah , Syed Adil Ehsan , Rao Shahan Naveed
 *
 */
public class ShowAppointment {
	ViewMonth var = new ViewMonth();
	CheckAppointment check = new CheckAppointment();
	String date = null;
	boolean found = false;
	static int start = -1;
	static int end = -1;
	public String pr = "";
/**
 * Gets month and year as input.
 * Checks each day of the months and finds the appointment of it.
 * Marks them as booked.
 * @param month appointments of this month are to be shown.
 * @param year will be used in getting appointments of the needed month of the year.
 * @throws SQLException shows error in connection with database and related to database.
 */
	public void show_appointment_month(String month, String year) throws SQLException {
		for (int i = 0; i < 31; i++) {

			date = month + " " + (i + 1) + ", " + year;
			found = check.check_appointment_of_month(date, ViewMonth.username);

			if (found == true) {
				String endDate = check.get_end_date(date, ViewMonth.username);
				int startdate = 0, enddate = 0;
				if (!date.substring(5, 6).equals(",")) {
					startdate = Integer.parseInt(date.substring(4, 6));
				} else {
					startdate = Integer.parseInt(date.substring(4, 5));
				}
				if (!endDate.substring(5, 6).equals(",")) {
					enddate = Integer.parseInt(endDate.substring(4, 6));
				} else {
					enddate = Integer.parseInt(endDate.substring(4, 5));
				}

				for (int x = startdate; x <= enddate; x++) {
					ViewMonth.appointment[x - 1] = "Booked";
				}

			}
		}

	}
/**
 * This function determines the end time of the appointment.
 * @param username is the profile that is to be checked.
 * @param endDay last day of the appointment.
 * @throws SQLException shows error in connection with database and related to database.
 */
	public void check_end_time(String username, String endDay) throws SQLException {
		String endTime;
		endTime = check.get_endtime(username, endDay); 
		if (!endTime.equals("")) {
			end = Integer.parseInt(endTime.substring(0, 2));

	        pr = check.get_priority_end(username, endDay  , endTime);
			mark_fromStart();
		}
	}
/**
 * Checks if the selected comes in between the starting date and the ending date of an event
 * @param username profile name of the user that is logged in
 * @param day date that is to be checked
 * @throws SQLException shows error in connection with database and related to database
 */
	public void check_in_the_middle(String username, String day) throws SQLException {
		String date;
		String mark ;
		for (int i = 1; i < 31; i++) {
			if (!day.substring(5, 6).equals(",")) {
				date = day.substring(0, 4) + i + day.substring(6);
			} else {
				date = day.substring(0, 4) + i + "," + day.substring(6);
			}
			 
			mark = check.check_middle_date(username, date, day);
			
			if (!mark.equals("empty")) {
				start = -1;
				pr = mark.substring(0,1) + " ";
				 
				mark_fromend();
			}
		}

	}
/**
 * Checks the starting time of an event in the database and compares it with the day to be checked.
 * @param username profile id of the user who is logged in
 * @param day date that is to be checked
 * @throws SQLException shows error in connection with database and related to database
 */
	public void show_start_appointment_day(String username, String day) throws SQLException {
		String time;
		String endTime = null, endDate;
		String title;
		String priority;

		for (int i = 0; i < 24; i++) {
			if (i < 10) {

				time = "0" + i + ":";

			} else {

				time = i + ":";
			}
			title = check.get_title(day, ViewMonth.username, time);
			priority = check.get_priority_start(ViewMonth.username, day, time);
			if (!title.equals(" ")) {
				ViewDay.app[i] = " " + priority + " " + title;
				pr = priority;
				start = i;
				endTime = check.get_end_time_title(ViewMonth.username, title);
				endDate = check.check_end_appointment_day(day, ViewMonth.username, title);

				if (endDate.equals(day)) {
					end = Integer.parseInt(endTime.substring(0, 2));
					mark();
				} else {
					mark_fromend();
				}

			}

		}

	}
/**
 * Hours are marked along with there respective priorities for the coloring purposes.
 * Starting and ending hours are given here.
 */
	public void mark() {
		for (int j = start + 1; j <= end; j++) {

			ViewDay.app[j] = " " + pr;
		}
	}
/**
 * If event starts on a day and carries on to the next day , only the start time of that event
 * will be needed.<p> The day will be marked until the end.
 */
	public void mark_fromend() {
		for (int j = start + 1; j <= 23; j++) {

			ViewDay.app[j] = " " + pr;
		}
	}
/**
* If event ends on a day , only the end time of that event
 * will be needed.<p> The day will be marked from the start to that time.
 */
	public void mark_fromStart() {
		for (int j = 0; j <= end; j++) {

			ViewDay.app[j] = " " + pr;
		}
	}
}
