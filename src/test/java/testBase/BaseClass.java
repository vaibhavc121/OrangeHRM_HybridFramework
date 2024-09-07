package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass
{
	public static WebDriver driver;
	public Properties p;
	public Logger logger; // log4j

	@BeforeClass

	public void setup() throws IOException
	{
		p = new Properties();
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p.load(file);

		logger = LogManager.getLogger(this.getClass()); // log4j2

		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appurl"));
	}

	@AfterClass
	public void tearDown()
	{
		// driver.quit();
	}
}
