package databaseManagement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import start.Welcome;
import userInterface.BookAppointment;
import userInterface.ViewAppointment;
/**
 * This class handles the events interaction with the database.It can read and write events in the database
 * @author Muhammad Obaid Ullah , Syed Adil Ehsan . Rao Shahan Naveed
 *
 */
public class Events {
	Statement stmt;
/**
 * This function returns the event number of the previously added event.
 * @return last added event's id.
 * @throws SQLException Sql connectivity and command errors will be checked.
 */
	public int get_event_number() throws SQLException {
		stmt = Welcome.con.createStatement();
		int input = 0;
		ResultSet rs = stmt
				.executeQuery("select * from event_schedule " + " where id = (select MAX(id) from event_schedule)");

		while (rs.next()) {
			input = rs.getInt("id");
		}
		return input;
	}
/**
 * This function will create an event in the database.
 * @param username Profile's username for which an event will be created.
 * @param eventNumber event's ID.
 * @throws SQLException Sql connectivity and command errors will be checked.
 */
	public void create_event(String username, int eventNumber) throws SQLException {

		PreparedStatement stmt = Welcome.con
				.prepareStatement("INSERT INTO event_schedule VALUES (?,?" + ",?,?,?,?,?,?,?,?)");
		stmt.setInt(1, eventNumber);
		stmt.setString(2, username);
		stmt.setString(3, "empty");
		stmt.setString(4, "empty");
		stmt.setString(5, "empty");
		stmt.setString(6, "empty");
		stmt.setString(7, "empty");
		stmt.setString(8, "empty");
		stmt.setString(9, "empty");
		stmt.setString(10, "empty");

		stmt.execute();
	}
/**
 * This function is used to update an already existing event.
 * @throws SQLException Sql connectivity and command errors will be checked
 */
	public void update_event() throws SQLException {
	 
		PreparedStatement stmt = Welcome.con.prepareStatement("UPDATE event_schedule SET username= (?),"
				+ " name_of_event = (?), start_date= (?)," + " end_date = (?), start_time = (?), end_time =(?), "
				+ "location = (?), priority = (?), reminder = (?) WHERE id = (?)");

		stmt.setString(1, BookAppointment.username);
		stmt.setString(2, BookAppointment.nameOfEvent);
		stmt.setString(3, BookAppointment.startDate);
		stmt.setString(4, BookAppointment.endDate);
		stmt.setString(5, BookAppointment.startTime);
		stmt.setString(6, BookAppointment.endTime);
		stmt.setString(7, BookAppointment.locationOfEvent);
		stmt.setString(8, BookAppointment.priority);
		stmt.setString(9, BookAppointment.reminder);
		stmt.setInt(10, BookAppointment.eventID);
		stmt.execute();
	}
/**
 * This function reads the detail of an event from the database and stores it in the variables.
 * 
 * @param username profile id of the user.
 * @param date date of the event.
 * @param time time of the event.
 * @return returns the id of the event.
 * @throws SQLException Sql connectivity and command errors will be checked.
 */
	public int get_event_details(String username, String date, String time) throws SQLException {
		stmt = Welcome.con.createStatement();

		
		if (date.substring(5, 6).equals(",")) {
			date = date.substring(4, 5);
		} else {

			date = date.substring(4, 6);
		}
		int id = -1, stTime = -1, eTime = -1, check = 0 , stDay = 0 , eDay = 0 , cDay = Integer.parseInt(date) ;
		String startD = "" , endD = "" , startTime = null, endTime = null, startday = null, endday = null, location = null, name = "Not booked";
		String startT = null, endT = null;
		ResultSet rs = stmt.executeQuery("select * from event_schedule " + "where username = '" + username + "'"
				);

		check = Integer.parseInt(time.substring(0, 2));
		while (rs.next()) {
			startTime = rs.getString("start_time");
			endTime = rs.getString("end_time");
			startday = rs.getString("start_date");
			endday = rs.getString("end_date");
			if (startday.substring(5, 6).equals(",")) {
				startday = startday.substring(4, 5);
				
			} else {
				startday = startday.substring(4, 6);
			}
			stDay = Integer.parseInt(startday);
			if (endday.substring(5, 6).equals(",")) {
				endday = endday.substring(4, 5);
			} else {

				endday = endday.substring(4, 6);
			}

			eDay = Integer.parseInt(endday);
			stTime = Integer.parseInt(startTime.substring(0, 2));
			eTime = Integer.parseInt(endTime.substring(0, 2));
            check = Integer.parseInt(time.substring(0, 2));
			if(stDay == cDay )
			{
				if(stDay == eDay)
				{
				if(check > stTime && eTime > check)
				{
				    id = rs.getInt("id");
					name = rs.getString("name_of_event");
					startT = rs.getString("start_time");
					endT = rs.getString("end_time");
					startD = rs.getString("start_date");
					location = rs.getString("location");
				}
				}
				else {
					if(check >= stTime)
					{
					    id = rs.getInt("id");
						name = rs.getString("name_of_event");
						startT = rs.getString("start_time");
						endT = rs.getString("end_time");
						startD = rs.getString("start_date");
						location = rs.getString("location");
					}
				}
				
			}
			if(cDay < eDay && cDay > stDay)
			{
				id = rs.getInt("id");
				name = rs.getString("name_of_event");
				startT = rs.getString("start_time");
				endT = rs.getString("end_time");
				startD = rs.getString("start_date");
				location = rs.getString("location");
			}
			if(cDay == eDay)
			{
				if(eTime >= check)
				{
				    id = rs.getInt("id");
					name = rs.getString("name_of_event");
					startT = rs.getString("start_time");
					endT = rs.getString("end_time");
					startD = rs.getString("start_date");
					location = rs.getString("location");
				}
			}
			 
		}

		ViewAppointment.nameOfEvent = name;
		ViewAppointment.location = location;
		ViewAppointment.startTime = startT;
		ViewAppointment.endTime = endT;
		ViewAppointment.startDate = startD;

		return id;
	}
	
	/**
	 * This function reads the events details of the given event id.
	 * @param eventID id of an event.
	 * @throws SQLException Sql connectivity and command errors will be checked.
	 */
	
	public void event_details(int eventID) throws SQLException
	{
		int id;
		String name = null , startT = null , endT = null , startD = null , location = null , endDate = null ;
		stmt = Welcome.con.createStatement();
 
		ResultSet rs = stmt
				.executeQuery("select * from event_schedule where id = '"+eventID+"'");
         while(rs.next())
         {
        	 id = rs.getInt("id");
				name = rs.getString("name_of_event");
				startT = rs.getString("start_time");
				endDate = rs.getString("end_date");
				endT = rs.getString("end_time");
				startD = rs.getString("start_date");
				location = rs.getString("location");
         }
        
         BookAppointment.nameOfEvent = name;
         BookAppointment.startDate = startD;
         BookAppointment.endDate = endDate;
         BookAppointment.startTime= startT ;
         BookAppointment.endTime = endT;
         BookAppointment.locationOfEvent= location;
         
	}
}
