package com.brightsdiamonds.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.brightsdiamonds.domain.EngagementSetting;
import com.brightsdiamonds.domain.SettingImage;
import com.brightsdiamonds.domain.SettingRingCust;
import com.brightsdiamonds.service.EngagementSettingService;
import com.brightsdiamonds.service.SettingImageService;
import com.brightsdiamonds.service.StaticImageService;

@Controller
public class EngagementSettingController {
	
	@Autowired
	private EngagementSettingService engagementSettingService;
	@Autowired
	private SettingImageService settingImageService;
	@Autowired
	private StaticImageService staticImageService;

//	@RequestMapping("/home")
//	public ModelAndView home(Model model) {
//		return new ModelAndView("test/formTagsTestViews/formTagsHome", "orgRegistration", new OrganizationRegistration());
//	}
	
	@RequestMapping("/listSettings")
	public String listSetting(Model model) throws UnsupportedEncodingException {
		List<EngagementSetting> settingList = engagementSettingService.getSettingList();
		List<SettingImage> settingImageList = settingImageService.getSettingImages();
		List<String> settingImageLists = new ArrayList<>();
		for(SettingImage settingImage : settingImageList) {
			byte[] encodeBase64 = Base64.encodeBase64(settingImage.getImageData());
			String settingImageEncoded = new String (encodeBase64, "UTF-8");
			settingImageLists.add(settingImageEncoded);
		}
		
		byte[] encodeBase64 = Base64.encodeBase64(staticImageService.getStaticImage(1).getImageData());
		String logoImage = new String (encodeBase64, "UTF-8");
		model.addAttribute("logo", logoImage);
		
		model.addAttribute("settingList", settingList);
		model.addAttribute("settingImageList", settingImageLists);
		return "listSettings";
	}
	
	@RequestMapping(value = "/settingsDetails", method=RequestMethod.GET)
	public String getSettingbyid(@RequestParam("id") int settingId, Model model) throws UnsupportedEncodingException{
		EngagementSetting engagementSetting = engagementSettingService.getSetting(settingId);
		byte[] encodeBase64 = Base64.encodeBase64(settingImageService.getSettingImage(engagementSetting.getId()).getImageData());
		String settingImageEncoded = new String (encodeBase64, "UTF-8");
		
		encodeBase64 = Base64.encodeBase64(settingImageService.getSettingImage(engagementSetting.getId() + 100).getImageData());
		String settingImageEncoded2 = new String (encodeBase64, "UTF-8");
		
		encodeBase64 = Base64.encodeBase64(staticImageService.getStaticImage(1).getImageData());
		String logoImage = new String (encodeBase64, "UTF-8");
		model.addAttribute("logo", logoImage);
		
		model.addAttribute("engagementSetting", engagementSetting);
		model.addAttribute("settingImage", settingImageEncoded);
		model.addAttribute("settingImage2", settingImageEncoded2);
		
		model.addAttribute("settingRingCust", new SettingRingCust());
		return "settingsDetails";
	}
	
//	@RequestMapping("/diamondDetails")
//	public String getDiamondByid(@RequestParam("id") int diamondId, Model model) throws UnsupportedEncodingException {
//		Diamond diamond = diamondService.getDiamond(diamondId);
//		byte[] encodeBase64 = Base64.encodeBase64(productImageService.getProductImage(diamond.getId()).getImageData());
//		String base64Encoded = new String (encodeBase64, "UTF-8");
//		
//		model.addAttribute("diamond", diamond);
//		model.addAttribute("productImage", base64Encoded);
//		return "diamondDetails";
//	}
	
//	@RequestMapping("/listDiamonds")
//	public String listOrganizations (Model model) {
//		List<Diamond> diamond = diamondService.getDiamondList();
//		model.addAttribute("diamondList", diamond);
//		return "listDiamonds";
//	}

}
