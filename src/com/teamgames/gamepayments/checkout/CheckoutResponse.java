package com.teamgames.gamepayments.checkout;

/*
 * @author Nelson Sanchez
 */

public class CheckoutResponse {
	
	String redirect;
	String message;
	String extendedMessage;
	
	public String getRedirect() {
		return redirect;
	}
	
	public String getMessage() {
		return message;
	}
	
	public String getExtendedMessage() {
		return extendedMessage;
	}

}
