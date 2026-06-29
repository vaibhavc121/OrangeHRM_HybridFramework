package apiTesting;

import static io.restassured.RestAssured.get;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GetData
{

	// traditional approcach
//	@Test
//	public void testResponseCode()
//	{
//		Response resp = RestAssured.get("https://parabank.parasoft.com/parabank/services/bank/customers/12212/");
//		int code = resp.getStatusCode();
//		//resp.asString()
//		//resp.getTime()
//		System.out.println("Status code is: " + code);
//		Assert.assertEquals(code, 200);
//	}

	// Best practices (modern approach)

	@Test
	public void testResponseCode1()
	{
		int code = get("https://parabank.parasoft.com/parabank/services/bank/customers/12212/").getStatusCode();
		System.out.println("Status code is: " + code);
		Assert.assertEquals(code, 200);

//		int code = get("https://api.onenfinity.com/SalesInvoice/GetInvoiceDueAmount?SalesInvoiceId=&TxnNum=257")
//				.getStatusCode();
//		System.out.println("Status code is: " + code);
//		Assert.assertEquals(code, 200);

	}
}
