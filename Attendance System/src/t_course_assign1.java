import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import javax.swing.JComboBox;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class t_course_assign1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String x="abc";
					t_course_assign1 frame = new t_course_assign1(x);
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
	public t_course_assign1(final String x) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 554);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 250, 210));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 0));
		panel.setBounds(0, 0, 635, 74);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Course Assignment");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 11, 339, 52);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setText("Welcome "+x);
		lblNewLabel_1.setBounds(21, 85, 314, 39);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblAvailableCourses = new JLabel("Available Courses");
		lblAvailableCourses.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAvailableCourses.setBounds(21, 173, 150, 24);
		contentPane.add(lblAvailableCourses);
		
		final JComboBox a_course = new JComboBox();
		a_course.setFont(new Font("Tahoma", Font.PLAIN, 13));
		a_course.setBounds(181, 177, 224, 20);
		contentPane.add(a_course);
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance report system", "root","");
			String sql="Select * from course";
			PreparedStatement pst =con.prepareStatement(sql);
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next())
				a_course.addItem(rs.getString("coursename"));
			con.close();
		}
		 catch (Exception e) {
				e.printStackTrace();
				System.out.print(e.getMessage());
			}
		
		JButton btnAssignCourse = new JButton("Assign Course");
		btnAssignCourse.setForeground(new Color(255, 255, 255));
		btnAssignCourse.setBackground(new Color(139, 69, 19));
		btnAssignCourse.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAssignCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String fid = null;
					Class.forName("com.mysql.jdbc.Driver");
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance report system", "root","");
					Statement stmt=(Statement) con.createStatement();
					String sql="select courseid from course where coursename='"+a_course.getSelectedItem().toString()+"'";
					String query ="insert into course_teacher(courseid,t_id) values(?,?)";
					ResultSet rs=(ResultSet) stmt.executeQuery(sql);
					PreparedStatement pst =con.prepareStatement(query);
					while(rs.next())
					    fid=rs.getString("courseid");
						pst.setString(1,fid);
						pst.setString(2,x);
						pst.executeUpdate();
						con.close();
							JOptionPane.showMessageDialog(null, "Course assigned Successfuly");
						
							
					}
				 catch (Exception e) {
					 
						e.printStackTrace();
					}
			}
		});
		btnAssignCourse.setBounds(425, 172, 198, 39);
		contentPane.add(btnAssignCourse);
		
		
	}
	

}
