package start;

import email.SendEmail;
import encryption.Encrypt;
import encryption.SecretKey;
import utilities.RandomNumber;
import warnings.Error;

import javax.swing.JFrame;

import databaseManagement.*;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import javax.mail.MessagingException;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
/**
 * This class shows register form and takes information from user.
 * @author Muhammad Obaid Ullah , Adil Ehsan , Rao Shahan Naveed
 *
 */
public class RegisterUser extends JFrame {
 
	static RegisterUser frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	private String firstname, lastname, username, email;
	String password;
	String confirmPassword;
/**
 * Runs the Register frame.
 */
	public void run() {
		frame = new RegisterUser();
		if (!frame.isUndecorated()) {
			frame.setUndecorated(true);
		}
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	/**
	 * Creates the form on the frame with information fields to register in the application. 
	 */
	public RegisterUser() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Registeration Form");
		lblNewLabel_1.setBackground(SystemColor.textHighlight);
		lblNewLabel_1.setBounds(112, 25, 349, 71);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		getContentPane().add(lblNewLabel_1);

		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setBounds(10, 25, 89, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Welcome.main(null);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.setBounds(536, 28, 89, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				System.exit(0);
			}

		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(btnNewButton_2);

		JLabel lblNewLabel = new JLabel("First Name*");
		lblNewLabel.setBounds(95, 107, 110, 32);
		getContentPane().add(lblNewLabel);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblLastName = new JLabel("Last Name*");
		lblLastName.setBounds(95, 156, 110, 32);
		getContentPane().add(lblLastName);
		lblLastName.setForeground(Color.BLACK);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblEmail = new JLabel("Email*");
		lblEmail.setBounds(95, 264, 110, 32);
		getContentPane().add(lblEmail);
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblPassword = new JLabel("Password*");
		lblPassword.setBounds(95, 307, 110, 32);
		getContentPane().add(lblPassword);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(282, 107, 298, 30);
		getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblConfirmPassword_1 = new JLabel("Confirm Password*");
		lblConfirmPassword_1.setBounds(95, 365, 177, 32);
		lblConfirmPassword_1.setForeground(Color.BLACK);
		lblConfirmPassword_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblConfirmPassword_1);

		JLabel lblUsername = new JLabel("Username*");
		lblUsername.setBounds(95, 209, 110, 32);
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblUsername);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setBounds(282, 157, 298, 30);
		textField_1.setColumns(10);
		getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.setBounds(282, 210, 298, 30);
		textField_2.setColumns(10);
		getContentPane().add(textField_2);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_3.setBounds(282, 265, 298, 30);
		textField_3.setColumns(10);
		getContentPane().add(textField_3);

		passwordField = new JPasswordField();
		passwordField.setBounds(282, 315, 298, 32);
		getContentPane().add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(282, 365, 298, 32);
		getContentPane().add(passwordField_1);

		JButton btnNewButton = new JButton("Register");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				firstname = textField.getText();
				lastname = textField_1.getText();
				username = textField_2.getText();
				email = textField_3.getText();
				password = String.valueOf(passwordField.getPassword());
				confirmPassword = String.valueOf(passwordField_1.getPassword());
				SendEmail authenticate = new SendEmail();
				Error warning = new Error();
				try {

					UserInformation user_info = new UserInformation();
					DuplicateUser check = new DuplicateUser();
					boolean userName_exists = check.check_duplicate_in_database(username, email);
					if (firstname.equals("")) {
						warning.errorMessage("Field empty");
						textField.setBackground(Color.RED);
					} else if (lastname.equals("")) {
						warning.errorMessage("Field empty");
						textField_1.setBackground(Color.RED);
					} else if(username.equals(""))
					{
						warning.errorMessage("Field empty");
						textField_2.setBackground(Color.RED);
					}
					else if(email.equals(""))
					{
						warning.errorMessage("Field empty");
						textField_3.setBackground(Color.RED);
					} else if (userName_exists == true) {

						warning.errorMessage("User name or email already exist");
						textField_2.setBackground(Color.RED);
						textField_3.setBackground(Color.RED);

					}else if(!password.equals(confirmPassword))
					{
						passwordField.setBackground(Color.RED);
						passwordField_1.setBackground(Color.RED);
					}
					else if (userName_exists == false) {

						RandomNumber num = new RandomNumber();
						int random = num.randomNumber();
						String subject = "Verify your Email";
						String msg = "Please enter code " + random + " to register in the app";
						boolean valid = authenticate.send_email(email, subject, msg);

						if(valid == true)
						{
						EnterCode verify = new EnterCode();
						verify.verifyCode(random);
						SecretKey key = new SecretKey();
						int seckey = key.generate_secretkey();
						SecretKeyManager uploadkey = new SecretKeyManager();
						uploadkey.upload_secretkey(seckey, username);

						firstname = Encrypt.encrypt(firstname, seckey);
						lastname = Encrypt.encrypt(lastname, seckey);
						email = Encrypt.encrypt(email, seckey);
						password = Encrypt.encrypt(password, seckey);

						user_info.uploadInfo(username, firstname, lastname, email, password);
						frame.dispose();
						Login window2 = new Login();
						window2.login();
						}
					}
					 

				} catch (SQLException | MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(282, 416, 110, 32);
		getContentPane().add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(
				"abstract-white-futuristic-background-connecting-dots-lines-white-background-abstract-white-futuristic-background-white-146584221.jpg"));
		lblNewLabel_2.setBounds(0, 0, 816, 588);
		getContentPane().add(lblNewLabel_2);
		setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(310, 50, 689, 549);
	}
}
