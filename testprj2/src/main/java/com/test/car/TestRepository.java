package com.test.car;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface TestRepository {    
     void insertTestData(Test testData);
     void updateTestDate(String test_id);
     List<Test> getTestList();
}


