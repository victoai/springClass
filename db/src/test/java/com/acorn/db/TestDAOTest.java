package com.acorn.db;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acorn.db.di.Program;
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/test.xml" , "file:src/main/webapp/WEB-INF/spring/**/test2.xml"} )
public class TestDAOTest {

  
   @Autowired
   TestDAO dao; 
	 
	@Test
	public void testSelect() throws SQLException {
	// 	ApplicationContext  ac = new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/**/test.xml" , "file:src/main/webapp/WEB-INF/spring/**/test2.xml");		
	// 	TestDAO dao  =ac.getBean(TestDAO.class);	 		
		assertTrue (dao.test() != null);	 
	}

}
