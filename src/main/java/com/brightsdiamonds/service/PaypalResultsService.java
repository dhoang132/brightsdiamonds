package com.brightsdiamonds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brightsdiamonds.dao.PaypalResultsDao;
import com.brightsdiamonds.domain.PaypalResults;

@Service
public class PaypalResultsService {
	
	@Autowired
	private PaypalResultsDao paypalResultsDao;
	
	public void createPaypalResults(PaypalResults paypalResults) {
		paypalResultsDao.create(paypalResults);
	}
	
	public PaypalResults getPaypalResutls(String cartId) {
		PaypalResults paypalResults = paypalResultsDao.getPaypalResults(cartId);
		return paypalResults;
	}
	
	public List<PaypalResults> getUserPayments(String email){
		List<PaypalResults> userPaymentList = paypalResultsDao.getAllUserPaymentResults(email);
		return userPaymentList;
	}
	
//	public List<Diamond> getDiamondList(){
//	List<Diamond> diamondList = diamondDao.getAllDiamonds();
//	return diamondList;
//}
	
//	public void createUser(User user) {
//	userDao.create(user);
//}
	
//	@Autowired
//	private DiamondDao diamondDao;
//	
//	public List<Diamond> getDiamondList(){
//		List<Diamond> diamondList = diamondDao.getAllDiamonds();
//		return diamondList;
//	}
//	
//	public Diamond getDiamond(int id) {
//		Diamond diamond = diamondDao.getDiamond(id);
//		return diamond;
//	}
//	
//	public void updateIsInStock(Diamond diamond, String stockItem, boolean isInStock) {
//		System.out.println(diamondDao.update(diamond, stockItem, isInStock));
//		
//	}
}
