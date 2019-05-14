package apucr;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import apucr.Splash.Login;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;


public class AdmManage extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtDesignation;
	private JTextField txtName;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdmManage frame = new AdmManage();
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
	/** [START] MY CLASSES 
	 * 
	 * 
	 * Inherit Login Class values
	 *
	 */
	
	public class adminManage extends Login{
		String admName = iName;
		String admUsername = iUsername;
		String admPassword = iPassword;
		String admDesignation = iDesignation;
		int admUserID = iUserID;
		int usrGroup = iGroup;
		int usrRecords = iRecords - 1;
		
		String username = txtUsername.getText();
		String password = txtPassword.getText();
		String name = txtName.getText();
		
		String designation = txtDesignation.getText();
		
		
		public void updateAdmin() {
			String record = null;
			FileReader in = null;
			txtDirectory = "C:\\\\Users\\\\mrbil\\\\eclipse-workspace\\\\apucr\\\\users.txt";
			try {
				in = new FileReader(txtDirectory);
				BufferedReader br = new BufferedReader(in);
				// PrintWriter object for output.txt
				FileWriter pw = new FileWriter("C:\\\\\\\\Users\\\\\\\\mrbil\\\\\\\\eclipse-workspace\\\\\\\\apucr\\\\\\\\output.txt", true);
				
				String tmpNewData = "\n" + Integer.toString(admUserID) + " " + username + " " + password + " " + Integer.toString(usrGroup) + " " + name + " "+ designation + "\n";
				
				while ((record = br.readLine()) != null) {
					
					String[] split = record.split("\\s");
					if (split.length < 2) { // prevent empty lines from crashing the program
						continue;
					}
					iUserID = Integer.parseInt(split[0]);
					iUsername = split[1];
					iPassword = split[2];
					iGroup = Integer.parseInt(split[3]);
					iName = split[4];
					iDesignation = split[5];
					String tmpOldData = "\n" + iUserID + " " + iUsername + " " + iPassword + " " + iGroup + " " + iName + " " + iDesignation + "\n";
					
					
					if(this.admUserID == Integer.parseInt(split[0])) {
						pw.write(tmpNewData);
						System.out.println("Jackpot!");
							
						
//						br.close();
//						pw.close();
						
						
					}else {
						pw.write(tmpOldData);
						br.close();
						pw.close();
					}
					
					
//					if(this.admUserID == Integer.parseInt(split[0])) {
//							iUserID = Integer.parseInt(split[0]);
//							iUsername = split[1];
//							iPassword = split[2];
//							iGroup = Integer.parseInt(split[3]);
//							iName = split[4];
//							iDesignation = split[5];
//							String data = split.toString();
//							String tmpOldData = iUserID + iUsername + iPassword + iGroup + iName + iDesignation;
//							String tmpNewData = Integer.toString(admUserID) + username + password + Integer.toString(usrGroup) + name + designation;
//							String newData = data.replaceAll(tmpOldData, tmpNewData);
//							
//							FileWriter writer = new FileWriter(txtDirectory);
//							writer.write(newData);
//							writer.close();
//					}
				}
				
			}catch (IOException f) {
				f.getCause();
				
			}
		}
	}
	
	/** [END] MY CLASSES 
	 * 
	 * 
	 * Inherit Login Class values
	 *
	 */

	/**
	 * Create the frame.
	 */
	public AdmManage() {
		setTitle("Manage Profile");
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 312, 259);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{150, 150, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{65, 65, 0, 65, 65, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.gridheight = 5;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblDesignation = new JLabel("Designation:");
		lblDesignation.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lbluserID = new JLabel(Integer.toString(Login.iUserID));
		
		
		/** Designation Field **/
		txtDesignation = new JTextField();
		txtDesignation.setText(Login.iDesignation);
		txtDesignation.setColumns(10);
		
		/** Name Field **/
		txtName = new JTextField();
		txtName.setText(Login.iName);
		txtName.setColumns(10);
		
		/** Add User Button */
		JButton btnNewButton = new JButton("Add User");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addAdmin adp = new addAdmin();
		        adp.setVisible(true);
		        adp.pack();
		        adp.setLocationRelativeTo(null);
		        adp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		
		/** Update Profile Button */
		JButton btnNewButton_1 = new JButton("Update Profile");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adminManage obj1 = new adminManage();
				obj1.updateAdmin();
				JOptionPane.showMessageDialog(contentPane, "Successfully Updated Profile!");
				
			}
		});
		
		/** user-name Field */
		txtUsername = new JTextField();
		txtUsername.setText(Login.iUsername);
		txtUsername.setColumns(10);
		
		JLabel lblUsername_1 = new JLabel("Username:");
		lblUsername_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		/** Password Field **/
		txtPassword = new JTextField();
		txtPassword.setText(Login.iPassword);
		txtPassword.setColumns(10);
		
		JLabel lblPassword_1 = new JLabel("Password:");
		lblPassword_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(95)
							.addComponent(btnNewButton_1))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
							.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(lblPassword_1)
							.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
							.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblUsername_1)
								.addComponent(lblDesignation, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lbluserID, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDesignation, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
								.addComponent(txtUsername))))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbluserID))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtDesignation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDesignation, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblUsername_1)
						.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(15)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword_1))
					.addGap(17)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton)))
		);
		panel.setLayout(gl_panel);
		
		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.BOTH;
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 3;
		gbc_label.gridy = 2;
		contentPane.add(label, gbc_label);
		
		/** [START]
		 * 
		 */
		String username = apucr.Splash.usrName.getText();
//		AdmDetails obj1 = new AdmDetails();
		System.out.println(Login.iDesignation);
//		String designation = Login.iDesignation;
		System.out.println(username);
		System.out.println("This is it");
//		System.out.println(designation);
		
		/** [END]
		 * 
		 */
		
	}
}
