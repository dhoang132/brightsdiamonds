package com.brightsdiamonds.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.brightsdiamonds.domain.Cart;
import com.brightsdiamonds.domain.CartItem;
import com.brightsdiamonds.domain.Diamond;
import com.brightsdiamonds.domain.EngagementSetting;
import com.brightsdiamonds.domain.Product;
import com.brightsdiamonds.domain.SettingRingCust;
import com.brightsdiamonds.service.DiamondService;
import com.brightsdiamonds.service.EngagementSettingService;
import com.brightsdiamonds.service.StaticImageService;

@Controller
public class CartItemController {
	
	@Autowired
	private DiamondService diamondService;
	@Autowired
	private EngagementSettingService engagementSettingService;
	@Autowired
	private StaticImageService staticImageService;
	
	@RequestMapping("/addCart")
	public String addToCart(@RequestParam("id") int diamondId, HttpSession session, Model model) throws UnsupportedEncodingException {
		Diamond diamond = diamondService.getDiamond(diamondId);
		CartItem cartItem = new CartItem(diamond);
		Cart cart = (Cart)session.getAttribute("cartItems");
		
		if(cart==null) {
			cart = new Cart();
			session.setAttribute("cartItems", cart);
		}
		
		byte[] encodeBase64 = Base64.encodeBase64(staticImageService.getStaticImage(1).getImageData());
		String base64Encoded = new String (encodeBase64, "UTF-8");
		model.addAttribute("logo", base64Encoded);
		cart.addCartItem(cartItem);
		return "cartList";
		
	}
//	@RequestMapping(value="/registerOrg", method=RequestMethod.POST)
//	public String organizationRegistration(@ModelAttribute OrganizationRegistration orgRegistration, Model model) {
//		model.addAttribute("orgreg", orgRegistration);
//		return "test/formTagsTestViews/formTagsResult";
//	}
	
	@RequestMapping(value = "/addSettingCart", method=RequestMethod.POST)
	public String addSettingCart(@RequestParam("id") int settingId, @ModelAttribute(value="settingRingCust") SettingRingCust settingRingCust, HttpSession session, Model model) throws UnsupportedEncodingException {
		EngagementSetting engagementSetting = engagementSettingService.getSetting(settingId);
		
		engagementSetting.setName(engagementSetting.getName() + "; setting Size:" +settingRingCust.getSize());
		
		CartItem cartItem = new CartItem(engagementSetting);
		Cart cart = (Cart)session.getAttribute("cartItems");
		
		if(cart==null) {
			cart = new Cart();
			session.setAttribute("cartItems", cart);
		}
		
		byte[] encodeBase64 = Base64.encodeBase64(staticImageService.getStaticImage(1).getImageData());
		String base64Encoded = new String (encodeBase64, "UTF-8");
		model.addAttribute("logo", base64Encoded);
		
		cart.addCartItem(cartItem);
		return "cartList";
		
	}
	
	@RequestMapping("/viewCart")
	public String viewCart(HttpSession session, Model model) throws UnsupportedEncodingException {
		Cart cart = (Cart)session.getAttribute("cartItems");
		
		if(cart==null) {
			cart = new Cart();
			session.setAttribute("cartItems", cart);
		}		
//		for (String key: cart.getCartItems().keySet()) {
//		    System.out.println("key : " + key);
//		    System.out.println("value : " + cart.getCartItems().get(key).getProduct().getName());
//		}
		
		byte[] encodeBase64 = Base64.encodeBase64(staticImageService.getStaticImage(1).getImageData());
		String base64Encoded = new String (encodeBase64, "UTF-8");
		model.addAttribute("logo", base64Encoded);
		return "cartList";
		
	}
	
	@RequestMapping("/clearCart")
	public String clearCart(HttpSession session, Model model) throws UnsupportedEncodingException {
		session.removeAttribute("cartItems");		
//		for (String key: cart.getCartItems().keySet()) {
//		    System.out.println("key : " + key);
//		    System.out.println("value : " + cart.getCartItems().get(key).getProduct().getName());
//		}
		
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

	@RequestMapping("/itemNotAval")
	public String itemNotAval(Model model) throws UnsupportedEncodingException {
		
		byte[] encodeBase64 = Base64.encodeBase64(staticImageService.getStaticImage(1).getImageData());
		String base64Encoded = new String (encodeBase64, "UTF-8");
		model.addAttribute("logo", base64Encoded);
		return "itemNotAval";
		
	}
	

}

//ShoppingCart cart = (ShoppingCart)session.getAttribute("cart");

//@Controller
//@SessionAttributes("ShoppingCart")
//@RequestMapping("/req")
//public class MYController {
//
//    @ModelAttribute("ShoppingCart")
//    public Visitor getShopCart (....) {
//        return new ShoppingCart(....); //get From DB Or Session
//    }  
//  }