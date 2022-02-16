package documents;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFileChooser;

import start.Welcome;

public class PrintWeek {
	public void print_weekly_appointments(String username, String startDate, String endDate, String month, String year)
			throws SQLException, FileNotFoundException {
		int dayStart = Integer.parseInt(startDate);
		int dayEnd = Integer.parseInt(endDate);
        String filename = startDate + "-" + endDate + " " +month + " " + year + ".txt";
		String check = "";
		JFileChooser choose = new JFileChooser();
		choose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int x = choose.showSaveDialog(null);
		String path;
		path = choose.getSelectedFile().getPath() + "\\" + filename;
		PrintWriter writer = new PrintWriter(path);
		  
		for (int i = dayStart; i <= dayEnd; i++) {
			check = month + " " + i + ", " + year;

			Statement stmt = Welcome.con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from event_schedule where username = '" + username + "'"
					+ "and start_date = '" + check + "'");
			String name, date, startTime, endTime, location, priority;
			
			 
			while (rs.next()) {
				name = rs.getString("name_of_event");
				date = rs.getString("start_date");
				startTime = rs.getString("start_time");
				endDate = rs.getString("end_date");
				endTime = rs.getString("end_time");
				location = rs.getString("location");
				priority = rs.getString("priority");
 
				writer.println("\n Name of Event : " + name);
				writer.println("\n Start date : " + date);
				writer.println("\n End date : " + endDate);
				writer.println("\n startTime : " + startTime);
				writer.println("\n endTime : " + endTime);
				writer.println("\n location : " + location);
				writer.println("\n priority: " + priority);
				writer.println("\n ------------------------------------ \n");
			}
		}
		writer.close();
	}
}
