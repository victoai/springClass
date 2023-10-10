package com.acorn.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component; 


@Component
public class TestDAO {	
	@Autowired
	DataSource ds;
		
	public void select() {	
		String sql ="select * from member_tbl_11"; 
		try {
			Connection con  =ds.getConnection();
			PreparedStatement  pst  = con.prepareStatement(sql);
			
			ResultSet rs  = pst.executeQuery();
			while( rs.next()) {
				System.out.print( rs.getString(1));
				System.out.print( rs.getString(2));
				System.out.print( rs.getString(3));
				System.out.println( rs.getString(4));
			}
			rs.close();
			pst.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	

	//테스트를 위한 매서드 작성
	public ArrayList<String> test() {	
		
		ArrayList<String> testList = new ArrayList<>();
		testList.add("테스트항목1");
		testList.add("테스트항목2");	
		
		// return null;   //  테스트시 실패
		return testList;  // 테스트시 성공
	}
	
}
