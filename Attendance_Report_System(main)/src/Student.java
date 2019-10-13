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
import javax.swing.border.BevelBorder;
import java.awt.Cursor;
import javax.swing.border.EtchedBorder;


public class Student extends JFrame {

	private JPanel contentPane;
	private JTextField coursename;
	private JButton btnBack;
	private JPanel panel;
	private JTable table_1;

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
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 250, 210));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCourse = new JLabel("CourseID");
		lblCourse.setBounds(55, 135, 70, 14);
		lblCourse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblCourse);
		
		coursename = new JTextField();
		coursename.setBounds(135, 134, 122, 20);
		contentPane.add(coursename);
		coursename.setColumns(10);
		
		JButton btnNewButton = new JButton("SHOW ALL INFO");
		btnNewButton.setBounds(504, 116, 169, 52);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(139, 69, 19));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
				ShowData();
		}
		});
		contentPane.add(btnNewButton);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(267, 128, 89, 29);
		btnSearch.setFocusPainted(false);
		btnSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearch.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnSearch.setForeground(new Color(255, 255, 255));
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSearch.setBackground(new Color(139, 69, 19));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ShowData1();
			}
		});
		contentPane.add(btnSearch);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(685, 527, 89, 23);
		btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setBackground(new Color(139, 69, 19));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//String x=null;
				home_page window = new home_page();
				window.frame.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnBack);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 784, 92);
		panel.setBackground(new Color(128, 0, 0));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Faculty Information");
		lblNewLabel.setBounds(10, 11, 291, 68);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 30));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 188, 617, 332);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
	
}
private void ShowData(){
	try{
		int rows=table_1.getRowCount();
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance report system", "root","");
	DefaultTableModel model=new DefaultTableModel();
	model.addColumn("Name");
	model.addColumn("Course");
	model.addColumn("Contact no.");
	model.addColumn("Email");
	
		
	
		//Class.forName("com.mysql.jdbc.Driver");
		//Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Attendenece System", "root","");
	//PRoblem is here Nowshin//
	String query = "select Name,''as 'Course',Contact_no,Email from teacherinfo";
		PreparedStatement st =(PreparedStatement) con.prepareStatement(query);
	/*String str="Select userid from teacherinfo";
		PreparedStatement st1=(PreparedStatement) con.prepareStatement(str);
		ResultSet rs1=(ResultSet) st1.executeQuery(str);*/
		ResultSet rs =(ResultSet) st.executeQuery(query);
		/*while(rs1.next())
		{
			String q=rs1.getString("userid");
			String sql="select courseid from course_teacher where t_id=q";
		}*/
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
	//Problem is here Nowshin//
		String query = "select Name,''as Course',Contact_no,Email from teacherinfo";
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