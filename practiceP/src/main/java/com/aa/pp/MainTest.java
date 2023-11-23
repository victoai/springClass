package com.aa.pp;

import java.util.ArrayList;

public class MainTest {

	public static void main(String[] args) {
		 
		
		
		ArrayList<MyDTO> list = new ArrayList<MyDTO>();
		
		
		list.add( new MyDTO(1 ));
		list.add( new MyDTO(2 ));
		list.add( new MyDTO(3 ));
		
		
		
		MyDTO  b  = list.get(0);
		b.setSu(10);
		
		int aaaa= list.get(0).getSu();		
		System.out.println( aaaa);
		

	}

}
