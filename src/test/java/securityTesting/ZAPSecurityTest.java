package securityTesting;

import java.io.IOException;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.zaproxy.clientapi.core.ApiResponse;
import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.core.ClientApiException;

public class ZAPSecurityTest
{
	static final String ZAP_PROXY_ADDRESS = "localhost";
	static final int ZAP_PROXY_PORT = 8081;
	static final String ZAP_API_KEY = "3b05rhlh4f2lna37j0n9gb6md3";

	private WebDriver driver;
	private ClientApi api;

	@BeforeMethod
	public void setup()
	{
		String proxyServerUrl = ZAP_PROXY_ADDRESS + ":" + ZAP_PROXY_PORT;
		Proxy proxy = new Proxy();
		proxy.setHttpProxy(proxyServerUrl);
		proxy.setSslProxy(proxyServerUrl);

		ChromeOptions co = new ChromeOptions();
		co.setAcceptInsecureCerts(true);
		co.setProxy(proxy);
		driver = new ChromeDriver(co);
		api = new ClientApi(ZAP_PROXY_ADDRESS, ZAP_PROXY_PORT, ZAP_API_KEY);
	}

	@Test
	public void amazonSecurityTest() throws InterruptedException
	{
		driver.get("https://testlogin.onenfinity.com/User/Login");
		// Assert.assertTrue(driver.getTitle().contains("India"));

//		driver.get("https://testlogin.onenfinity.com/User/Login");
//		driver.findElement(By.name("Username")).sendKeys("vaibhavc121@demo.com");
//		driver.findElement(By.name("Password")).sendKeys("rohitc121");
//		driver.findElement(By.xpath("//div[@aria-label='Sign In']//div[@class='dx-button-content']")).click();
	}

	@AfterMethod
	public void tearDown() throws ClientApiException, IOException
	{
		if (api != null)
		{
			String title = "Amazon ZAP Security Report";
			String template = "traditional-html";
			String description = "This is Amazon zap security test report";
			String reportfilename = "amazon-zap-report.html";
			String targetFolder = System.getProperty("user.dir");
			try
			{
				ApiResponse response = api.reports.generate(title, template, null, description, null, null, null, null,
						null, reportfilename, null, targetFolder, null);

				System.out.println("ZAP report generated at this location: " + response.toString());
			}

			catch (ClientApiException e)
			{
				System.err.println("Error generating ZAP report: " + e.getMessage());
				e.printStackTrace();
				Assert.fail();
			}

		}

		driver.quit();
	}
}
