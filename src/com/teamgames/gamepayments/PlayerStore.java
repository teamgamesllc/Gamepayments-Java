package com.teamgames.gamepayments;

import java.util.LinkedHashMap;
import java.util.Map;

import org.google.gson.Gson;

import com.teamgames.request.Connection;

public class PlayerStore { 
	
	public static void main(String args[]) throws Exception {
		

	}
	
	public static PlayerStoreResponse confirmUsername(String apiKey, String username, String verificationKey) throws Exception {
		Map<String, Object> params = new LinkedHashMap<>();

		params.put("username", username);
		params.put("verificationKey", verificationKey);

		final String ADDRESS = Configurations.isLocal ? Configurations.LOCAL_ADDRESS
				: Configurations.GAMEPAYMENTS_ADDRESS;

		final String serverResponse = Connection.sendPostParams(params,
				ADDRESS + "/api/v1/client/global/confirm-player-seller", apiKey);

		Gson gson = new Gson();

		PlayerStoreResponse apiResponse = gson.fromJson(serverResponse, PlayerStoreResponse.class);

		return apiResponse;
	}

	public static PlayerStoreResponse sellProduct(String apiKey, String username, int productId, String productName, double price, int quantity) throws Exception {

		Map<String, Object> params = new LinkedHashMap<>();

		params.put("username", username);
		params.put("productId", productId);
		params.put("productName", productName);
		params.put("price", price);
		params.put("quantity", quantity);

		final String ADDRESS = Configurations.isLocal ? Configurations.LOCAL_ADDRESS
				: Configurations.GAMEPAYMENTS_ADDRESS;

		final String serverResponse = Connection.sendPostParams(params,
				ADDRESS + "/api/v1/client/global/sell-player-product", apiKey);

		Gson gson = new Gson();

		PlayerStoreResponse apiResponse = gson.fromJson(serverResponse, PlayerStoreResponse.class);

		return apiResponse;

	}
}
