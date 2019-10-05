import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

import com.mysql.jdbc.ResultSet;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JButton;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JPasswordField;


public class Admin extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;
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
					Student frame = new Student();
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
	public Admin() {
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent arg0) {
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(68, 157, 72, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(68, 190, 72, 14);
		contentPane.add(lblPassword);
		
		username = new JTextField();
		username.setBounds(154, 154, 86, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(154, 187, 86, 20);
		contentPane.add(password);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					boolean islogin_success;
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance report system","root","");
					Statement stmt=con.createStatement();
					String sql="Select * from admin where Username='"+username.getText()+"' and Password='"+password.getText().toString()+"'";
					ResultSet rs=(ResultSet) stmt.executeQuery(sql);
					if(rs.next())
					{
						islogin_success=true;
						create_teach_acc frame = new create_teach_acc();
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
		btnLogin.setBounds(151, 237, 89, 23);
		contentPane.add(btnLogin);
		
		JLabel lblAdminLogin = new JLabel("Admin Login");
		lblAdminLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAdminLogin.setBounds(68, 54, 172, 23);
		contentPane.add(lblAdminLogin);
	
}
}
;