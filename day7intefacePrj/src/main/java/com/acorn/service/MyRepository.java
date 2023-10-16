package com.acorn.service;

import org.springframework.stereotype.Repository;

@Repository
public class MyRepository {
	public void insertMember( String id, String name,  String latitude , String longitude ) {
		//마이바티스 
		//jdbc
		System.out.println("회원테이블에 등록");
		System.out.println( id + name + latitude +longitude );
	}
	
}
