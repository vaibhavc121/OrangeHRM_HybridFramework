package apiTesting;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SalesmanTest
{

	public static void main(String[] args)
	{
		// Set the base URL
		RestAssured.baseURI = "https://erp-api.onenfinity.com";

		// Step 1: Authenticate and retrieve token
		String token = given().contentType(ContentType.JSON)
				.body("{ \"username\": \"admin@demo.com\", \"password\": \"123\" }").post("/security/token").then()
				.statusCode(200).extract().path("token");

		// Step 2: Create Salesman
		String createSalesmanJson = "{\n" + " \"Code\": \"S01\",\n" + " \"Name\": \"Salesman Test\",\n"
				+ " \"NameL2\": \"\",\n" + " \"Description\": \"Any description of salesman\",\n"
				+ " \"SalesCommissionInPercent\": \"5.5\",\n" + " \"Email\": \"dummy@ebs.com\",\n"
				+ " \"Title\": \"Sales Executive\",\n" + " \"ExtensionNumber\": \"207\",\n"
				+ " \"MobileNumber\": \"12345678\"\n" + "}";

		Response response = given().header("Authorization", "Bearer " + token).contentType(ContentType.JSON)
				.body(createSalesmanJson).when().post("/salesman/create");

		// Step 3: Assertions
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200, "Expected status code to be 200");

		String message = response.jsonPath().getString("Message");
		Assert.assertEquals(message, "Record created successfully", "Expected success message");

		System.out.println("Status Code: " + statusCode);
		System.out.println("Response Message: " + message);
	}
}