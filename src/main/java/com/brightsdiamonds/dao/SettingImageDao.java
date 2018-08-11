package com.brightsdiamonds.dao;

import java.util.List;

import javax.sql.DataSource;

import com.brightsdiamonds.domain.SettingImage;

public interface SettingImageDao {

	public void setDataSource(DataSource ds);
	
	public List<SettingImage> getAllSettingImage();
	
	public SettingImage getSettingImage(int id);
}
