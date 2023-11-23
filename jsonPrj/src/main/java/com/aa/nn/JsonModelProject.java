package com.aa.nn;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class JsonModelProject {
	
	
	
	@RequestMapping("/jsonModel")
	public void a( Model model) {
		ItemDto item = new ItemDto();
		item.setId("test");
		item.setPw("0001");
		
		Map<String, String> jsonMap = new HashMap<String, String>();
		jsonMap.put("one", "hello");
		jsonMap.put("two", "world");

		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(jsonMap);
		String json2  = gson.toJson(item);  
		
		
		 model.addAttribute("item1", json);
		 model.addAttribute("item2", json2);
		
		
	}

}