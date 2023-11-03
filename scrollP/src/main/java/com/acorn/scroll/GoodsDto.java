package com.acorn.scroll;

public class GoodsDto {
	
	String code;
	String name;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "GoodsDto [code=" + code + ", name=" + name + "]";
	}
	public GoodsDto(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}
	public GoodsDto() {
		// TODO Auto-generated constructor stub
	}
	
	

}
