package com.brightsdiamonds.domain;

public interface Product <T> {
	
	String getStockItem();
	
	String getName();
	
	double getUnitPrice();
	
	boolean	getIsInStock();
	
	void setIsInStock(boolean isInStock);
}
