package com.acorn.btran;

 

import java.util.HashMap;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 


@Repository
public class MemberDao  {
    @Autowired
    private SqlSession session;
    private static String namespace = "com.acorn.MemberMapper.";

   
   
    public List<Member> selectAll() throws Exception {
        return session.selectList(namespace+"selectAll");
    } // List<E> selectList(String statement)

   
     
    
    public int insert(Member dto) throws Exception {    	 
        return session.insert(namespace+"insert", dto);        
    } // int insert(String statement, Object parameter)

 

}
 