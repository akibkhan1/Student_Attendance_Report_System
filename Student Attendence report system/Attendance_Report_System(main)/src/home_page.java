import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class home_page {

	JFrame frame;

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
					home_page window = new home_page();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public home_page() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(250, 250, 210));
		frame.setBounds(100, 100, 765, 608);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JButton btnNewButton = new JButton("Student");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				student_option ob= new student_option();
				ob.setVisible(true);
				
			}
		});
		btnNewButton.setForeground(new Color(240, 255, 255));
		btnNewButton.setBackground(new Color(139, 69, 19));
		btnNewButton.setFont(new Font("Sitka Heading", Font.BOLD, 25));
		btnNewButton.setBounds(294, 218, 170, 63);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Teacher");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				TeacherLogin ob= new TeacherLogin();
				ob.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(new Color(245, 255, 250));
		btnNewButton_1.setBackground(new Color(139, 69, 19));
		btnNewButton_1.setFont(new Font("Sitka Subheading", Font.BOLD, 25));
		btnNewButton_1.setBounds(294, 318, 170, 63);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Admin");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Admin ob= new Admin();
				ob.setVisible(true);
			}
		});
		btnNewButton_2.setForeground(new Color(245, 255, 250));
		btnNewButton_2.setBackground(new Color(139, 69, 19));
		btnNewButton_2.setFont(new Font("Sitka Subheading", Font.BOLD, 25));
		btnNewButton_2.setBounds(294, 415, 170, 63);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(178, 11, 46, 14);
		frame.getContentPane().add(label_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 0));
		panel.setBounds(0, 0, 749, 148);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblIut = new JLabel("IUT");
		lblIut.setBounds(338, 51, 67, 38);
		panel.add(lblIut);
		lblIut.setForeground(new Color(255, 255, 255));
		lblIut.setFont(new Font("Modern No. 20", Font.BOLD, 35));
		
		JLabel lblIutStudentsAttendace = new JLabel("Students' Attendance Report System");
		lblIutStudentsAttendace.setBounds(82, 85, 609, 41);
		panel.add(lblIutStudentsAttendace);
		lblIutStudentsAttendace.setForeground(new Color(255, 255, 255));
		lblIutStudentsAttendace.setFont(new Font("Modern No. 20", Font.BOLD, 35));
	}
	public Color getFrameContentPaneBackground() {
		return frame.getContentPane().getBackground();
	}
	public void setFrameContentPaneBackground(Color background) {
		frame.getContentPane().setBackground(background);
	}
}
