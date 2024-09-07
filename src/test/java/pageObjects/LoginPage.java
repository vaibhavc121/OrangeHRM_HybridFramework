package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{

	public LoginPage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement username;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password;
	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement login;

	public void setUname(String uname)
	{
		username.sendKeys(uname);
	}

	public void setPwd(String pwd)
	{
		password.sendKeys(pwd);
	}

	public void clkLoginBtn()
	{
		login.click();
	}

}
