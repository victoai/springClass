package com.annotatiion.basic;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Main {

	
	// 괄호 안에  필드명 = 값 , 값이 한 개인경우  value 이름 사용
    @Count(value = 3)
    private int apples; 

    //    default가 있을 시 생략 가능
    @Count
    private int bananas;

    //    필드가 하나고 필드명이 value일 시  ,  값만 넣을 수 있음
    @Count(5)
    private int cacaos;
    
	//    값이 여럿일 시. 순서 무관
    @PersonName(last = "홍", first = "길동")
    private Object seller;
    
	//   배열 타입의 필드일 시
    @LocsAvail(
            quick = {"서울", "대전", "강원"}, // {} 안에 작성
            visit = "판교", // 하나만 있을 시 {} 생략 가능
            delivery = {} // 요소가 없을 시 {} 필요
    )
    private Object store;
    
    
    public static void main(String[] args) {
	    List<Object> annotVals = new ArrayList<>();
        
        for (Field f : Main.class.getDeclaredFields()) {
            for (Annotation a : f.getAnnotations()) {
                if (a instanceof Count) {
                    annotVals.add(((Count) a).value());
                }
                if (a instanceof PersonName) {
                    annotVals.add(((PersonName) a).first());
                    annotVals.add(((PersonName) a).last());
                }							 
                if (a instanceof LocsAvail) {
                    annotVals.add(((LocsAvail) a).visit());
                    annotVals.add(((LocsAvail) a).delivery());
                    annotVals.add(((LocsAvail) a).quick());
                }
            }
        }
        
        
        
        annotVals.forEach( item -> System.out.println( item));
        
	}
    
    
}
