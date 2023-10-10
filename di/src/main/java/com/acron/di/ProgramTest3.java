package com.acron.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ProgramTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		 /*
	     * 객체 생성, 주입 =>  Spring Ioc Container * 
	     * 지시서 작성 : xml , java config  , 어노테이션	       
	     */		
		ApplicationContext ac = new GenericXmlApplicationContext( "com/acron/di/setting.xml"  );
		Test  program  = ac.getBean(Test.class);		
		program.test( ); 
		
 

	}

}
