package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import pageObjects.LoginPage;

public class BaseClass
{
	public static WebDriver driver;
	public Properties p;
	public Logger logger; // log4j

	@BeforeClass
	@Parameters("browser")
	public void setup(String br) throws IOException
	{
		p = new Properties();
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p.load(file);

		logger = LogManager.getLogger(this.getClass()); // log4j2

		if (br.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if (br.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("No matching browser ");
		}

		// driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appurl"));
	}

	@BeforeMethod
	public void login()
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUname(p.getProperty("username"));
		lp.setPwd(p.getProperty("pwd"));
		lp.clkLoginBtn();
	}

	@AfterClass
	public void tearDown()
	{
		// driver.quit();
	}
}
