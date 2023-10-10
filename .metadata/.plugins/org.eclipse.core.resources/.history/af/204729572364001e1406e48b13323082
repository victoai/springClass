package com.acorn.day2.db;

 

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DramaController {

	@Autowired
	DramaService service;
	@Autowired
	DramaDAO dao;

	
	@RequestMapping("/dramaTest3")
	public String drama3(Model model) {
		 
		ArrayList<Drama> a= new ArrayList<>();
		a=dao.selectAll();
		model.addAttribute("dList",a);
		System.out.println(a);
		return "drama";
	}
	
}
