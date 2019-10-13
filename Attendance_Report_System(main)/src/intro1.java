import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;


public class intro1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					intro1 window = new intro1();
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
	public intro1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblStudents = new JLabel("Students' Attendance");
		lblStudents.setFont(new Font("Cambria", Font.BOLD, 30));
		lblStudents.setBounds(168, 34, 316, 48);
		frame.getContentPane().add(lblStudents);
		
		JLabel lblReport = new JLabel(" Report System");
		lblReport.setFont(new Font("Cambria", Font.BOLD, 27));
		lblReport.setBounds(226, 82, 185, 32);
		frame.getContentPane().add(lblReport);
		
		JButton btnGetStarted = new JButton("GET STARTED");
		btnGetStarted.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home_page window = new home_page();
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnGetStarted.setFocusPainted(false);
		btnGetStarted.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGetStarted.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnGetStarted.setForeground(new Color(0, 0, 0));
		btnGetStarted.setBackground(new Color(250, 250, 210));
		btnGetStarted.setFont(new Font("Garamond", Font.BOLD, 30));
		btnGetStarted.setBounds(263, 429, 239, 78);
		frame.getContentPane().add(btnGetStarted);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Akib\\Downloads\\iut-logo.png"));
		lblNewLabel_1.setBounds(10, 11, 88, 144);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(new MatteBorder(2, 1, 2, 1, (Color) new Color(0, 0, 0)));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Akib\\Downloads\\24121703_baa4356568_o.png"));
		lblNewLabel.setBounds(0, 0, 784, 561);
		frame.getContentPane().add(lblNewLabel);
	}

}
