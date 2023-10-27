package com.acorn.dbtran;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Component;
 


 
public class MemberDao2 {
 
    DataSource ds;
   
    final int FAIL = 0;
 
    public int insertUser(Member member) throws SQLException  {
    	
    	System.out.println("dfdfd");
        int rowCnt = FAIL;
        Connection conn = null;
        PreparedStatement pstmt = null;
        

        String sql = "insert into member_info values (?, ?, ?, ?,?,?, sysdate) ";

        try {        
        	conn= DataSourceUtils.getConnection(ds);        	 
            conn.setAutoCommit(false);        	
        	System.out.println( conn);
            pstmt = conn.prepareStatement(sql); 
            pstmt.setString(1, member.getId());
            pstmt.setString(2, member.getPwd());
            pstmt.setString(3, member.getName());
            pstmt.setString(4, member.getEmail());
            pstmt.setString(5, member.getBirth());
            pstmt.setString(6, member.getSns());

            rowCnt  = pstmt.executeUpdate(); //  insert, delete, update;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {          
        	close(pstmt);
        	DataSourceUtils.releaseConnection(conn, ds);    // 
        }        
        
        return rowCnt;
    }

    
    
    

    private void close(AutoCloseable... acs) {
        for(AutoCloseable ac :acs)
            try { if(ac!=null) ac.close(); } catch(Exception e) { e.printStackTrace(); }
    }
    
    
    
}