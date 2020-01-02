package com.teamgames.gamepayments;

/**
 * @author Nelson Sanchez
 */

public class TransactionResponse {
	
	String message;
	String extendedMessage;
	Transaction[] transactions;
	
	public Transaction[] getTransactions() {
		return transactions;
	}
	
	public String getMessage() {
		return message;
	}
	
	public String getExtendedMessage() {
		return extendedMessage;
	}

}
