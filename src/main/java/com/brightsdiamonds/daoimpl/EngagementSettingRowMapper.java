package com.brightsdiamonds.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.brightsdiamonds.domain.EngagementSetting;

public class EngagementSettingRowMapper implements RowMapper<EngagementSetting> {

	public EngagementSetting mapRow(ResultSet rs, int rownum) throws SQLException{
		EngagementSetting engagementSetting = new EngagementSetting();
		engagementSetting.setId(rs.getInt("id"));
		engagementSetting.setStockItem(rs.getString("stock_item"));
		engagementSetting.setName(rs.getString("name"));
		engagementSetting.setUnitPrice(rs.getDouble("unit_price"));
		engagementSetting.setIsInStock(rs.getBoolean("in_stock"));
		engagementSetting.setMetal(rs.getString("metal"));
		engagementSetting.setWidth(rs.getDouble("width"));
		engagementSetting.setProngMetal(rs.getString("prong_metal"));
		engagementSetting.setSizeAvailMin(rs.getDouble("size_avail_min"));
		engagementSetting.setSizeAvailMax(rs.getDouble("size_avail_max"));
		engagementSetting.setDiamondNumber(rs.getInt("diamond_number"));
		engagementSetting.setCaratTotal(rs.getDouble("carat_total"));
		engagementSetting.setColor(rs.getString("color"));
		engagementSetting.setClarity(rs.getString("clarity"));
		engagementSetting.setDiamondShape(rs.getString("diamond_shape"));
		return engagementSetting;
	}
	
}

//public EngagementSetting(int id, String stockItem, String name, double unitPrice, boolean isInStock, String metal,
//double width, String prongMetal, double sizeAvailMin, double sizeAvailMax, int diamondNumber,
//double caratTotal, String color, String clarity, String diamondShape) {

//public Diamond mapRow(ResultSet rs, int rownum) throws SQLException {
//	Diamond diamond = new Diamond();
//	diamond.setId(rs.getInt("id"));
//	diamond.setShape(rs.getString("shape"));
//	diamond.setColor(rs.getString("color"));
//	diamond.setCarat(rs.getDouble("carat"));
//	diamond.setClarity(rs.getString("clarity"));