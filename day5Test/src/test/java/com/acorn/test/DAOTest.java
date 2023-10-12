package com.acorn.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/test.xml" , "file:src/main/webapp/WEB-INF/spring/**/test2.xml"} )
public class DAOTest {

	@Autowired
	DataSource ds;
	
	@Autowired
	MemberDAO dao;
	 
	public void test() throws SQLException {
		   assertTrue( ds.getConnection()!= null);
	}
	
	
	@Test
	public void test2() {		
		int result  =dao.insert(new Member("test15","10","10","10"));
		assertTrue(result==1);
	}
	

}
