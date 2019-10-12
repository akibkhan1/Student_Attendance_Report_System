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
		setBounds(100, 100, 913, 778);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 250, 210));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCourse = new JLabel();
		lblCourse.setText("Welcome "+x);
		lblCourse.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblCourse.setBounds(10, 114, 283, 35);
		contentPane.add(lblCourse);
		
		final JComboBox a_course = new JComboBox();
		a_course.setBounds(203, 183, 111, 20);
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
		
		btnSearch.setBounds(336, 174, 158, 37);
		contentPane.add(btnSearch);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home_page window = new home_page();
				window.frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(756, 650, 89, 23);
		contentPane.add(btnBack);
		//table.setModel(model);
		
		JButton btnNewButton = new JButton("SUBMIT");
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
					con.close();
					
					
				}
				 catch (Exception e) {
						e.printStackTrace();
						System.out.print(e.getMessage());
					}
			}
		});
		btnNewButton.setBounds(756, 352, 89, 35);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 0));
		panel.setBounds(0, 0, 897, 103);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Teacher Information");
		lblNewLabel.setBounds(27, 0, 257, 103);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 24));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel model =(DefaultTableModel)table.getModel();
				int sr=table.getSelectedRow();
				id.setText(model.getValueAt(sr, 0).toString());
			}
		});
		scrollPane.setBounds(131, 222, 583, 310);
		contentPane.add(scrollPane);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i=table.getSelectedRow();
				TableModel model=table.getModel();
				final String c_id=model.getValueAt(i,0).toString();
				model.setValueAt("Present", i, 2);
			}
		});
		scrollPane.setViewportView(table);
		
		
		
		JLabel lblSelectCourse = new JLabel("Select Course");
		lblSelectCourse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSelectCourse.setBounds(82, 180, 111, 23);
		contentPane.add(lblSelectCourse);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(744, 287, 89, 23);
		contentPane.add(btnRegister);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String date =sdf.format(new Date(System.currentTimeMillis()));
		dte = new JTextField();
		dte.setEditable(false);
		dte.setBounds(599, 183, 111, 20);
		contentPane.add(dte);
		dte.setText(date);
		dte.setColumns(10);
		
		JLabel lblDate = new JLabel("DATE");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDate.setBounds(633, 161, 53, 14);
		contentPane.add(lblDate);
		
		id = new JTextField();
		id.setBounds(146, 616, 129, 20);
		contentPane.add(id);
		id.setColumns(10);
		
		JButton btnGetAttendance = new JButton("Get Attendance %");
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
					count.setText(String.valueOf(a));
					}catch(Exception e){
						System.out.println("Error" + e);
				}
			}
		});
		btnGetAttendance.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGetAttendance.setBounds(306, 607, 145, 35);
		contentPane.add(btnGetAttendance);
		
		count = new JTextField();
		count.setFont(new Font("Tahoma", Font.BOLD, 16));
		count.setBounds(494, 616, 86, 20);
		contentPane.add(count);
		count.setColumns(10);
		
	}
}