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
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;















import com.toedter.calendar.JDateChooser;

import javax.swing.DefaultComboBoxModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JList;
import javax.swing.JRadioButton;


@SuppressWarnings("serial")
public class course_reg extends JFrame {
	int a;
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
					String x=null;
					course_reg frame = new course_reg(x);
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
	public course_reg(final String x) {
		
		Vector<Object> columnNames = new Vector<Object>();
        Vector<Object> data = new Vector<Object>();

       /* try
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
           // columnNames.addElement("Select");

            //  Get row data

            while (rs.next())
            {
                Vector<Object> row = new Vector<Object>(columns);

                for (int i = 1; i <= columns; i++)
                {
                    row.addElement( rs.getObject(i) );
                }
               // row.addElement(false);
                data.addElement( row );
            }

            rs.close();
            stmt.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println( e );
        }*/

        //  Create table with database data

       /* DefaultTableModel model = new DefaultTableModel(data, columnNames)
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
        };*/
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
		lblCourse.setBounds(124, 177, 109, 35);
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
		dep.setBounds(241, 187, 109, 20);
		contentPane.add(dep);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblSemester.setBounds(377, 177, 109, 35);
		contentPane.add(lblSemester);
		
		final JComboBox sem = new JComboBox();
		sem.setModel(new DefaultComboBoxModel(new String[] {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th"}));
		sem.setBounds(473, 187, 94, 20);
		contentPane.add(sem);
		//String query = "select courseid,coursename from course where Department='"+dep.getSelectedItem().toString()+"' and Sem='"+sem.getSelectedItem().toString()+"'";
		
		class CheckBoxWrapperTableModel extends AbstractTableModel
		{
		    private Map<Integer, Boolean> checkBoxes = new HashMap<Integer, Boolean>();

		    private TableModel model;
		    private String columnName;

		    public CheckBoxWrapperTableModel(TableModel model, String columnName)
		    {
		        this.model = model;
		        this.columnName = columnName;
		    }

		    @Override
		    public String getColumnName(int col)
		    {
		        return (col > 0) ? model.getColumnName(col - 1) : columnName;
		    }

		    public int getRowCount()
		    {
		        return model.getRowCount();
		    }

		    public int getColumnCount()
		    {
		        return model.getColumnCount() + 1;
		    }

		    public Object getValueAt(int row, int col)
		    {
		        if (col > 0)
		            return model.getValueAt(row, col - 1);
		        else
		        {
		            Object value = checkBoxes.get(row);
		            return (value == null) ? Boolean.FALSE : value;
		        }
		    }

		    @Override
		    public boolean isCellEditable(int row, int col)
		    {
		        if (col > 0)
		            return model.isCellEditable(row, col - 1);
		        else
		            return true;
		    }

		    @Override
		    public void setValueAt(Object value, int row, int col)
		    {
		        if (col > 0)
		            model.setValueAt(value, row, col - 1);
		        else
		            checkBoxes.put(row, (Boolean) value);

		        fireTableCellUpdated(row, col);
		    }

		    @Override
		    public Class getColumnClass(int col)
		    {
		        return (col > 0) ? model.getColumnClass(col - 1) : Boolean.class;
		    }
		}
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(124, 679, 89, 23);
		contentPane.add(btnRegister);
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance report system", "root","");
					String query = "select CourseID,CourseName from course where Department='"+dep.getSelectedItem().toString()+"' and Sem='"+sem.getSelectedItem().toString()+"'";
			PreparedStatement st =(PreparedStatement) con.prepareStatement(query);
			
			ResultSet rs =(ResultSet) st.executeQuery(query);
			//table_1.setModel(DbUtils.resultSetToTableModel(rs));
		
			
				
					rs.close();
					st.close();
					con.close();}
				catch(Exception e)
					{
						System.out.println("Error" + e);
						
					}

		        	
		       
			}
		});
		btnSearch.setBounds(650, 186, 89, 23);
		contentPane.add(btnSearch);
		
		JLabel label = new JLabel();
		label.setFont(new Font("Tahoma", Font.BOLD, 25));
		label.setText("Welcome "+x);
		label.setBounds(10, 114, 285, 35);
		contentPane.add(label);
		
		JRadioButton rdbtnN = new JRadioButton("n");
		rdbtnN.setBounds(34, 444, 75, 23);
		contentPane.add(rdbtnN);
		System.out.print(a);
		
		
		
	}
}