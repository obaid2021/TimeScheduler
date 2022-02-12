package start;
//recent
import warnings.Error;
 
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
 
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.SystemColor;
import admin.LoginAdmin;
import databaseManagement.DeleteEvent;
 
/**
 * This class shows the first window of the program with register, login and admin buttons.
 * <p>
 * @author Muhammad Obaid Ullah , Rao Shahan Naveed , Syed Adil Ehsan
 *
 */
@SuppressWarnings("serial")
public class Welcome extends JFrame {

	private JPanel contentPane;
	static Welcome frame;
	public static Connection con;
	/**
	 * Main method connects mysql with eclipse IDE using the driver.<p>
	 * Deletes any empty events in the event_schedule table of the Database. Creates main frame.<p>
	 * Launches the application.
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		   try {
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/timeschedule?serverTimezone=Europe/Helsinki", "root", "Welcome@123");
	            System.out.print("Connection Succesful");
	            DeleteEvent delete = new DeleteEvent();
	            delete.delete_empty_events();
		   } catch (SQLException e) {
	            Error error= new Error();
				error.errorWarning("Connection with database was unsuccessful");

	            return;
	        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Welcome();
					frame.setLocationRelativeTo(null);  
					frame.setVisible(true);
					frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * This Constructor creates the frame with buttons on it.
	 */
	public Welcome() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Clock.JPG"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(310, 50, 772, 490);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				System.exit(0);
			}
		});
		btnNewButton.setBounds(10, 22, 111, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sign in");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login window = new Login();
				
				window.login();
			}
		});
		btnNewButton_1.setBounds(401, 241, 212, 43);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Time Scheduler");
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setForeground(SystemColor.desktop);
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(212, 97, 480, 59);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("Register");
		btnNewButton_2.setForeground(SystemColor.text);
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterUser window = new RegisterUser();
				dispose();
				window.run();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBounds(134, 241, 212, 43);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Admin");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginAdmin window = new LoginAdmin();
				window.admin_login();
			}
		});
		btnNewButton_2_1.setForeground(Color.WHITE);
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2_1.setBackground(Color.DARK_GRAY);
		btnNewButton_2_1.setBounds(267, 317, 212, 43);
		contentPane.add(btnNewButton_2_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("abstract-white-futuristic-background-connecting-dots-lines-white-background-abstract-white-futuristic-background-white-146584221.jpg"));
		lblNewLabel.setBounds(0, 0, 775, 467);
		contentPane.add(lblNewLabel);
	}
}
