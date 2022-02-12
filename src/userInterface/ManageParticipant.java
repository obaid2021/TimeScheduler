package userInterface;

 

import javax.swing.JFrame;
import warnings.Error;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
 
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
 
import databaseManagement.Participants;
import start.Welcome;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
/**
 * Participants of an Event will be managed in this class.
 * @author Muhammad Obaid Ullah , Syed Adil Ehsan , Rao Shahan Naveed
 *
 */
@SuppressWarnings("serial")
public class ManageParticipant extends JFrame implements MouseListener{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	private JTable table_1;
	static int eventID;
	String name, email;
	DefaultTableModel tableModel;
	static ManageParticipant frame;

	/**
	 * Creates a frame.
	 * @param ID is event's id 
	 * @throws SQLException shows error in connection with database and related to database
	 */
	public void participant_manage(int ID) throws SQLException {
		eventID = ID;
 
		try {
			frame = new ManageParticipant();
		 
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates frame and shows database entries of participants in the form of a table.<p>
	 * User can add and remove participants by using buttons.
	 * @throws SQLException shows error in connection with database and related to database
	 */
	public ManageParticipant() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 933, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Add\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				tableModel = (DefaultTableModel) table_1.getModel();
				name = textField.getText();
				email = textField_1.getText();
				Error msg = new Error();
				if(name.equals("") || email.equals(""))
				{
					msg.errorMessage("Field/s empty");
				}
				else {
				
				try {
					Participants participant = new Participants();

					int x = 0;
					x = participant.last_participant();
					x++; 
			 
					participant.add_participant(x, eventID, name, email);
			        frame.dispose();
			        participant_manage(eventID);
				} catch (SQLException e) {
				 
					e.printStackTrace();
				}
				}
			}
		});
		btnNewButton.setBounds(86, 137, 89, 23);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(10, 57, 130, 29);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 98, 130, 28);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblEmail);

		textField = new JTextField();
		textField.setBounds(86, 57, 250, 29);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(86, 97, 250, 29);
		textField_1.setColumns(10);
		contentPane.add(textField_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(403, 36, 470, 157);
		contentPane.add(scrollPane);

		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		table_1.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Name", "Email" }) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] { String.class, String.class };

			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_1.addMouseListener(this);
		scrollPane.setViewportView(table_1);
		read_participants();
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Participants participant;
				try {
					participant = new Participants();
					name = textField.getText();
					email = textField_1.getText();
					
					participant.delete_entry(name , email);
					frame.dispose();;
					participant_manage(eventID);
					
				} catch (SQLException e1) {
				 
					e1.printStackTrace();
				}
				 
			}
		});
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRemove.setBounds(200, 137, 122, 23);
		contentPane.add(btnRemove);
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnDone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDone.setBounds(132, 171, 122, 23);
		contentPane.add(btnDone);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("abstract-white-futuristic-background-connecting-dots-lines-white-background-abstract-white-futuristic-background-white-146584221.jpg"));
		lblNewLabel_1.setBounds(0, 0, 933, 292);
		contentPane.add(lblNewLabel_1);

	}
/**
 * Reads the participants from the database into a table.
 * @throws SQLException shows error in connection with database and related to database
 */
	void read_participants() throws SQLException {
		DefaultTableModel tableModel = (DefaultTableModel) table_1.getModel();
		Statement stmt = Welcome.con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from participants where event_schedule_id ='" + eventID + "'");
		int id, evID;
		String name, email;
		while (rs.next()) {
			id = rs.getInt("id");
			evID = rs.getInt("event_schedule_id");
			name = rs.getString("name");
			email = rs.getString("email");

			tableModel.addRow(new Object[] { name, email });
		}

	}
/**
 * Selects a row in the Table and sets the textfield accordingly.
 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		int index = table_1.getSelectedRow();
		textField.setText(model.getValueAt(index, 0).toString());
		textField_1.setText(model.getValueAt(index, 1).toString());
 	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
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
}
