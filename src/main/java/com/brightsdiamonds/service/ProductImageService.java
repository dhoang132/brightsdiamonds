package com.brightsdiamonds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brightsdiamonds.dao.ProductImageDao;
import com.brightsdiamonds.domain.ProductImage;

@Service
public class ProductImageService {
	
	@Autowired
	private ProductImageDao productImageDao;
	
	public List<ProductImage> getProductImages(String stockId){
		List<ProductImage> productImageList = productImageDao.getAllProductImage(stockId);
		return productImageList;
	}
	
	public ProductImage getProductImage(int id){
		ProductImage productImage=productImageDao.getProductImage(id);
		return productImage;
	}

}
