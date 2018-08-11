package com.brightsdiamonds.dao;

import java.util.List;

import javax.sql.DataSource;

import com.brightsdiamonds.domain.EngagementSetting;

public interface EngagementSettingDao {

	public void setDataSource(DataSource ds);
	
	public List<EngagementSetting> getAllEngagementSettings();
	
	public EngagementSetting getEngagementSetting(int id);
	
}
