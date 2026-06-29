package apiTesting;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ItemTest
{

	public static void main(String[] args)
	{
		// Set the base URL
		RestAssured.baseURI = "https://Erp-api.onenfinity.com";

		// Step 1: Authenticate and retrieve token
		String token = given().contentType(ContentType.JSON)
				.body("{ \"username\": \"admin@demo.com\", \"password\": \"123\" }").post("/security/token").then()
				.statusCode(200).extract().path("token");

		// Step 2: Create Item
		String createItemJson = "{\n" + "   \"ItemWM\":{\n" + "      \"Code\":\"20001\",\n"
				+ "      \"Name\":\"ABC\",\n" + "      \"NameInArabic\":\"\",\n" + "      \"Description\":\"ABC\",\n"
				+ "      \"ItemType\":\"1\",\n" + "      \"TrackingMode\":\"1\",\n" + "      \"CostingMethod\":\"1\",\n"
				+ "      \"ItemGroup\":\"\",\n" + "      \"ItemCategory\":\"\",\n"
				+ "      \"BaseUnitOfMeasure\":\"Each\",\n" + "      \"SalesPrice\":\"\",\n"
				+ "      \"PurchasePrice\":\"\"\n" + "    },\n" + "      \"ItemSupplierWM\":[          \n"
				+ "           {\n" + "             \"SupplierCode\":\"3001\",          \n"
				+ "             \"PurchaseUnitOfMeasure\":\"Each\",\n" + "             \"ManufacturerPartNum\":\"\",\n"
				+ "             \"ManufacturerBarcode\":\"\",\n" + "             \"PurchaseUnitPrice\":\"\"          \n"
				+ "          }\n" + "       ]\n" + "}";

		Response response = given().header("Authorization", "Bearer " + token).contentType(ContentType.JSON)
				.body(createItemJson).when().post("/Item/CreateItemIfNotExist");

		// Step 3: Assertions
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200, "Expected status code to be 200");

		String message = response.jsonPath().getString("Message");
		Assert.assertEquals(message, "Record created successfully", "Expected success message");

		System.out.println("Status Code: " + statusCode);
		System.out.println("Response Message: " + message);
	}
}
