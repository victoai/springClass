package com.acorn.dbprc;

public class 가변인자 {
	
	public void method1( String... args) {		
		for( String s : args) {
			System.out.println( s);
		}
	}
	

	public static void main(String[] args) {
		가변인자 a = new 가변인자();
		a.method1();
		a.method1("one");
		a.method1("one", "two");
		
	}

}
