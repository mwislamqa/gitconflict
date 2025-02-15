package com.demo;

	import java.net.URI;
	import java.net.http.HttpClient;
	import java.net.http.HttpRequest;
	import java.net.http.HttpResponse;
	import java.net.http.HttpHeaders;
	import java.util.Map;
	import java.util.HashMap;
  //  import com.google.gson.Gson; // Add Gson dependency for JSON parsing

	public class ApiLogin {

	    public static void main(String[] args) throws Exception {
	        String loginUrl = "https://your-api-url.com/login"; // Replace with your API URL
	        String username = "yourUsername"; // Replace with actual username
	        String password = "yourPassword"; // Replace with actual password

	        // Prepare login request data
	        Map<String, String> credentials = new HashMap<>();
	        credentials.put("username", username);
	        credentials.put("password", password);

	        // Convert credentials map to JSON using Gson
	     //   Gson gson = new Gson();
	     //   String requestBody = gson.toJson(credentials);

	        // Create HttpClient and HttpRequest
	        HttpClient client = HttpClient.newHttpClient();
	        HttpRequest request = HttpRequest.newBuilder()
	                .uri(URI.create(loginUrl))
	                .header("Content-Type", "application/json")
	        //        .POST(HttpRequest.BodyPublishers.ofString(requestBody))
	                .build();

	        // Send the request and handle response
	        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

	        // Check if login was successful
	        if (response.statusCode() == 200) {
	            System.out.println("Login successful!");

	            // Extract token or session ID from response (if any)
	            String responseBody = response.body();
	            System.out.println("Response: " + responseBody);

	            // You may need to parse the response JSON to extract the token (JWT, session id, etc.)
	            // Example: parse JWT token from response (if provided)
	            // String token = new JsonParser().parse(responseBody).getAsJsonObject().get("token").getAsString();

	        } else {
	            System.out.println("Login failed with status code: " + response.statusCode());
	            System.out.println("Response: " + response.body());
	        }
	    }
	}


