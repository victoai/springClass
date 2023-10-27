package com.acron.tran;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestDB2 {

	public static void main(String[] args)    {
		 
		String driver = "oracle.jdbc.driver.OracleDriver" ;
		String url="jdbc:oracle:thin:@localhost:1521:testdb";
		String user="scott";
		String password="tiger";
		
			 
		   Connection conn=null;
	 
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	      
			 
		
			try {
				//
				conn.setAutoCommit(false);
				String sql1= " insert into testdb values( 'a1', '000')";
				PreparedStatement pst  = conn.prepareStatement(sql1);
				int result  =pst.executeUpdate();
				
				
				String sql2= " insert into testdb values( 'a1', '000')";
				PreparedStatement pst2  = conn.prepareStatement(sql2);
				int result2  =pst2.executeUpdate();				
				conn.commit();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			 
			
			
		

	}

}
