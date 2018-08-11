package com.brightsdiamonds.domain;

public class EngagementSetting implements Product<EngagementSetting> {
	
	private int id;

	private String stockItem;
	
	private String name;
	
	private double unitPrice;
	
	private boolean isInStock;
	
	private String metal;
	
	private double width;
	
	private String prongMetal;
	
	private double sizeAvailMin;
	
	private double sizeAvailMax;
	
	private int diamondNumber;
	
	private double caratTotal;
	
	private String color;
	
	private String clarity;
	
	private String diamondShape;

	public EngagementSetting(int id, String stockItem, String name, double unitPrice, boolean isInStock, String metal,
			double width, String prongMetal, double sizeAvailMin, double sizeAvailMax, int diamondNumber,
			double caratTotal, String color, String clarity, String diamondShape) {
		super();
		this.id = id;
		this.stockItem = stockItem;
		this.name = name;
		this.unitPrice = unitPrice;
		this.isInStock = isInStock;
		this.metal = metal;
		this.width = width;
		this.prongMetal = prongMetal;
		this.sizeAvailMin = sizeAvailMin;
		this.sizeAvailMax = sizeAvailMax;
		this.diamondNumber = diamondNumber;
		this.caratTotal = caratTotal;
		this.color = color;
		this.clarity = clarity;
		this.diamondShape = diamondShape;
	}

	public EngagementSetting() {
		// TODO Auto-generated constructor stub
	}

	public String getStockItem() {
		return stockItem;
	}

	public void setStockItem(String stockItem) {
		this.stockItem = stockItem;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public boolean getIsInStock() {
		return isInStock;
	}

	public void setIsInStock(boolean isInStock) {
		this.isInStock = isInStock;
	}

	public String getMetal() {
		return metal;
	}

	public void setMetal(String metal) {
		this.metal = metal;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public String getProngMetal() {
		return prongMetal;
	}

	public void setProngMetal(String prongMetal) {
		this.prongMetal = prongMetal;
	}

	public double getSizeAvailMin() {
		return sizeAvailMin;
	}

	public void setSizeAvailMin(double sizeAvailMin) {
		this.sizeAvailMin = sizeAvailMin;
	}

	public double getSizeAvailMax() {
		return sizeAvailMax;
	}

	public void setSizeAvailMax(double sizeAvailMax) {
		this.sizeAvailMax = sizeAvailMax;
	}

	public int getDiamondNumber() {
		return diamondNumber;
	}

	public void setDiamondNumber(int diamondNumber) {
		this.diamondNumber = diamondNumber;
	}

	public double getCaratTotal() {
		return caratTotal;
	}

	public void setCaratTotal(double caratTotal) {
		this.caratTotal = caratTotal;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getClarity() {
		return clarity;
	}

	public void setClarity(String clarity) {
		this.clarity = clarity;
	}

	public String getDiamondShape() {
		return diamondShape;
	}

	public void setDiamondShape(String diamondShape) {
		this.diamondShape = diamondShape;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "EngagementSetting [id=" + id + ", stockItem=" + stockItem + ", name=" + name + ", unitPrice="
				+ unitPrice + ", isInStock=" + isInStock + ", metal=" + metal + ", width=" + width + ", prongMetal="
				+ prongMetal + ", sizeAvailMin=" + sizeAvailMin + ", sizeAvailMax=" + sizeAvailMax + ", diamondNumber="
				+ diamondNumber + ", caratTotal=" + caratTotal + ", color=" + color + ", clarity=" + clarity
				+ ", diamondShape=" + diamondShape + "]";
	}
	
//	String getStockItem()
//	
//	String getName()
//	
//	double getUnitPrice()
//	
//	boolean	getIsInStock()
//	
//	void setIsInStock(Boolean isInStock)
	
}
