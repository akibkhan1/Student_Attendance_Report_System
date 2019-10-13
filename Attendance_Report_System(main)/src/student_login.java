import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import com.mysql.jdbc.ResultSet;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.Cursor;


public class student_login extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student_login frame = new student_login();
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
	public student_login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 530);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTeacherLogin = new JLabel("Student Login");
		lblTeacherLogin.setForeground(new Color(255, 255, 255));
		lblTeacherLogin.setFont(new Font("Cambria", Font.BOLD, 30));
		lblTeacherLogin.setBounds(10, 0, 209, 71);
		contentPane.add(lblTeacherLogin);
		
		JLabel lblUsername = new JLabel("Student ID");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(43, 186, 93, 20);
		contentPane.add(lblUsername);
		
		username = new JTextField();
		username.setBounds(146, 186, 131, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(43, 240, 93, 20);
		contentPane.add(lblPassword);
		
		password = new JPasswordField();
		password.setBounds(146, 240, 131, 20);
		contentPane.add(password);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogin.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnLogin.setBackground(new Color(139, 69, 19));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					boolean islogin_success;
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance report system","root","");
					Statement stmt=con.createStatement();
					String sql="Select StID,Password from student where StID='"+username.getText()+"' and Password='"+password.getText().toString()+"'";
					String x=username.getText();
					student_option ob = new student_option(x);
					ResultSet rs=(ResultSet) stmt.executeQuery(sql);
					if(rs.next())
					{
						islogin_success=true;
						student_option frame = new student_option(x);
						frame.setVisible(true);
						dispose();
						}
					
					else{
						islogin_success=false;
						JOptionPane.showMessageDialog(null, "Incorrect Username/Password");}
					con.close();
				} catch(Exception e) {System.out.print(e);}
				
			}
		});
		
		/*String sql="Select UserID,Password from teacherinfo where UserID='"+username.getText()+"' and Password='"+password.getText().toString()+"'";
		String x=username.getText();
		t_course_assign1 ob=new t_course_assign1(x);
		ResultSet rs=(ResultSet) stmt.executeQuery(sql);
		if(rs.next())
		{
			islogin_success=true;
			t_course_assign1 frame = new t_course_assign1(x);
			frame.setVisible(true);
			dispose();
			}
		
		else{
			islogin_success=false;
			JOptionPane.showMessageDialog(null, "Incorrect Username/Password");}
		con.close();
		*/
		
		
		btnLogin.setBounds(146, 319, 93, 29);
		contentPane.add(btnLogin);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(139, 0, 0));
		panel.setBounds(0, 0, 469, 71);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBack.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setBackground(new Color(139, 69, 19));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home_page window = new home_page();
				window.frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(351, 457, 84, 23);
		contentPane.add(btnBack);
	}
}
