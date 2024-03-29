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
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JTextPane;


public class reg_teacher extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JPasswordField pass;
	private JTextField email;
	private JTextField phone;
	private JTextField id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reg_teacher frame = new reg_teacher();
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
	public reg_teacher() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 447, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setName("Select GENDER");
		panel_1.setBackground(new Color(250, 250, 210));
		panel_1.setBounds(0, 64, 431, 396);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		final JComboBox dep = new JComboBox();
		dep.setBounds(192, 176, 123, 20);
		panel_1.add(dep);
		dep.setModel(new DefaultComboBoxModel(new String[] {"CSE", "EEE", "MCE", "CEE", "BTM", "TVE"}));
		
		final JComboBox gender = new JComboBox();
		gender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		gender.setBounds(192, 204, 123, 20);
		panel_1.add(gender);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 0));
		panel.setBounds(0, 0, 431, 64);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblRegisterFaculty = new JLabel("Register Faculty");
		lblRegisterFaculty.setForeground(new Color(255, 255, 255));
		lblRegisterFaculty.setBounds(10, 0, 266, 64);
		panel.add(lblRegisterFaculty);
		lblRegisterFaculty.setFont(new Font("Cambria", Font.PLAIN, 30));
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(64, 179, 71, 14);
		panel_1.add(lblDepartment);
		
		JLabel lblFacultyName = new JLabel("Faculty Name");
		lblFacultyName.setBounds(64, 51, 77, 14);
		panel_1.add(lblFacultyName);
		
		name = new JTextField();
		name.setBounds(192, 48, 123, 20);
		panel_1.add(name);
		name.setColumns(10);
		
		JLabel lblFacultyid = new JLabel("FacultyID");
		lblFacultyid.setBounds(64, 76, 89, 14);
		panel_1.add(lblFacultyid);
		
		id = new JTextField();
		id.setBounds(192, 73, 123, 20);
		panel_1.add(id);
		id.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(192, 100, 123, 20);
		panel_1.add(pass);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setForeground(new Color(255, 255, 255));
		btnRegister.setBackground(new Color(139, 69, 19));
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance report system", "root","");
					String query ="insert into teacherinfo(name,department,contact_no,email,userid,password,gender) values(?,?,?,?,?,?,?)";
					PreparedStatement pst =con.prepareStatement(query);
					
					if(name.getText().length()!=0){
						pst.setString(1, name.getText());
						pst.setString(2,dep.getSelectedItem().toString());
						pst.setString(3,phone.getText());
						pst.setString(4,email.getText());
						pst.setString(5,id.getText());
						pst.setString(6,pass.getText());
						pst.setString(7,gender.getSelectedItem().toString());
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
		btnRegister.setBounds(169, 318, 112, 32);
		panel_1.add(btnRegister);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(332, 362, 89, 23);
		panel_1.add(btnBack);
		
		JLabel lblallTheFields = new JLabel("*All the fields are required*");
		lblallTheFields.setForeground(new Color(255, 0, 0));
		lblallTheFields.setBounds(264, 235, 157, 14);
		panel_1.add(lblallTheFields);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(64, 207, 46, 14);
		panel_1.add(lblGender);
		
		JLabel lblNewPassword = new JLabel("Password");
		lblNewPassword.setBounds(64, 103, 77, 14);
		panel_1.add(lblNewPassword);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setBounds(64, 128, 46, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblPhoneNo = new JLabel("Phone no.");
		lblPhoneNo.setBounds(64, 154, 56, 14);
		panel_1.add(lblPhoneNo);
		
		email = new JTextField();
		email.setBounds(192, 125, 123, 20);
		panel_1.add(email);
		email.setColumns(10);
		
		phone = new JTextField();
		phone.setBounds(192, 151, 123, 20);
		panel_1.add(phone);
		phone.setColumns(10);
		
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				create_teach_acc window = new create_teach_acc();
				window.setVisible(true);
				dispose();
			}
		});
	}
}
