package com.teamgames.gamepayments;

public class ProductResponse {

	String message;
	String extendedMessage;
	Product[] products;
	
	public Product[] getProducts() {
		return products;
	}
	
	public String getMessage() {
		return message;
	}
	
	public String getExtendedMessage() {
		return extendedMessage;
	}
    
}