package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_LoginTest extends BaseClass
{
	@Test
	public void verify_login()
	{
		logger.info("--login test started--");
		try
		{
			LoginPage lp = new LoginPage(driver);
			lp.setUname(p.getProperty("username"));
			lp.setPwd(p.getProperty("pwd"));
			lp.clkLoginBtn();

			Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		}
		catch (Exception e)
		{
			Assert.fail();
		}

		logger.info("--test case finished--");
	}
}
