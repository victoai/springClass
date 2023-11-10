package com.spring.project.event.dto;

import java.sql.Date;

public class ReviewDTO {
	private int re_no;
	private int re_score;
	private String re_content;
	private Date re_writeDate;
	private String re_img;	
	private String id;
    private int lod_id;
    private int act_no;
    private int tr_no;
  
	public int getRe_no() {
		return re_no;
	}
	public void setRe_no(int re_no) {
		this.re_no = re_no;
	}
	public Date getRe_writeDate() {
		return re_writeDate;
	}
	public void setRe_writeDate(Date re_writeDate) {
		this.re_writeDate = re_writeDate;
	}
	public int getRe_score() {
		return re_score;
	}
	public void setRe_score(int re_score) {
		this.re_score = re_score;
	}
	public String getRe_content() {
		return re_content;
	}
	public void setRe_content(String re_content) {
		this.re_content = re_content;
	}
	public String getRe_img() {
		return re_img;
	}
	public void setRe_img(String re_img) {
		this.re_img = re_img;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getLod_id() {
		return lod_id;
	}
	public void setLod_id(int lod_id) {
		this.lod_id = lod_id;
	}
	public int getAct_no() {
		return act_no;
	}
	public void setAct_no(int act_no) {
		this.act_no = act_no;
	}
	public int getTr_no() {
		return tr_no;
	}
	public void setTr_no(int tr_no) {
		this.tr_no = tr_no;
	}

    
}
