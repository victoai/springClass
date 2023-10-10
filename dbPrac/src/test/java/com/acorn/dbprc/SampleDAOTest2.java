package com.acorn.dbprc;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/test.xml" , "file:src/main/webapp/WEB-INF/spring/**/test2.xml"})
public class SampleDAOTest2 {

	@Autowired	
	SampleDAO dao;
	
	@Test
	public void testInsertUser() {
			
		int result  = dao.insertUser("test", "test");
		System.out.println( result);
		assertEquals(1, result);
	}

}
