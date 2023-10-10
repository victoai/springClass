package com.acron.di;

public class ProgramTest1 {

	public static void main(String[] args) {	 
		/*
		ACalculator calculator  = new ACalculator();
		Program program = new Program(calculator);
		 */
		//생성자주입
		//주입 Injection 
		//세터주입	
		//ACalculator calculator  = new ACalculator();
		BCalculator calculator  = new BCalculator();
		Program program = new Program( );
		program.setCalculator(calculator);
		 
	    program.addNumber(5, 3);
	    	    
	    /*
	     * 객체 생성, 주입 =>  Spring Ioc Container
	     * 
	     * 지시서 작성 : xml , java config  , 어노테이션	       
	     */
	    
	    
	}

}
