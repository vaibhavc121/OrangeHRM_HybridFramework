package securityTesting;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.zaproxy.clientapi.core.ApiResponse;
import org.zaproxy.clientapi.core.ApiResponseElement;
import org.zaproxy.clientapi.core.ApiResponseList;
import org.zaproxy.clientapi.core.ClientApi;

public class EnfinitySecurityTest
{

	// OWASP ZAP client
	private static final String ZAP_PROXYHOST = "127.0.0.1"; // ZAP Proxy IP
	private static final int ZAP_PROXYPORT = 8081; // ZAP Proxy port
	private static final String ZAP_APIKEY = "68i3bbfivpibp6qk21e0ef9bfe"; // Add API key if required

	public WebDriver driver;
	private ClientApi zapClient;

	@BeforeClass
	public void setUp()
	{
		// Configure Selenium to use OWASP ZAP as a proxy
		Proxy proxy = new Proxy();
		proxy.setHttpProxy(ZAP_PROXYHOST + ":" + ZAP_PROXYPORT).setFtpProxy(ZAP_PROXYHOST + ":" + ZAP_PROXYPORT)
				.setSslProxy(ZAP_PROXYHOST + ":" + ZAP_PROXYPORT);

		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		options.setProxy(proxy);

		// Set up ChromeDriver with proxy settings
		// System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		// Initialize ZAP client for security scanning
		zapClient = new ClientApi(ZAP_PROXYHOST, ZAP_PROXYPORT, ZAP_APIKEY);
	}

	@Test
	public void testLoginAndSecurityScan() throws Exception
	{
		// Step 1: Selenium functional testing
//		driver.get("https://example.com/login");
//
//		WebElement usernameField = driver.findElement(By.id("username"));
//		WebElement passwordField = driver.findElement(By.id("password"));
//		WebElement loginButton = driver.findElement(By.id("loginBtn"));
//
//		usernameField.sendKeys("testuser");
//		passwordField.sendKeys("password123");
//		loginButton.click();

		driver.get("https://testlogin.onenfinity.com/User/Login");
//		driver.get("http://localhost:8081/");
//		driver.findElement(By.name("Username")).sendKeys("vaibhavc121@demo.com");
//		driver.findElement(By.name("Password")).sendKeys("rohitc121");
//		driver.findElement(By.xpath("//div[@aria-label='Sign In']//div[@class='dx-button-content']")).click();

		// Step 2: Initiate OWASP ZAP active scan (scanning based on captured traffic)
		String targetUrl = "https://testlogin.onenfinity.com/User/Login";
//		String targetUrl = "http://localhost:8081/";
		zapClient.pscan.enableAllScanners(); // Enable passive scanning

		// Start active scan
		ApiResponse response = zapClient.ascan.scan(targetUrl, "True", "False", null, null, null);
		String scanId = ((ApiResponseElement) response).getValue();
		System.out.println("ZAP Active Scan initiated. Scan ID: " + scanId);

		// Poll the scan status and print progress
		while (true)
		{
			Thread.sleep(5000); // Wait for 5 seconds between polling
			int progress = Integer.parseInt(zapClient.ascan.status(scanId).toString());
			System.out.println("Scan progress: " + progress + "%");

			if (progress >= 100)
			{
				break;
			}
		}

		// Step 3: Retrieve scan results (alerts found)
		ApiResponseList alerts = (ApiResponseList) zapClient.core.alerts(targetUrl, null, null);
		System.out.println("Number of alerts: " + alerts.getItems().size());

		// Loop through each alert to display details
		for (ApiResponse alert : alerts.getItems())
		{
			System.out.println(alert.toString());
		}
	}

	@AfterClass
	public void tearDown()
	{
		if (driver != null)
		{
			// driver.quit();
		}
	}
}
