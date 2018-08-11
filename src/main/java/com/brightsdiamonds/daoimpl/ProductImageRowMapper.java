package com.brightsdiamonds.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.brightsdiamonds.domain.ProductImage;

public class ProductImageRowMapper implements RowMapper<ProductImage> {
	public ProductImage mapRow(ResultSet rs, int rownum) throws SQLException {
		ProductImage productImage = new ProductImage();
		productImage.setId(rs.getInt("id"));
		productImage.setFileName(rs.getString("image_name"));
		productImage.setStockId(rs.getString("stock_id"));
		productImage.setImageData(rs.getBytes("image_data"));
		return productImage;
	}
}
