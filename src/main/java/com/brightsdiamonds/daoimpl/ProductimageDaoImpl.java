package com.brightsdiamonds.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.brightsdiamonds.dao.ProductImageDao;
import com.brightsdiamonds.domain.ProductImage;

@Repository
public class ProductimageDaoImpl implements ProductImageDao {
	private NamedParameterJdbcTemplate namedParamJdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource ds) {
		namedParamJdbcTemplate = new NamedParameterJdbcTemplate(ds);
	}

	@Override
	public List<ProductImage> getAllProductImage(String stockId) {
		String sqlQuery = "SELECT * FROM diamondimages WHERE stock_id = '" + stockId + "';" ;
		List<ProductImage> imageList = namedParamJdbcTemplate.query(sqlQuery, new ProductImageRowMapper());
		return imageList;
	}

	@Override
	public ProductImage getProductImage(int id){
		
		SqlParameterSource Params = new MapSqlParameterSource("ID", id);
		String sqlQuery = "SELECT * FROM diamondimages Where id =" + id + ";";
		ProductImage productImage = namedParamJdbcTemplate.queryForObject(sqlQuery, Params, new ProductImageRowMapper());
		return productImage;
	}

}
