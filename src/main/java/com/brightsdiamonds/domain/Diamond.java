package com.brightsdiamonds.domain;

public class Diamond implements Product<Diamond>{
	
	
	private String stockItem;
	private String name;
	private double unitPrice;
	private boolean	isInStock;
	
	
	private int id;
	
	private String shape;
	
	private String color;
	
	private double carat;
	
	private String clarity;
	
	private String certificateId;
	
	private String cut;
	
	private String polish;
	
	private String symmetry;
	
	private String girdle;
	
	private String cutlet;
	
	private String Fluorescence;
	
	private String diamondVideo;

	
	

	public String getShape() {
		return shape;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getCarat() {
		return carat;
	}

	public void setCarat(double carat) {
		this.carat = carat;
	}

	public String getClarity() {
		return clarity;
	}

	public void setClarity(String clarity) {
		this.clarity = clarity;
	}

	public String getCertificateId() {
		return certificateId;
	}

	public void setCertificateId(String certificateId) {
		this.certificateId = certificateId;
	}

	public void setStockItem(String stockItem) {
		this.stockItem = stockItem;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public boolean getIsInStock() {
		return isInStock;
	}




	public String getStockItem() {
		return stockItem;
	}

	public String getName() {
		return name;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setIsInStock(boolean isInStock) {
		this.isInStock = isInStock;
	}

	public String getCut() {
		return cut;
	}

	public void setCut(String cut) {
		this.cut = cut;
	}


	public String getPolish() {
		return polish;
	}

	public void setPolish(String polish) {
		this.polish = polish;
	}

	public String getSymmetry() {
		return symmetry;
	}

	public void setSymmetry(String symmetry) {
		this.symmetry = symmetry;
	}

	public String getGirdle() {
		return girdle;
	}

	public void setGirdle(String girdle) {
		this.girdle = girdle;
	}

	public String getCutlet() {
		return cutlet;
	}

	public void setCutlet(String cutlet) {
		this.cutlet = cutlet;
	}

	public String getFluorescence() {
		return Fluorescence;
	}

	public void setFluorescence(String fluorescence) {
		Fluorescence = fluorescence;
	}
	
	

	public String getDiamondVideo() {
		return diamondVideo;
	}

	public void setDiamondVideo(String diamondVideo) {
		this.diamondVideo = diamondVideo;
	}

	@Override
	public String toString() {
		return "Diamond [stockItem=" + stockItem + ", name=" + name + ", unitPrice=" + unitPrice + ", isInStock="
				+ isInStock + ", id=" + id + ", shape=" + shape + ", color=" + color + ", carat=" + carat + ", clarity="
				+ clarity + ", certificateId=" + certificateId + ", cut=" + cut + ", polish=" + polish + ", symmetry="
				+ symmetry + ", girdle=" + girdle + ", cutlet=" + cutlet + ", Fluorescence=" + Fluorescence + "]";
	}


	
	
}
