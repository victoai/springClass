package com.acorn.scroll;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class AController {

	
	
	@ResponseBody
	@RequestMapping("/a")
	public ArrayList<GoodsDto>  getList(  Integer page){
		
		
		ArrayList<GoodsDto>  list = new ArrayList<GoodsDto>();
		
		list.add( new GoodsDto("t01","맥주"));
		list.add( new GoodsDto("t01","맥주"));
		list.add( new GoodsDto("t01","맥주"));
		list.add( new GoodsDto("t01","맥주"));
		list.add( new GoodsDto("t01","맥주"));
		list.add( new GoodsDto("t01","맥주"));
		list.add( new GoodsDto("t01","맥주"));
		list.add( new GoodsDto("t01","맥주"));
		list.add( new GoodsDto("t01","맥주"));
		list.add( new GoodsDto("t01","맥주"));
		list.add( new GoodsDto("t01","맥주"));
		list.add( new GoodsDto("t01","맥주"));
		list.add( new GoodsDto("t01","맥주"));
		list.add( new GoodsDto("t01","맥주"));
		list.add( new GoodsDto("t01","맥주"));
		list.add( new GoodsDto("t01","맥주"));
		list.add( new GoodsDto("t01","맥주"));
		list.add( new GoodsDto("t01","맥주"));
		list.add( new GoodsDto("t01","맥주"));
		list.add( new GoodsDto("t01","맥주"));
		list.add( new GoodsDto("t01","맥주"));
		list.add( new GoodsDto("t01","맥주"));
		
		
		
		return list;
		
		
		
	}
	
	
}
