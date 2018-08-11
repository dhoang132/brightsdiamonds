package com.brightsdiamonds.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.brightsdiamonds.dao.PaypalResultsDao;
import com.brightsdiamonds.domain.PaypalResults;

@Repository
public class PaypalResultsDaoImpl implements PaypalResultsDao {
	private NamedParameterJdbcTemplate namedParamJdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource ds) {
		namedParamJdbcTemplate = new NamedParameterJdbcTemplate(ds);
	}
	
//	INSERT INTO payment (payment_info, email) VALUES("hello", "dhoang");
	@Override
	public boolean create(PaypalResults paypalResults) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(paypalResults);
		String sqlQuery = "INSERT INTO payment (payment_info, email, shipping_address, date, cart_id, cart_products, cart_total)"
				+ " VALUES('" + paypalResults.getPaymentInfo() + "', '" + paypalResults.getEmail() + "', '" 
				+ paypalResults.getUserShippingAddress() + "', '" + paypalResults.getDate() 
				+ "', '" + paypalResults.getCartId() + "', '" + paypalResults.getCartProducts() 
				+ "', '" + paypalResults.getCartTotal() + "');";		
		return namedParamJdbcTemplate.update(sqlQuery, beanParams)==1;
	}

	@Override
	public PaypalResults getPaypalResults(String cartId) {
		SqlParameterSource Params = new MapSqlParameterSource("cart_id", cartId);
		String sqlQuery = "SELECT * FROM payment Where cart_id ='" + cartId + "';";
		PaypalResults paypalResults= namedParamJdbcTemplate.queryForObject(sqlQuery, Params, new PaypalResultsRowMapper());
		return paypalResults;
	}
	
	public List<PaypalResults> getAllUserPaymentResults(String email){
		String sqlQuery = "SELECT * FROM payment WHERE email = '" + email + "';";
		List<PaypalResults> userPaymentList = namedParamJdbcTemplate.query(sqlQuery, new PaypalResultsRowMapper());
		return userPaymentList;
		
//		String sqlQuery = "SELECT * FROM diamond WHERE in_stock = 1";
//		List<Diamond> diamondList = namedParamJdbcTemplate.query(sqlQuery, new DiamondRowMapper());
//		return diamondList;
	}

}
