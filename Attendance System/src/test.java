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


public class test extends JFrame {

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
					test frame = new test();
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
	public test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 834, 300);
		contentPane = new JPanel();
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
		count.setBounds(415, 139, 86, 20);
		contentPane.add(count);
		count.setColumns(10);
		
		JButton btnNewButton = new JButton("Total Attendance");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance report system", "root","");
					String sql="Select count(Present) from attendance where StID='"+id.getText()+"' and CourseID='"+course.getText()+"' and Present=1";
					PreparedStatement pst =(PreparedStatement) con.prepareStatement(sql);
					
					ResultSet rs =(ResultSet) pst.executeQuery();
					String sql1="Select count(Present) from attendance where StID='"+id.getText()+"' and CourseID='"+course.getText()+"'";
					PreparedStatement pst1 =(PreparedStatement) con.prepareStatement(sql1);
					
					ResultSet rs1 =(ResultSet) pst1.executeQuery();
					float c = 0 ,c1 = 0 ;
					if(rs.next())
					{
						 c= rs.getInt("count(Present)");
						//count.setText(c);
					}
					if(rs1.next())
					{
						c1= rs1.getInt("count(Present)");
						//count.setText(c);
					}
					float a=(c/c1)*100;
					count.setText(String.valueOf(a));
					}catch(Exception e){
						System.out.println("Error" + e);
				}
			}
		});
		btnNewButton.setBounds(368, 93, 166, 23);
		contentPane.add(btnNewButton);
		
		id = new JTextField();
		id.setBounds(195, 71, 86, 20);
		contentPane.add(id);
		id.setColumns(10);
		
		course = new JTextField();
		course.setBounds(195, 118, 86, 20);
		contentPane.add(course);
		course.setColumns(10);
		
		lblNewLabel = new JLabel("Student ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(72, 74, 97, 14);
		contentPane.add(lblNewLabel);
		
		lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCourse.setBounds(72, 121, 97, 14);
		contentPane.add(lblCourse);
		
		lblNewLabel_1 = new JLabel("%");
		lblNewLabel_1.setBounds(511, 142, 46, 14);
		contentPane.add(lblNewLabel_1);
	}
}
