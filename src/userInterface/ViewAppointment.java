package userInterface;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import databaseManagement.Events;

import documents.Attachments;
import start.Welcome;
import warnings.Confirm;

import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.Color;

/**
 * Shows overview of each of the appointment booked.
 * 
 * @author Muhammad Obaid Ullah , Syed Adil Ehsan , Rao Shahan Naveed
 *
 */
@SuppressWarnings("serial")
public class ViewAppointment extends JFrame {

	static private JPanel contentPane;
	static public ViewAppointment frame;
	static private JTable table;
	Events event = new Events();
	static public String nameOfEvent, location, startDate, startTime, endTime;
	static public int eventID = 0;

	/**
	 * This function shows each appointment in detail. 
	 * @param time Hour of the day that was clicked in Daily view of application
	 * @param date Date that was opened in Daily view of application
	 */

	public void view_appoinment(String time, String date) {
		try {
			nameOfEvent = "Not Booked";
			location = "-";
			startDate = "-";
			startTime = ":";
			endTime = ":";
			eventID = event.get_event_details(ViewMonth.username, date, time);

			frame = new ViewAppointment();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Creates a frame that shows the information of an appointment.
	 * 
	 * @throws SQLException shows error in connection with database and related to database.
	 */
	public ViewAppointment() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 867, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnNewButton = new JButton("Close");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setBounds(703, 24, 99, 34);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}

		});
		contentPane.setLayout(null);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Appointment");
		lblNewLabel.setBounds(86, 24, 403, 47);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Event Name");
		lblNewLabel_1.setBounds(86, 82, 165, 34);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Date");
		lblNewLabel_1_1.setBounds(86, 131, 165, 34);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Location");
		lblNewLabel_1_2.setBounds(86, 177, 165, 34);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Starts at");
		lblNewLabel_1_3.setBounds(86, 222, 165, 34);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("Ends at");
		lblNewLabel_1_4.setBounds(86, 269, 165, 34);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_5_1 = new JLabel("Participants");
		lblNewLabel_1_5_1.setBounds(86, 358, 165, 34);
		lblNewLabel_1_5_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(lblNewLabel_1_5_1);

		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				BookAppointment edit = new BookAppointment();
				String id = String.valueOf(eventID);
				edit.user_interface(ViewMonth.username, id, "edit");

			}
		});
		btnEdit.setForeground(Color.WHITE);
		btnEdit.setBackground(Color.DARK_GRAY);
		btnEdit.setBounds(703, 69, 99, 34);
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(btnEdit);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Confirm getConfirmation = new Confirm();
				getConfirmation.get_confirmation();

			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(Color.DARK_GRAY);
		btnDelete.setBounds(703, 114, 99, 34);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(btnDelete);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(261, 367, 446, 77);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Name", "Email" }));
		scrollPane.setViewportView(table);
		read_participants(eventID);

		JLabel lblNewLabel_2 = new JLabel(nameOfEvent);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(292, 82, 327, 30);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel(startDate);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(292, 135, 327, 30);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel(location);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_2.setBounds(292, 181, 327, 30);
		contentPane.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_3 = new JLabel(startTime);
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_3.setBounds(292, 226, 327, 30);
		contentPane.add(lblNewLabel_2_3);

		JLabel lblNewLabel_2_4 = new JLabel(endTime);
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_4.setBounds(292, 273, 327, 30);
		contentPane.add(lblNewLabel_2_4);

		JLabel lblNewLabel_1_4_1 = new JLabel("Ends at");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_4_1.setBounds(86, 313, 165, 34);
		contentPane.add(lblNewLabel_1_4_1);

		JButton btnNewButton_1 = new JButton("Attachment download");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Attachments file;
				try {
					file = new Attachments();
					file.view_attachment(eventID);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(290, 314, 282, 33);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(
				"abstract-white-futuristic-background-connecting-dots-lines-white-background-abstract-white-futuristic-background-white-146584221.jpg"));
		lblNewLabel_3.setBounds(-12, 0, 919, 499);
		contentPane.add(lblNewLabel_3);
	}
/**
 * This function fetches the list of the appointments from database.
 * @param eventIDs id of the event, of which the participants list is needed.
 * @throws SQLException shows error in connection with database and related to database.
 */
	void read_participants(int eventIDs) throws SQLException {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		Statement stmt = Welcome.con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from participants where event_schedule_id ='" + eventIDs + "'");

		String name, email;
		while (rs.next()) {

			name = rs.getString("name");
			email = rs.getString("email");
			tableModel.addRow(new Object[] { name, email });
		}

	}
}
