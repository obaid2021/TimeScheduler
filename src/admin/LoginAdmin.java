package admin;

import warnings.Error;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
/**
 * This class shows a frame for the administrator to login.
 * @author Muhammad Obaid Ullah, Syed Adil Ehsan, Rao Shahan Naveed
 *
 */
@SuppressWarnings("serial")
public class LoginAdmin extends JFrame {

	private JPanel contentPane;
	private JPasswordField textField;
	static private LoginAdmin frame;

	/**
	 *Creates a frame for admin to login. 
	 */
	public void admin_login() {

		try {
			frame = new LoginAdmin();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 *A window will be created for the admin to log in.
	 */
	public LoginAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 725, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Administrator ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(219, 62, 250, 46);
		contentPane.add(lblNewLabel);

		textField = new JPasswordField();
		textField.setBounds(219, 119, 240, 34);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(220, 164, 108, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String password = String.valueOf(textField.getPassword());
				if (password.equalsIgnoreCase("admin")) {
					Admin enter;
					try {
						enter = new Admin();
						enter.admin_login();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else {
					Error msg = new Error();
					msg.errorMessage("Wrong Password");
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(351, 164, 108, 23);
		contentPane.add(btnNewButton_1);
	}
}
