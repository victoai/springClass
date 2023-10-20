package com.test.car;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

 

@Repository
public class TestRepositoryImp   implements   TestRepository {
	 @Autowired
	    private SqlSession session;
	    private static String namespace = "com.test.TestMapper.";
  
	
	@Override
	public void insertTestData(Test testData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTestDate(String test_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Test> getTestList() {		 
	 return session.selectList(namespace+"selectAll");
	}

}
