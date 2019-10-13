import java.awt.*;
import java.lang.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

import com.mysql.jdbc.ResultSet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;















import com.toedter.calendar.JDateChooser;

import javax.swing.table.TableModel;
import javax.swing.DefaultComboBoxModel;

import net.proteanit.sql.DbUtils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;


@SuppressWarnings("serial")
public class teacherattendence extends JFrame {

	private JPanel contentPane;
	private JButton btnBack;
	private JDateChooser dateChooser;
	JButton btnNewButton;
	private JTable table;
	private JTextField dte;
	private JTextField id;
	private JTextField count;

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
					String x=null;
					teacherattendence frame = new teacherattendence(x);
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
	public teacherattendence(String x) {
		
		
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
		
		JLabel lblCourse = new JLabel();
		lblCourse.setText("Welcome "+x);
		lblCourse.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblCourse.setBounds(10, 91, 283, 35);
		contentPane.add(lblCourse);
		
		final JComboBox a_course = new JComboBox();
		a_course.setBounds(132, 155, 111, 20);
		contentPane.add(a_course);
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			int a=-1;
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance report system", "root","");
			String sql="Select courseid,t_id from course_teacher";
			PreparedStatement pst =con.prepareStatement(sql);
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()){
				a=x.compareTo(rs.getString("t_id"));
				if(a==0)
					a_course.addItem(rs.getString("courseid"));
			}
			con.close();
		}
		 catch (Exception e) {
				e.printStackTrace();
				System.out.print(e.getMessage());
			}
		
		
		JButton btnSearch = new JButton("Get student list");
		btnSearch.setForeground(new Color(255, 255, 255));
		btnSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearch.setBackground(new Color(139, 69, 19));
		btnSearch.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//ShowData1();
				
				try{
					DefaultTableModel model=new DefaultTableModel();
					Class.forName("com.mysql.jdbc.Driver");
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance report system", "root","");
					String query = "select St_ID as 'StudentID',courseid as 'CourseID',''as 'Attendance' from course_student where courseid='"+a_course.getSelectedItem().toString()+"'";
					PreparedStatement st =(PreparedStatement) con.prepareStatement(query);
					ResultSet rs =(ResultSet) st.executeQuery(query);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					st.close();
					con.close();
					}catch(Exception e)
					{
						System.out.println("Error" + e);
						
					}
			}
		});
		
		btnSearch.setBounds(288, 145, 145, 37);
		contentPane.add(btnSearch);
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBack.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnBack.setBackground(new Color(139, 69, 19));
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home_page window = new home_page();
				window.frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(674, 528, 89, 23);
		contentPane.add(btnBack);
		//table.setModel(model);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setBackground(new Color(139, 69, 19));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					int rows=table.getRowCount();
					Class.forName("com.mysql.jdbc.Driver");
					
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance report system", "root","");
					String query ="insert into attendance(StID,CourseID,Date,Attendance) values(?,?,?,?)";
					PreparedStatement pst =con.prepareStatement(query);
					
					for(int i=0;i<rows;i++)
					{
						String stid = (String)table.getValueAt(i,0);
						String name =(String) table.getValueAt(i, 1);
						String p= (String) table.getValueAt(i,2);
						
						//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						//String date =sdf.format(new Date(System.currentTimeMillis()));
						pst.setString(1,stid);
						pst.setString(2,name);
						pst.setString(3,dte.getText());
						pst.setString(4,p);
						//pst.setString(7, date);
						pst.executeUpdate();
					}
					JOptionPane.showMessageDialog(null, "Attendance Recorded Successfully");
					con.close();
					
					
				}
				 catch (Exception e) {
						e.printStackTrace();
						System.out.print(e.getMessage());
					}
			}
		});
		btnNewButton.setBounds(615, 298, 89, 35);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 0));
		panel.setBounds(0, 0, 897, 80);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Attendance Panel");
		lblNewLabel.setBounds(10, 11, 335, 57);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 35));
		
		final JButton btnAbsent = new JButton("Absent");
		btnAbsent.setBackground(new Color(255, 0, 0));
		btnAbsent.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnAbsent.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAbsent.setForeground(new Color(255, 255, 255));
		btnAbsent.setFocusPainted(false);
		final JButton btnPresent = new JButton("Present");
		btnPresent.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPresent.setFocusPainted(false);
		btnPresent.setForeground(new Color(255, 255, 255));
		btnPresent.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPresent.setBackground(new Color(0, 128, 0));
		btnPresent.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel model =(DefaultTableModel)table.getModel();
				int sr=table.getSelectedRow();
				id.setText(model.getValueAt(sr, 0).toString());
			}
		});
		scrollPane.setBounds(22, 186, 583, 335);
		contentPane.add(scrollPane);
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnPresent.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int i=table.getSelectedRow();
						TableModel model=table.getModel();
						model.setValueAt("Present", i, 2);
					}
				});
				
					btnAbsent.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							int i=table.getSelectedRow();
							TableModel model=table.getModel();
							final String c_id=model.getValueAt(i,0).toString();
							model.setValueAt("Absent", i, 2);
						}
					});
					int i=table.getSelectedRow();
					TableModel model=table.getModel();
					final String s_id=model.getValueAt(i,0).toString();
					id.setText(s_id);
			}
		});
		scrollPane.setViewportView(table);
		
		
		
		JLabel lblSelectCourse = new JLabel("Select Course");
		lblSelectCourse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSelectCourse.setBounds(22, 152, 111, 23);
		contentPane.add(lblSelectCourse);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String date =sdf.format(new Date(System.currentTimeMillis()));
		dte = new JTextField();
		dte.setHorizontalAlignment(SwingConstants.TRAILING);
		dte.setEditable(false);
		dte.setBounds(652, 117, 111, 20);
		contentPane.add(dte);
		dte.setText(date);
		dte.setColumns(10);
		
		JLabel lblDate = new JLabel("DATE");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDate.setBounds(710, 92, 53, 14);
		contentPane.add(lblDate);
		
		id = new JTextField();
		id.setEditable(false);
		id.setHorizontalAlignment(SwingConstants.CENTER);
		id.setBounds(634, 393, 129, 20);
		contentPane.add(id);
		id.setColumns(10);
		
		JButton btnGetAttendance = new JButton("Get Attendance %");
		btnGetAttendance.setForeground(new Color(255, 255, 255));
		btnGetAttendance.setBackground(new Color(139, 69, 19));
		btnGetAttendance.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGetAttendance.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnGetAttendance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance report system", "root","");
					String sql="Select count(Attendance) from attendance where StID='"+id.getText()+"' and CourseID='"+a_course.getSelectedItem().toString()+"' and Attendance='Present'";
					PreparedStatement pst =(PreparedStatement) con.prepareStatement(sql);
					
					ResultSet rs =(ResultSet) pst.executeQuery();
					String sql1="Select count(Attendance) from attendance where StID='"+id.getText()+"' and CourseID='"+a_course.getSelectedItem().toString()+"'";
					PreparedStatement pst1 =(PreparedStatement) con.prepareStatement(sql1);
					
					ResultSet rs1 =(ResultSet) pst1.executeQuery();
					float c = 0 ,c1 = 0 ;
					
					if(rs.next())
					{
						 c= rs.getInt("count(Attendance)");
						//count.setText(c);
					}
					if(rs1.next())
					{
						c1= rs1.getInt("count(Attendance)");
						//count.setText(c);
					}
					float a=(c/c1)*100;
					if(a<75)
					{
						count.setForeground(new Color(255, 0, 0));
						count.setText(String.valueOf(a));
					}
					else
					{
						count.setForeground(new Color(0, 128, 0));
						count.setText(String.valueOf(a));
					}
					count.setText(String.valueOf(a));
					}catch(Exception e){
						System.out.println("Error" + e);
				}
			}
		});
		btnGetAttendance.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGetAttendance.setBounds(636, 424, 127, 35);
		contentPane.add(btnGetAttendance);
		
		count = new JTextField();
		count.setHorizontalAlignment(SwingConstants.RIGHT);
		count.setEditable(false);
		count.setFont(new Font("Tahoma", Font.BOLD, 16));
		count.setBounds(663, 470, 77, 26);
		contentPane.add(count);
		count.setColumns(10);
		
		
		
		btnPresent.setBounds(615, 183, 89, 35);
		contentPane.add(btnPresent);
		
		
		
		btnAbsent.setBounds(615, 234, 89, 35);
		contentPane.add(btnAbsent);
		
		JLabel label = new JLabel("%");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(750, 470, 16, 21);
		contentPane.add(label);
		
		JLabel lblStudentid = new JLabel("StudentID");
		lblStudentid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStudentid.setBounds(634, 368, 77, 14);
		contentPane.add(lblStudentid);
		
	}
}