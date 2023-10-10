package com.acorn.db;

import java.sql.*;
 

public class DBTest1 {

	public static void main(String[] args) {
		 
		String driver = "oracle.jdbc.driver.OracleDriver" ;
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String password="1234";
		
		Connection con;
		try {
			 Class.forName(driver);
			 con = DriverManager.getConnection(url, user, password);
			 if( con != null)System.out.println("ok");
			 
			 String sql="select  * from member_tbl_11";
			 PreparedStatement pst =  con.prepareStatement(sql);
			 ResultSet rs  =pst.executeQuery();
			 
			 while(rs.next()) {
				 System.out.print( rs.getString(1));
				 System.out.print( rs.getString(2));
				 System.out.print( rs.getString(3));
				 System.out.println( rs.getString(4));
			 } 			 
			 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
