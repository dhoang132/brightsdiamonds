package com.brightsdiamonds.dao;

import java.util.List;

import javax.sql.DataSource;

import com.brightsdiamonds.domain.SettingImage;
import com.brightsdiamonds.domain.StaticImage;

public interface StaticImageDao {

	public void setDataSource(DataSource ds);
	
	public StaticImage getStaticImage(int id);
}
