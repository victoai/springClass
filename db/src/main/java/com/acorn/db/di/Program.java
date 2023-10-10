package com.acorn.db.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Program {
	private Calculator calculator;
	
	@Autowired
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}	
	
	public void printNumers( int su1, int su2) {
		
		int result  =calculator.add(su1, su2)	;
		System.out.println("=======결과=======");
		System.out.println(  result);
	}
	
	
	public int testmethod() {
		return  5;
	}
			
	
}
