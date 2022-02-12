package documents;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import databaseManagement.Events;
import email.InvitationEmailPrepare;
import userInterface.BookAppointment; 
import userInterface.ViewDay;
import userInterface.ViewMonth;

import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;

import javax.mail.MessagingException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import warnings.Error;
/**
 * This Class shows the entered information to the User for 
 * booking an event before it gets uploaded in the database.
 * @author Muhammad Obaid Ullah , Syed Adil Ehsan , Rao Shahan Naveed
 *
 */
@SuppressWarnings("serial")
public class Form extends JFrame {
	static Form frame1;
	private JPanel contentPane;

	/**
	 * Makes a frame in application.
	 */

	public void make_form() {
		try {
			frame1 = new Form();
			frame1.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Shows the details of the event on the screen in the form of labels.
	 * Upload button will confirm the writing of the information in the database
	 */
	public Form() {
		setBackground(SystemColor.window);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 473);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Event Details");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(119, 31, 454, 72);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Name of Event:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(119, 114, 159, 28);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Date of Event:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_1.setBounds(119, 147, 159, 28);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Duration:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_2.setBounds(119, 186, 159, 28);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Location:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_3.setBounds(119, 216, 159, 28);
		contentPane.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_3_1 = new JLabel("Priority:");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_3_1.setBounds(119, 252, 159, 28);
		contentPane.add(lblNewLabel_1_3_1);

		JLabel lblNewLabel_1_3_2 = new JLabel("Reminder:");
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_3_2.setBounds(119, 281, 159, 28);
		contentPane.add(lblNewLabel_1_3_2);

		JLabel lblNewLabel_1_4 = new JLabel(" " + BookAppointment.nameOfEvent);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_4.setBounds(304, 114, 366, 28);
		contentPane.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_4_1 = new JLabel(" " + BookAppointment.startDate + " - " + BookAppointment.endDate);
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_4_1.setBounds(304, 147, 366, 28);
		contentPane.add(lblNewLabel_1_4_1);

		JLabel lblNewLabel_1_4_2 = new JLabel(" " + BookAppointment.startTime + " to " + BookAppointment.endTime);
		lblNewLabel_1_4_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_4_2.setBounds(304, 186, 416, 28);
		contentPane.add(lblNewLabel_1_4_2);

		JLabel lblNewLabel_1_4_3 = new JLabel(" " + BookAppointment.locationOfEvent);
		lblNewLabel_1_4_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_4_3.setBounds(304, 216, 389, 28);
		contentPane.add(lblNewLabel_1_4_3);

		JLabel lblNewLabel_1_4_4 = new JLabel(" " + BookAppointment.priority);
		lblNewLabel_1_4_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_4_4.setBounds(304, 252, 159, 28);
		contentPane.add(lblNewLabel_1_4_4);

		JLabel lblNewLabel_1_4_5 = new JLabel(" " + BookAppointment.reminder_1);
		lblNewLabel_1_4_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_4_5.setBounds(304, 281, 159, 28);
		contentPane.add(lblNewLabel_1_4_5);

		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame1.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(523, 44, 122, 33);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Upload");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Events create = new Events();
				Error message = new Error();
			 
				try {
					 
					create.update_event();
					InvitationEmailPrepare send = new InvitationEmailPrepare();
					send.event_creation_email(BookAppointment.eventID, BookAppointment.username);
					 
					message.errorMessage("Event Uploaded Successfully");
					frame1.dispose();
					BookAppointment.frame.dispose();
					ViewDay view = new ViewDay();
					ViewDay.frame.dispose();
					view.view_day(ViewMonth.inputDate);
					}
				  catch (SQLException e1) {
	
					e1.printStackTrace();
				} catch (MessagingException e1) {
		
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(304, 347, 138, 39);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(
				"abstract-white-futuristic-background-connecting-dots-lines-white-background-abstract-white-futuristic-background-white-146584221.jpg"));
		lblNewLabel_2.setBounds(-12, 0, 901, 461);
		contentPane.add(lblNewLabel_2);
	}
}
