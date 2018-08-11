package com.brightsdiamonds.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.brightsdiamonds.dao.EngagementSettingDao;
import com.brightsdiamonds.domain.EngagementSetting;

@Repository
public class EngagementSettingDaoImpl implements EngagementSettingDao {

	private NamedParameterJdbcTemplate namedParamJdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource ds) {
		namedParamJdbcTemplate = new NamedParameterJdbcTemplate(ds);
	}

	@Override
	public List<EngagementSetting> getAllEngagementSettings() {
		
		String sqlQuery = "SELECT * FROM setting";
		List<EngagementSetting> settingList = namedParamJdbcTemplate.query(sqlQuery, new EngagementSettingRowMapper());
		return settingList;
		
//		String sqlQuery = "SELECT * FROM diamond WHERE in_stock = 1";
//		List<Diamond> diamondList = namedParamJdbcTemplate.query(sqlQuery, new DiamondRowMapper());
//		return diamondList;
	}

	@Override
	public EngagementSetting getEngagementSetting(int id) {
		
		SqlParameterSource Params = new MapSqlParameterSource("ID", id);
		String sqlQuery = "SELECT * FROM setting Where id =" + id + ";";
		EngagementSetting engagementSetting = namedParamJdbcTemplate.queryForObject(sqlQuery, Params, new EngagementSettingRowMapper());
		return engagementSetting;
	}

}
