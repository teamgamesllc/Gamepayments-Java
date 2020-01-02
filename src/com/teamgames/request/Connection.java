package com.teamgames.request;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.Map;

public class Connection {

	public static String sendPostParams(Map<String, Object> params, String targetURL, String apiKey)
			throws Exception {
		System.out.println("Target URL: " + targetURL);
		URL url;
		HttpURLConnection connection = null;
		try {
			// Create connection
			url = new URL(targetURL);

			StringBuilder postData = new StringBuilder();
			for (Map.Entry<String, Object> param : params.entrySet()) {
				if (postData.length() != 0)
					postData.append('&');
				postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
				postData.append('=');
				postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
			}

			byte[] postDataBytes = postData.toString().getBytes("UTF-8");

			connection = (HttpURLConnection) url.openConnection();

			connection.setReadTimeout(60 * 1000);
			connection.setConnectTimeout(60 * 1000);

			// Custom Gamepayments Header
			
			connection.setRequestProperty("Authorization", new String(Base64.getEncoder().encode(apiKey.getBytes())));

			connection.setRequestMethod("POST");
			connection.setRequestProperty("Host", "10.0.0.53:1340");
			connection.setRequestProperty("User-Agent", "GamepaymentsJavaClientAPI/1.1");
			connection.setRequestProperty("Accept", "*/*");
			connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
			connection.setRequestProperty("X-Requested-With", "XMLHttpRequest");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			connection.setRequestProperty("Content-Language", "en-US");
			connection.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
			
			// End Custom Headers	

			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setDoOutput(true);

			// Send request
			DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			wr.writeBytes(postData.toString());
			wr.flush();
			wr.close();

			// Get Response
			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			String line;
			StringBuffer response = new StringBuffer();
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}
			rd.close();
			return response.toString();

		} catch (Exception e) {

			e.printStackTrace();
			return null;

		} finally {

			if (connection != null) {
				connection.disconnect();
			}
		}
	}
}
