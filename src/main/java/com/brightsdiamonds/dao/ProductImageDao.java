package com.brightsdiamonds.dao;

import java.util.List;

import javax.sql.DataSource;

import com.brightsdiamonds.domain.ProductImage;

public interface ProductImageDao {

	public void setDataSource(DataSource ds);
	
	public List<ProductImage> getAllProductImage(String stockId);
	
	public ProductImage getProductImage(int id);
}
