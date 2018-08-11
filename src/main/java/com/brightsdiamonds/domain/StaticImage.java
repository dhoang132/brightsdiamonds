package com.brightsdiamonds.domain;


public class StaticImage {
	private int id;
	private byte[] imageData;
	private String fileName;
	public int getId() {
		return id;
	}
	
	
	
	public StaticImage() {
		super();
	}

	public StaticImage(int id, byte[] imageData, String fileName) {
		super();
		this.id = id;
		this.imageData = imageData;
		this.fileName = fileName;
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
	@Override
	public String toString() {
		return "ProductImage [id=" + id + ", imageData=" + imageData + ", fileName=" + fileName + "]";
	}


}
