package apucr;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Splash extends JFrame {

	public static JPanel contentPane;
	public static JTextField usrName;
	public static JTextField usrPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Splash frame = new Splash();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void close() {
		setVisible(false);
	}
	
	/**
	 * START: Login class to validate user credentials
	 */
	public static class Login {
		public static String iUsername;
		public static String iPassword;
		public static String iName;
		public static String iDesignation;
		public static String txtDirectory;
		public static int iGroup;
		public static int iUserID;
		public static int iRecords = 0;
		boolean isAdm;
		
	
	public boolean validate(String username, String password) {
		String record = null;
		FileReader in = null;
		txtDirectory = "C:\\\\Users\\\\mrbil\\\\eclipse-workspace\\\\apucr\\\\users.txt";
		boolean status = false;
		try {
			in = new FileReader(txtDirectory);
			BufferedReader br = new BufferedReader(in);
			
			while ((record = br.readLine()) != null) {
				iRecords++;
				String[] split = record.split("\\s");
				if (split.length < 2) { // prevent empty lines from crashing the program
					continue;
				}
				if(username.equals(split[1]) && password.equals(split[2])) {
					
					if(Integer.parseInt(split[3]) == 1) {
						
						iUserID = Integer.parseInt(split[0]);
						iUsername = split[1];
						iPassword = split[2];
						iGroup = Integer.parseInt(split[3]);
						iName = split[4];
						iDesignation = split[5];
						status = true;
						isAdm = true;
					}else {
						status = true;
					}
				}
			}
			
		}catch (IOException f) {
			f.getCause();
			
		}
		return status;
	}
	
	public String usrGroup() {
		String usrGroupText;
		usrGroupText = "student";
		if(isAdm) {
		usrGroupText =  "admin";
		}
		return usrGroupText;
	}
	public void AdminPanel() {
		AdmPanel adp = new AdmPanel();
        adp.setVisible(true);
        adp.pack();
        adp.setLocationRelativeTo(null);
        adp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void StudentPanel() {
		StdntPanel adp = new StdntPanel();
        adp.setVisible(true);
        adp.pack();
        adp.setLocationRelativeTo(null);
        adp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
	
	/**
	 * END: Login class to validate user credentials
	 */

	/**
	 * Create the frame.
	 */
	public Splash() {
		setTitle("APUCR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 329, 173);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[52px][4px][226px]", "[15px][14px][20px][20px][23px]"));
		
		JLabel lblApuCourseRegistration = new JLabel("APU Course Registration System");
		lblApuCourseRegistration.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblApuCourseRegistration, "cell 0 0 3 1,alignx center,aligny center");
		
		JLabel lblPleaseLoginTo = new JLabel("Please Login To Begin.");
		contentPane.add(lblPleaseLoginTo, "cell 0 1 3 1,alignx center,aligny center");
		
		JLabel lblUsername = new JLabel("Username:");
		contentPane.add(lblUsername, "cell 0 2,alignx center,aligny center");
		
		usrName = new JTextField();
		contentPane.add(usrName, "cell 2 2,growx,aligny center");
		usrName.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		contentPane.add(lblPassword, "cell 0 3,alignx center,aligny center");
		
		usrPass = new JTextField();
		contentPane.add(usrPass, "cell 2 3,growx,aligny center");
		usrPass.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = usrName.getText();
				String password = usrPass.getText();
				Login attempst = new Login();
				if(attempst.validate(username, password)) {
					if(attempst.usrGroup() == "admin") {
						attempst.AdminPanel();
						close();
					}else {
						attempst.StudentPanel();
						close();
					}
				}
			}
		});
		contentPane.add(btnNewButton, "cell 2 4,growx,aligny center");
	}

}
