package userInterface;
 
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
 
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
 
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import documents.PrintWeek;
import utilities.DaysOfWeek;
import utilities.Months;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 
import javax.swing.ImageIcon;
 /**
  * Creates a calendar like GUI of months on the screen. Paints the booked days with Blue color.<p>
  * Shows weekly schedule print buttons.
  * @author Muhammad Obaid Ullah , Adil Ehsan , Rao Shahan Naveed
  *
  */

public class ViewMonth extends JFrame implements MouseListener {
 
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static String currentMonth = "02-2022";
	static String[] dayName;
	static String nameOfMonth = "Feb";
	static String nameOfYear = "2022";
	static int year = 2022;
	static int month = 2;
	public static String inputDate;
	private PrintWeek print;
	JYearChooser yearChooser;
	JMonthChooser monthChooser;
	public static String[] standardDays = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday",
			"Saturday" };
	public static String[] days = { "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY" };
	static ViewMonth frame;
	static String finalDay;
	static String appoint = "A";
	static String appointment[] = { "", "", "", "", "", "" + "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "", "" };
	static JLabel lblNewLabel1;
	static String username;


/**
 * Creates the frame for monthly Calendar like GUI. Shows appointments on the GUI.
 * @param user Username that has logged in to the system
 * @throws SQLException SQLException database access errors or other errors related to database
 */

	public void view_month(String user) throws SQLException {
		username = user;
		String appointments[] = { "", "", "", "", "", "" + "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				"", "", "", "", "", "", "", "", "", "", "" };
		appointment = appointments;
		ShowAppointment show = new ShowAppointment();
		show.show_appointment_month(nameOfMonth, nameOfYear);
		try {
			frame = new ViewMonth();
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
	 * Generates a GUI of the month. Colors the day in blue if the day has some appointments.<p>
	 * User can change the month to be viewed.
	 */
	public ViewMonth() {

		setBackground(SystemColor.inactiveCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1189, 567);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.text);
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel(days[0]);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(SystemColor.desktop);
		lblNewLabel.setBounds(30, 32, 121, 49);
		contentPane.add(lblNewLabel);

		JLabel lblMonday = new JLabel(days[1]);
		lblMonday.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonday.setForeground(SystemColor.desktop);
		lblMonday.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMonday.setBounds(150, 32, 151, 49);
		contentPane.add(lblMonday);

		JLabel lblTuesday = new JLabel(days[2]);
		lblTuesday.setHorizontalAlignment(SwingConstants.CENTER);
		lblTuesday.setForeground(SystemColor.desktop);
		lblTuesday.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTuesday.setBounds(300, 32, 151, 49);
		contentPane.add(lblTuesday);

		JLabel lblWednesday = new JLabel(days[3]);
		lblWednesday.setHorizontalAlignment(SwingConstants.CENTER);
		lblWednesday.setForeground(SystemColor.desktop);
		lblWednesday.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblWednesday.setBounds(450, 32, 151, 49);
		contentPane.add(lblWednesday);

		JLabel lblThursday = new JLabel(days[4]);
		lblThursday.setHorizontalAlignment(SwingConstants.CENTER);
		lblThursday.setForeground(SystemColor.desktop);
		lblThursday.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblThursday.setBounds(600, 32, 151, 49);
		contentPane.add(lblThursday);

		JLabel lblFriday = new JLabel(days[5]);
		lblFriday.setHorizontalAlignment(SwingConstants.CENTER);
		lblFriday.setForeground(SystemColor.desktop);
		lblFriday.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFriday.setBounds(750, 32, 151, 49);
		contentPane.add(lblFriday);

		JLabel lblSaturday = new JLabel(days[6]);
		lblSaturday.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaturday.setForeground(SystemColor.desktop);
		lblSaturday.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSaturday.setBounds(900, 32, 150, 49);
		contentPane.add(lblSaturday);

		JSeparator separator = new JSeparator();
		separator.setBackground(SystemColor.desktop);
		separator.setBounds(30, 80, 1020, 9);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(SystemColor.infoText);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(150, 32, 9, 400);
		contentPane.add(separator_1);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBackground(SystemColor.desktop);
		separator_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1.setBounds(300, 32, 9, 400);
		contentPane.add(separator_1_1);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBackground(SystemColor.desktop);
		separator_1_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1_1.setBounds(900, 32, 9, 400);
		contentPane.add(separator_1_1_1);

		JSeparator separator_1_1_2 = new JSeparator();
		separator_1_1_2.setBackground(SystemColor.desktop);
		separator_1_1_2.setOrientation(SwingConstants.VERTICAL);
		separator_1_1_2.setBounds(450, 32, 9, 400);
		contentPane.add(separator_1_1_2);

		JSeparator separator_1_1_3 = new JSeparator();
		separator_1_1_3.setBackground(SystemColor.desktop);
		separator_1_1_3.setOrientation(SwingConstants.VERTICAL);
		separator_1_1_3.setBounds(750, 32, 9, 400);
		contentPane.add(separator_1_1_3);

		JSeparator separator_1_1_4 = new JSeparator();
		separator_1_1_4.setBackground(SystemColor.desktop);
		separator_1_1_4.setOrientation(SwingConstants.VERTICAL);
		separator_1_1_4.setBounds(600, 32, 9, 400);
		contentPane.add(separator_1_1_4);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(SystemColor.desktop);
		separator_2.setBounds(30, 150, 1020, 9);
		contentPane.add(separator_2);

		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBackground(SystemColor.controlText);
		separator_2_1.setBounds(30, 220, 1020, 9);
		contentPane.add(separator_2_1);

		JSeparator separator_2_2 = new JSeparator();
		separator_2_2.setBackground(SystemColor.desktop);
		separator_2_2.setBounds(30, 290, 1020, 2);
		contentPane.add(separator_2_2);

		JSeparator separator_2_3 = new JSeparator();
		separator_2_3.setBackground(SystemColor.desktop);
		separator_2_3.setBounds(30, 360, 1020, 9);
		contentPane.add(separator_2_3);

		JSeparator separator_2_4 = new JSeparator();
		separator_2_4.setBackground(SystemColor.desktop);
		separator_2_4.setBounds(30, 430, 1020, 33);
		contentPane.add(separator_2_4);

		JLabel lbl1 = new JLabel("1");
		lbl1.setBackground(SystemColor.textHighlight);
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl1.setForeground(SystemColor.textText);
		lbl1.setBounds(30, 83, 121, 69);
		contentPane.add(lbl1);
		lbl1.addMouseListener(this);

		JLabel lbl2 = new JLabel("2");
		lbl2.setBackground(SystemColor.infoText);
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setForeground(SystemColor.controlText);
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl2.setBounds(150, 83, 151, 69);
		contentPane.add(lbl2);
		lbl2.addMouseListener(this);

		JLabel lbl3 = new JLabel("3");
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3.setForeground(SystemColor.desktop);
		lbl3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl3.setBounds(300, 83, 151, 69);
		contentPane.add(lbl3);
		lbl3.addMouseListener(this);

		JLabel lbl4 = new JLabel("4");
		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl4.setForeground(SystemColor.desktop);
		lbl4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl4.setBounds(450, 83, 151, 69);
		contentPane.add(lbl4);
		lbl4.addMouseListener(this);

		JLabel lbl5 = new JLabel("5");
		lbl5.setHorizontalAlignment(SwingConstants.CENTER);
		lbl5.setForeground(Color.BLACK);
		lbl5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl5.setBounds(600, 83, 151, 69);
		contentPane.add(lbl5);
		lbl5.addMouseListener(this);

		JLabel lbl6 = new JLabel("6");
		lbl6.setHorizontalAlignment(SwingConstants.CENTER);
		lbl6.setForeground(Color.BLACK);
		lbl6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl6.setBounds(750, 83, 151, 69);
		contentPane.add(lbl6);
		lbl6.addMouseListener(this);

		JLabel lbl7 = new JLabel("7");
		lbl7.setHorizontalAlignment(SwingConstants.CENTER);
		lbl7.setForeground(Color.BLACK);
		lbl7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl7.setBounds(899, 83, 151, 69);
		contentPane.add(lbl7);
		lbl7.addMouseListener(this);

		JLabel lbl9 = new JLabel("9");
		lbl9.setHorizontalAlignment(SwingConstants.CENTER);
		lbl9.setForeground(SystemColor.controlText);
		lbl9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl9.setBounds(150, 150, 151, 69);
		contentPane.add(lbl9);
		lbl9.addMouseListener(this);

		JLabel lbl10 = new JLabel("10");
		lbl10.setHorizontalAlignment(SwingConstants.CENTER);
		lbl10.setForeground(SystemColor.desktop);
		lbl10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl10.setBounds(300, 150, 151, 69);
		contentPane.add(lbl10);
		lbl10.addMouseListener(this);

		JLabel lbl11 = new JLabel("11");
		lbl11.setHorizontalAlignment(SwingConstants.CENTER);
		lbl11.setForeground(SystemColor.desktop);
		lbl11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl11.setBounds(450, 150, 151, 69);
		contentPane.add(lbl11);
		lbl11.addMouseListener(this);

		JLabel lbl12 = new JLabel("12");
		lbl12.setHorizontalAlignment(SwingConstants.CENTER);
		lbl12.setForeground(Color.BLACK);
		lbl12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl12.setBounds(600, 150, 151, 69);
		contentPane.add(lbl12);
		lbl12.addMouseListener(this);

		JLabel lbl13 = new JLabel("13");
		lbl13.setHorizontalAlignment(SwingConstants.CENTER);
		lbl13.setForeground(Color.BLACK);
		lbl13.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl13.setBounds(750, 150, 151, 69);
		contentPane.add(lbl13);
		lbl13.addMouseListener(this);

		JLabel lbl14 = new JLabel("14");
		lbl14.setHorizontalAlignment(SwingConstants.CENTER);
		lbl14.setForeground(Color.BLACK);
		lbl14.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl14.setBounds(899, 150, 151, 69);
		contentPane.add(lbl14);
		lbl14.addMouseListener(this);

		JLabel lbl16 = new JLabel("16");
		lbl16.setHorizontalAlignment(SwingConstants.CENTER);
		lbl16.setForeground(SystemColor.desktop);
		lbl16.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl16.setBounds(150, 220, 151, 69);
		contentPane.add(lbl16);
		lbl16.addMouseListener(this);

		JLabel lbl17 = new JLabel("17");
		lbl17.setHorizontalAlignment(SwingConstants.CENTER);
		lbl17.setForeground(SystemColor.desktop);
		lbl17.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl17.setBounds(300, 220, 151, 69);
		contentPane.add(lbl17);
		lbl17.addMouseListener(this);

		JLabel lbl18 = new JLabel("18");
		lbl18.setHorizontalAlignment(SwingConstants.CENTER);
		lbl18.setForeground(Color.BLACK);
		lbl18.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl18.setBounds(450, 220, 151, 69);
		contentPane.add(lbl18);
		lbl18.addMouseListener(this);

		JLabel lbl19 = new JLabel("19");
		lbl19.setHorizontalAlignment(SwingConstants.CENTER);
		lbl19.setForeground(Color.BLACK);
		lbl19.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl19.setBounds(600, 220, 151, 69);
		contentPane.add(lbl19);
		lbl19.addMouseListener(this);

		JLabel lbl20 = new JLabel("20");
		lbl20.setHorizontalAlignment(SwingConstants.CENTER);
		lbl20.setForeground(Color.BLACK);
		lbl20.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl20.setBounds(750, 220, 151, 69);
		contentPane.add(lbl20);
		lbl20.addMouseListener(this);

		JLabel lbl21 = new JLabel("21");
		lbl21.setHorizontalAlignment(SwingConstants.CENTER);
		lbl21.setForeground(Color.BLACK);
		lbl21.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl21.setBounds(899, 220, 151, 69);
		contentPane.add(lbl21);
		lbl21.addMouseListener(this);

		JLabel lbl23 = new JLabel("23");
		lbl23.setHorizontalAlignment(SwingConstants.CENTER);
		lbl23.setForeground(SystemColor.desktop);
		lbl23.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl23.setBounds(150, 290, 151, 69);
		contentPane.add(lbl23);
		lbl23.addMouseListener(this);

		JLabel lbl24 = new JLabel("24");
		lbl24.setHorizontalAlignment(SwingConstants.CENTER);
		lbl24.setForeground(SystemColor.desktop);
		lbl24.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl24.setBounds(300, 290, 151, 69);
		contentPane.add(lbl24);
		lbl24.addMouseListener(this);

		JLabel lbl25 = new JLabel("25");
		lbl25.setHorizontalAlignment(SwingConstants.CENTER);
		lbl25.setForeground(Color.BLACK);
		lbl25.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl25.setBounds(450, 290, 151, 69);
		contentPane.add(lbl25);
		lbl25.addMouseListener(this);

		JLabel lbl26 = new JLabel("26");
		lbl26.setHorizontalAlignment(SwingConstants.CENTER);
		lbl26.setForeground(Color.BLACK);
		lbl26.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl26.setBounds(600, 290, 151, 69);
		contentPane.add(lbl26);
		lbl26.addMouseListener(this);

		JLabel lbl27 = new JLabel("27");
		lbl27.setHorizontalAlignment(SwingConstants.CENTER);
		lbl27.setForeground(Color.BLACK);
		lbl27.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl27.setBounds(750, 290, 151, 69);
		contentPane.add(lbl27);
		lbl27.addMouseListener(this);

		JLabel lbl28 = new JLabel("28");
		lbl28.setHorizontalAlignment(SwingConstants.CENTER);
		lbl28.setForeground(Color.BLACK);
		lbl28.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl28.setBounds(899, 290, 151, 69);
		contentPane.add(lbl28);
		lbl28.addMouseListener(this);

		if (month != 2) {
			JButton btnNewButton_2_4 = new JButton("");
			btnNewButton_2_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			 
							try {
								print.print_weekly_appointments(username , "29" , "31" , nameOfMonth , nameOfYear );
							} catch (SQLException | FileNotFoundException ee) {
								// TODO Auto-generated catch block
								ee.printStackTrace();
							}
			 
				}
			});
			btnNewButton_2_4.setIcon(new ImageIcon("Capture.JPG"));
			btnNewButton_2_4.setForeground(Color.WHITE);
			btnNewButton_2_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnNewButton_2_4.setBackground(Color.DARK_GRAY);
			btnNewButton_2_4.setBounds(1075, 381, 43, 33);
			contentPane.add(btnNewButton_2_4);
			
			JLabel lbl30 = new JLabel("30");
			lbl30.setHorizontalAlignment(SwingConstants.CENTER);
			lbl30.setForeground(Color.BLACK);
			lbl30.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbl30.setBounds(150, 360, 151, 69);
			contentPane.add(lbl30);
			lbl30.addMouseListener(this);
			if (appointment[29].equals("Booked")) {

				lbl30.setBackground(Color.blue);
				lbl30.setOpaque(true);
			}
		}
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			JLabel lbl31 = new JLabel("31");
			lbl31.setHorizontalAlignment(SwingConstants.CENTER);
			lbl31.setForeground(Color.BLACK);
			lbl31.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbl31.setBounds(300, 360, 151, 69);
			contentPane.add(lbl31);
			lbl31.addMouseListener(this);
			if (appointment[30].equals("Booked")) {

				lbl31.setBackground(Color.blue);
				lbl31.setOpaque(true);
			}
		}

		JLabel lbl8 = new JLabel("8");
		lbl8.setHorizontalAlignment(SwingConstants.CENTER);
		lbl8.setForeground(SystemColor.desktop);
		lbl8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl8.setBounds(30, 150, 122, 69);
		contentPane.add(lbl8);
		lbl8.addMouseListener(this);

		JLabel lbl15 = new JLabel("15");
		lbl15.setHorizontalAlignment(SwingConstants.CENTER);
		lbl15.setForeground(SystemColor.controlText);
		lbl15.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl15.setBounds(30, 220, 122, 69);
		contentPane.add(lbl15);
		lbl15.addMouseListener(this);

		JLabel lbl22 = new JLabel("22");
		lbl22.setHorizontalAlignment(SwingConstants.CENTER);
		lbl22.setForeground(SystemColor.controlText);
		lbl22.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl22.setBounds(30, 290, 122, 69);
		contentPane.add(lbl22);
		lbl22.addMouseListener(this); 
		if (month != 2 || year % 4 == 0 || year % 400 == 0) {
		
			if (year % 100 != 0) {
				JLabel lbl29 = new JLabel("29");
				lbl29.setHorizontalAlignment(SwingConstants.CENTER);
				lbl29.setForeground(Color.BLACK);
				lbl29.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lbl29.setBounds(30, 360, 122, 69);
				contentPane.add(lbl29);
				lbl29.addMouseListener(this);
				if (appointment[28].equals("Booked")) {

					lbl29.setBackground(Color.blue);
					lbl29.setOpaque(true);
				}
			}
		}
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBackground(SystemColor.infoText);
		separator_1_2.setOrientation(SwingConstants.VERTICAL);
		separator_1_2.setBounds(31, 32, 9, 400);
		contentPane.add(separator_1_2);

		JSeparator separator_1_1_5 = new JSeparator();
		separator_1_1_5.setBackground(SystemColor.desktop);
		separator_1_1_5.setOrientation(SwingConstants.VERTICAL);
		separator_1_1_5.setBounds(1050, 32, 9, 400);
		contentPane.add(separator_1_1_5);

		JSeparator separator_2_4_1 = new JSeparator();
		separator_2_4_1.setBackground(SystemColor.controlText);
		separator_2_4_1.setBounds(30, 28, 1022, 16);
		contentPane.add(separator_2_4_1);

		JButton btnNewButton = new JButton("View");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				year = yearChooser.getYear();
				month = monthChooser.getMonth() + 1;
				Months name = new Months();
				nameOfMonth = name.get_month_name(month);
				nameOfYear = Integer.toString(year);
		 
				currentMonth = nameOfMonth + "-" + year;
				inputDate = "01/" + month + "/" + year;
				SimpleDateFormat format1 = new SimpleDateFormat("dd/M/yyyy");
				Date dt1 = null;
				try {
					dt1 = format1.parse(inputDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				DateFormat format2 = new SimpleDateFormat("EEEE");
				finalDay = format2.format(dt1);
				frame.dispose();
				DaysOfWeek day = new DaysOfWeek();
				day.daysOfWeek(finalDay);

				try {
					view_month(username);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(640, 460, 104, 33);
		contentPane.add(btnNewButton);
 
		yearChooser = new JYearChooser();
		yearChooser.getSpinner().setForeground(Color.LIGHT_GRAY);
		yearChooser.getSpinner().setBackground(Color.LIGHT_GRAY);
		yearChooser.setBounds(542, 460, 58, 33);
		contentPane.add(yearChooser);

		monthChooser = new JMonthChooser();
		monthChooser.getComboBox().setBackground(Color.LIGHT_GRAY);
		monthChooser.getComboBox().setFont(new Font("Tahoma", Font.PLAIN, 15));
		monthChooser.setBounds(402, 460, 130, 33);
		contentPane.add(monthChooser);

		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setText("Month " + nameOfMonth+ "-" + nameOfYear );
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(30, 461, 186, 32);
		contentPane.add(lblNewLabel_2);

		lblNewLabel1 = new JLabel(appointment[0]);
		lblNewLabel1.setBounds(97, 125, 49, 14);
		contentPane.add(lblNewLabel1);

		JLabel lblNewLabel2 = new JLabel(appointment[1]);
		lblNewLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel2.setBounds(241, 125, 49, 14);
		contentPane.add(lblNewLabel2);

		JLabel lblNewLabel3 = new JLabel(appointment[2]);
		lblNewLabel3.setBounds(391, 125, 49, 14);
		contentPane.add(lblNewLabel3);

		JLabel lblNewLabel4 = new JLabel(appointment[3]);
		lblNewLabel4.setBounds(542, 125, 49, 14);
		contentPane.add(lblNewLabel4);

		JLabel lblNewLabel5 = new JLabel(appointment[4]);
		lblNewLabel5.setBounds(691, 125, 49, 14);
		contentPane.add(lblNewLabel5);

		JLabel lblNewLabel6 = new JLabel(appointment[5]);
		lblNewLabel6.setBounds(836, 125, 49, 14);
		contentPane.add(lblNewLabel6);

		JLabel lblNewLabel7 = new JLabel(appointment[6]);
		lblNewLabel7.setBounds(993, 125, 49, 14);
		contentPane.add(lblNewLabel7);

		JLabel lblNewLabel8 = new JLabel(appointment[7]);
		lblNewLabel8.setBounds(97, 196, 49, 14);
		contentPane.add(lblNewLabel8);

		JLabel lblNewLabel9 = new JLabel(appointment[8]);
		lblNewLabel9.setBounds(241, 195, 49, 14);
		contentPane.add(lblNewLabel9);

		JLabel lblNewLabel10 = new JLabel(appointment[9]);
		lblNewLabel10.setBounds(391, 196, 49, 14);
		contentPane.add(lblNewLabel10);

		JLabel lblNewLabel11 = new JLabel(appointment[10]);
		lblNewLabel11.setBounds(541, 195, 49, 14);
		contentPane.add(lblNewLabel11);

		JLabel lblNewLabel12 = new JLabel(appointment[11]);
		lblNewLabel12.setBounds(691, 195, 49, 14);
		contentPane.add(lblNewLabel12);

		JLabel lblNewLabel13 = new JLabel(appointment[12]);
		lblNewLabel13.setBounds(836, 196, 49, 14);
		contentPane.add(lblNewLabel13);

		JLabel lblNewLabel14 = new JLabel(appointment[13]);
		lblNewLabel14.setBounds(993, 195, 49, 14);
		contentPane.add(lblNewLabel14);

		JLabel lblNewLabel15 = new JLabel(appointment[14]);
		lblNewLabel15.setBounds(97, 265, 49, 14);
		contentPane.add(lblNewLabel15);

		JLabel lblNewLabel16 = new JLabel(appointment[15]);
		lblNewLabel16.setBounds(241, 264, 49, 14);
		contentPane.add(lblNewLabel16);

		JLabel lblNewLabel17 = new JLabel(appointment[16]);
		lblNewLabel17.setBounds(391, 265, 49, 14);
		contentPane.add(lblNewLabel17);

		JLabel lblNewLabel18 = new JLabel(appointment[17]);
		lblNewLabel18.setBounds(542, 265, 49, 14);
		contentPane.add(lblNewLabel18);

		JLabel lblNewLabel19 = new JLabel(appointment[18]);
		lblNewLabel19.setBounds(691, 264, 49, 14);
		contentPane.add(lblNewLabel19);

		JLabel lblNewLabel20 = new JLabel(appointment[19]);
		lblNewLabel20.setBounds(841, 264, 49, 14);
		contentPane.add(lblNewLabel20);

		JLabel lblNewLabel21 = new JLabel(appointment[20]);
		lblNewLabel21.setBounds(993, 265, 49, 14);
		contentPane.add(lblNewLabel21);

		JLabel lblNewLabel22 = new JLabel(appointment[21]);
		lblNewLabel22.setBounds(97, 335, 49, 14);
		contentPane.add(lblNewLabel22);

		JLabel lblNewLabel23 = new JLabel(appointment[22]);
		lblNewLabel23.setBounds(241, 334, 49, 14);
		contentPane.add(lblNewLabel23);

		JLabel lblNewLabel24 = new JLabel(appointment[23]);
		lblNewLabel24.setBounds(391, 334, 49, 14);
		contentPane.add(lblNewLabel24);

		JLabel lblNewLabel25 = new JLabel(appointment[24]);
		lblNewLabel25.setBounds(541, 334, 49, 14);
		contentPane.add(lblNewLabel25);

		JLabel lblNewLabel26 = new JLabel(appointment[25]);
		lblNewLabel26.setBounds(691, 334, 49, 14);
		contentPane.add(lblNewLabel26);

		JLabel lblNewLabel27 = new JLabel(appointment[26]);
		lblNewLabel27.setBounds(836, 334, 49, 14);
		contentPane.add(lblNewLabel27);

		if (appointment[0].equals("Booked")) {

			lbl1.setBackground(Color.blue);
			lbl1.setOpaque(true);
		}
		if (appointment[1].equals("Booked")) {

			lbl2.setBackground(Color.blue);
			lbl2.setOpaque(true);
		}
		if (appointment[2].equals("Booked")) {

			lbl3.setBackground(Color.blue);
			lbl3.setOpaque(true);
		}
		if (appointment[3].equals("Booked")) {

			lbl4.setBackground(Color.blue);
			lbl4.setOpaque(true);
		}
		if (appointment[4].equals("Booked")) {

			lbl5.setBackground(Color.blue);
			lbl5.setOpaque(true);
		}
		if (appointment[5].equals("Booked")) {

			lbl6.setBackground(Color.blue);
			lbl6.setOpaque(true);
		}
		if (appointment[5].equals("Booked")) {

			lbl6.setBackground(Color.blue);
			lbl6.setOpaque(true);
		}
		if (appointment[6].equals("Booked")) {

			lbl7.setBackground(Color.blue);
			lbl7.setOpaque(true);
		}
		if (appointment[7].equals("Booked")) {

			lbl8.setBackground(Color.blue);
			lbl8.setOpaque(true);
		}
		if (appointment[8].equals("Booked")) {

			lbl9.setBackground(Color.blue);
			lbl9.setOpaque(true);
		}
		if (appointment[9].equals("Booked")) {

			lbl10.setBackground(Color.blue);
			lbl10.setOpaque(true);
		}
		if (appointment[10].equals("Booked")) {

			lbl11.setBackground(Color.blue);
			lbl11.setOpaque(true);
		}
		if (appointment[11].equals("Booked")) {

			lbl12.setBackground(Color.blue);
			lbl12.setOpaque(true);
		}
		if (appointment[12].equals("Booked")) {

			lbl13.setBackground(Color.blue);
			lbl13.setOpaque(true);
		}
		if (appointment[13].equals("Booked")) {

			lbl14.setBackground(Color.blue);
			lbl14.setOpaque(true);
		}
		if (appointment[14].equals("Booked")) {

			lbl15.setBackground(Color.blue);
			lbl15.setOpaque(true);
		}
		if (appointment[15].equals("Booked")) {

			lbl16.setBackground(Color.blue);
			lbl16.setOpaque(true);
		}
		if (appointment[16].equals("Booked")) {

			lbl17.setBackground(Color.blue);
			lbl17.setOpaque(true);
		}
		if (appointment[17].equals("Booked")) {

			lbl18.setBackground(Color.blue);
			lbl18.setOpaque(true);
		}
		if (appointment[18].equals("Booked")) {

			lbl19.setBackground(Color.blue);
			lbl19.setOpaque(true);
		}
		if (appointment[19].equals("Booked")) {

			lbl20.setBackground(Color.blue);
			lbl20.setOpaque(true);
		}
		if (appointment[20].equals("Booked")) {

			lbl21.setBackground(Color.blue);
			lbl21.setOpaque(true);
		}
		if (appointment[21].equals("Booked")) {

			lbl22.setBackground(Color.blue);
			lbl22.setOpaque(true);
		}
		if (appointment[22].equals("Booked")) {

			lbl23.setBackground(Color.blue);
			lbl23.setOpaque(true);
		}
		if (appointment[23].equals("Booked")) {

			lbl24.setBackground(Color.blue);
			lbl24.setOpaque(true);
		}
		if (appointment[24].equals("Booked")) {

			lbl25.setBackground(Color.blue);
			lbl25.setOpaque(true);
		}
		if (appointment[25].equals("Booked")) {

			lbl26.setBackground(Color.blue);
			lbl26.setOpaque(true);
		}
		if (appointment[26].equals("Booked")) {

			lbl27.setBackground(Color.blue);
			lbl27.setOpaque(true);
		}
		if (appointment[27].equals("Booked")) {

			lbl28.setBackground(Color.blue);
			lbl28.setOpaque(true);
		}

		JLabel lblNewLabel28 = new JLabel(appointment[27]);
		lblNewLabel28.setBounds(993, 334, 49, 14);
		contentPane.add(lblNewLabel28);

		JLabel lblNewLabel29 = new JLabel(appointment[28]);
		lblNewLabel29.setBounds(97, 404, 49, 14);
		contentPane.add(lblNewLabel29);

		JLabel lblNewLabel30 = new JLabel(appointment[29]);
		lblNewLabel30.setBounds(241, 404, 49, 14);
		contentPane.add(lblNewLabel30);

		JLabel lblNewLabel31 = new JLabel(appointment[30]);
		lblNewLabel31.setBounds(391, 404, 49, 14);
		contentPane.add(lblNewLabel31);

		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				System.exit(0);
			}

		});
		btnNewButton_1.setBounds(1060, 460, 104, 33);
		contentPane.add(btnNewButton_1);
		print = new PrintWeek();
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
			 
				try {
					print.print_weekly_appointments(username , "01" , "07" , nameOfMonth , nameOfYear );
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("Capture.JPG"));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.setBounds(1075, 99, 43, 33);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					print.print_weekly_appointments(username , "08" , "14" , nameOfMonth , nameOfYear );
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_2_1.setIcon(new ImageIcon("Capture.JPG"));
		btnNewButton_2_1.setForeground(Color.WHITE);
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2_1.setBackground(Color.DARK_GRAY);
		btnNewButton_2_1.setBounds(1075, 175, 43, 33);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					print.print_weekly_appointments(username , "15" , "21" , nameOfMonth , nameOfYear );
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2_2.setIcon(new ImageIcon("Capture.JPG"));
		btnNewButton_2_2.setForeground(Color.WHITE);
		btnNewButton_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2_2.setBounds(1075, 245, 43, 33);
		contentPane.add(btnNewButton_2_2);
		
		JButton btnNewButton_2_3 = new JButton("");
		btnNewButton_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					print.print_weekly_appointments(username , "22" , "28" , nameOfMonth , nameOfYear );
				} catch (SQLException ee) {
					// TODO Auto-generated catch block
					ee.printStackTrace();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
	 		
		btnNewButton_2_3.setIcon(new ImageIcon("Capture.JPG"));
		btnNewButton_2_3.setForeground(Color.WHITE);
		btnNewButton_2_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2_3.setBackground(Color.DARK_GRAY);
		btnNewButton_2_3.setBounds(1075, 315, 43, 33);
		contentPane.add(btnNewButton_2_3);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("abstract-white-futuristic-background-connecting-dots-lines-white-background-abstract-white-futuristic-background-white-146584221.jpg"));
		lblNewLabel_1.setBounds(0, -14, 1191, 579);
		contentPane.add(lblNewLabel_1);
	}
/**
 * Gets the command of mouse click and opens the day that is selected by mouse.
 * @param e mouse command
 */
	public void mouseClicked(MouseEvent e) {
 
		JLabel l = (JLabel) e.getSource();
		Months name = new Months();
		inputDate = name.get_month_name(month) + " " + l.getText() + ", " + year;

		ViewDay view = new ViewDay();
		view.view_day(inputDate);
	}
/**
 * Turns the number to gray when the mouse pointer is entered in the label
 * @param e mouse command
 */
	@Override
	public void mouseEntered(MouseEvent e) {
 		JLabel l = (JLabel) e.getSource();
		l.setForeground(SystemColor.gray);
	}
/**
 * When the mouse pointer exits the number is again turned the orginal color black
 * @param e mouse command
 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel l = (JLabel) e.getSource();
		l.setForeground(SystemColor.black);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		 
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		 
	}
}
