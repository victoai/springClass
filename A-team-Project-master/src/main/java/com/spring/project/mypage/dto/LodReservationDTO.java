package com.spring.project.mypage.dto;

public class LodReservationDTO {
	private int lod_id;
	private String id;
	private String res_name;
	private String res_tel;
	private String lod_title;
	private String r_title;
	private String lod_checkIn;
	private String lod_checkOut;
	private String res_from;
	private String res_to;
	private String payment;
	private int price;
	
	public int getLod_id() {
		return lod_id;
	}
	public void setLod_id(int lod_id) {
		this.lod_id = lod_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRes_name() {
		return res_name;
	}
	public void setRes_name(String res_name) {
		this.res_name = res_name;
	}
	public String getRes_tel() {
		return res_tel;
	}
	public void setRes_tel(String res_tel) {
		this.res_tel = res_tel;
	}
	public String getLod_title() {
		return lod_title;
	}
	public void setLod_title(String lod_title) {
		this.lod_title = lod_title;
	}
	public String getR_title() {
		return r_title;
	}
	public void setR_title(String r_title) {
		this.r_title = r_title;
	}
	public String getLod_checkIn() {
		return lod_checkIn;
	}
	public void setLod_checkIn(String lod_checkIn) {
		this.lod_checkIn = lod_checkIn;
	}
	public String getLod_checkOut() {
		return lod_checkOut;
	}
	public void setLod_checkOut(String lod_checkOut) {
		this.lod_checkOut = lod_checkOut;
	}

	public String getRes_from() {
		return res_from;
	}
	public void setRes_from(String res_from) {
		this.res_from = res_from;
	}
	public String getRes_to() {
		return res_to;
	}
	public void setRes_to(String res_to) {
		this.res_to = res_to;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
