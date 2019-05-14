package apucr;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class AdmPanel extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdmPanel frame = new AdmPanel();
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
	public AdmPanel() {
		setTitle("Admin Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 110);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Welcome to the Admin Panel");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JButton btnManageProfile = new JButton("Manage Profile");
		btnManageProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdmManage adp = new AdmManage();
		        adp.setVisible(true);
		        adp.pack();
		        adp.setLocationRelativeTo(null);
		        adp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		        setVisible(false);
			}
		});
		panel.add(btnManageProfile);
		
		JButton btnNewButton = new JButton("Courses");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Student List");
		panel.add(btnNewButton_1);
	}

}
