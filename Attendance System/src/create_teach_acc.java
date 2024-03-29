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


public class create_teach_acc extends JFrame {

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
					create_teach_acc frame = new create_teach_acc();
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
	public create_teach_acc() {
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent arg0) {
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 250, 210));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnCreateTeacher = new JButton("Register Faculty");
		btnCreateTeacher.setBounds(178, 86, 237, 51);
		btnCreateTeacher.setBackground(new Color(139, 69, 19));
		btnCreateTeacher.setForeground(new Color(255, 255, 255));
		btnCreateTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reg_teacher frame = new reg_teacher();
				frame.setVisible(true);
				dispose();
			}
		});
		contentPane.setLayout(null);
		btnCreateTeacher.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(btnCreateTeacher);
		
		JButton btnUpdateTeacherInformation = new JButton("Course Assignment");
		btnUpdateTeacherInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				t_course_assign frame = new t_course_assign();
				frame.setVisible(true);
				dispose();
			}
		});
		btnUpdateTeacherInformation.setBounds(178, 162, 237, 51);
		btnUpdateTeacherInformation.setForeground(new Color(255, 255, 255));
		btnUpdateTeacherInformation.setBackground(new Color(139, 69, 19));
		btnUpdateTeacherInformation.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(btnUpdateTeacherInformation);
		
		JButton btnHome = new JButton("Home");
		btnHome.setBounds(178, 408, 237, 51);
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
		contentPane.add(btnHome);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 622, 62);
		panel.setBackground(new Color(139, 0, 0));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAdminPanel = new JLabel("Admin Panel");
		lblAdminPanel.setForeground(new Color(255, 255, 255));
		lblAdminPanel.setBounds(10, 11, 206, 42);
		panel.add(lblAdminPanel);
		lblAdminPanel.setBackground(Color.CYAN);
		lblAdminPanel.setFont(new Font("Cambria", Font.BOLD, 35));
		
		JButton btnAddStudent = new JButton("Register Student");
		btnAddStudent.setBounds(178, 235, 237, 51);
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				student_reg window = new student_reg();
				window.setVisible(true);
				dispose();
			}
		});
		btnAddStudent.setForeground(Color.WHITE);
		btnAddStudent.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAddStudent.setBackground(new Color(139, 69, 19));
		contentPane.add(btnAddStudent);
	
}
}
;