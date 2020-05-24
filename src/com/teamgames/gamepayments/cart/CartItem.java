package com.teamgames.gamepayments.cart;

/**
 * 
 * @author Nelson Sanchez
 *
 */

public class CartItem {
	
	public int id;
	public int quantity;
	
	public CartItem(int id, int quantity) {
		this.id = id;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


}
