package com.acorn.ex;

import java.sql.SQLException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalCatcher {
	
	@ExceptionHandler(SQLException.class)
	public String catcher( SQLException ex  , Model model) {
		model.addAttribute("ex", ex);
		return "err2";
		
	}

}
