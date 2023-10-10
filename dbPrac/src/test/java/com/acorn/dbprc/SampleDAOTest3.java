package com.acorn.dbprc;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/test.xml" , "file:src/main/webapp/WEB-INF/spring/**/test2.xml"})
public class SampleDAOTest3 {

	@Autowired
	SampleDAO  dao;
	
	@Test
	public void test() {		
		int result  = dao.insertUser("test1", "test1");	
		System.out.println( result);
		assertEquals(1, result);		
		
	}

}
