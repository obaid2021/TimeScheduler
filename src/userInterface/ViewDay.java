package userInterface;

 

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
 
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
/**
 * Shows a 24 Hour GUI and the appointments colored in green , yellow and red depending upon<p>
 * their respective priorities. Option of booking an appointment is shown as a button.<p> 
 * Click on each hour will show the appointments booked in that particular hour. 
 * @author Muhammad Obaid Ullah , Syed Adil Ehsan , Rao Shahan Naveed
 *
 */
@SuppressWarnings("serial")
public class ViewDay extends JFrame implements MouseListener {

	static String[] app = { "", "", "", "", "", "" + "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
			"", "", "" };

	private JPanel contentPane;
	private JLabel lblNewLabel_0;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_16;
	private JLabel lblNewLabel_170;
	private JLabel lblNewLabel_18;
	private JLabel lblNewLabel_19;
	private JLabel lblNewLabel_17;
	private JLabel lblNewLabel_20;
	private JLabel lblNewLabel_21;

	private JLabel lblNewLabel_22;
	private JLabel lblNewLabel_23;
	private JLabel lblAppointmentsOfThe;
	static String dayViewing;
	public static ViewDay frame;
	ShowAppointment show;
	private JLabel lblNewLabel_110_2_2;
	private JLabel lblNewLabel_110_2_3;
	private JLabel lblNewLabel_110_2_4;
	private JLabel lblNewLabel_110_2_5;
	private JLabel lblNewLabel_24;

