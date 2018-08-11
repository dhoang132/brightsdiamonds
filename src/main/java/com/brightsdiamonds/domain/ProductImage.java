package com.brightsdiamonds.domain;

import java.sql.Blob;

public class ProductImage {
	private int id;
	private byte[] imageData;
	private String fileName;
	private String stockId;
	public int getId() {
		return id;
	}
	
	
	
	public ProductImage() {
		super();
	}

	public ProductImage(int id, byte[] imageData, String fileName, String stockId) {
		super();
		this.id = id;
		this.imageData = imageData;
		this.fileName = fileName;
		this.stockId = stockId;
	}



	public void setId(int id) {
		this.id = id;
	}
	public byte[] getImageData() {
		return imageData;
	}
	
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}



	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getStockId() {
		return stockId;
	}
	public void setStockId(String stockId) {
		this.stockId = stockId;
	}
	@Override
	public String toString() {
		return "ProductImage [id=" + id + ", imageData=" + imageData + ", fileName=" + fileName + ", stockId=" + stockId
				+ "]";
	}


}
