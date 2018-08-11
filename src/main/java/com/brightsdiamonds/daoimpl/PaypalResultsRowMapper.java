package com.brightsdiamonds.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.brightsdiamonds.domain.PaypalResults;

public class PaypalResultsRowMapper implements RowMapper<PaypalResults> {

	public PaypalResults mapRow(ResultSet rs, int rownum) throws SQLException {
		PaypalResults paypalResults = new PaypalResults();
		paypalResults.setId(rs.getInt("id"));
		paypalResults.setPaymentInfo(rs.getString("payment_info"));
		paypalResults.setEmail(rs.getString("email"));
		paypalResults.setUserShippingAddress(rs.getString("shipping_address"));
		paypalResults.setDate(rs.getString("date"));
		paypalResults.setCartId(rs.getString("cart_id"));
		paypalResults.setCartProducts(rs.getString("cart_products"));
		paypalResults.setCartTotal(rs.getDouble("cart_total"));
		paypalResults.setShippingStatus(rs.getString("status"));
		return paypalResults;
	}
}
