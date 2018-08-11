package com.brightsdiamonds.dao;

import java.util.List;

import javax.sql.DataSource;

import com.brightsdiamonds.domain.PaypalResults;

public interface PaypalResultsDao {
	
	public void setDataSource(DataSource ds);
	
	public boolean create(PaypalResults paypalResults);
	
	public PaypalResults getPaypalResults(String cartId);
	
	public List<PaypalResults> getAllUserPaymentResults(String email);
	
//	public List<Diamond> getAllDiamonds();

}
