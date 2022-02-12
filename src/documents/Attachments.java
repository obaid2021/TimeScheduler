package documents;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import databaseManagement.FileManagement;
import start.Welcome;

import javax.swing.JButton;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

/**
 * This class shows the attachment window in the application. User can view and download the attachments
 * attached of each event booked.
 * @author Muhammad Obaid Ullah , Syed Adil Ehsan , Rao Shahan Naveed
 */
@SuppressWarnings("serial")
public class Attachments extends JFrame implements MouseListener {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	static int eventID;
	static Attachments frame;

	/**
	 * Creates a frame for the event id.
	 * @param id event id that was selected by user to open attachments.
	 */

	public void view_attachment(int id) {
		try {
			eventID = id;
			frame = new Attachments();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Makes a frame which shows the attachments in the form of table. User has the option to download 
	 * and delete the attachments.
	 * @throws SQLException SQL connectivity and commands errors are caught.
	 */
	public Attachments() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 200, 628, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(395, 37, 145, 215);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "File" }));
		table.addMouseListener(this);
		scrollPane.setViewportView(table);
		read_filenames(eventID);

		JButton btnNewButton = new JButton("Download");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileName = textField.getText();
				FileManagement database = new FileManagement();
				try {
					database.read_file_database(fileName, eventID);
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(138, 161, 145, 23);
		contentPane.add(btnNewButton);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(Color.DARK_GRAY);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDelete.setBounds(138, 195, 145, 23);
		contentPane.add(btnDelete);

		textField = new JTextField();
		textField.setBounds(112, 98, 210, 31);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Select a file here");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(386, 5, 218, 21);
		contentPane.add(lblNewLabel);

		JButton btnClose = new JButton("Close");
		btnClose.setForeground(Color.WHITE);
		btnClose.setBackground(Color.DARK_GRAY);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnClose.setBounds(138, 229, 145, 23);
		contentPane.add(btnClose);

		JLabel lblNewLabel_2 = new JLabel("Selected File");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(112, 56, 197, 31);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(
				"abstract-white-futuristic-background-connecting-dots-lines-white-background-abstract-white-futuristic-background-white-146584221.jpg"));
		lblNewLabel_1.setBounds(-12, 0, 659, 318);
		contentPane.add(lblNewLabel_1);
	}
/**
 * mouse click selects the attachment from the list shown.
 * @param e command received from mouse
 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int index = table.getSelectedRow();
		textField.setText(model.getValueAt(index, 0).toString());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
/**
 * reads the attachments from the database and puts them in the table.
 * @param eventIDs each event id has its own attachments
 * @throws SQLException sql errors in connectivity and commands
 */ 
	void read_filenames(int eventIDs) throws SQLException {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		Statement stmt = Welcome.con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from file where event_id ='" + eventIDs + "'");

		String name;
		while (rs.next()) {

			name = rs.getString("file_name");
			tableModel.addRow(new Object[] { name });
		}

	}
}
