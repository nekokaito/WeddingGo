package com.start.pak;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.login.pak.Login;
import com.login.pak.SignUp;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class StartUp extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartUp frame = new StartUp();
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
	public StartUp() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(StartUp.class.getResource("/icon/logo.png")));
		setTitle("Wedding GO (beta)");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 447);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel BG_Animation = new JLabel("");
		BG_Animation.setIcon(new ImageIcon(StartUp.class.getResource("/com/start/pak/welcome_ani.gif")));
		BG_Animation.setBounds(0, 0, 745, 198);
		contentPane.add(BG_Animation);
		
		JLabel Head_Title = new JLabel("Join Our Family Now");
		Head_Title.setFont(new Font("Unispace", Font.PLAIN, 17));
		Head_Title.setBounds(203, 223, 217, 40);
		contentPane.add(Head_Title);
		
		JButton SignUpB = new JButton("Sign Up");
		SignUpB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp in = new SignUp();
				in.show();
				dispose();
			}
		});
		SignUpB.setBackground(new Color(255, 255, 255));
		SignUpB.setBounds(175, 289, 89, 23);
		contentPane.add(SignUpB);
		
		JButton LoginButton = new JButton("Login");
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login in = new Login();
				in.show();
				dispose();
			}
		});
		LoginButton.setBackground(new Color(255, 255, 255));
		LoginButton.setBounds(331, 289, 89, 23);
		contentPane.add(LoginButton);
		
		JLabel copyrightext = new JLabel("Copyright © 2023 All rights reserved. No part of this application, \"Wedding Go,\" may be reproduced, distributed.");
		copyrightext.setEnabled(false);
		copyrightext.setFont(new Font("Tahoma", Font.PLAIN, 8));
		copyrightext.setBounds(111, 383, 400, 14);
		contentPane.add(copyrightext);
	}

}
