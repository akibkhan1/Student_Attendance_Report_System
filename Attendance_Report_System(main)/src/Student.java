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

import javax.swing.ImageIcon;
import javax.swing.JRadioButton;


public class Student extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField coursename;
	private JScrollPane scrollPane;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance report system", "root","");
				
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
		setBounds(100, 100, 882, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Teacher Information");
		lblNewLabel.setFont(new Font("Sitka Display", Font.BOLD, 19));
		lblNewLabel.setBounds(364, 59, 204, 41);
		contentPane.add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(271, 135, 1, 1);
		contentPane.add(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(153, 204, 589, 233);
		contentPane.add(scrollPane_1);
		
		scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCourse.setBounds(153, 135, 46, 14);
		contentPane.add(lblCourse);
		
		coursename = new JTextField();
		coursename.setBounds(209, 134, 122, 20);
		contentPane.add(coursename);
		coursename.setColumns(10);
		
		JButton btnNewButton = new JButton("SHOW ALL INFO");
		btnNewButton.setFont(new Font("Sitka Heading", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
				ShowData();
		}
		});
		
		btnNewButton.setBounds(592, 113, 150, 52);
		contentPane.add(btnNewButton);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ShowData1();
			}
		});
		btnSearch.setBounds(343, 131, 89, 23);
		contentPane.add(btnSearch);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home_page window = new home_page();
				window.frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(746, 29, 89, 23);
		contentPane.add(btnBack);
	
}
private void ShowData(){
	try{
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance report system", "root","");
	DefaultTableModel model=new DefaultTableModel();
	model.addColumn("Name");
	model.addColumn("Course");
	model.addColumn("Contact no.");
	model.addColumn("Email");
	
		
	
		//Class.forName("com.mysql.jdbc.Driver");
		//Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Attendenece System", "root","");
	String query = "select * from teacherinfo";
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
private void ShowData1(){
	try{
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance report system", "root","");
	DefaultTableModel model=new DefaultTableModel();
	model.addColumn("Name");
	model.addColumn("Course");
	model.addColumn("Contact no.");
	model.addColumn("Email");
	
		
	
		//Class.forName("com.mysql.jdbc.Driver");
		//Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Attendenece System", "root","");
	String query = "select * from teacherinfo where Course='"+coursename.getText()+"'";
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