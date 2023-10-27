package com.acorn.tran;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestDB {

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
				// transaction  : 같은 connection객체일경우만 가능 
				// 자동커밋, 수동커밋
			 
				String sql1= " insert into testdb values( 'a1', '000')";
				PreparedStatement pst  = conn.prepareStatement(sql1);
				int result  =pst.executeUpdate();
				
				String sql2= " insert into testdb values( 'a1', '000')";
				PreparedStatement pst2  = conn.prepareStatement(sql2);
				int result2  =pst2.executeUpdate();				
			 
				// 첫번째의 데이터는 정상으로 insert 됨
				// 두 경우가 성공할 경우만 처리되고 아니라면 모두 취소하고 싶다면 
				// 두 개의 쿼리가 하나의 작업단위 트랜잭션으로 묶을 수 있다.
				
				// 트랜잭션 처리를 위한 필요사항
				// 같은 커넥션을 얻어와야 한다
				// 수동커밋으로 되어 있어야 함 
				// 둘 다 정상일때 commit,예외발생했다면  rollback 처리한다
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); 
			}
			 
			
			
		

	}

}
