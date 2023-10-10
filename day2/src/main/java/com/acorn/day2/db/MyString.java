package com.acorn.day2.db;

public class MyString  {
	//변수
	char[] value; 
	
	public MyString() {
		// TODO Auto-generated constructor stub
	}
	MyString(char[] value){
		this.value  = value;
	}
	
	//매서드
	char chatAt(int index ) {
		return value[index];
	}
	
	 void substr(int  sindex ,int eindex ) {
		
	}
	 
	 
	 public static void main(String[] args) {
		 char[] str = {'h','e', 'l', 'l', 'o'};
		 MyString s = new MyString( str);
		 
		 char  result  = s.chatAt(1);
		 System.out.println( result);
		 
		
		
	}
	
	
}
