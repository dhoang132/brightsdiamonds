package com.brightsdiamonds.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.brightsdiamonds.domain.SettingImage;
import com.brightsdiamonds.domain.StaticImage;

public class StaticImageRowMapper implements RowMapper<StaticImage> {
	public StaticImage mapRow(ResultSet rs, int rownum) throws SQLException {
		StaticImage staticImage = new StaticImage();
		staticImage.setId(rs.getInt("id"));
		staticImage.setFileName(rs.getString("name"));
		staticImage.setImageData(rs.getBytes("image_data"));
		return staticImage;
	}
}
