import java.awt.*;
import java.lang.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

import com.mysql.jdbc.ResultSet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JButton;










import com.toedter.calendar.JDateChooser;

import javax.swing.DefaultComboBoxModel;

import net.proteanit.sql.DbUtils;


@SuppressWarnings("serial")
public class course_reg extends JFrame {

	private JPanel contentPane;
	private JButton btnBack;
	private JTable table;
	private JDateChooser dateChooser;
	JButton btnNewButton;

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
					teacherattendence frame = new teacherattendence();
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
	public course_reg() {
		
		Vector<Object> columnNames = new Vector<Object>();
        Vector<Object> data = new Vector<Object>();

        try
        {
            //  Connect to an Access Database

            
           
            Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance report system", "root","");
            //  Read data from a table

            String sql = "Select CourseID,CourseName from course";
            Statement stmt = con.createStatement();
            ResultSet rs = (ResultSet) stmt.executeQuery( sql );
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get column names
        	
        	
           for (int i = 1; i <= columns; i++)
            {
                columnNames.addElement( md.getColumnName(i) );
            }
            columnNames.addElement("Select");

            //  Get row data

            while (rs.next())
            {
                Vector<Object> row = new Vector<Object>(columns);

                for (int i = 1; i <= columns; i++)
                {
                    row.addElement( rs.getObject(i) );
                }
                row.addElement(false);
                data.addElement( row );
            }

            rs.close();
            stmt.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println( e );
        }

        //  Create table with database data

        DefaultTableModel model = new DefaultTableModel(data, columnNames)
        {
        	@SuppressWarnings({ "unchecked", "rawtypes" })
			@Override
            public Class getColumnClass(int column)
            {
        		
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);

                    if (o != null)
                    {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent arg0) {
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 913, 778);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 250, 210));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCourse = new JLabel("Department\r\n");
		lblCourse.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblCourse.setBounds(124, 135, 109, 35);
		contentPane.add(lblCourse);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home_page window = new home_page();
				window.frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(798, 705, 89, 23);
		contentPane.add(btnBack);
		
		table = new JTable(model);
		table.setBounds(124, 210, 709, 416);
		contentPane.add(table);
		
		JButton btnNewButton = new JButton("Register\r\n");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					int rows=table.getRowCount();
					Class.forName("com.mysql.jdbc.Driver");
					
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance report system", "root","");
					String query ="insert into attendance(StID,CourseID,Date,Present,Absent,Late) values(?,?,?,?,?,?)";
					PreparedStatement pst =con.prepareStatement(query);
					
					for(int i=0;i<rows;i++)
					{
						Integer stid = (Integer)table.getValueAt(i,0);
						Integer cid =(Integer) table.getValueAt(i, 2);
						Boolean p= (Boolean) table.getValueAt(i,3);
						Boolean a= (Boolean) table.getValueAt(i,4);
						Boolean l= (Boolean) table.getValueAt(i,5);
						
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						String date =sdf.format(new Date(System.currentTimeMillis()));
						pst.setInt(1,stid);
						pst.setInt(2,cid);
						pst.setString(3,date);
						pst.setBoolean(4,p);
						pst.setBoolean(5,a);
						pst.setBoolean(6,l);
						//pst.setString(7, date);
						pst.executeUpdate();
					}
					con.close();
					
					
				}
				 catch (Exception e) {
						e.printStackTrace();
						System.out.print(e.getMessage());
					}
			}
		});
		btnNewButton.setBounds(124, 650, 89, 35);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 0));
		panel.setBounds(0, 0, 897, 103);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Course Registration");
		lblNewLabel.setBounds(27, 0, 257, 103);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 24));
		
		final JComboBox dep = new JComboBox();
		dep.setModel(new DefaultComboBoxModel(new String[] {"CSE", "EEE", "MCE", "CEE", "BTM", "TVE"}));
		dep.setBounds(243, 145, 109, 20);
		contentPane.add(dep);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblSemester.setBounds(386, 135, 109, 35);
		contentPane.add(lblSemester);
		
		final JComboBox sem = new JComboBox();
		sem.setModel(new DefaultComboBoxModel(new String[] {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th"}));
		sem.setBounds(479, 145, 94, 20);
		contentPane.add(sem);
		//String query = "select courseid,coursename from course where Department='"+dep.getSelectedItem().toString()+"' and Sem='"+sem.getSelectedItem().toString()+"'";
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Vector<Object> columnNames = new Vector<Object>();
		        Vector<Object> data = new Vector<Object>();
		        String sql;
		        Statement stmt;
		        ResultSet rs;
		        Connection con;
		        try
		        {
		            //  Connect to an Access Database

		        	 Class.forName("com.mysql.jdbc.Driver");
						con= DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance report system", "root","");

						 sql = "select courseid,coursename from course where Department='"+dep.getSelectedItem().toString()+"' and Sem='"+sem.getSelectedItem().toString()+"'";
			            stmt = con.createStatement();
			             rs = (ResultSet) stmt.executeQuery( sql );
			            table.setModel(DbUtils.resultSetToTableModel(rs));
		            rs.close();
		            stmt.close();
		            con.close();
		           
		        }
		        catch(Exception e)
		        {
		            System.out.println( e );
		        }

		        //  Create table with database data

		        DefaultTableModel model = new DefaultTableModel(data, columnNames)
		        {
		        	@SuppressWarnings({ "unchecked", "rawtypes" })
					@Override
		            public Class getColumnClass(int column)
		            {
		        		
		                for (int row = 0; row < getRowCount(); row++)
		                {
		                    Object o = getValueAt(row, column);

		                    if (o != null)
		                    {
		                        return o.getClass();
		                    }
		                }

		                return Object.class;
		            }
		        };
		        

		       
			}
		});
		btnSearch.setBounds(602, 144, 89, 23);
		contentPane.add(btnSearch);
		
	}
}