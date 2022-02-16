package userInterface;

import warnings.Error;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import com.toedter.calendar.JDateChooser;

import javax.swing.JSpinner;
import javax.swing.JComboBox;

import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;

import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;

import databaseManagement.DeleteEvent;
import databaseManagement.Events;
import documents.Form;
import documents.UploadFile;
import utilities.StringIntTime;

/**
 * User can input the event information and book an appointment for that.
 * 
 * @author Muhammad Obaid Ullah , Syed Adil Ehsan , Rao Shahan Naveed
 *
 */
@SuppressWarnings("serial")
public class BookAppointment extends JFrame {

	private JPanel contentPane;
	public static String Heading = "";
	public static BookAppointment frame;
	public static JTextField textField;
	public static JTextField textField_5;
	public static String username;
	static public String startDate = "";
	public static String endDate = "";
	static public String nameOfEvent = "";
	static public String locationOfEvent = "";
	static public String priority = "";
	static public String reminder_1 = "";
	public int starthour, startmin, endhour, endmin, eventNumber;
	public static JSpinner jSpinner;
	static int id;
	static public String startTime = "", endTime = "";
	Error window = new Error();
	static public String reminder;
	static public int eventID;

	/**
	 * This function will show GUI to book a new or edit an existing appointment.
	 * <p>
	 * Operation variable will decide if we are going to edit an existing meeting or
	 * create a
	 * <p>
	 * new one. In case of booking new appointment, a new id for the event will be
	 * generated.
	 * <p>
	 * In case of editing an appointment , username along with the event's id is
	 * required.
	 * <p>
	 * 
	 * @param username1 profile id that is logged in.
	 * @param dateOrId  It can be either date or ID.
	 * @param operation It can be new appointment or edit an existing one.
	 * @return returns nothing.
	 */
	public int user_interface(String username1, String dateOrId, String operation) {
		Events newEvent = new Events();
		try {
			if (operation.equals("new"))

			{
				Heading = "Schedule an Event";
				username = username1;
				startDate = dateOrId;
				frame = new BookAppointment();

				id = newEvent.get_event_number();
				id++;
				eventID = id;
				newEvent.create_event(username, id);

			}
			if (operation.equals("edit")) {
				username = username1;
				Heading = " Edit an event";
				eventID = Integer.parseInt(dateOrId);
				if (eventID != -1) {

					frame = new BookAppointment();
					newEvent.event_details(eventID);
					frame.dispose();

					user_interface(username1, dateOrId, "show");
				} else {
					Error err = new Error();
					err.errorMessage("Empty");
					return 0;
				}
			}
			if (operation.equals("show")) {

				frame = new BookAppointment();

				textField.setText(nameOfEvent);
				textField_5.setText(locationOfEvent);

			}
			if (!frame.isUndecorated()) {
				frame.setUndecorated(true);
			}
			frame.setVisible(true);
			frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

	}

	/**
	 * Makes a frame with textfields to get the information of the event that is
	 * being booked or edited.
	 */
	public BookAppointment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 50, 786, 643);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(-28, 0, 1041, 99);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel(" " + Heading);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(60, 26, 457, 45);
		panel.add(lblNewLabel_1);

		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(Color.DARK_GRAY);
		btnExit.setBounds(525, 11, 105, 23);
		panel.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeleteEvent delete = new DeleteEvent();

				try {
					delete.delete_empty_events();
				} catch (SQLException e) {

					e.printStackTrace();
				}

