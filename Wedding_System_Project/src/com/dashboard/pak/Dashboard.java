package com.dashboard.pak;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


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
		
		JLabel WeddingGoLogo = new JLabel("");
		WeddingGoLogo.setIcon(new ImageIcon(Dashboard.class.getResource("/icon/logo.png")));
		WeddingGoLogo.setBounds(612, 27, 257, 223);
		contentPane.add(WeddingGoLogo);
		
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
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Dashboard.class.getResource("/com/login/pak/Title.png")));
		lblNewLabel_4.setBounds(625, 418, 244, 46);
		contentPane.add(lblNewLabel_4);
		
		JLabel GuestLists = new JLabel("aa");
		GuestLists.setIcon(new ImageIcon(Dashboard.class.getResource("/icon/Guest.png")));
		GuestLists.setBounds(57, 132, 109, 98);
		contentPane.add(GuestLists);
		GuestLists.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                GuestList in = new GuestList();
                in.show();
                dispose();
            }
        });
		
		JLabel StaffList = new JLabel("New label");
		StaffList.setIcon(new ImageIcon(Dashboard.class.getResource("/icon/Staff.png")));
		StaffList.setBounds(227, 132, 109, 98);
		contentPane.add(StaffList);
		StaffList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	StaffList in = new StaffList();
                in.show();
                dispose();
            }
        });
		
		JLabel VendorList = new JLabel("New label");
		VendorList.setIcon(new ImageIcon(Dashboard.class.getResource("/icon/vendor.png")));
		VendorList.setBounds(57, 297, 109, 98);
		contentPane.add(VendorList);
		VendorList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	VendorList in = new VendorList();
                in.show();
                dispose();
            }
        });
		
		JLabel AboutUs = new JLabel("New label");
		AboutUs.setIcon(new ImageIcon(Dashboard.class.getResource("/icon/dark_weddinggo.png")));
		AboutUs.setBounds(226, 298, 109, 98);
		contentPane.add(AboutUs);
		AboutUs.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                 String url = "https://github.com/nekokaito/WeddingGo";
                
                try {
                    
                    Desktop.getDesktop().browse(new java.net.URI(url));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
		
		JLabel GuestList_Text = new JLabel("Guest");
		GuestList_Text.setFont(new Font("Unispace", Font.PLAIN, 11));
		GuestList_Text.setBounds(93, 227, 46, 14);
		contentPane.add(GuestList_Text);
		GuestList_Text.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	GuestList in = new GuestList();
                in.show();
                dispose();
            }
        });
		
		JLabel StaffList_Text = new JLabel("Staff");
		StaffList_Text.setFont(new Font("Unispace", Font.PLAIN, 11));
		StaffList_Text.setBounds(270, 227, 46, 14);
		contentPane.add(StaffList_Text);
		StaffList_Text.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	StaffList in = new StaffList();
                in.show();
                dispose();
            }
        });
		
		JLabel VendorList_Text = new JLabel("Vendor");
		VendorList_Text.setFont(new Font("Unispace", Font.PLAIN, 11));
		VendorList_Text.setBounds(93, 406, 46, 14);
		contentPane.add(VendorList_Text);
		VendorList_Text.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	VendorList in = new VendorList();
                in.show();
                dispose();
            }
        });
		
		JLabel AboutUs_Text = new JLabel("AboutUs");
		AboutUs_Text.setFont(new Font("Unispace", Font.PLAIN, 11));
		AboutUs_Text.setBounds(259, 406, 77, 14);
		contentPane.add(AboutUs_Text);
		AboutUs_Text.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
String url = "https://github.com/nekokaito/WeddingGo";
                
                try {
                    
                    Desktop.getDesktop().browse(new java.net.URI(url));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
	}
}
