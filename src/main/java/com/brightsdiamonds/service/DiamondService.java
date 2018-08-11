package com.brightsdiamonds.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brightsdiamonds.dao.DiamondDao;
import com.brightsdiamonds.domain.Diamond;

@Service
public class DiamondService {
	
	@Autowired
	private DiamondDao diamondDao;
	
	public List<Diamond> getDiamondList(){
		List<Diamond> diamondList = diamondDao.getAllDiamonds();
		return diamondList;
	}
	
	public Diamond getDiamond(int id) {
		Diamond diamond = diamondDao.getDiamond(id);
		return diamond;
	}
	
	public void updateIsInStock(Diamond diamond, String stockItem, boolean isInStock) {
		System.out.println(diamondDao.update(diamond, stockItem, isInStock));
		
	}
}
