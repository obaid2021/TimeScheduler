
package start;
import warnings.Error;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
/**
 * Verifies the code sent to user via Email to register.
 * @author Win10 Pro x64
 *
 */
public class EnterCode extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	static int checkCode;
	static EnterCode frame;
 
/**
 * Creates the frame for entering code.
 * @param code is the number that was sent to user via Email.
 */
	public void verifyCode(int code) {
		checkCode = code;
		try {
			frame = new EnterCode();
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Creates a textfield and a button on the frame to take the input code.
	 */
	public EnterCode() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 192);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Verify Code");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(50, 49, 307, 41);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(190, 49, 209, 41);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Verify");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Error message = new Error();
				try {
				if (checkCode == Integer.parseInt(textField.getText())) {
					
					message.errorWarning("Email verified");
					frame.dispose();
				} else {
					message.errorWarning("Wrong code try again");
				}
				}
				catch (Exception ex)
				{
					message.errorWarning("Invalid Entry");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(190, 106, 94, 38);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegisterUser window = new RegisterUser();
				dispose();
				window.run();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(305, 106, 94, 38);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("abstract-white-futuristic-background-connecting-dots-lines-white-background-abstract-white-futuristic-background-white-146584221.jpg"));
		lblNewLabel_1.setBounds(0, 0, 511, 199);
		contentPane.add(lblNewLabel_1);
	}
}
