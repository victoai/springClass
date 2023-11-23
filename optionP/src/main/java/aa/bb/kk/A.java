package aa.bb.kk;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class A {

	
	
	@RequestMapping("/ctest")
	public void cart( Model model) {		 		 
		 String values ="코드 1000 / 가격 2000/ 상품명  감자 아랑랑랑ㄹㅇ  , 코드 1000 / 가격 2000/ 상품명  감자 아랑랑랑ㄹㅇ , 코드 1000 / 가격 2000/ 상품명  감자 아랑랑랑ㄹㅇ ";	 
	 	 
		 OrderDTO2  o =new OrderDTO2();
		 o.setOptions(values);		 
		 System.out.println(o ); 		 
		 model.addAttribute("cart", o);
		 
		 
		
		
	}
}
