package com.acorn.prac;

import static org.junit.Assert.fail;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/test.xml" , "file:src/main/webapp/WEB-INF/spring/**/test2.xml"} )
@Log4j
public class MemberRepositoryTest {

	
	@Autowired
	MemberRepository dao;
	
	
	@Test
	public void test() {
		//fail("Not yet implemented");
		log.info(  dao.selectAll().size());
		
	}

	

	@Test
	public void test2() {
		//fail("Not yet implemented");
		//log.info(  dao.select("test01").getName().equals("장주원"));
		 log.info(  dao.select("test01") );
	}
}
