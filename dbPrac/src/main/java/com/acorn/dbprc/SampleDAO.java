package com.acorn.dbprc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SampleDAO {

	@Autowired
	DataSource  ds;	
	//회원등록
	public int  insertUser(  String id, String pw) {	
		
		int resultRow=0;
		Connection con=null;
		PreparedStatement  pst= null;
		
		
		try {
			String sql="insert into sampletbl values( ?,?)" ;
			con  = ds.getConnection();
			pst  = con.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, pw);
			resultRow =pst.executeUpdate();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		 /*	if( pst != null)
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if( con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			*/
		   close( pst, con);
		}		
		return  resultRow;
	}	
	
	
	
	private void  close(AutoCloseable ... acs) {		
		for( AutoCloseable ac: acs) {
			if( ac !=null)
				try {
					ac.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
	
	
}
