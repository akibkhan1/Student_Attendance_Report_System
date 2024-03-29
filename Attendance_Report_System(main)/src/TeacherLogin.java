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


public class TeacherLogin extends JFrame {
	//public String teacher_login_username;
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
					String x="abc";
					TeacherLogin frame = new TeacherLogin(x);
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
	public TeacherLogin(final String x) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 530);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("FacultyID");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblUsername.setBounds(43, 189, 93, 20);
		contentPane.add(lblUsername);
		
		username = new JTextField();
		username.setBounds(138, 189, 147, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPassword.setBounds(43, 244, 93, 20);
		contentPane.add(lblPassword);
		
		password = new JPasswordField();
		password.setBounds(138, 244, 147, 20);
		contentPane.add(password);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(139, 69, 19));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					boolean islogin_success;
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance report system","root","");
					Statement stmt=con.createStatement();
					String sql="Select UserID,Password from teacherinfo where UserID='"+username.getText()+"' and Password='"+password.getText().toString()+"'";
					String x=username.getText();
					teacherattendence ob=new teacherattendence(x);
					ResultSet rs=(ResultSet) stmt.executeQuery(sql);
					if(rs.next())
					{
						islogin_success=true;
						teacherattendence frame = new teacherattendence(x);
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
		btnLogin.setBounds(138, 330, 89, 23);
		contentPane.add(btnLogin);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(139, 0, 0));
		panel.setBounds(0, 0, 445, 71);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTeacherLogin = new JLabel("Teacher Login");
		lblTeacherLogin.setBounds(10, 0, 209, 71);
		panel.add(lblTeacherLogin);
		lblTeacherLogin.setForeground(new Color(255, 255, 255));
		lblTeacherLogin.setFont(new Font("Cambria", Font.BOLD, 30));
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBack.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
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
