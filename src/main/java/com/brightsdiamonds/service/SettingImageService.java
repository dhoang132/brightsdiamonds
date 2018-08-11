package com.brightsdiamonds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brightsdiamonds.dao.SettingImageDao;
import com.brightsdiamonds.domain.SettingImage;

@Service
public class SettingImageService {
	
	@Autowired
	private SettingImageDao settingImageDao;
	
	public List<SettingImage> getSettingImages(){
		List<SettingImage> settingImageList = settingImageDao.getAllSettingImage();
		return settingImageList;
	}
	
	public SettingImage getSettingImage(int id) {
		SettingImage productImage=settingImageDao.getSettingImage(id);
		return productImage;
	}

}
