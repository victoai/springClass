package com.acorn.test;

import org.springframework.stereotype.Component;

 
public class GoogleApiTemp  implements GoogleApi {
 
	@Override
	public double[] 위도경도구하기() {	 		
		double[]  result = { 37.4997187   ,127.0348982};
		return result;		
	}
}
