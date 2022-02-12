package documents;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFileChooser;

import start.Welcome;

/**
 * 
 * This class prints out the schedule of the week.
 * 
 * @author Muhammad Obaid Ullah , Syed Adil Ehsan , Rao Shahan Naveed
 *
 */
public class PrintWeek {
	/**
	 * This function opens a dialog to take a path from user , where the file will
	 * be stored.<p>
	 * It will read the appointments of the selected week and write them into the file one by one.
	 * @param username  profile that is logged in currently.
	 * @param startDate Date on the start of the week.
	 * @param endDate   Date on the end of the week.
	 * @param month     Month of the selected week.
	 * @param year      Year of the selected week-
	 * @throws SQLException          errors which occur in the sql connection and
	 *                               commands.
	 * @throws FileNotFoundException if the files is missing.
	 */
	public void print_weekly_appointments(String username, String startDate, String endDate, String month, String year)
			throws SQLException, FileNotFoundException {
		int dayStart = Integer.parseInt(startDate);
		int dayEnd = Integer.parseInt(endDate);
		String filename = startDate + "-" + endDate + " " + month + " " + year + ".txt";
		String check = "";
		JFileChooser choose = new JFileChooser();
		choose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		String path;
		path = choose.getSelectedFile().getPath() + "\\" + filename;
		PrintWriter writer = new PrintWriter(path);

		for (int i = dayStart; i <= dayEnd; i++) {
			check = month + " " + i + ", " + year;

			Statement stmt = Welcome.con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from event_schedule where username = '" + username + "'"
					+ "and start_date = '" + check + "'");
			String name, startdate, enddate, startTime, endTime, location, priority;

			while (rs.next()) {
				name = rs.getString("name_of_event");
				startdate = rs.getString("start_date");
				enddate = rs.getString("end_date");
				startTime = rs.getString("start_time");
				endTime = rs.getString("end_time");
				location = rs.getString("location");
				priority = rs.getString("priority");

				writer.println("\n Name of Event : " + name);
				writer.println("\n Start date : " + startdate);
				writer.println("\n Start Time : " + startTime);
				writer.println("\n End date : " + enddate);
				writer.println("\n End Time : " + endTime);
				writer.println("\n location : " + location);
				writer.println("\n priority: " + priority);
				writer.println("\n ------------------------------------ \n");
			}
		}
		writer.close();
	}
}
