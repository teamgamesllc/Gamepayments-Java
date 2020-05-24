package com.teamgames.gamepayments.checkout;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.google.gson.Gson;

import com.teamgames.gamepayments.Configurations;
import com.teamgames.gamepayments.cart.CartItem;
import com.teamgames.request.Connection;

public class Checkout {

	public static CheckoutResponse completeCheckout(String apiKey, String username, List<CartItem> cartItems) throws Exception {

		Gson gson = new Gson();
		Map<String, Object> params = new LinkedHashMap<>();
		params.put("username", username);
		System.out.println(gson.toJson(cartItems).toString());
		params.put("cartItems", gson.toJson(cartItems).toString());

		final String ADDRESS = Configurations.isLocal ? Configurations.LOCAL_ADDRESS
				: Configurations.GAMEPAYMENTS_ADDRESS;

		final String serverResponse = Connection.sendPostParams(params, ADDRESS + "/api/v2/client/global/checkout/complete",
				apiKey);

		CheckoutResponse apiResponse = gson.fromJson(serverResponse, CheckoutResponse.class);

		return apiResponse;
	}
	
}
