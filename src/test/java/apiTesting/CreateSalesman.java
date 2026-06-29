package apiTesting;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateSalesman
{

	// Base URLs
	private static final String AUTH_URL = "https://erp-api.onenfinity.com/security/token";
	private static final String CREATE_SALESMAN_URL = "https://erp-api.onenfinity.com/salesman/create";

	// Sample credentials
	private static final String USERNAME = "admin@demo.com";
	private static final String PASSWORD = "123";

	// Hardcoded token for demo purposes; replace this with dynamic token retrieval
	// if needed
	private static final String ACCESS_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJlYzQ0MzA2ZS1jMjg3LTRhNjYtYjczYS1lNGJhNzg4NmY5ZDQiLCJpYXQiOjE3MzAzNjIwMzAsIm5iZiI6MTczMDM2MjAzMCwiZXhwIjoxNzYxODk4MDMwLCJpc3MiOiJodHRwczovL2FwaS5vbmVuZmluaXR5LmNvbSIsImF1ZCI6IkVuZmluaXR5QXVkaWVuY2UifQ.uKmZE0rkLT6zQDfOYWVh8lHNV_EObvs8WlJhp9K_Jy8";

	public static void createSalesman()
	{

		// Sample JSON data for creating a salesman
		String requestBody = "{\n" + " \"Code\": \"1\",\n" + " \"Name\": \"Salesman Test\",\n" + " \"NameL2\": \"\",\n"
				+ " \"Description\": \"Any description of salesman\",\n" + " \"SalesCommissionInPercent\": \"5.5\",\n"
				+ " \"Email\": \"dummy@ebs.com\",\n" + " \"Title\": \"Sales Executive\",\n"
				+ " \"ExtensionNumber\": \"207\",\n" + " \"MobileNumber\": \"12345678\"\n" + "}";

		// Make POST request to create a salesman
		Response response = given().contentType(ContentType.JSON).header("Authorization", "Bearer " + ACCESS_TOKEN) // Pass
																													// access
																													// token
																													// in
																													// the
																													// header
				.body(requestBody).post(CREATE_SALESMAN_URL);

		// Check response status and print response
		if (response.statusCode() == 200)
		{
			System.out.println("Salesman created successfully!");
			System.out.println("Response: " + response.asString());
		}
		else
		{
			System.out.println("Failed to create salesman. Status Code: " + response.statusCode());
			System.out.println("Response: " + response.asString());
		}
	}

	public static void main(String[] args)
	{
		createSalesman();
	}
}
