package com.brightsdiamonds.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.brightsdiamonds.domain.Diamond;
import com.brightsdiamonds.domain.ProductImage;
import com.brightsdiamonds.domain.SettingImage;
import com.brightsdiamonds.service.DiamondService;
import com.brightsdiamonds.service.ProductImageService;
import com.brightsdiamonds.service.StaticImageService;


@Controller
public class DiamondController {

	@Autowired
	private DiamondService diamondService;
	@Autowired
	private ProductImageService productImageService;
	@Autowired
	private StaticImageService staticImageService;
	
	@RequestMapping("/listDiamonds")
	public String listOrganizations (Model model) throws UnsupportedEncodingException {
		List<Diamond> diamond = diamondService.getDiamondList();
		byte[] encodeBase64 = Base64.encodeBase64(staticImageService.getStaticImage(1).getImageData());
		String base64Encoded = new String (encodeBase64, "UTF-8");
		model.addAttribute("logo", base64Encoded);
		
		model.addAttribute("diamondList", diamond);
		
		return "listDiamonds";
	}
	
	@RequestMapping("/diamondDetails")
	public String getDiamondByid(@RequestParam("id") int diamondId, Model model) throws UnsupportedEncodingException {
		Diamond diamond = diamondService.getDiamond(diamondId);
		byte[] encodeBase64 = Base64.encodeBase64(productImageService.getProductImage(diamond.getId()).getImageData());
		String base64Encoded = new String (encodeBase64, "UTF-8");
		model.addAttribute("productImage", base64Encoded);
		
		encodeBase64 = Base64.encodeBase64(productImageService.getProductImage(diamond.getId()+100).getImageData());
		base64Encoded = new String (encodeBase64, "UTF-8");
		model.addAttribute("productImage2", base64Encoded);
		
		encodeBase64 = Base64.encodeBase64(staticImageService.getStaticImage(1).getImageData());
		base64Encoded = new String (encodeBase64, "UTF-8");
		model.addAttribute("logo", base64Encoded);
		
		model.addAttribute("diamond", diamond);
		
		encodeBase64 = Base64.encodeBase64(staticImageService.getStaticImage(1).getImageData());
		base64Encoded = new String (encodeBase64, "UTF-8");
		model.addAttribute("logo", base64Encoded);
		
		return "diamondDetails";
	}
	
	@RequestMapping("/diamondImage")
	public String getImagesByStockItem(@RequestParam("stockItem") int id, Model model) throws UnsupportedEncodingException {
		byte[] encodeBase64 = Base64.encodeBase64(productImageService.getProductImage(id).getImageData());
		String base64Encoded = new String (encodeBase64, "UTF-8");
		model.addAttribute("productImage", base64Encoded);
		
		encodeBase64 = Base64.encodeBase64(staticImageService.getStaticImage(1).getImageData());
		base64Encoded = new String (encodeBase64, "UTF-8");
		model.addAttribute("logo", base64Encoded);
		
		return "diamondImage";
	}
}
//byte[] encodeBase64 = Base64.encode(usersService.getAllFoto());
//String base64Encoded = new String(encodeBase64, "UTF-8");

//@RequestMapping("/product")
//public String getProductById(@RequestParam("id") String productId, Model model){
//	Product p = productService.getProductById(productId);
//	model.addAttribute("product", p);
//	return "product";
//}