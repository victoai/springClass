package com.acorn.com;

import java.sql.Connection;
import java.sql.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/* 
 * 	<bean   id="d" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<property name="driverClassName" value="oracle.jdbc.driver.OracleDriver"></property>
		<property name="url" value="jdbc:oracle:thin:@localhost:1521:testdb"></property>
		<property name="username" value="scott"></property>
		<property name="password" value="tiger"></property>
	</bean>
		
 */
@Component
public class TestDAO {	
	
	@Autowired
	DataSource ds;	
	
	public void select() {		
		String sql="select * from atbl";
		try {
			Connection con = ds.getConnection();
			PreparedStatement  pst =con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(1));				 
			} 			
			//
			rs.close();
			pst.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
}
