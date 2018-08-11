package com.brightsdiamonds.daoimpl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.brightsdiamonds.dao.StaticImageDao;
import com.brightsdiamonds.domain.SettingImage;
import com.brightsdiamonds.domain.StaticImage;

@Repository
public class StaticImageDaoImpl implements StaticImageDao {
	private NamedParameterJdbcTemplate namedParamJdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource ds) {
		namedParamJdbcTemplate = new NamedParameterJdbcTemplate(ds);
	}

	@Override
	public StaticImage getStaticImage(int id) {
		SqlParameterSource Params = new MapSqlParameterSource("ID", id);
		String sqlQuery = "SELECT * FROM staticimages Where id =" + id + ";";
		StaticImage staticImage = namedParamJdbcTemplate.queryForObject(sqlQuery, Params, new StaticImageRowMapper());
		return staticImage;
	}

}
