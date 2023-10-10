package com.acorn.day2.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DramaDAO {
	
	@Autowired
	DataSource ds;

	public ArrayList<Drama> selectAll() {
		String sql = "select * from drama_tbl";
		ArrayList<Drama>  list = new ArrayList<Drama>();
		Drama drama = new Drama();
		
		try {
			Connection con = ds.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				
				list.add( new Drama(rs.getString(1) ,rs.getString(2),rs.getString(3)));
				
			}
			rs.close();
			pst.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		 
	}
}
