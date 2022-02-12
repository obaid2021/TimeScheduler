package admin;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

import databaseManagement.SecretKeyManager;
import databaseManagement.UserInformation;
import encryption.Decrypt;
import encryption.Encrypt;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
/**
 *this class is used for admin GUI.User profiles are read into a table.
 *a profile can be modified or deleted.
 * @author Muhammad Obaid Ullah, Syed Adil Ehsan, Rao Shahan Naveed
 *
 */
@SuppressWarnings("serial")
public class Admin extends JFrame implements MouseListener {

	private JPanel contentPane;
	static public JTable table_1;
	static private Admin frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblNewLabel_1;
	static private String username, firstname, lastname, email, password;
	static private int seckey = 0;

	/**
	 *makes a frame for admin GUI.
	 */
	public void admin_login() {
		try {
			frame = new Admin();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 *creates a table.Shows buttons to update and delete the users from the table.Reads data from the database <p>
	 *into the table.Reveal button will decrypt the data of the tables.
	 * 
	 * @throws SQLException Sql connectivity and command errors will be checked
	 */
	public Admin() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1233, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String profile = lblNewLabel_1.getText();
				if (profile.isEmpty()) {
				} else {
					int result = JOptionPane.showConfirmDialog(frame, "Sure? You want to Delete?", "Confirm",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (result == JOptionPane.YES_OPTION) {
						UserInformation action = new UserInformation();
						try {
							action.deleleProfile(profile);
							frame.setVisible(false);
							admin_login();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else if (result == JOptionPane.NO_OPTION) {
					 
					} else {
						 
					}

				}
			}
		});
		btnNewButton.setBounds(143, 337, 111, 36);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(btnNewButton);

		JButton btnEdit = new JButton("Update");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserInformation info = new UserInformation();
				String profile = lblNewLabel_1.getText();

				try {

					username = lblNewLabel_1.getText();
					username = Encrypt.encrypt(username, seckey);

					firstname = textField_1.getText();
					firstname = Encrypt.encrypt(firstname, seckey);

					lastname = textField_2.getText();
					lastname = Encrypt.encrypt(lastname, seckey);

					email = textField_3.getText();
					email = Encrypt.encrypt(email, seckey);

					password = textField_4.getText();
					password = Encrypt.encrypt(password, seckey);

					info.update_info(profile, firstname, lastname, email, password);
					frame.setVisible(false);
					admin_login();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnEdit.setBounds(10, 337, 111, 36);
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(btnEdit);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(554, 51, 634, 287);
		contentPane.add(scrollPane);

		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		table_1.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Username", "Firstname", "Lastname", "Email", "Password" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table_1);
		table_1.addMouseListener(this);

		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(23, 68, 159, 29);
		contentPane.add(lblNewLabel);

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnClose.setBounds(424, 337, 111, 36);
		contentPane.add(btnClose);

		JLabel lblFirstname = new JLabel("Firstname");
		lblFirstname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFirstname.setBounds(24, 115, 159, 29);
		contentPane.add(lblFirstname);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(192, 108, 232, 36);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(192, 155, 232, 36);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(192, 202, 232, 36);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(192, 250, 232, 36);
		contentPane.add(textField_4);

		JLabel lblLastname = new JLabel("Lastname");
		lblLastname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLastname.setBounds(24, 162, 159, 29);
		contentPane.add(lblLastname);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(24, 209, 159, 29);
		contentPane.add(lblEmail);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(24, 261, 159, 29);
		contentPane.add(lblPassword);

		lblNewLabel_1 = new JLabel("username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(192, 64, 232, 36);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton_1 = new JButton("Reveal");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				firstname = textField_1.getText();
				firstname = Decrypt.decrypt(firstname, seckey);
				textField_1.setText(firstname);

				lastname = textField_2.getText();
				lastname = Decrypt.decrypt(lastname, seckey);
				textField_2.setText(lastname);

				email = textField_3.getText();
				email = Decrypt.decrypt(email, seckey);
				textField_3.setText(email);

				password = textField_4.getText();
				password = Decrypt.decrypt(password, seckey);
				textField_4.setText(password);

			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(285, 337, 111, 36);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("abstract-white-futuristic-background-connecting-dots-lines-white-background-abstract-white-futuristic-background-white-146584221.jpg"));
		lblNewLabel_2.setBounds(-11, 0, 1260, 464);
		contentPane.add(lblNewLabel_2);

		UserInformation info = new UserInformation();
		info.downloadInformation();
	}
/**
 * this function will select the row from the table with a mouse click and put the entries into the text fields
 * @param arg0 command received from mouse action
 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		int index = table_1.getSelectedRow();
		lblNewLabel_1.setText(model.getValueAt(index, 0).toString());
		textField_1.setText(model.getValueAt(index, 1).toString());
		textField_2.setText(model.getValueAt(index, 2).toString());
		textField_3.setText(model.getValueAt(index, 3).toString());
		textField_4.setText(model.getValueAt(index, 4).toString());

		String profile = lblNewLabel_1.getText();
		SecretKeyManager key = new SecretKeyManager();
		try {
			seckey = key.download_secretkey(profile);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}
