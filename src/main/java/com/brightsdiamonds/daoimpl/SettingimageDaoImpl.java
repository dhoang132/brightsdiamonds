package com.brightsdiamonds.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.brightsdiamonds.dao.SettingImageDao;
import com.brightsdiamonds.domain.ProductImage;
import com.brightsdiamonds.domain.SettingImage;

@Repository
public class SettingimageDaoImpl implements SettingImageDao {
	private NamedParameterJdbcTemplate namedParamJdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource ds) {
		namedParamJdbcTemplate = new NamedParameterJdbcTemplate(ds);
	}

	@Override
	public List<SettingImage> getAllSettingImage() {
		String sqlQuery = "SELECT * FROM settingimages;";
		List<SettingImage> imageList = namedParamJdbcTemplate.query(sqlQuery, new SettingImageRowMapper());
		return imageList;
	}

	@Override
	public SettingImage getSettingImage(int id) {
		SqlParameterSource Params = new MapSqlParameterSource("ID", id);
		String sqlQuery = "SELECT * FROM settingimages Where id =" + id + ";";
		SettingImage settingImage = namedParamJdbcTemplate.queryForObject(sqlQuery, Params, new SettingImageRowMapper());
		return settingImage;
	}

}
