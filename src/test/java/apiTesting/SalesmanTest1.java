package apiTesting;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SalesmanTest1
{

	public static void main(String[] args)
	{
		// Set the base URL
		RestAssured.baseURI = "https://erp-api.onenfinity.com";

		// Access Token
		String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJjZmJhZDNhMS01ZmNmLTQ5NGUtOTgwZC0zZWZiMzM0NGY5MjMiLCJpYXQiOjE3MzAxMzUxMjQsIm5iZiI6MTczMDEzNTEyNCwiZXhwIjoxNzYxNjcxMTI0LCJpc3MiOiJodHRwczovL2FwaS5vbmVuZmluaXR5LmNvbSIsImF1ZCI6IkVuZmluaXR5QXVkaWVuY2UifQ.yeQWYx2kK9VHCaTF9hBubOyAGUHDAv1RQGQ4rP0Ljxk";

		// JSON data for creating a salesman
		String createSalesmanJson = "{\n" + " \"Code\": \"S01\",\n" + " \"Name\": \"Salesman Test\",\n"
				+ " \"NameL2\": \"\",\n" + " \"Description\": \"Any description of salesman\",\n"
				+ " \"SalesCommissionInPercent\": \"5.5\",\n" + " \"Email\": \"dummy@ebs.com\",\n"
				+ " \"Title\": \"Sales Executive\",\n" + " \"ExtensionNumber\": \"207\",\n"
				+ " \"MobileNumber\": \"12345678\"\n" + "}";

		// Step: Create Salesman
		Response response = given().header("Authorization", "Bearer " + token).contentType(ContentType.JSON)
				.body(createSalesmanJson).when().post("/salesman/create");

		// Assertions
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200, "Expected status code to be 200");

		String message = response.jsonPath().getString("Message");
		Assert.assertEquals(message, "Record created successfully", "Expected success message");

		System.out.println("Status Code: " + statusCode);
		System.out.println("Response Message: " + message);
	}
}
