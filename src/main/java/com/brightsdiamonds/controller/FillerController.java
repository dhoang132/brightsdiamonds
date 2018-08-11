package com.brightsdiamonds.controller;

import java.io.UnsupportedEncodingException;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brightsdiamonds.service.StaticImageService;

@Controller
public class FillerController {

	@Autowired
	private StaticImageService staticImageService;
	
	@RequestMapping("/about")
	public String getAboutPage(Model model) throws UnsupportedEncodingException {
		byte[] encodeBase64 = Base64.encodeBase64(staticImageService.getStaticImage(1).getImageData());
		String base64Encoded = new String (encodeBase64, "UTF-8");
		model.addAttribute("logo", base64Encoded);
		return "about";
	}
	
	@RequestMapping("/education")
	public String getEducationPage(Model model) throws UnsupportedEncodingException {
		byte[] encodeBase64 = Base64.encodeBase64(staticImageService.getStaticImage(1).getImageData());
		String logo = new String (encodeBase64, "UTF-8");
		model.addAttribute("logo", logo);
		encodeBase64 = Base64.encodeBase64(staticImageService.getStaticImage(2).getImageData());
		String labVs = new String (encodeBase64, "UTF-8");
		model.addAttribute("labVs", labVs);
		return "education";
	}
}
