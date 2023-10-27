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
 


 @Component
public class MemberDao {
    
	 @Autowired
    DataSource ds;
   
    final int FAIL = 0;

    public int deleteUser(String id) {
        int rowCnt = FAIL; //    insert, delete, update
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "delete from user_info where id= ? ";

        try {   
        	conn =  DataSourceUtils.getConnection(ds);   
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rowCnt = pstmt.executeUpdate(); //  
            return rowCnt;      
            
        } catch (SQLException e) {
            e.printStackTrace();
            return FAIL;
        } finally {
             close(pstmt);  
             DataSourceUtils.releaseConnection(conn, ds);
        }
    }

    public Member selectUser(String id) throws Exception {
        Member member = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from member_info where id= ? ";

        try {
            conn = DataSourceUtils.getConnection(ds); 
            pstmt = conn.prepareStatement(sql); 
            pstmt.setString(1, id);

            rs = pstmt.executeQuery(); //  select
            
            System.out.println(  rs);

            if (rs.next()) {
            	member = new Member();
            	member.setId(rs.getString(1));
            	member.setPwd(rs.getString(2));
            	member.setName(rs.getString(3));
            	member.setEmail(rs.getString(4));           
            	member.setBirth(rs.getString(5));
            	member.setSns(rs.getString(6));
            	member.setReg_date(new Date(rs.getTimestamp(7).getTime()));
            }
        } catch (SQLException e) {
        	e.printStackTrace();
            
        } finally {
            close(rs, pstmt );   
            DataSourceUtils.releaseConnection(conn, ds);
        }

        return member;
    }

    //
    
    public int insertUser2(Member member, Connection conn) throws SQLException  {
        int rowCnt = FAIL;       
        PreparedStatement pstmt = null;       

        String sql = "insert into member_info values (?, ?, ?, ?,?,?, sysdate) ";
        try {        
        	System.out.println( conn);
            pstmt = conn.prepareStatement(sql); 
            pstmt.setString(1, member.getId());
            pstmt.setString(2, member.getPwd());
            pstmt.setString(3, member.getName());
            pstmt.setString(4, member.getEmail());
            pstmt.setString(5, member.getBirth());
            pstmt.setString(6, member.getSns());

            return pstmt.executeUpdate();  
        } catch (SQLException e) {         
            e.printStackTrace();
            throw e;    //예외 되던지기 
        } finally {        
        	close(pstmt);        	 
        }
    }

    
  
    public int insertUser(Member member) throws SQLException  {
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

            return pstmt.executeUpdate(); //  insert, delete, update;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {          
        	close(pstmt);
        	DataSourceUtils.releaseConnection(conn, ds);    // 
        }
    }

    
   
    public int updateUser(Member member) throws SQLException {
        int rowCnt = 0; //  insert, delete, update  

 
        String sql = "update member_info " +
                     "set pwd = ?, name=?, email=?, birth =?, sns=?, reg_date=? " +
                     "where id = ? ";
        
        Connection conn =null;
        PreparedStatement pstmt= null;
                 
        try {
         	conn= DataSourceUtils.getConnection(ds);        	 
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(sql);  
     
            pstmt.setString(1, member.getPwd());
            pstmt.setString(2, member.getName());
            pstmt.setString(3, member.getEmail());
            pstmt.setString(4, member.getBirth());
            pstmt.setString(5, member.getSns());
            pstmt.setTimestamp(6, new java.sql.Timestamp(member.getReg_date().getTime()));
            pstmt.setString(7, member.getId());
            rowCnt = pstmt.executeUpdate();          
         
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
         
        }finally {
        	   close( pstmt); 
        	   DataSourceUtils.releaseConnection(conn, ds);
			
		}
        return rowCnt;
    }
    

    public void deleteAll() throws Exception {
        
        Connection conn =  DataSourceUtils.getConnection(ds);
        String sql = "delete from user_info ";
        PreparedStatement pstmt = conn.prepareStatement(sql);  
        pstmt.executeUpdate(); // 
        close(pstmt);
        DataSourceUtils.releaseConnection(conn, ds);        
    }
    

    private void close(AutoCloseable... acs) {
        for(AutoCloseable ac :acs)
            try { if(ac!=null) ac.close(); } catch(Exception e) { e.printStackTrace(); }
    }
    
    
    
}