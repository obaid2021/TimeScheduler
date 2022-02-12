package databaseManagement;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import start.Welcome;
/**
 * This class is used to delete the events of a user.
 * @author Muhammad Obaid Ullah , Syed Adil Ehsan , Rao Shahan Naveed
 *
 */
public class DeleteEvent {
	PreparedStatement stmt;
/**
 * This function will deletes the event, its attached files and its participants from the database.
 * @param id is the id number of the event that is to be deleted.
 * @throws SQLException Sql connectivity and command errors will be checked
 */
	public void delete_event(int id) throws SQLException {
		stmt = Welcome.con.prepareStatement("DELETE from file where event_id = '" + id + "'");
		stmt.executeUpdate();

		stmt = Welcome.con.prepareStatement("DELETE from participants where event_schedule_id = '" + id + "'");
		stmt.executeUpdate();

		stmt = Welcome.con.prepareStatement("DELETE from event_schedule where id = '" + id + "'");
		stmt.executeUpdate();
	}
	/**
	 * This function will delete all the entries in the table of events in the database which are empty.
	 * @throws SQLException Sql connectivity and command errors will be checked
	 */
	public void delete_empty_events() throws SQLException
	{
		String empty = "empty";
		stmt = Welcome.con.prepareStatement("DELETE from event_schedule where name_of_event = '"+empty+"'"
				+ "and start_date = '"+empty+"'");
		stmt.executeUpdate();
	}
}
