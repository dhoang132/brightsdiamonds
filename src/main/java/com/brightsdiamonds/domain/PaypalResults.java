package com.brightsdiamonds.domain;

public class PaypalResults {
	
	
	private int id;
	private String email;
	private String paymentInfo;
	private String userShippingAddress;
	private String date;
	private String cartId;
	private String cartProducts;
	private double cartTotal;
	private String shippingStatus;
	
	public PaypalResults() {		
	}

	public PaypalResults(String email, String paymentInfo, String userShippingAddress, String date, String cartId,
			String cartProducts, int cartTotal) {
		super();
		this.email = email;
		this.paymentInfo = paymentInfo;
		this.userShippingAddress = userShippingAddress;
		this.date = date;
		this.cartId = cartId;
		this.cartProducts = cartProducts;
		this.cartTotal = cartTotal;
	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPaymentInfo() {
		return paymentInfo;
	}
	public void setPaymentInfo(String paymentInfo) {
		this.paymentInfo = paymentInfo;
	}
	
	
	public String getUserShippingAddress() {
		return userShippingAddress;
	}

	public void setUserShippingAddress(String userShippingAddress) {
		this.userShippingAddress = userShippingAddress;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCartId() {
		return cartId;
	}


	public void setCartId(String cartId) {
		this.cartId = cartId;
	}


	public String getCartProducts() {
		return cartProducts;
	}


	public void setCartProducts(String cartProducts) {
		this.cartProducts = cartProducts;
	}

	public double getCartTotal() {
		return cartTotal;
	}

	public void setCartTotal(double cartTotal) {
		this.cartTotal = cartTotal;
	}

	public String getShippingStatus() {
		return shippingStatus;
	}

	public void setShippingStatus(String shippingStatus) {
		this.shippingStatus = shippingStatus;
	}

	@Override
	public String toString() {
		return "PaypalResults [id=" + id + ", email=" + email + ", paymentInfo=" + paymentInfo
				+ ", userShippingAddress=" + userShippingAddress + ", date=" + date + ", cartId=" + cartId
				+ ", cartProducts=" + cartProducts + ", cartTotal=" + cartTotal + ", shippingStatus=" + shippingStatus
				+ "]";
	}
}
