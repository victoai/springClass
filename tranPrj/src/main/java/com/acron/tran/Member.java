package com.acron.tran;


 

import lombok.Data;


/*
 * 
 * create table testdb( id varchar2(10) primary key, pwd varchar2(10));
 * 
 */

@Data
public class Member {
    private String id;
    private String pwd; 
}