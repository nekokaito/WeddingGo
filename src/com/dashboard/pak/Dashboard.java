package com.dashboard.pak;

import java.awt.EventQueue;


import com.start.pak.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import com.login.pak.*;
import com.login.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
public class Dashboard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
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
	public Dashboard() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Dashboard.class.getResource("/icon/logo.png")));
		setTitle("Wedding Go (beta)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome admin");
		lblNewLabel.setFont(new Font("Unispace", Font.PLAIN, 22));
		lblNewLabel.setBounds(31, 40, 262, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Dashboard.class.getResource("/icon/logo.png")));
		lblNewLabel_1.setBounds(612, 27, 257, 223);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Sign Out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StartUp in = new StartUp();
				in.show();
				dispose();
				
			}
		});
		btnNewButton.setBounds(31, 455, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("We regret to inform you that our dashboard service is currently unavailable");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(44, 132, 489, 41);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("as we are in the beta testing process to improve the overall functionality of Wedding Go.");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(44, 185, 599, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Dashboard.class.getResource("/com/login/pak/Title.png")));
		lblNewLabel_4.setBounds(625, 418, 244, 46);
		contentPane.add(lblNewLabel_4);
	}
}
