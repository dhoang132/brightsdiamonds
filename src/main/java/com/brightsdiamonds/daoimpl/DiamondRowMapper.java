package com.brightsdiamonds.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.brightsdiamonds.domain.Diamond;

public class DiamondRowMapper implements RowMapper<Diamond> {

	public Diamond mapRow(ResultSet rs, int rownum) throws SQLException {
		Diamond diamond = new Diamond();
		diamond.setId(rs.getInt("id"));
		diamond.setShape(rs.getString("shape"));
		diamond.setColor(rs.getString("color"));
		diamond.setCarat(rs.getDouble("carat"));
		diamond.setClarity(rs.getString("clarity"));
		diamond.setCertificateId(rs.getString("certificate_id"));
		diamond.setStockItem(rs.getString("stock_item"));
		diamond.setName(rs.getString("name"));
		diamond.setUnitPrice(rs.getDouble("unit_price"));
		diamond.setIsInStock(rs.getBoolean("in_stock"));
		diamond.setCut(rs.getString("cut"));
		diamond.setPolish(rs.getString("polish"));
		diamond.setSymmetry(rs.getString("symmetry"));
		diamond.setGirdle(rs.getString("girdle"));
		diamond.setCutlet(rs.getString("cutlet"));
		diamond.setFluorescence(rs.getString("fluorescence"));
		return diamond;
	}
}
