import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import com.mysql.jdbc.ResultSet;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JTextPane;


public class student_reg extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JPasswordField pass;
	private JTextField email;
	private JTextField phone;
	private JTextField id;
	
	JComboBox semester;
	int n;
	private JTextField session;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student_reg frame = new student_reg();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("rawtypes")
	public student_reg() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 932, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setName("Select GENDER");
		panel_1.setBackground(new Color(250, 250, 210));
		panel_1.setBounds(0, 65, 916, 396);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		final JComboBox dep = new JComboBox();
		dep.setBounds(628, 100, 123, 20);
		panel_1.add(dep);
		dep.setModel(new DefaultComboBoxModel(new String[] {"CSE", "EEE", "MCE", "CEE", "BTM", "TVE"}));
		dep.setSelectedItem(null);
		
		final JComboBox gender = new JComboBox();
		gender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		gender.setSelectedItem(null);
		gender.setBounds(192, 226, 123, 20);
		panel_1.add(gender);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 0));
		panel.setBounds(0, 0, 916, 64);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblRegisterFaculty = new JLabel("Student Registration\r\n");
		lblRegisterFaculty.setForeground(new Color(255, 255, 255));
		lblRegisterFaculty.setBounds(10, 0, 266, 64);
		panel.add(lblRegisterFaculty);
		lblRegisterFaculty.setFont(new Font("Cambria", Font.PLAIN, 30));
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(500, 103, 71, 14);
		panel_1.add(lblDepartment);
		
		JLabel lblFacultyName = new JLabel(" Name");
		lblFacultyName.setBounds(64, 51, 77, 14);
		panel_1.add(lblFacultyName);
		
		name = new JTextField();
		name.setBounds(192, 48, 123, 20);
		panel_1.add(name);
		name.setColumns(10);
		
		JLabel lblFacultyid = new JLabel("Student ID");
		lblFacultyid.setBounds(64, 95, 89, 14);
		panel_1.add(lblFacultyid);
		
		id = new JTextField();
		id.setBounds(192, 92, 123, 20);
		panel_1.add(id);
		id.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(628, 156, 123, 20);
		panel_1.add(pass);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setForeground(new Color(255, 255, 255));
		btnRegister.setBackground(new Color(139, 69, 19));
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//	
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance report system", "root","");
					String query ="insert into student(StID,Name,Semester,Department,Contact,Email,Gender,Session,Password) values(?,?,?,?,?,?,?,?,?)";
					PreparedStatement pst =con.prepareStatement(query);
					
					if(name.getText().length()!=0){
						pst.setString(1, id.getText());
						pst.setString(2, name.getText());
						pst.setString(3,semester.getSelectedItem().toString());
						pst.setString(4,dep.getSelectedItem().toString());
						pst.setString(5,phone.getText());
						pst.setString(6,email.getText());
						pst.setString(7,gender.getSelectedItem().toString());
						pst.setString(8,session.getText());
						pst.setString(9,pass.getText());
						
						pst.executeUpdate();
						con.close();
							JOptionPane.showMessageDialog(null, "Registered Successfully");}
					else
						JOptionPane.showMessageDialog(null, "Registered Unsuccessful");
						
							
					}
				 catch (Exception e) {
					 
						e.printStackTrace();
					}
			}
		});
		btnRegister.setBounds(415, 319, 112, 32);
		panel_1.add(btnRegister);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(817, 362, 89, 23);
		panel_1.add(btnBack);
		
		JLabel lblallTheFields = new JLabel("*All the fields are required*");
		lblallTheFields.setForeground(new Color(255, 0, 0));
		lblallTheFields.setBounds(642, 251, 157, 14);
		panel_1.add(lblallTheFields);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(64, 229, 46, 14);
		panel_1.add(lblGender);
		
		JLabel lblNewPassword = new JLabel("Password");
		lblNewPassword.setBounds(500, 159, 77, 14);
		panel_1.add(lblNewPassword);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setBounds(64, 180, 46, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblPhoneNo = new JLabel("Phone no.");
		lblPhoneNo.setBounds(64, 138, 56, 14);
		panel_1.add(lblPhoneNo);
		
		email = new JTextField();
		email.setBounds(192, 177, 123, 20);
		panel_1.add(email);
		email.setColumns(10);
		
		phone = new JTextField();
		phone.setBounds(192, 135, 123, 20);
		panel_1.add(phone);
		phone.setColumns(10);
		
		JLabel sem = new JLabel("Semester");
		sem.setBounds(500, 54, 89, 14);
		panel_1.add(sem);
		
		JLabel lblSession = new JLabel("Session");
		lblSession.setBounds(500, 207, 89, 14);
		panel_1.add(lblSession);
		
		session = new JTextField();
		session.setColumns(10);
		session.setBounds(628, 204, 123, 20);
		panel_1.add(session);
		
		 semester = new JComboBox();
		semester.setModel(new DefaultComboBoxModel(new String[] {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th"}));
		semester.setSelectedItem(null);
		semester.setBounds(628, 48, 123, 20);
		panel_1.add(semester);
		
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				create_teach_acc window = new create_teach_acc();
				window.setVisible(true);
				dispose();
			}
		});
	}
	
}
