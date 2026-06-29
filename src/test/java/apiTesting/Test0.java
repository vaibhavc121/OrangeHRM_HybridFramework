package apiTesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Test0
{

	public static void main(String[] args)
	{
		RestAssured.baseURI = "https://erp-api.onenfinity.com";

		// Send a POST request to retrieve the token
		Response authResponse = RestAssured.given().contentType(ContentType.JSON)
				.body("{ \"username\": \"admin@demo.com\", \"password\": \"123\" }") // Ensure this matches API
																						// expectation
				.post("/security/token");

		// Print response status and body to troubleshoot
		System.out.println("Status Code: " + authResponse.getStatusCode());
		System.out.println("Response Body: " + authResponse.getBody().asString());

		// Extract the token from the response if successful
		if (authResponse.getStatusCode() == 200)
		{
			String token = authResponse.jsonPath().getString("access_token"); // Confirm field name from actual response
			System.out.println("Access Token: " + token);
		}
		else
		{
			System.out.println("Failed to retrieve token. Check credentials or API endpoint.");
		}
	}
}
