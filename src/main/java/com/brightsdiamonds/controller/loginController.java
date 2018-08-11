package com.brightsdiamonds.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brightsdiamonds.domain.Cart;
import com.brightsdiamonds.domain.PaypalResults;
import com.brightsdiamonds.domain.User;
import com.brightsdiamonds.service.PaypalResultsService;
import com.brightsdiamonds.service.StaticImageService;

@Controller
public class loginController {
	
	@Autowired
	private PaypalResultsService paypalResultsService;
	@Autowired
	private StaticImageService staticImageService;
	
//	@Autowired
//	private DiamondService diamondService;

	@RequestMapping("/userDetails")
	public String homePage(HttpSession session, Model model) throws UnsupportedEncodingException {
		User user = (User)session.getAttribute("user");
		if(user == null) {
			return "home";
		}
		
		List<PaypalResults> userPaymentList = paypalResultsService.getUserPayments(user.getEmail());
		model.addAttribute("paymentList", userPaymentList);
		
		byte[] encodeBase64 = Base64.encodeBase64(staticImageService.getStaticImage(1).getImageData());
		String base64Encoded = new String (encodeBase64, "UTF-8");
		model.addAttribute("logo", base64Encoded);
		
		return "userDetails";
	}
	
//	List<Diamond> diamond = diamondService.getDiamondList();
//	model.addAttribute("diamondList", diamond);
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session, Model model) throws UnsupportedEncodingException {
		session.removeAttribute("user");
		session.removeAttribute("cartItems");
		byte[] encodeBase64 = Base64.encodeBase64(staticImageService.getStaticImage(1).getImageData());
		String base64Encoded = new String (encodeBase64, "UTF-8");
		model.addAttribute("logo", base64Encoded);
		
		encodeBase64 = Base64.encodeBase64(staticImageService.getStaticImage(3).getImageData());
		String homeImage = new String (encodeBase64, "UTF-8");
		model.addAttribute("homeImage", homeImage);
		
		encodeBase64 = Base64.encodeBase64(staticImageService.getStaticImage(4).getImageData());
		String homeImage2 = new String (encodeBase64, "UTF-8");
		model.addAttribute("homeImage2", homeImage2);
		
		return "home";
	}
	
	@RequestMapping("/")
	public String homeLink(Model model) throws UnsupportedEncodingException{
		byte[] encodeBase64 = Base64.encodeBase64(staticImageService.getStaticImage(1).getImageData());
		String logoImage = new String (encodeBase64, "UTF-8");
		model.addAttribute("logo", logoImage);
		
		encodeBase64 = Base64.encodeBase64(staticImageService.getStaticImage(3).getImageData());
		String homeImage = new String (encodeBase64, "UTF-8");
		model.addAttribute("homeImage", homeImage);
		
		encodeBase64 = Base64.encodeBase64(staticImageService.getStaticImage(4).getImageData());
		String homeImage2 = new String (encodeBase64, "UTF-8");
		model.addAttribute("homeImage2", homeImage2);
		
		return "home";
	}
	
//	 @RequestMapping("/")
//	  public String homepage2(ModelMap model, HttpServletRequest request, HttpServletResponse response){
//	    System.out.println("blablabla2");
//	    model.addAttribute("sigh", "lesigh");
//	    return "index";
//	  }
	 
}
