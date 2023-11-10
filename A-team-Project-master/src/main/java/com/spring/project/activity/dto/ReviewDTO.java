package com.spring.project.activity.dto;

import java.sql.Date;

public class ReviewDTO {
	private int re_no; // 리뷰번호
	private int re_score; // 평점
	private String re_content; // 리뷰내용
	private Date re_writeDate; // 리뷰작성일
	private String re_img;	//리뷰이미지
	private String id; //리뷰 작성자
    private int lod_no; // 숙소번호
    private int ac_no; // 액티비티 정보
    private int fd_no; // 음식 정보
    private int tr_no;	// 관광정보
  
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
	public int getLod_no() {
		return lod_no;
	}
	public void setLod_no(int lod_no) {
		this.lod_no = lod_no;
	}

	public int getTr_no() {
		return tr_no;
	}
	public void setTr_no(int tr_no) {
		this.tr_no = tr_no;
	}
	public int getAc_no() {
		return ac_no;
	}
	public void setAc_no(int ac_no) {
		this.ac_no = ac_no;
	}
	public int getFd_no() {
		return fd_no;
	}
	public void setFd_no(int fd_no) {
		this.fd_no = fd_no;
	}
}