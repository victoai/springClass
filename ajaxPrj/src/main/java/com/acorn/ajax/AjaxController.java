package com.acorn.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AjaxController {

	
	
	@RequestMapping( value="/ajax1", method = {   RequestMethod.GET } )
	public void data( String id , String pw) {
		
		System.out.println ( id);
		System.out.println( pw);
	}
	
	
	
	
	@RequestMapping( value="/ajax2", method = {   RequestMethod.GET }  )
	public void data2( User user) {
		
		System.out.println ( user);
		 
	}
	
	
	@RequestMapping( value="/bbb", method =  RequestMethod.POST    )
	public void data3(@RequestBody User user) {
		
		System.out.println ("ajax3" +  user);
		 
	}
	
}
