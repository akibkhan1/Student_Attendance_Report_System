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
import java.awt.Color;


public class Student extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField coursename;
	private JScrollPane scrollPane;
	private JButton btnBack;
	private JPanel panel;

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
		setBounds(100, 100, 882, 553);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(139, 69, 19));
		btnNewButton.setFont(new Font("Sitka Heading", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
				ShowData();
		}
		});
		
		btnNewButton.setBounds(592, 113, 150, 52);
		contentPane.add(btnNewButton);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setForeground(new Color(255, 255, 255));
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSearch.setBackground(new Color(139, 69, 19));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ShowData1();
			}
		});
		btnSearch.setBounds(343, 131, 89, 29);
		contentPane.add(btnSearch);
		
		btnBack = new JButton("Back");
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setBackground(new Color(139, 69, 19));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home_page window = new home_page();
				window.frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(767, 423, 89, 23);
		contentPane.add(btnBack);
		
		panel = new JPanel();
		panel.setBackground(new Color(128, 0, 0));
		panel.setBounds(0, 0, 866, 100);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Faculty Information");
		lblNewLabel.setBounds(228, 5, 327, 84);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 27));
	
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
	String query = "select Name,Course,Contact_no,Email from teacherinfo";
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
	String query = "select Name,Course,Contact_no,Email from teacherinfo where Course='"+coursename.getText()+"'";
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