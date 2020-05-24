package com.teamgames;

import java.util.ArrayList;
import java.util.List;

import com.teamgames.gamepayments.Product;
import com.teamgames.gamepayments.ProductResponse;
import com.teamgames.gamepayments.cart.CartItem;
import com.teamgames.gamepayments.checkout.Checkout;
import com.teamgames.gamepayments.checkout.CheckoutResponse;

public class Main {

	public static void main(String args[]) {
//		try {
//			System.out.println("Fetching products");
//			
//			ProductResponse productResponse = Product.fetch("");
//			Product[] products = productResponse.getProducts();
//			for (Product product : products) {
//				System.out.println("Name -> " + product.name);
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		List<CartItem> cartItems = new ArrayList<CartItem>();
		cartItems.add(new CartItem(591, 1));
		cartItems.add(new CartItem(583, 1));
		
//		try {
//			CheckoutResponse checkoutResponse = Checkout.completeCheckout(
//					"apiKey", 
//					"username", cartItems);
//			System.out.println("Redirect URL -> " + checkoutResponse.getRedirect());
//			
//		} catch (Exception e) {
//			
//		}
		
		System.out.println("Teamgames API version 1.04");
	}

}
