import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.Cursor;


public class intro {

	private JFrame frame;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					intro window = new intro();
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
	public intro() {
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
		
		JButton btnGetStarted = new JButton("GET STARTED");
		btnGetStarted.setFocusPainted(false);
		btnGetStarted.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGetStarted.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnGetStarted.setForeground(new Color(0, 0, 0));
		btnGetStarted.setBackground(new Color(250, 250, 210));
		btnGetStarted.setFont(new Font("Garamond", Font.BOLD, 30));
		btnGetStarted.setBounds(230, 419, 325, 107);
		frame.getContentPane().add(btnGetStarted);
		
		JLabel lblNewLabel_1 = new JLabel("Students' Attendance Report System");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Bell MT", Font.BOLD, 43));
		lblNewLabel_1.setBounds(45, 111, 695, 136);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Akib\\Downloads\\iut-logo.png"));
		label.setBounds(348, 11, 88, 144);
		frame.getContentPane().add(label);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Akib\\Downloads\\0171.0.jpg"));
		lblNewLabel.setBounds(0, 0, 784, 561);
		frame.getContentPane().add(lblNewLabel);
	}
}
