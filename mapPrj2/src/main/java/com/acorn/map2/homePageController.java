package com.acorn.map2;

import org.springframework.stereotype.Controller;


 
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homePageController {

	@RequestMapping("/homePage")
	public String homePage() {

		//return "/homePage/homePage";
		
		 return "homePage2";
	}

}
