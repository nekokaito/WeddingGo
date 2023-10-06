package com.dashboard.pak;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import java.sql.*;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.Window.Type;
public class GuestList extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField familytext;
	private JTextField membertext;
	private JTextField searchtxt;
	private JTable tablex;
	private JFrame framex;
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JPanel upperpanel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuestList frame = new GuestList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
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
	public void table_load()
	 {
	     try 
	     {
	     pst = con.prepareStatement("select * from guestlist");
	     rs = pst.executeQuery();
	     tablex.setModel(DbUtils.resultSetToTableModel(rs));
	 } 
	     catch (SQLException e) 
	      {
	         e.printStackTrace();
	   } 
	 }


	/**
	 * Create the frame.
	 */
	public GuestList() {
		setTitle("Wedding Go (beta)");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GuestList.class.getResource("/icon/logo.png")));
		Connect();
		tablex = new JTable(); 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 946, 636);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(GuestList.class.getResource("/icon/Guest.png")));
		lblNewLabel.setBounds(29, 32, 109, 96);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Guest List");
		lblNewLabel_1.setFont(new Font("Unispace", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(148, 60, 150, 41);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dashboard in = new Dashboard();
				in.show();
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Unispace", Font.PLAIN, 11));
		btnNewButton.setBounds(29, 536, 109, 23);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(504, 166, 358, 210);
		contentPane.add(panel);
		panel.setLayout(null);
		
		familytext = new JTextField();
		familytext.setBounds(29, 45, 299, 26);
		panel.add(familytext);
		familytext.setColumns(10);
		
		membertext = new JTextField();
		membertext.setBounds(29, 102, 299, 26);
		panel.add(membertext);
		membertext.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Family Name");
		lblNewLabel_2.setFont(new Font("Unispace", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(29, 20, 103, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("No. Members");
		lblNewLabel_3.setFont(new Font("Unispace", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(29, 77, 93, 14);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String familyname = familytext.getText();
			    String noofmember =  membertext.getText();     
			   
			    try {
			    	if (con != null) {
			        pst = con.prepareStatement("insert into guestlist(familyname,noofmember)values(?,?)");
			        pst.setString(1, familyname);
			        pst.setString(2, noofmember);
			        
			        System.out.println(familyname);
			        System.out.println(noofmember);
			        
			        int rowsInserted = pst.executeUpdate();
			        
			        if (rowsInserted > 0) {
			        JOptionPane.showMessageDialog(null, "Record Added.");
			        table_load();
			                       
			       
			        }
			        else {
			        	JOptionPane.showMessageDialog(null, "Failed to added.");
			        }
			    	}
			    	else {
			    		JOptionPane.showMessageDialog(null, "Database connection is not established.");
			    	}
			    	
			    	
			       }
			    catch (SQLException e1) 
			        {            
			       e1.printStackTrace();
			    }
			}
		});
		btnNewButton_1.setFont(new Font("Unispace", Font.PLAIN, 11));
		btnNewButton_1.setBounds(65, 159, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				familytext.setText("");
				membertext.setText("");
				familytext.requestFocus();
			}
		});
		btnNewButton_2.setFont(new Font("Unispace", Font.PLAIN, 11));
		btnNewButton_2.setBounds(199, 159, 89, 23);
		panel.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 229, 405, 210);
		contentPane.add(scrollPane);
		
		tablex = new JTable();
		scrollPane.setViewportView(tablex);
		table_load();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(20, 347, 328, 65);
		//framex.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		
		JPanel upperpanel;
		upperpanel = new JPanel();
		upperpanel.setBounds(39, 147, 405, 49);
		contentPane.add(upperpanel);
		upperpanel.setLayout(null);
		
		searchtxt = new JTextField();
		searchtxt.setBounds(21, 11, 243, 27);
		upperpanel.add(searchtxt);
		searchtxt.setColumns(10);
		
		JButton search = new JButton("Select");
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String familyname = null;
		            String search = searchtxt.getText();
		            pst = con.prepareStatement("select familyname, noofmember from guestlist where familyname= ?");
		            pst.setString(1, familyname);
		            
		            ResultSet rs = pst.executeQuery();
		            
		            if (rs == null || search.isEmpty() ) {
		            	JOptionPane.showMessageDialog(null, "Input Your Text.");
			        	   
			        	   }
		            
			           else {
			        	   
			        	   JOptionPane.showMessageDialog(null, "Selected.");
			        	   
		            if (rs.next()) {
		                String familynames = rs.getString(1);
		                String noofmember = rs.getString(2);
		                
		                
		                familytext.setText(familynames);
		                membertext.setText(noofmember);
		                
		                
		            } else {
		                familytext.setText("");
		                membertext.setText("");;
		            }
			           }
		           }
		         catch (SQLException ex) {
		            // Handle any exceptions here
		        }
			}
		});
		search.setFont(new Font("Unispace", Font.PLAIN, 11));
		search.setBounds(284, 13, 89, 23);
		upperpanel.add(search);
		
		JButton updatebt = new JButton("Update");
		updatebt.setFont(new Font("Unispace", Font.PLAIN, 11));
		updatebt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String familyname = familytext.getText();
			    String noofmember =  membertext.getText();
			    if (familyname.isEmpty()) {
			        JOptionPane.showMessageDialog(null, "Family Name is required.");
			        return;
			    }

			    // Check if noofmember is empty
			    if (noofmember.isEmpty()) {
			        JOptionPane.showMessageDialog(null, "Number of Members is required.");
			        return;
			    }
			    
			    else {
			    
			    try {
			    	 pst = con.prepareStatement("UPDATE guestlist SET noofmember = ? WHERE familyname = ?");
			    	    pst.setString(1, noofmember);
			    	    pst.setString(2, familyname);
                    
			    	    int rowsInserted = pst.executeUpdate();
				        
				        if (rowsInserted > 0) {
				        JOptionPane.showMessageDialog(null, "Record Added.");
				        table_load();
				        familytext.setText("");
	                    membertext.setText("");         
				       
				        }
				        else {
				        	JOptionPane.showMessageDialog(null, "Failed to added.");
				        }
            }

                catch (SQLException e1) {
                    
                    e1.printStackTrace();
                }
			    } 
			}
		});
		updatebt.setBounds(66, 450, 89, 23);
		contentPane.add(updatebt);
		
		JButton deletebt = new JButton("Delete");
		deletebt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bid;
		           bid  = searchtxt.getText();
		           
		            try {
		                   pst = con.prepareStatement("delete from guestlist where familyname=?");
		           
		                   pst.setString(1, bid);
		                   pst.executeUpdate();
		                   JOptionPane.showMessageDialog(null, "Record Delete!!!!!");
		                   table_load();
		                  
		                   familytext.setText("");
		                   membertext.setText("");
		                   
		                   familytext.requestFocus();
		               }

		               catch (SQLException e1) {
		                   
		                   e1.printStackTrace();
		               }
				
			
			}
		});
		deletebt.setFont(new Font("Unispace", Font.PLAIN, 11));
		deletebt.setBounds(178, 450, 89, 23);
		contentPane.add(deletebt);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(GuestList.class.getResource("/com/login/pak/Title.png")));
		lblNewLabel_4.setBounds(651, 48, 244, 46);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Name of the Family");
		lblNewLabel_5.setFont(new Font("Unispace", Font.PLAIN, 11));
		lblNewLabel_5.setBounds(66, 204, 166, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Number of Guest");
		lblNewLabel_6.setFont(new Font("Unispace", Font.PLAIN, 11));
		lblNewLabel_6.setBounds(279, 204, 150, 14);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton_3 = new JButton("Delete All");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setFont(new Font("Unispace", Font.PLAIN, 11));
		btnNewButton_3.setBounds(289, 450, 109, 23);
		contentPane.add(btnNewButton_3);
	}
}
