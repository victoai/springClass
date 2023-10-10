package com.acorn.day1.di;

import java.util.ArrayList;

import org.springframework.stereotype.Component;


@Component
public class TestDao {

	public ArrayList<String> selectAll(){		
		ArrayList<String> list  = new ArrayList<>();
		list.add("아아");
		list.add("산책");
		list.add("책읽기");			
	    return list;
	}
	
	
}
