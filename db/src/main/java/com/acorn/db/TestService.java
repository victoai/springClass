package com.acorn.db;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestService {
	
	@Autowired
	TestDAO dao;		 

	public  ArrayList<String> test() {
		return dao.test();
	}
	
}
