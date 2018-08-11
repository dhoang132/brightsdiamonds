package com.brightsdiamonds.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.brightsdiamonds.dao.DiamondDao;
import com.brightsdiamonds.domain.Diamond;


@Repository
public class DiamondDaoImpl implements DiamondDao {
	private NamedParameterJdbcTemplate namedParamJdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource ds) {
		namedParamJdbcTemplate = new NamedParameterJdbcTemplate(ds);
	}

	public boolean create(Diamond diamond) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(diamond);
		String sqlQuery = "INSERT INTO Diamond (company_name, year_of_incorporation,"
				+ "employee_count) VALUES(:companyName, :yearOfIncorporated, :employeeCount)";
		
		return namedParamJdbcTemplate.update(sqlQuery, beanParams)==1;
		
//		Object[]args = new Object[] {org.getCompanyName(), org.getYearOfIncorporated(), org.getEmployeeCount()};
//		return jdbcTemplate.update(sqlQuery, args) == 1;
	}
	
	public Diamond getDiamond (int id) {
		SqlParameterSource Params = new MapSqlParameterSource("ID", id);
		String sqlQuery = "SELECT * FROM diamond Where id =" + id;
		Diamond diamond = namedParamJdbcTemplate.queryForObject(sqlQuery, Params, new DiamondRowMapper());
		return diamond;
	}

	public List<Diamond> getAllDiamonds() {
		String sqlQuery = "SELECT * FROM diamond WHERE in_stock = 1";
		List<Diamond> diamondList = namedParamJdbcTemplate.query(sqlQuery, new DiamondRowMapper());
		return diamondList;
	}

	public boolean delete(Diamond diamond) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(diamond);
		String sqlQuery = "DELETE FROM diamond WHERE id = :id";

		return namedParamJdbcTemplate.update(sqlQuery, beanParams)==1;
	}

	public boolean update(Diamond diamond, String stockItem, boolean isInStock) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(diamond);
		int stock;
		if(isInStock ==false) {
			stock = 0;
		} else {
			stock =1;
		}
		//UPDATE diamond SET in_stock = '1' WHERE stock_item = 'D041818001';
		String sqlQuery = "UPDATE diamond SET in_stock = '" + stock +"' WHERE stock_item = '" + stockItem + "';";
		return namedParamJdbcTemplate.update(sqlQuery, beanParams)==1;
	}

	public void cleanup() {
		String sqlQuery = "TRUNCATE TABLE diamond";
		namedParamJdbcTemplate.getJdbcOperations().execute(sqlQuery);
	}
}
