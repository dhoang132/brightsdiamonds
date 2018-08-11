package com.brightsdiamonds.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.brightsdiamonds.domain.SettingImage;

public class SettingImageRowMapper implements RowMapper<SettingImage> {
	public SettingImage mapRow(ResultSet rs, int rownum) throws SQLException {
		SettingImage settingImage = new SettingImage();
		settingImage.setId(rs.getInt("id"));
		settingImage.setFileName(rs.getString("image_name"));
		settingImage.setStockId(rs.getString("stock_id"));
		settingImage.setImageData(rs.getBytes("image_data"));
		return settingImage;
	}
}
