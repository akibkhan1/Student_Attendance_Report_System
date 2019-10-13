import java.awt.*;
import java.lang.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

import com.mysql.jdbc.ResultSet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;






















import com.toedter.calendar.JDateChooser;

import javax.swing.DefaultComboBoxModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JList;
import javax.swing.JRadioButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;


@SuppressWarnings("serial")
public class c_r extends JFrame {
	int a;
	private JPanel contentPane;
	private JButton btnBack;
	private JTable table;
	private JDateChooser dateChooser;
	JButton btnNewButton;
	private JTable table_1;
	private JComboBox dep,sem;

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
					String x=null;
					c_r frame = new c_r(x);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public c_r(final String x) {
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent arg0) {
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 250, 210));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCourse = new JLabel("Department\r\n");
		lblCourse.setBounds(40, 143, 109, 35);
		lblCourse.setFont(new Font("Cambria", Font.PLAIN, 18));
		contentPane.add(lblCourse);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(798, 705, 89, 23);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home_page window = new home_page();
				window.frame.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnBack);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 784, 86);
		panel.setBackground(new Color(128, 0, 0));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Course Registration");
		lblNewLabel.setBounds(10, 11, 320, 64);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 35));
		
		final JComboBox dep = new JComboBox();
		dep.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dep.setName("");
		dep.setBounds(159, 153, 109, 20);
		dep.setModel(new DefaultComboBoxModel(new String[] {"CSE", "EEE", "MCE", "CEE", "BTM", "TVE"}));
		contentPane.add(dep);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setBounds(313, 143, 94, 35);
		lblSemester.setFont(new Font("Cambria", Font.PLAIN, 18));
		contentPane.add(lblSemester);
		
		final JComboBox sem = new JComboBox();
		sem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		sem.setBounds(417, 153, 94, 20);
		sem.setModel(new DefaultComboBoxModel(new String[] {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th"}));
		contentPane.add(sem);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSearch.setForeground(new Color(255, 255, 255));
		btnSearch.setBackground(new Color(139, 69, 19));
		btnSearch.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearch.setBounds(533, 150, 89, 23);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					DefaultTableModel model=new DefaultTableModel();
					model.addColumn("CourseID");
					model.addColumn("CourseName");
					Class.forName("com.mysql.jdbc.Driver");
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance report system", "root","");
					String query = "select CourseID,CourseName,''as'Status' from course where Department='"+dep.getSelectedItem().toString()+"' and Sem='"+sem.getSelectedItem().toString()+"'";
					PreparedStatement st =(PreparedStatement) con.prepareStatement(query);
					ResultSet rs =(ResultSet) st.executeQuery(query);
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					st.close();
					con.close();}
				catch(Exception e)
					{
						System.out.println("Error" + e);
						
					}
		       
			}
		});
		contentPane.add(btnSearch);
		
		JLabel label = new JLabel();
		label.setBounds(10, 97, 285, 35);
		label.setFont(new Font("Times New Roman", Font.BOLD, 25));
		label.setText("Welcome "+x);
		contentPane.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		scrollPane.setBounds(40, 189, 583, 361);
		contentPane.add(scrollPane);
		
		final JButton btnRegister = new JButton("Register");
		btnRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegister.setFont(new Font("Garamond", Font.PLAIN, 25));
		btnRegister.setForeground(new Color(255, 255, 255));
		btnRegister.setBackground(new Color(139, 69, 19));
		btnRegister.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		btnRegister.setBounds(643, 318, 119, 66);
		contentPane.add(btnRegister);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i=table_1.getSelectedRow();
				TableModel model=table_1.getModel();
				final String c_id=model.getValueAt(i,0).toString();
				model.setValueAt("Registered", i, 2);
				btnRegister.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try{
							//String fid = null;
							Class.forName("com.mysql.jdbc.Driver");
							Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance report system", "root","");
							Statement stmt=(Statement) con.createStatement();
							String query ="insert into course_student(courseid,st_id) values(?,?)";
							PreparedStatement pst =con.prepareStatement(query);
								pst.setString(1,c_id);
								pst.setString(2,x);
								pst.executeUpdate();
								con.close();
									JOptionPane.showMessageDialog(null, "Course registered Successfuly");
								
									
							}
						 catch (Exception e) {
							 
								e.printStackTrace();
							}
					}
				});
			}
		});
		scrollPane.setViewportView(table_1);
		
		JButton btnBack = new JButton("Back");
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBack.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnBack.setBackground(new Color(139, 69, 19));
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String x=null;
				student_option window = new student_option(x);
				window.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(674, 528, 89, 23);
		contentPane.add(btnBack);
		
		
		//add(new JScrollPane(table_1));
	}
	private void showData(){
		
	}
	}