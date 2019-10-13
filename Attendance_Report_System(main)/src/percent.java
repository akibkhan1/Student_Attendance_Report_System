import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JRadioButton;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JTextField;
import javax.swing.JButton;

import com.mysql.jdbc.ResultSet;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.border.BevelBorder;

import java.awt.Cursor;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;


public class percent extends JFrame {

	private JPanel contentPane;
	private JTextField count;
	private JTextField id;
	private JLabel lblNewLabel;
	private JLabel lblCourse;
	private JLabel lblNewLabel_1;
	private JButton btnBack;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String y=null;
					percent frame = new percent(y);
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
	public percent(final String y) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 250, 210));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		DefaultTableModel ds = new DefaultTableModel();
		ds.setDataVector(new Object[][]
				{
				{"Arsenal",new JRadioButton("Favourite")},
				},
				new Object[]{"Team","Choice"});
		
		count = new JTextField();
		count.setFont(new Font("Tahoma", Font.BOLD, 13));
		count.setHorizontalAlignment(SwingConstants.RIGHT);
		count.setEditable(false);
		count.setBounds(259, 314, 86, 35);
		contentPane.add(count);
		count.setColumns(10);
		
		final JComboBox s_course = new JComboBox();
		s_course.setBounds(179, 221, 86, 20);
		contentPane.add(s_course);
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			int a=-1;
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance report system", "root","");
			String sql="Select courseid,st_id from course_student";
			PreparedStatement pst =con.prepareStatement(sql);
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()){
				a=y.compareTo(rs.getString("st_id"));
				if(a==0)
					s_course.addItem(rs.getString("courseid"));
			}
			con.close();
		}
		 catch (Exception e) {
				e.printStackTrace();
				System.out.print(e.getMessage());
			}
		
		JButton btnNewButton = new JButton("Attendance %");
		btnNewButton.setFocusPainted(false);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(139, 69, 19));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance report system", "root","");
					String sql="Select count(Attendance) from attendance where StID='"+id.getText()+"' and CourseID='"+s_course.getSelectedItem().toString()+"' and Attendance='Present'";
					PreparedStatement pst =(PreparedStatement) con.prepareStatement(sql);
					
					ResultSet rs =(ResultSet) pst.executeQuery();
					String sql1="Select count(Attendance) from attendance where StID='"+id.getText()+"' and CourseID='"+s_course.getSelectedItem().toString()+"'";
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
					}catch(Exception e){
						System.out.println("Error" + e);
				}
			}
		});
		btnNewButton.setBounds(72, 314, 165, 35);
		contentPane.add(btnNewButton);
		
		id = new JTextField();
		id.setEditable(false);
		id.setBounds(179, 176, 86, 20);
		contentPane.add(id);
		id.setColumns(10);
		id.setText(y);
		
		lblNewLabel = new JLabel("Student ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(72, 182, 97, 14);
		contentPane.add(lblNewLabel);
		
		lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCourse.setBounds(72, 227, 97, 14);
		contentPane.add(lblCourse);
		
		lblNewLabel_1 = new JLabel("%");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(355, 325, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 0));
		panel.setBounds(0, 0, 624, 82);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAttendancePercentage = new JLabel("Attendance Percentage");
		lblAttendancePercentage.setFont(new Font("Cambria", Font.BOLD, 32));
		lblAttendancePercentage.setForeground(new Color(255, 255, 255));
		lblAttendancePercentage.setBounds(10, 0, 359, 78);
		panel.add(lblAttendancePercentage);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				student_option window = new student_option(y);
				window.setVisible(true);
				dispose();
			}
		});
		btnBack.setBackground(new Color(139, 69, 19));
		btnBack.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBounds(525, 407, 89, 23);
		contentPane.add(btnBack);
		
		label = new JLabel();
		label.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		label.setText("Welcome "+y);
		label.setBounds(10, 93, 285, 35);
		contentPane.add(label);
		
		
	}
}
