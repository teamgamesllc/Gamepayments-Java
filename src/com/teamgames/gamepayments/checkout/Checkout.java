package com.teamgames.gamepayments.checkout;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.google.gson.Gson;

import com.teamgames.gamepayments.Configurations;
import com.teamgames.gamepayments.ProductResponse;
import com.teamgames.gamepayments.cart.CartItem;
import com.teamgames.request.Connection;

public class Checkout {
	
	public boolean completedCheckout;
	public String redirect;

	public static ProductResponse fetch(String apiKey, String username, List<CartItem> cartItems) throws Exception {
		Map<String, Object> params = new LinkedHashMap<>();
		params.put("username", username);
		params.put("cartItems", cartItems);

		final String ADDRESS = Configurations.isLocal ? Configurations.LOCAL_ADDRESS
				: Configurations.GAMEPAYMENTS_ADDRESS;

		final String serverResponse = Connection.sendPostParams(params, ADDRESS + "/api/v2/client/global/checkout/complete",
				apiKey);

		Gson gson = new Gson();

		ProductResponse apiResponse = gson.fromJson(serverResponse, ProductResponse.class);

		return apiResponse;
	}
	
}
