package com.brightsdiamonds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brightsdiamonds.dao.EngagementSettingDao;
import com.brightsdiamonds.domain.EngagementSetting;

@Service
public class EngagementSettingService {
	
	@Autowired
	private EngagementSettingDao engagementSettingDao;
	
	public List<EngagementSetting> getSettingList(){
		List<EngagementSetting> settingList = engagementSettingDao.getAllEngagementSettings();
		return settingList;
	}
	
	public EngagementSetting getSetting(int id) {
		EngagementSetting engagementSetting = engagementSettingDao.getEngagementSetting(id);
		return engagementSetting;
	}
	
//	@Autowired
//	private DiamondDao diamondDao;
//	
//	public List<Diamond> getDiamondList(){
//		List<Diamond> diamondList = diamondDao.getAllDiamonds();
//		return diamondList;
//	}
//	
//	public Diamond getDiamond(int id) {
//		Diamond diamond = diamondDao.getDiamond(id);
//		return diamond;
//	}
//	
//	public void updateIsInStock(Diamond diamond, String stockItem, boolean isInStock) {
//		System.out.println(diamondDao.update(diamond, stockItem, isInStock));
//		
//	}
}
