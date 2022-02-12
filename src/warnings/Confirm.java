package warnings;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import databaseManagement.DeleteEvent;
import userInterface.ViewAppointment;
import userInterface.ViewDay;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
/**
 * This class is used to generate window for confirmation purpose.
 * @author Muhammad Obaid Ullah , Syed Adil Ehsan . Rao Shahan Naveed
 *
 */
@SuppressWarnings("serial")
public class Confirm extends JFrame {
	static Confirm frame;
	private JPanel contentPane;
	static String message = "";

	/**
	 * Creates the frame for the confirmation.
	 */

	public String get_confirmation() {
		try {
			frame = new Confirm();
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	/**
	 * Creates frame with yes and no button to confirm a job.
	 */
	public Confirm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 174);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Are you sure?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(93, 35, 212, 31);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Yes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteEvent del = new DeleteEvent();
				try {
					del.delete_event(ViewAppointment.eventID);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ViewAppointment.frame.dispose();
				frame.dispose();
				ViewDay.frame.dispose();
				ViewDay view = new ViewDay();
				view.view_day(ViewDay.daySave);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(93, 87, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNo = new JButton("No");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				try {
					ViewAppointment window = new ViewAppointment();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNo.setForeground(Color.WHITE);
		btnNo.setBackground(Color.DARK_GRAY);
		btnNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNo.setBounds(256, 87, 89, 23);
		contentPane.add(btnNo);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(
				"C:\\Users\\Win10 Pro x64\\eclipse-workspace\\TimeScheduler\\Resources\\abstract-white-futuristic-background-connecting-dots-lines-white-background-abstract-white-futuristic-background-white-146584221.jpg"));
		lblNewLabel_1.setBounds(0, 0, 481, 162);
		contentPane.add(lblNewLabel_1);
	}
}