	public static String daySave;

	
/**
 * Makes a Daily view frame of GUI. Loads the booked hours of the day.
 * @param day Selected day on Monthly view of GUI is taken as parameter.
 */
	public void view_day(String day) {
		daySave = day;
		for (int i = 0; i < 24; i++) {
			app[i] = " ";
		}
		try {
			show = new ShowAppointment();
			
			show.show_start_appointment_day(ViewMonth.username, day);
      		show.check_in_the_middle(ViewMonth.username, day);
			show.check_end_time(ViewMonth.username, day);
			dayViewing = day;
			frame = new ViewDay();
			frame.setLocationRelativeTo(null);
			if (!frame.isUndecorated()) {
				frame.setUndecorated(true);
			}
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

/**
 * Creates a frame with hourly view of each day selected from monthly view.<p>
 * Button to book a new appoinment is also shown.
 */
	public ViewDay() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1087, 567);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel(dayViewing);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(21, 11, 309, 39);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_110 = new JLabel("Time");
		lblNewLabel_110.setForeground(Color.BLACK);
		lblNewLabel_110.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_110.setBounds(21, 49, 44, 33);
		contentPane.add(lblNewLabel_110);

		lblNewLabel_0 = new JLabel("00:00" + app[0]);
		lblNewLabel_0.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_0.setBounds(21, 90, 360, 35);
		contentPane.add(lblNewLabel_0);
		lblNewLabel_0.addMouseListener(this);

		lblNewLabel_1 = new JLabel("01:00" + app[1]);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(21, 130, 360, 35);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.addMouseListener(this);

		lblNewLabel_2 = new JLabel("02:00" + app[2]);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(21, 170, 360, 35);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.addMouseListener(this);

		lblNewLabel_3 = new JLabel("03:00" + app[3]);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(21, 210, 360, 35);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.addMouseListener(this);

		lblNewLabel_4 = new JLabel("04:00" + app[4]);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(21, 250, 360, 35);
		contentPane.add(lblNewLabel_4);
		lblNewLabel_4.addMouseListener(this);

		lblNewLabel_5 = new JLabel("05:00" + app[5]);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(21, 290, 360, 35);
		contentPane.add(lblNewLabel_5);
		lblNewLabel_5.addMouseListener(this);

		lblNewLabel_6 = new JLabel("06:00" + app[6]);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(21, 330, 360, 35);
		contentPane.add(lblNewLabel_6);
		lblNewLabel_6.addMouseListener(this);

		lblNewLabel_7 = new JLabel("07:00" + app[7]);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(21, 370, 360, 35);
		contentPane.add(lblNewLabel_7);
		lblNewLabel_7.addMouseListener(this);

		lblNewLabel_8 = new JLabel("08:00" + app[8]);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(21, 410, 360, 35);
		contentPane.add(lblNewLabel_8);
		lblNewLabel_8.addMouseListener(this);

		lblNewLabel_9 = new JLabel("09:00" + app[9]);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(21, 450, 360, 35);
		contentPane.add(lblNewLabel_9);
		lblNewLabel_9.addMouseListener(this);

		lblNewLabel_10 = new JLabel("10:00" + app[10]);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_10.setBounds(21, 490, 360, 35);
		contentPane.add(lblNewLabel_10);
		lblNewLabel_10.addMouseListener(this);

		lblNewLabel_11 = new JLabel("11:00" + app[11]);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_11.setBounds(21, 530, 360, 35);
		contentPane.add(lblNewLabel_11);
		lblNewLabel_11.addMouseListener(this);

		lblNewLabel_12 = new JLabel("12:00" + app[12]);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_12.setBounds(414, 90, 360, 35);
		contentPane.add(lblNewLabel_12);
		lblNewLabel_12.addMouseListener(this);

		lblNewLabel_13 = new JLabel("13:00" + app[13]);
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_13.setBounds(414, 130, 360, 35);
		contentPane.add(lblNewLabel_13);
		lblNewLabel_13.addMouseListener(this);

		lblNewLabel_170 = new JLabel("Time");
		lblNewLabel_170.setForeground(Color.BLACK);
		lblNewLabel_170.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_170.setBounds(414, 49, 51, 33);
		contentPane.add(lblNewLabel_170);

		lblNewLabel_14 = new JLabel("14:00" + app[14]);
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_14.setBounds(414, 170, 360, 35);
		contentPane.add(lblNewLabel_14);
		lblNewLabel_14.addMouseListener(this);

		lblNewLabel_15 = new JLabel("15:00" + app[15]);
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_15.setBounds(414, 210, 360, 35);
		contentPane.add(lblNewLabel_15);
		lblNewLabel_15.addMouseListener(this);

		lblNewLabel_16 = new JLabel("16:00" + app[16]);
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_16.setBounds(414, 250, 360, 35);
		contentPane.add(lblNewLabel_16);
		lblNewLabel_16.addMouseListener(this);

		lblNewLabel_17 = new JLabel("17:00" + app[17]);
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_17.setBounds(414, 290, 360, 35);
		contentPane.add(lblNewLabel_17);
		lblNewLabel_17.addMouseListener(this);

		lblNewLabel_18 = new JLabel("18:00" + app[18]);
		lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_18.setBounds(414, 330, 360, 35);
		contentPane.add(lblNewLabel_18);
		lblNewLabel_18.addMouseListener(this);

		lblNewLabel_19 = new JLabel("19:00" + app[19]);
		lblNewLabel_19.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_19.setBounds(414, 370, 360, 35);
		contentPane.add(lblNewLabel_19);
		lblNewLabel_19.addMouseListener(this);

		lblNewLabel_20 = new JLabel("20:00" + app[20]);
		lblNewLabel_20.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_20.setBounds(414, 410, 360, 35);
		contentPane.add(lblNewLabel_20);
		lblNewLabel_20.addMouseListener(this);

		lblNewLabel_21 = new JLabel("21:00" + app[21]);
		lblNewLabel_21.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_21.setBounds(414, 450, 360, 35);
		contentPane.add(lblNewLabel_21);
		lblNewLabel_21.addMouseListener(this);

		lblNewLabel_22 = new JLabel("22:00" + app[22]);
		lblNewLabel_22.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_22.setBounds(414, 490, 360, 35);
		contentPane.add(lblNewLabel_22);
		lblNewLabel_22.addMouseListener(this);

		coloring(lblNewLabel_22, app[22]);

		lblNewLabel_23 = new JLabel("23:00" + app[23]);
		lblNewLabel_23.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_23.setBounds(414, 530, 360, 35);
		contentPane.add(lblNewLabel_23);
		lblNewLabel_23.addMouseListener(this);

		lblAppointmentsOfThe = new JLabel("Appointments Of the Day");
		lblAppointmentsOfThe.setForeground(Color.BLACK);
		lblAppointmentsOfThe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblAppointmentsOfThe.setBounds(340, 11, 331, 39);
		contentPane.add(lblAppointmentsOfThe);

		JButton btnNewButton = new JButton("Book New");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookAppointment window1 = new BookAppointment();
				window1.user_interface(ViewMonth.username, dayViewing  , "new");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(784, 291, 156, 33);
		contentPane.add(btnNewButton);
		 
		coloring(lblNewLabel_0, app[0]);
		coloring(lblNewLabel_1, app[1]);
		coloring(lblNewLabel_2, app[2]);
		coloring(lblNewLabel_3, app[3]);
		coloring(lblNewLabel_4, app[4]);
		coloring(lblNewLabel_5, app[5]);
		coloring(lblNewLabel_6, app[6]);
		coloring(lblNewLabel_7, app[7]);
		coloring(lblNewLabel_8, app[8]);
		coloring(lblNewLabel_9, app[9]);
		coloring(lblNewLabel_10, app[10]);
		coloring(lblNewLabel_11, app[11]);
		coloring(lblNewLabel_12, app[12]);
		coloring(lblNewLabel_13, app[13]);
		coloring(lblNewLabel_14, app[14]);
		coloring(lblNewLabel_15, app[15]);
		coloring(lblNewLabel_16, app[16]);
		coloring(lblNewLabel_17, app[17]);
		coloring(lblNewLabel_18, app[18]);
		coloring(lblNewLabel_19, app[19]);
		coloring(lblNewLabel_20, app[20]);
		coloring(lblNewLabel_21, app[21]);
		coloring(lblNewLabel_22, app[22]);
		coloring(lblNewLabel_23, app[23]);

		JButton btnClose = new JButton("Close");
		btnClose.setForeground(Color.WHITE);
		btnClose.setBackground(Color.DARK_GRAY);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnClose.setBounds(784, 251, 156, 33);
		contentPane.add(btnClose);

		JLabel lblNewLabel_110_1 = new JLabel("Priority");
		lblNewLabel_110_1.setForeground(Color.BLACK);
		lblNewLabel_110_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_110_1.setBounds(75, 49, 85, 33);
		contentPane.add(lblNewLabel_110_1);

		JLabel lblNewLabel_110_2 = new JLabel("Heading");
		lblNewLabel_110_2.setForeground(Color.BLACK);
		lblNewLabel_110_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_110_2.setBounds(147, 49, 126, 33);
		contentPane.add(lblNewLabel_110_2);

		JLabel lblNewLabel_110_1_1 = new JLabel("Priority");
		lblNewLabel_110_1_1.setForeground(Color.BLACK);
		lblNewLabel_110_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_110_1_1.setBounds(470, 49, 85, 33);
		contentPane.add(lblNewLabel_110_1_1);

		JLabel lblNewLabel_110_2_1 = new JLabel("Heading");
		lblNewLabel_110_2_1.setForeground(Color.BLACK);
		lblNewLabel_110_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_110_2_1.setBounds(545, 49, 126, 33);
		contentPane.add(lblNewLabel_110_2_1);

		lblNewLabel_110_2_2 = new JLabel("l-    low");
		lblNewLabel_110_2_2.setForeground(Color.GREEN);
		lblNewLabel_110_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_110_2_2.setBounds(784, 80, 126, 33);
		contentPane.add(lblNewLabel_110_2_2);

		lblNewLabel_110_2_3 = new JLabel("m-  Medium");
		lblNewLabel_110_2_3.setForeground(Color.YELLOW);
		lblNewLabel_110_2_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_110_2_3.setBounds(784, 120, 126, 33);
		contentPane.add(lblNewLabel_110_2_3);

		lblNewLabel_110_2_4 = new JLabel("h-  High");
		lblNewLabel_110_2_4.setForeground(Color.RED);
		lblNewLabel_110_2_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_110_2_4.setBounds(784, 160, 126, 33);
		contentPane.add(lblNewLabel_110_2_4);

		lblNewLabel_110_2_5 = new JLabel("Priority");
		lblNewLabel_110_2_5.setForeground(Color.BLACK);
		lblNewLabel_110_2_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_110_2_5.setBounds(784, 49, 126, 33);
		contentPane.add(lblNewLabel_110_2_5);

		lblNewLabel_24 = new JLabel("");
		lblNewLabel_24.setIcon(new ImageIcon(
				"abstract-white-futuristic-background-connecting-dots-lines-white-background-abstract-white-futuristic-background-white-146584221.jpg"));
		lblNewLabel_24.setBounds(0, 0, 1111, 571);
		contentPane.add(lblNewLabel_24);
	}
/**
 * Opens an appointment when mouse is clicked on an hour of the day.
 * @param e mouse command
 */
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel l = (JLabel) e.getSource();
		String time = l.getText();
		ViewAppointment appointment;
		try {
			appointment = new ViewAppointment();
			appointment.view_appoinment(time, dayViewing);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
/**
 * Turns the label color to blue when mouse enters a particular label.
 * @param e mouse command
 */
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel l = (JLabel) e.getSource();
		l.setForeground(SystemColor.blue);
	}
/**
 * Turns the color of the label back to noraml black after mouse exits.
 * @param e mouse command
 */
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel l = (JLabel) e.getSource();
		l.setForeground(SystemColor.black);
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
/**
 * This function colors the hours of a day in red,yellow and green depending upon their priorities booked by user.
 * @param label is the name JLabel of each hour 
 * @param priority determines the color of each hour
 */
	public void coloring(JLabel label, String priority) {
         
		if (priority.startsWith(" l ")) { 
			label.setBackground(Color.green);
			label.setOpaque(true);
		} else if (priority.startsWith(" h ")) {
			label.setBackground(Color.red);
			label.setOpaque(true);
		} else if (priority.startsWith(" m ")) {
			 
			label.setBackground(Color.yellow);
			label.setOpaque(true);
		} else {
			label.setBackground(Color.white);
			label.setOpaque(true);
		}
	}
}