				frame.dispose();
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JButton btnCloseWindow = new JButton("Close window");
		btnCloseWindow.setForeground(Color.WHITE);
		btnCloseWindow.setBackground(Color.DARK_GRAY);
		btnCloseWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				DeleteEvent delete = new DeleteEvent();
				try {
					delete.delete_empty_events();
				} catch (SQLException e) {

					e.printStackTrace();
				}
				frame.dispose();
			}
		});
		btnCloseWindow.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCloseWindow.setBounds(525, 45, 165, 23);
		panel.add(btnCloseWindow);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(
				"abstract-white-futuristic-background-connecting-dots-lines-white-background-abstract-white-futuristic-background-white-146584221.jpg"));
		lblNewLabel_4.setBounds(29, 0, 779, 99);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel = new JLabel("Name of Event*");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(106, 146, 165, 37);
		contentPane.add(lblNewLabel);

		JLabel lblDateOfBirth = new JLabel("Date of Event*");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDateOfBirth.setBounds(106, 229, 165, 37);
		contentPane.add(lblDateOfBirth);

		JLabel lblHealthInformation = new JLabel("Time of Event*");
		lblHealthInformation.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHealthInformation.setBounds(106, 277, 176, 37);
		contentPane.add(lblHealthInformation);

		JLabel lblInsurance = new JLabel("Location of Event*");
		lblInsurance.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInsurance.setBounds(106, 325, 165, 37);
		contentPane.add(lblInsurance);

		JLabel lblDistance = new JLabel("Participants");
		lblDistance.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDistance.setBounds(106, 372, 165, 37);
		contentPane.add(lblDistance);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(280, 149, 320, 32);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_5.setColumns(10);
		textField_5.setBounds(281, 328, 320, 32);
		contentPane.add(textField_5);

		JLabel lblNewLabel_3 = new JLabel("Starts");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(280, 192, 65, 29);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("Ends");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(450, 192, 65, 29);
		contentPane.add(lblNewLabel_3_1);

		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(450, 235, 140, 31);
		contentPane.add(dateChooser_1);

		Date date = new Date();
		SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
		jSpinner = new javax.swing.JSpinner(sm);
		JSpinner.DateEditor de = new JSpinner.DateEditor(jSpinner, "HH:mm");
		jSpinner.setEditor(de);
		jSpinner.setBounds(278, 285, 100, 23);
		contentPane.add(jSpinner);

		SpinnerDateModel sm1 = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
		JSpinner jSpinner1 = new javax.swing.JSpinner(sm1);
		JSpinner.DateEditor de1 = new JSpinner.DateEditor(jSpinner1, "HH:mm");
		jSpinner1.setEditor(de1);
		jSpinner1.setBounds(450, 288, 100, 23);
		contentPane.add(jSpinner1);

		JButton btnNewButton_2 = new JButton("Add/Remove Participants");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManageParticipant participant;
				try {
					participant = new ManageParticipant();
					participant.participant_manage(eventID);
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBounds(281, 381, 216, 23);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_1 = new JButton("Add attachment");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UploadFile section = new UploadFile();

				section.upload_file(eventID);

			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(280, 429, 217, 23);
		contentPane.add(btnNewButton_1);

		String[] priorty = { "low", "medium", "high" };

		JComboBox<Object> comboBox = new JComboBox<Object>(priorty);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setBounds(280, 466, 158, 34);
		contentPane.add(comboBox);

		JLabel lblAttachFile = new JLabel("Attach File");
		lblAttachFile.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAttachFile.setBounds(106, 420, 165, 37);
		contentPane.add(lblAttachFile);

		JLabel lblSetPriorty = new JLabel("Set Priorty");
		lblSetPriorty.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSetPriorty.setBounds(106, 463, 165, 37);
		contentPane.add(lblSetPriorty);

		JLabel lblSetReminder = new JLabel("Set Reminder");
		lblSetReminder.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSetReminder.setBounds(106, 511, 165, 37);
		contentPane.add(lblSetReminder);

		String[] reminder = { "1 minute", "1 week", "3 days", "1 hour", "10 minutes" };
		JComboBox<Object> comboBox_1 = new JComboBox<Object>(reminder);
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_1.setBounds(280, 514, 158, 34);
		contentPane.add(comboBox_1);

		JButton btnNewButton_3 = new JButton("Done");
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(Color.DARK_GRAY);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Error message = new Error();

				Date date;

				date = dateChooser_1.getDate();
			 
				startTime = jSpinner.getValue().toString().substring(11, 19);
				endTime = jSpinner1.getValue().toString().substring(11, 19);
				try {
					endDate = DateFormat.getDateInstance().format(date);
					nameOfEvent = textField.getText();
					locationOfEvent = textField_5.getText();
					priority = comboBox.getSelectedItem().toString();
					reminder_1 = comboBox_1.getSelectedItem().toString();

					int date1, month1, year1, date2, month2, year2;
					StringIntTime convert = new StringIntTime();
					date1 = convert.get_day_int(startDate);
					date2 = convert.get_day_int(endDate);

					month1 = convert.get_month_int(startDate);
					month2 = convert.get_month_int(endDate);

					year1 = convert.get_year_int(startDate);
					year2 = convert.get_year_int(endDate);
					if (nameOfEvent.equals("")) {
						window.errorMessage("Name of Event is empty!!! ");
					} else if (locationOfEvent.equals("")) {
						message.errorMessage("Location field  Blank");
					}

					else if (year2 < year1) {
						message.errorMessage("Year is invalid");
					} else if (month2 < month1) {
						if (year2 <= year1) {
							message.errorMessage("Month is invalid");
						}
					} else if (date2 < date1) {
						if (month2 <= month1) {
							if (year2 <= year1) {
								message.errorMessage("Date is invalid");
							}
						}
					} else {

						Form form = new Form();
						form.make_form();
					}

					try {
						jSpinner.commitEdit();
						jSpinner1.commitEdit();
					} catch (ParseException e) {

						e.printStackTrace();
					}
					}
					catch(Exception e)
					{
						message.errorMessage("End Date field  Blank");
					}
				 
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_3.setBounds(494, 509, 112, 40);
		contentPane.add(btnNewButton_3);

		JLabel lblNewLabel_2 = new JLabel("Username " + username);
		lblNewLabel_2.setBounds(106, 110, 225, 25);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblNewLabel_5 = new JLabel(" " + startDate);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(280, 234, 140, 29);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(
				"abstract-white-futuristic-background-connecting-dots-lines-white-background-abstract-white-futuristic-background-white-146584221.jpg"));
		lblNewLabel_6.setBounds(0, 96, 792, 559);
		contentPane.add(lblNewLabel_6);

	}
}
