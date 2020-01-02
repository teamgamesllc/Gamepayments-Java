package com.teamgames.gamepayments;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.google.gson.*;

import com.teamgames.request.Connection;

/**
 * @author Nelson Sanchez
 */

public class Transaction {

	/**
	 * These variables represent the JSON response that is sent from Gamepayments
	 */

	public String productId;
	public String name;
	public float price;
	public float priceWithDiscount;
	public int quantity;
	public int allowReclaim;
	public int gameServer;
	public String username;
	public String paymentType;
	public float tax;
	public String invoice;
	public String paymentStatus;
	public String deliveryStatus;

	public static ArrayList<String> orders = new ArrayList<String>();

	public static void main(String args[]) throws Exception {
		
	}

	public static TransactionResponse getResponse(String apiKey, String username) throws Exception {

		Map<String, Object> params = new LinkedHashMap<>();

		params.put("username", username);

		final String ADDRESS = Configurations.isLocal ? Configurations.LOCAL_ADDRESS
				: Configurations.GAMEPAYMENTS_ADDRESS;

		final String serverResponse = Connection.sendPostParams(params,
				ADDRESS + "/api/v1/client/global/claim-purchase", apiKey);

		Gson gson = new Gson();

		TransactionResponse apiResponse = gson.fromJson(serverResponse, TransactionResponse.class);
		
		if (!apiResponse.getMessage().equalsIgnoreCase("")) {
			
			if (apiResponse.getTransactions().length > 0) {
				
				final String invoice = apiResponse.getTransactions()[0].invoice;
				
				if (!orders.isEmpty()) {
					if (orders.contains(invoice)) {
						apiResponse.message = "ALREADY_PROCESSED";
						apiResponse.extendedMessage = "Transaction has already been processed.";
					}
				}
				
				orders.add(invoice);
			}
		}

		return apiResponse;

	}

}
