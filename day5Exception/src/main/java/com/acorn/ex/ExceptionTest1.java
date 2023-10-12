package com.acorn.ex;

public class ExceptionTest1 {

	//매서드
	public int add ( int num1, int num2) throws Exception {		
		if( num1 <0  || num2 <0) {
			 throw new Exception("0보다 커야함 ");
		}
		return num1+num2;		
	}
	 
	
	//실행
	public static void main(String[] args) throws Exception {		
		ExceptionTest1  ex = new ExceptionTest1();
		try {
			int result  =ex.add(-3, 3);
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(" 음수 오류");
			//e.printStackTrace();
			throw e;
		}
		
		
		System.out.println("정상 종료");
		
	}

}
