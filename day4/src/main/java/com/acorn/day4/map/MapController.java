package com.acorn.day4.map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController {

	
	@GetMapping("/map1")
	public String map1() {
		return  "mapApi";
	}
	
	@GetMapping("/map2")
	public String map2() {
		return  "mapApi2";
	}
	
}
