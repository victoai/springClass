package com.acron.di;


public class ACalculator  implements Calculator {

	@Override
	public int add(int su1, int su2) {
		// TODO Auto-generated method stub
		System.out.println( "A calculator");
		return su1+su2;
	}

}
