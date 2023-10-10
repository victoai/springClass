package com.acorn.day2.db;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DramaService {

	@Autowired
	DramaDAO dao;
	
	public ArrayList<Drama> getinfo(){
		ArrayList<Drama> dList = dao.selectAll();
		for (Drama drama : dList) {
			System.out.println(drama);
		}
		return dList;
	}
}
