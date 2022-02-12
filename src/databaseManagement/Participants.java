package databaseManagement;

import warnings.Error;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import start.Welcome;
import userInterface.ManageParticipant;

/**
 * This class is used for the entry and deletion of the table participant in the
 * database.
 * 
 * @author Muhamamad Obaid Ullah , Syed Adil Ehsan , Rao Shahan Naveed
 *
 */
@SuppressWarnings("serial")
public class Participants extends ManageParticipant {
	/**
	 * This constructor will be used to throw SQL exception.
	 * 
	 * @throws SQLException Sql connectivity and command errors will be checked
	 */
	public Participants() throws SQLException {
		super();

	}

	Statement stmt;

	/**
	 * This function will return the id of the last participant that is added in the
	 * database.
	 * 
	 * @return returns the last added participant's id
	 * @throws SQLException Sql connectivity and command errors will be checked
	 */
	public int last_participant() throws SQLException {
		stmt = Welcome.con.createStatement();
		int input = 0;

		ResultSet rs = stmt
				.executeQuery("select * from participants" + "  where id = (select MAX(id) from participants)");
		while (rs.next()) {
			input = rs.getInt("id");

		}

		return input;
	}
/**
 * This function will be used to add a new participant in the database.
 * @param id is number used as identity for the participant
 * @param event_schedule_id event id to which the participant is added
 * @param name name of the participant
 * @param email email address of the participant
 * @throws SQLException
 */
	public void add_participant(int id, int event_schedule_id, String name, String email) throws SQLException {
		PreparedStatement stmt = Welcome.con.prepareStatement("INSERT INTO participants VALUES (?,?,?,? )");
		stmt.setInt(1, id);
		stmt.setInt(2, event_schedule_id);
		stmt.setString(3, name);
		stmt.setString(4, email);
		stmt.execute();
	}
/**
 * This function will read all the participants which are already added in an Event.
 * @param table table shown in the GUI to show the participants
 * @param eventID id of the event , of which the participants are going to join
 * @throws SQLException Sql connectivity and command errors will be checked
 */
	public void previously_added(DefaultTableModel table, int eventID) throws SQLException {
		Statement stmt = Welcome.con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from participants where event_schedule_id ='" + eventID + "'");
		int id, evID;
		String[] data = null;
		while (rs.next()) {
			id = rs.getInt("id");
			evID = rs.getInt("event_schedule_id");
			data[0] = rs.getString("name");
			data[1] = rs.getString("email");
			table.addRow(data);
		}
	}
/**
 * This function will delete the participants from the database.
 * @param name name of the participant 
 * @param email email of the participant 
 * @throws SQLException Sql connectivity and command errors will be checked
 */
	public void delete_entry(String name, String email) throws SQLException {
		if (!name.isEmpty()) {
			PreparedStatement stmt;
			stmt = Welcome.con.prepareStatement("DELETE from participants where name=(?)");
			stmt.setString(1, name);
			stmt.executeUpdate();
		} else if (!email.isEmpty()) {
			PreparedStatement stmt;
			stmt = Welcome.con.prepareStatement("DELETE from participants where email=(?)");
			stmt.setString(1, email);
			stmt.executeUpdate();
		} else {
			Error window = new Error();
			window.errorMessage("Please enter a valid name or email");
		}

	}

}
