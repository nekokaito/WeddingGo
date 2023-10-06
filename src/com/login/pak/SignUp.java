package com.login.pak;

import java.awt.EventQueue;

import java.awt.FlowLayout;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JPasswordField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

import java.util.ArrayList;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.sql.DriverManager;

public class SignUp extends JFrame {

	public record ArrayList() {

		public void add(String string) {
			// TODO Auto-generated method stub
			
		}

		public Object toArray(String[] strings) {
			// TODO Auto-generated method stub
			return null;
		}

	}

	private JPanel contentPane;
	private JTextField newUsernameText;
	private JTextField newEmailText;
	private JPasswordField repasswordField;
	private JPasswordField passwordField;
	private JTextField newPhoneNumberText;
	private JComboBox<String> monthComboBox;
    private JComboBox<String> dateComboBox;
    private JComboBox<Integer> yearComboBox;
    private JLabel lblGender;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
     Connection con;
	
	PreparedStatement pst;
	/**
	 * Create the frame.
	 */
	public void Connect()
    {
        try {
            
        	Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/weddinggo", "root","");
        }
        catch (ClassNotFoundException ex) 
        {
          ex.printStackTrace();
        }
        catch (SQLException ex) 
        {
               ex.printStackTrace();
        }

    }
	
	
	
	public SignUp() {
		
		Connect();
		
		setTitle("Wedding GO (beta)");
		setIconImage(Toolkit.getDefaultToolkit().getImage(SignUp.class.getResource("/icon/logo.png")));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(165, 204, 187));
		panel.setBounds(10, 11, 327, 727);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel BG_SignUp = new JLabel("New label");
		BG_SignUp.setIcon(new ImageIcon(SignUp.class.getResource("/com/login/pak/BG_Sign_Up.png")));
		BG_SignUp.setBounds(0, 0, 327, 533);
		panel.add(BG_SignUp);
		
		JLabel Logo_SignUp = new JLabel("New label");
		Logo_SignUp.setIcon(new ImageIcon(SignUp.class.getResource("/com/login/pak/Title.png")));
		Logo_SignUp.setBounds(32, 563, 250, 71);
		panel.add(Logo_SignUp);
		
		JLabel SignUpTittle = new JLabel("Sign Up");
		SignUpTittle.setFont(new Font("Unispace", Font.BOLD, 29));
		SignUpTittle.setBounds(401, 30, 188, 36);
		contentPane.add(SignUpTittle);
		
		JLabel newUsername = new JLabel("Username");
		newUsername.setFont(new Font("Unispace", Font.PLAIN, 13));
		newUsername.setBounds(401, 115, 83, 14);
		contentPane.add(newUsername);
		
		newUsernameText = new JTextField();
		newUsernameText.setFont(new Font("Consolas", Font.PLAIN, 14));
		newUsernameText.setBounds(401, 140, 330, 36);
		contentPane.add(newUsernameText);
		newUsernameText.setColumns(10);
		
		JLabel newEmail = new JLabel("Email");
		newEmail.setFont(new Font("Unispace", Font.PLAIN, 13));
		newEmail.setBounds(401, 193, 90, 14);
		contentPane.add(newEmail);
		
		newEmailText = new JTextField();
		newEmailText.setFont(new Font("Consolas", Font.PLAIN, 14));
		newEmailText.setColumns(10);
		newEmailText.setBounds(401, 218, 330, 36);
		contentPane.add(newEmailText);
		
		JLabel newPassword = new JLabel("Password");
		newPassword.setFont(new Font("Unispace", Font.PLAIN, 13));
		newPassword.setBounds(401, 265, 90, 14);
		contentPane.add(newPassword);
		
		JLabel newRePassword = new JLabel("Re-Password");
		newRePassword.setFont(new Font("Unispace", Font.PLAIN, 13));
		newRePassword.setBounds(401, 337, 90, 14);
		contentPane.add(newRePassword);
		
		repasswordField = new JPasswordField();
		repasswordField.setFont(new Font("Consolas", Font.PLAIN, 14));
		repasswordField.setBounds(404, 362, 327, 36);
		contentPane.add(repasswordField);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Consolas", Font.PLAIN, 14));
		passwordField.setBounds(404, 290, 327, 36);
		contentPane.add(passwordField);
		
		JLabel newPhoneNumber = new JLabel("Phone");
		newPhoneNumber.setFont(new Font("Unispace", Font.PLAIN, 13));
		newPhoneNumber.setBounds(401, 409, 90, 14);
		contentPane.add(newPhoneNumber);
		
		newPhoneNumberText = new JTextField();
		newPhoneNumberText.setFont(new Font("Consolas", Font.PLAIN, 14));
		newPhoneNumberText.setColumns(10);
		newPhoneNumberText.setBounds(401, 434, 330, 36);
		contentPane.add(newPhoneNumberText);
		
		JLabel dobLabel = new JLabel("Date of Birth");
        dobLabel.setFont(new Font("Unispace", Font.PLAIN, 13));
        dobLabel.setBounds(401, 481, 120, 14);
        contentPane.add(dobLabel);

