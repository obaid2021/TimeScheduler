package start;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import databaseManagement.FindProfile;
 

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
 /**
  * This class makes the login window in the application.
  * @author Muhammad Obaid Ullah , Syed Adil Ehsan , Rao Shahan Naveed
  *
  */
@SuppressWarnings("serial")
public class Login extends JFrame {

 
	private JPanel contentPane;
	static Login frame ;
	/**
	 * Runs Login frame
	 */
	public void login() {
		try {
			frame = new Login();
			if (!frame.isUndecorated()) {
				frame.setUndecorated(true);
			}
			frame.setVisible(true);
			frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	 

	/**
	 * Creates the login with text fields to get username and password with login button.
	 */
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Win10 Pro x64\\eclipse-workspace\\TimeScheduler\\Resources\\Clock.JPG"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(310, 50, 705, 558);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(105, 250, 145, 44);
		contentPane.add(lblPassword);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(105, 191, 145, 44);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JTextField textField = new JTextField("");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(240, 200, 265, 35);
		contentPane.add(textField);
		textField.setColumns(10);

		JPasswordField passwordField = new JPasswordField("");
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setBounds(240, 259, 265, 35);
		contentPane.add(passwordField);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			 	Welcome.main(null);
			}
		});
	 
		btnNewButton.setBounds(240, 333, 107, 35);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FindProfile verify = new FindProfile();
				frame.dispose();
				String password = String.valueOf(passwordField.getPassword()) ;
				try {
					verify.profileExists(textField.getText(), password);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
				
			}
		});
		btnNewButton_1.setBounds(398, 333, 107, 35);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				System.exit(0);
			}
		});
	 
		btnNewButton_2.setBounds(46, 53, 89, 35);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("Login Window");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2.setBounds(240, 37, 336, 59);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Win10 Pro x64\\eclipse-workspace\\TimeScheduler\\Resources\\abstract-white-futuristic-background-connecting-dots-lines-white-background-abstract-white-futuristic-background-white-146584221.jpg"));
		lblNewLabel_1.setBounds(0, 0, 852, 606);
		contentPane.add(lblNewLabel_1);
	}

}
