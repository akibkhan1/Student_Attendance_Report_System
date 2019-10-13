import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

import com.mysql.jdbc.ResultSet;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import java.awt.Color;

import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import java.awt.Cursor;


public class student_option extends JFrame {

	private JPanel contentPane;
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
					String y=null;
					student_option frame = new student_option(y);
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
	public student_option(final String y) {
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent arg0) {
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 250, 210));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCreateTeacher = new JButton("Course Registration\r\n");
		btnCreateTeacher.setFocusPainted(false);
		btnCreateTeacher.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCreateTeacher.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnCreateTeacher.setBackground(new Color(139, 69, 19));
		btnCreateTeacher.setForeground(new Color(255, 255, 255));
		btnCreateTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String x=y;
				c_r frame = new c_r(x);
				frame.setVisible(true);
				dispose();
			}
		});
		btnCreateTeacher.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCreateTeacher.setBounds(191, 142, 237, 51);
		contentPane.add(btnCreateTeacher);
		
		JButton btnUpdateTeacherInformation = new JButton("Faculty Information");
		btnUpdateTeacherInformation.setFocusPainted(false);
		btnUpdateTeacherInformation.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnUpdateTeacherInformation.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdateTeacherInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Student frame = new Student();
				frame.setVisible(true);
				dispose();
			}
		});
		btnUpdateTeacherInformation.setForeground(new Color(255, 255, 255));
		btnUpdateTeacherInformation.setBackground(new Color(139, 69, 19));
		btnUpdateTeacherInformation.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnUpdateTeacherInformation.setBounds(191, 216, 237, 51);
		contentPane.add(btnUpdateTeacherInformation);
		
		JButton btnHome = new JButton("Home");
		btnHome.setFocusPainted(false);
		btnHome.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHome.setForeground(new Color(255, 255, 255));
		btnHome.setBackground(new Color(139, 69, 19));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home_page window = new home_page();
				window.frame.setVisible(true);
				dispose();
			}
		});
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnHome.setBounds(191, 379, 237, 51);
		contentPane.add(btnHome);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(139, 0, 0));
		panel.setBounds(0, 0, 622, 69);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAdminPanel = new JLabel("Student Panel");
		lblAdminPanel.setBounds(10, 11, 200, 42);
		lblAdminPanel.setForeground(new Color(255, 255, 255));
		panel.add(lblAdminPanel);
		lblAdminPanel.setBackground(Color.CYAN);
		lblAdminPanel.setFont(new Font("Cambria", Font.BOLD, 30));
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setText("Welcome "+y);
		lblNewLabel.setBounds(10, 79, 405, 36);
		contentPane.add(lblNewLabel);
		
		JButton btnOfAttendance = new JButton("Attendance %");
		btnOfAttendance.setFocusPainted(false);
		btnOfAttendance.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOfAttendance.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnOfAttendance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String x=y;
				percent ob = new percent(x);
				ob.setVisible(true);
				dispose();
			}
		});
		btnOfAttendance.setForeground(Color.WHITE);
		btnOfAttendance.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnOfAttendance.setBackground(new Color(139, 69, 19));
		btnOfAttendance.setBounds(191, 288, 237, 51);
		contentPane.add(btnOfAttendance);
	
}
}
;