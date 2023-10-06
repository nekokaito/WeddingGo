package com.login.pak;

import java.awt.EventQueue;
import com.dashboard.pak.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField Username;
	private JPasswordField Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    Connection con;
	PreparedStatement pst;
	ResultSet rs;
	

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
    



	/**
	 * Create the frame.
	 */
	public Login() {

		Connect();

		setTitle("Wedding GO (beta)");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/icon/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(72, 75, 58));
		panel.setBounds(469, 0, 315, 749);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel BG_Login = new JLabel("New label");
		BG_Login.setIcon(new ImageIcon(Login.class.getResource("/com/login/pak/BG_Login.jpg")));
		BG_Login.setBounds(0, 0, 315, 551);
		panel.add(BG_Login);
		
		JLabel Logo_White = new JLabel("New label");
		Logo_White.setIcon(new ImageIcon(Login.class.getResource("/com/login/pak/Title__White.png")));
		Logo_White.setBounds(38, 588, 250, 71);
		panel.add(Logo_White);
		
		JLabel lblNewLabel_2 = new JLabel("Login Now !");
		lblNewLabel_2.setFont(new Font("Unispace", Font.PLAIN, 29));
		lblNewLabel_2.setBounds(42, 30, 207, 40);
		contentPane.add(lblNewLabel_2);
		
		Username = new JTextField();
		Username.setBounds(42, 183, 359, 40);
		contentPane.add(Username);
		Username.setColumns(10);
		
		JLabel Username_text = new JLabel("Username / Email");
		Username_text.setFont(new Font("Unispace", Font.PLAIN, 11));
		Username_text.setBounds(42, 158, 141, 14);
		contentPane.add(Username_text);
		
		Password = new JPasswordField();
		Password.setBounds(42, 256, 359, 40);
		contentPane.add(Password);
		
		JLabel PasswordText = new JLabel("Password");
		PasswordText.setFont(new Font("Unispace", Font.PLAIN, 11));
		PasswordText.setBounds(42, 234, 78, 14);
		contentPane.add(PasswordText);
		
		JCheckBox RememberMe = new JCheckBox("Remember Me");
		RememberMe.setFont(new Font("Tahoma", Font.PLAIN, 11));
		RememberMe.setBounds(42, 316, 97, 23);
		contentPane.add(RememberMe);
		
		JButton Login_Home = new JButton("Login");
		Login_Home.setFont(new Font("Unispace", Font.PLAIN, 11));
		Login_Home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				String username = Username.getText();
				char[] pass = Password.getPassword();
				
				pst = con.prepareStatement("SELECT password FROM useraccounts WHERE username=?");
				pst.setString(1, username);
				ResultSet rs = pst.executeQuery();
				
				if (rs.next()) {
	                char[] passDB = rs.getString(1).toCharArray();
	                
	                if (Arrays.equals(pass, passDB)) {
	                    JOptionPane.showMessageDialog(null, "Login Approved");
	                    Dashboard in = new Dashboard();
	                    in.show();
	                    dispose();
	                } else {
	                    JOptionPane.showMessageDialog(null, "Passwords do not match"); // Add this line for debugging
	                }
	            } else {
	                JOptionPane.showMessageDialog(null, "User not found"); // Add this line for debugging
	            }
	        } catch (SQLException e2) {
	            e2.printStackTrace();			}
			}
			
		});
			
				
		Login_Home.setBounds(104, 366, 89, 23);
		contentPane.add(Login_Home);
		
		JButton SignUpButton = new JButton("Sign Up");
		SignUpButton.setFont(new Font("Unispace", Font.PLAIN, 11));
		SignUpButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				SignUp in = new SignUp();
				in.show();
				dispose();
			}
		});
		SignUpButton.setBounds(204, 366, 97, 23);
		contentPane.add(SignUpButton);
		
		
		
	}
}
