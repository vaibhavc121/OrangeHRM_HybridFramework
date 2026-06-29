package pageObjects.login;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import base.BaseTest;

public class LoginPage extends BasePage
{

    //region Locators
    @FindBy(name = "username")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//button[normalize-space()='Login']") private WebElement login;

    @FindBy(xpath = "//span[normalize-space()='Skip']")
    static WebElement skip;

    //endregion

    //region Action Methods

    // Locate, highlight, enter data, and remove highlight for "Username" field
    public void setUsername(String uname)
    {
        highlightElement(DriverFactory.getDriver(), username, true);
        username.sendKeys(uname);
        highlightElement(DriverFactory.getDriver(), username, false); // Remove highlight
    }

    public void setPwd(String pwd)
    {
        highlightElement(DriverFactory.getDriver(), password, true);
        password.sendKeys(pwd);
        highlightElement(DriverFactory.getDriver(), password, false); // Remove highlight
    }

    public void clkLogin()
    {
        highlightElement(DriverFactory.getDriver(), login, true);
        login.click();
        // bc.highlightElement(DriverFactory.getDriver(), signIn, false); // Remove highlight
    }

    public static void clickOnSkip()
    {
        waitTS(4);
        skip.click();
    }

    public void login(String uname, String pwd)
    {
        WebElement usernameField = DriverFactory.getDriver().findElement(By.name("Username"));
        WebElement passwordField = DriverFactory.getDriver().findElement(By.name("Password"));
        WebElement loginButton = DriverFactory.getDriver().findElement(By.className("login-btn"));

        usernameField.sendKeys(uname);
        BaseTest.log("provided username: " + uname);

        passwordField.sendKeys(pwd);
        BaseTest.log("provided password: " + pwd);

        loginButton.click();
        BaseTest.log("clicked on login button");

//        try
//        {
//            clickOnSkip();
//        } catch (Exception e)
//        {
//
//        }
    }

    //endregion
}