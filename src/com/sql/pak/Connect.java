package com.sql.pak;

import java.sql.*;


public class Connect {
   
	public static void ConnectSQL() 
    {  Connection con;
	
	PreparedStatement pst;
        try {
            
        	Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/WeddingGO", "root","");
        }
        catch (ClassNotFoundException e1) 
        {
          e1.printStackTrace();
        }
        catch(SQLException e1) {
			e1.printStackTrace();
		}
       
    }
}
