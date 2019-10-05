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
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/attendence system", "root","");
				
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
		frame.getContentPane().setBackground(new Color(143, 188, 143));
		frame.setBounds(100, 100, 990, 895);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JButton btnNewButton = new JButton("Student");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Student ob= new Student();
				ob.setVisible(true);
				
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 100, 0));
		btnNewButton.setFont(new Font("Sitka Heading", Font.BOLD, 15));
		btnNewButton.setBounds(469, 243, 106, 52);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Teacher");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Teacher ob= new Teacher();
				ob.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(0, 100, 0));
		btnNewButton_1.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		btnNewButton_1.setBounds(469, 358, 106, 52);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Admin");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Admin ob= new Admin();
				ob.setVisible(true);
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(new Color(0, 100, 0));
		btnNewButton_2.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		btnNewButton_2.setBounds(469, 484, 106, 52);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblIutStudentsAttendace = new JLabel("IUT Students' Attendace Report System");
		lblIutStudentsAttendace.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblIutStudentsAttendace.setBounds(177, 94, 610, 41);
		frame.getContentPane().add(lblIutStudentsAttendace);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Akib\\Desktop\\New folder\\beautiful-line-gradient-blue-pastel-color-abstract-background-paper-texture_50039-644.jpg"));
		label.setBounds(0, 109, 984, 797);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(178, 11, 46, 14);
		frame.getContentPane().add(label_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Akib\\Desktop\\New folder\\beautiful-line-gradient-blue-pastel-color-abstract-background-paper-texture_50039-644.jpg"));
		lblNewLabel.setBounds(0, 0, 984, 159);
		frame.getContentPane().add(lblNewLabel);
	}
	public Color getFrameContentPaneBackground() {
		return frame.getContentPane().getBackground();
	}
	public void setFrameContentPaneBackground(Color background) {
		frame.getContentPane().setBackground(background);
	}
}
