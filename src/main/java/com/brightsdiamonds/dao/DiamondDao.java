package com.brightsdiamonds.dao;

import java.util.List;

import javax.sql.DataSource;

import com.brightsdiamonds.domain.Diamond;

public interface DiamondDao {

	public void setDataSource(DataSource ds);
	
	public boolean create(Diamond diamond);
	
	public List<Diamond> getAllDiamonds();
	
	public Diamond getDiamond(int id);
	
	public boolean delete(Diamond diamond);
	
	public boolean update(Diamond diamond, String stockItem, boolean isInStock);
	
	public void cleanup();
}