        // Day ComboBox
        String[] days = new String[31];
        for (int i = 1; i <= 31; i++) {
            days[i - 1] = Integer.toString(i);
        }
        dateComboBox = new JComboBox<>(days);
        dateComboBox.setFont(new Font("Consolas", Font.PLAIN, 14));
        dateComboBox.setBounds(401, 506, 60, 36);
        contentPane.add(dateComboBox);

        // Month ComboBox
        String[] months = {
            "January", "February", "March", "April", "May", "June", 
            "July", "August", "September", "October", "November", "December"
        };
        monthComboBox = new JComboBox<>(months);
        monthComboBox.setFont(new Font("Consolas", Font.PLAIN, 14));
        monthComboBox.setBounds(471, 506, 120, 36);
        contentPane.add(monthComboBox);

        // Year ComboBox
        Integer[] years = new Integer[100];
        int currentYear = java.time.LocalDate.now().getYear();
        for (int i = 0; i < 100; i++) {
            years[i] = currentYear - i;
        }
        yearComboBox = new JComboBox<>(years);
        yearComboBox.setFont(new Font("Consolas", Font.PLAIN, 14));
        yearComboBox.setBounds(601, 506, 80, 36);
        contentPane.add(yearComboBox);
        
        lblGender = new JLabel("Gender");
        lblGender.setFont(new Font("Unispace", Font.PLAIN, 13));
        lblGender.setBounds(401, 553, 120, 14);
        contentPane.add(lblGender);
        
        JRadioButton Male = new JRadioButton("Male");
        Male.setFont(new Font("Unispace", Font.PLAIN, 11));
        Male.setBounds(401, 586, 67, 23);
        contentPane.add(Male);
        
        JRadioButton Female = new JRadioButton("Female");
        Female.setFont(new Font("Unispace", Font.PLAIN, 11));
        Female.setBounds(472, 586, 67, 23);
        contentPane.add(Female);
        
        JRadioButton Others = new JRadioButton("Others");
        Others.setFont(new Font("Unispace", Font.PLAIN, 11));
        Others.setBounds(560, 586, 67, 23);
        contentPane.add(Others);
        
        JLabel lblNewLabel_1 = new JLabel("By clicking the button you agree with the terms &");
        lblNewLabel_1.setEnabled(false);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblNewLabel_1.setBounds(456, 656, 514, 36);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel(" conditions and privacy policy of WeddingGo");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblNewLabel_2.setEnabled(false);
        lblNewLabel_2.setBounds(466, 684, 226, 14);
        contentPane.add(lblNewLabel_2);
        
        JButton SignUpButton = new JButton("Sign Up");
        SignUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String username = newUsernameText.getText().trim();
                String email = newEmailText.getText().trim();
                char[] passwordChars = passwordField.getPassword();
                char[] passwordRe  =  repasswordField.getPassword();
                String password = new String(passwordChars);
                String password2 = new String(passwordRe);
                String phoneNumber = newPhoneNumberText.getText().trim();
                if (!password.equals(password2)) {
                	JOptionPane.showMessageDialog(null, "Password and Re-Password not matching.");
                }
                else {
                // Check if required fields are empty
                if (username.isEmpty() || email.isEmpty() || password.isEmpty() || phoneNumber.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all required fields.");
                } 
                
                else {
                    // Continue with registration
                    String dob = yearComboBox.getSelectedItem() + "-" + (monthComboBox.getSelectedIndex() + 1) + "-" + dateComboBox.getSelectedItem();
                    String gender = Male.isSelected() ? "Male" : (Female.isSelected() ? "Female" : "Others");

                    // Insert data into the database
                    try {
                        // Ensure that the 'con' variable is not null
                        if (con != null) {
                            pst = con.prepareStatement("INSERT INTO useraccounts (username, email, password, phone, dob, gender) VALUES (?, ?, ?, ?, ?, ?)");

                            pst.setString(1, username);
                            pst.setString(2, email);
                            pst.setString(3, password);
                            pst.setString(4, phoneNumber);
                            pst.setString(5, dob);
                            pst.setString(6, gender);

                            int rowsInserted = pst.executeUpdate();
                            if (rowsInserted > 0) {
                                JOptionPane.showMessageDialog(null, "Account Created. Enjoy our App!");
                                Login in = new Login();
                				in.show();
                				dispose();
                                
                            } else {
                                JOptionPane.showMessageDialog(null, "User-registration failed.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Database connection is not established.");
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
            }
        });
        SignUpButton.setFont(new Font("Unispace", Font.PLAIN, 11));
        SignUpButton.setBounds(471, 632, 89, 23);
        contentPane.add(SignUpButton);
        
        
        
        JButton loginbt = new JButton("Already Have?");
        loginbt.addActionListener(new ActionListener() {
        	@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
        		Login in = new Login();
				in.show();
				dispose();
        	}
        });
        loginbt.setFont(new Font("Unispace", Font.PLAIN, 11));
        loginbt.setBounds(572, 632, 130, 23);
        contentPane.add(loginbt);
	  
	}
}
