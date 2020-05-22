package com.teamgames.gamepayments;

import java.util.LinkedHashMap;
import java.util.Map;

import org.google.gson.Gson;

import com.teamgames.request.Connection;

public class Product {

	public static ProductResponse fetch(String apiKey) throws Exception {
		Map<String, Object> params = new LinkedHashMap<>();

		final String ADDRESS = Configurations.isLocal ? Configurations.LOCAL_ADDRESS
				: Configurations.GAMEPAYMENTS_ADDRESS;

		final String serverResponse = Connection.sendPostParams(params,
				ADDRESS + "/api/v2/client/global/products", apiKey);

		Gson gson = new Gson();

		ProductResponse apiResponse = gson.fromJson(serverResponse, ProductResponse.class);

		return apiResponse;
	}
    
}