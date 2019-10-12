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


public class percent extends JFrame {

	private JPanel contentPane;
	private JTextField count;
	private JTextField id;
	private JTextField course;
	private JLabel lblNewLabel;
	private JLabel lblCourse;
	private JLabel lblNewLabel_1;

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
		setBounds(100, 100, 834, 502);
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
		count.setBounds(424, 317, 86, 20);
		contentPane.add(count);
		count.setColumns(10);
		
		JButton btnNewButton = new JButton("Total Attendance");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance report system", "root","");
					String sql="Select count(Attendance) from attendance where StID='"+id.getText()+"' and CourseID='"+course.getText()+"' and Attendance='Present'";
					PreparedStatement pst =(PreparedStatement) con.prepareStatement(sql);
					
					ResultSet rs =(ResultSet) pst.executeQuery();
					String sql1="Select count(Attendance) from attendance where StID='"+id.getText()+"' and CourseID='"+course.getText()+"'";
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
		btnNewButton.setBounds(372, 269, 166, 23);
		contentPane.add(btnNewButton);
		
		id = new JTextField();
		id.setBounds(195, 272, 86, 20);
		contentPane.add(id);
		id.setColumns(10);
		id.setText(y);
		
		course = new JTextField();
		course.setBounds(195, 317, 86, 20);
		contentPane.add(course);
		course.setColumns(10);
		
		lblNewLabel = new JLabel("Student ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(72, 278, 97, 14);
		contentPane.add(lblNewLabel);
		
		lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCourse.setBounds(72, 317, 97, 14);
		contentPane.add(lblCourse);
		
		lblNewLabel_1 = new JLabel("%");
		lblNewLabel_1.setBounds(520, 320, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 0));
		panel.setBounds(0, 0, 818, 113);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAttendancePercentage = new JLabel("Attendance Percentage");
		lblAttendancePercentage.setFont(new Font("Cambria", Font.BOLD, 32));
		lblAttendancePercentage.setForeground(new Color(255, 255, 255));
		lblAttendancePercentage.setBounds(10, 11, 359, 102);
		panel.add(lblAttendancePercentage);
	}
}
