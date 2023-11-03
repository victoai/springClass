package com.acorn.day4.upload;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class SimpleUpload2 {

	String fileDir ="c:\\test\\upload\\"  ; // 물리적인 폴더를 만들어야 함 
	
	 
	
	
	
	 
	@PostMapping("/ftest")
	public String upload(   MultipartFile file   ) throws IllegalStateException, IOException {
		
		System.out.println( "ftest");
		if( !file.isEmpty()) {
			String fileRealName  = file.getOriginalFilename();
			String fullPath = fileDir + fileRealName ; // c:\\test\\upload\\고양이.jpg
			file.transferTo(new File(fullPath));
			 
		}		
		
		return  "upload-ok";
	}
	
	
 
	
}
