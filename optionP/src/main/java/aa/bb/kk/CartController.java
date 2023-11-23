package aa.bb.kk;

import java.util.List;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

 

@Controller
public class CartController {

 
	@PostMapping("/cartList"  )
	public String receiveCartData(  Model model ) {
		 
		
		CartInfoDTO  o  = new  CartInfoDTO();
		o.setOptions("   ");
	 
		model.addAttribute("cartInfo", o);  
		
	    return " cart_list";
	}
}
