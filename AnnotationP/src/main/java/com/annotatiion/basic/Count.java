package com.annotatiion.basic;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Count {
    //int value(); // 기본값이 없을 때 value이름 사용한다
    int value() default 1; //   기본값 설정
}