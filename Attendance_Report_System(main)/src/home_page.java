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
import javax.swing.border.BevelBorder;
import java.awt.Cursor;


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
		frame.setBounds(100, 100, 640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JButton btnNewButton = new JButton("Student");
		btnNewButton.setFocusPainted(false);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				String x=null;
				student_login ob= new student_login();
				ob.setVisible(true);
				
			}
		});
		btnNewButton.setForeground(new Color(240, 255, 255));
		btnNewButton.setBackground(new Color(139, 69, 19));
		btnNewButton.setFont(new Font("Garamond", Font.BOLD, 28));
		btnNewButton.setBounds(227, 134, 170, 63);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Faculty");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				String x=null;
				TeacherLogin ob= new TeacherLogin(x);
				ob.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(new Color(245, 255, 250));
		btnNewButton_1.setBackground(new Color(139, 69, 19));
		btnNewButton_1.setFont(new Font("Garamond", Font.BOLD, 28));
		btnNewButton_1.setBounds(227, 236, 170, 63);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Admin");
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Admin ob= new Admin();
				ob.setVisible(true);
			}
		});
		btnNewButton_2.setForeground(new Color(245, 255, 250));
		btnNewButton_2.setBackground(new Color(139, 69, 19));
		btnNewButton_2.setFont(new Font("Garamond", Font.BOLD, 28));
		btnNewButton_2.setBounds(227, 335, 170, 63);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(178, 11, 46, 14);
		frame.getContentPane().add(label_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 0));
		panel.setBounds(0, 0, 624, 99);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblIutStudentsAttendace = new JLabel("User Selection");
		lblIutStudentsAttendace.setBounds(10, 28, 237, 41);
		panel.add(lblIutStudentsAttendace);
		lblIutStudentsAttendace.setForeground(new Color(255, 255, 255));
		lblIutStudentsAttendace.setFont(new Font("Cambria", Font.BOLD, 35));
	}
	public Color getFrameContentPaneBackground() {
		return frame.getContentPane().getBackground();
	}
	public void setFrameContentPaneBackground(Color background) {
		frame.getContentPane().setBackground(background);
	}
}
