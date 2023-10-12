package com.acorn.open.uis;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DataController {

	

		@ResponseBody
		@RequestMapping(value = "/data", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
		public String test2() throws IOException {
			ApiExplorer2 search = new ApiExplorer2();
			String result = "";		 
			result = search.getDatas();			 
			return result;
		}
		 
		

		@ResponseBody
		@RequestMapping(value = "/dataList", method = RequestMethod.GET)
		public ArrayList<DataDto> test3() throws IOException {
			ApiExplorer2 search = new ApiExplorer2();
			ArrayList<DataDto> list  =null;
			String result="";			 
			result = search.getDatas();
			list  =search.getDataList(result);			 
			return list;
		}
		
	 
		
		
		//데이타를 view와 함께 응답
		@RequestMapping(value = "/dataview", method = RequestMethod.GET )
		public String test(HttpServletRequest request) throws IOException {
			ApiExplorer2 search = new ApiExplorer2();
			String result="";			
			result = search.getDatas();
			request.setAttribute("result", search.getDataList(result));			
			return "dataTest";
		}

}
