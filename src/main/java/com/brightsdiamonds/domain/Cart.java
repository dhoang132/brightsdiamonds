package com.brightsdiamonds.domain;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	
	private String cartId;
	private Map<String, CartItem> cartItems;
	private double grandTotal;

	
	public Cart() {
		setCartItems(new HashMap<String, CartItem>());
		setGrandTotal(0);
	}

	public Cart(String cartId) {
		this();
		this.setCartId(cartId);
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public Map<String, CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Map<String, CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public void addCartItem(CartItem item) {
		String productId = item.getProduct().getStockItem();
		if (cartItems.containsKey(productId)) {
			CartItem existingCartItem = cartItems.get(productId);
			if(existingCartItem.getQuantity()+item.getQuantity()>item.getQuantity()) {
				return;
			}
			existingCartItem.setQuantity(existingCartItem.getQuantity()
					+ item.getQuantity());
			cartItems.put(productId, existingCartItem);
		} else {
			cartItems.put(productId, item);
		}

		updateGrandTotal();
	}
	
	public void removeCartItem(String key) {
		this.cartItems.remove(key);
		updateGrandTotal();
	}
	
	public String checkItemsStock(Cart cart) {
		for (String key: cart.getCartItems().keySet()) {
			if (cart.getCartItems().get(key).getProduct().getIsInStock()==false);
			return key;
		}
		return null;
	}

	private void updateGrandTotal() {
		grandTotal = 0;
		for (CartItem item : cartItems.values())
			grandTotal = grandTotal + item.getTotalPrice();
	}

	@Override
	public int hashCode() {
		final int prime = 71;
		int result = 1;
		result = prime * result + ((cartId == null) ? 0 : cartId.hashCode());
		return result;
	}
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (cartId == null) {
			if (other.cartId != null)
				return false;
		} else if (!cartId.equals(other.cartId))
			return false;
		return true;
	}
}
