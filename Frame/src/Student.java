import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

import com.mysql.jdbc.ResultSet;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Student extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField textField;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/attendence system", "root","");
				
					}catch(Exception e){
						System.out.println("Error" + e);
				}
				try {
					Student frame = new Student();
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
	public Student() {
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent arg0) {
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 882, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Teacher's Information");
		lblNewLabel.setFont(new Font("Sitka Display", Font.BOLD, 19));
		lblNewLabel.setBounds(333, 71, 204, 41);
		contentPane.add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(271, 135, 1, 1);
		contentPane.add(table);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(212, 204, 429, 233);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setBounds(261, 135, 46, 14);
		contentPane.add(lblCourse);
		
		textField = new JTextField();
		textField.setBounds(343, 132, 122, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("SHOW ALL INFO");
		btnNewButton.setFont(new Font("Sitka Heading", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
				ShowData();
		}
		});
		
		btnNewButton.setBounds(592, 113, 150, 52);
		contentPane.add(btnNewButton);
	
}
private void ShowData(){
	try{
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/attendence system", "root","");
	DefaultTableModel model=new DefaultTableModel();
	model.addColumn("Name");
	model.addColumn("Contact no.");
	model.addColumn("Course");
	model.addColumn("Email");
	
		
	
		//Class.forName("com.mysql.jdbc.Driver");
		//Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Attendenece System", "root","");
	String query = "select * from Teacher";
		PreparedStatement st =(PreparedStatement) con.prepareStatement(query);
		
		ResultSet rs =(ResultSet) st.executeQuery(query);
		table_1.setModel(DbUtils.resultSetToTableModel(rs));
	
		rs.close();
		st.close();
		con.close();
		
	
		}catch(Exception e){
			System.out.println("Error" + e);
	}
		
		
	
}
}
;