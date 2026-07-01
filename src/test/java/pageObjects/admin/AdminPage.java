package pageObjects.admin;

import base.BasePage;
import factory.DriverFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utilities.JavaScriptUtils;

import javax.mail.Message;

public class AdminPage extends BasePage
{
    //region Locators
    @FindBy(xpath = "//span[text()='Admin']")
    private WebElement admin;

    //region User Management

    //region Add User
    @FindBy(xpath = "//span[normalize-space()='User Management']")
    private WebElement userManagement;
    @FindBy(xpath = "//a[normalize-space()='Users']")
    private WebElement users;
    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement add;
    @FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active'])[1]")
    private WebElement userRoleDD;
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement employeeName;
    @FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active'])[2]")
    private WebElement statusDD;
    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active oxd-input--error']")
    private WebElement username;
    @FindBy(xpath = "(//input[@type='password'])[1]")
    private WebElement password;
    @FindBy(xpath = "(//input[@type='password'])[2]")
    private WebElement confirmPassword;

    //endregion

    //region Update User
    //(//div[@class='oxd-table-cell oxd-padding-cell'])[2]
    //endregion

    //endregion

    //endregion

    //region Action Methods
    public void clickOnAdmin()
    {
        clickOnElement1(admin);
    }

    //region User Management

    //region Add User
    public void clickUserManagement()
    {
        clickOnElement1(userManagement);
        waitTS(1);
    }

    public void clickUsers()
    {
        clickOnElement1(users);
        waitTS(2);
    }

    public void clickAdd()
    {
        clickOnElement1(add);
        waitTS(1);
    }
    public void selectUserRole(String userRole)
    {
        clickOnElement1(userRoleDD);
        selectDropdownOption(userRole);
    }

    public void selectEmployeeName(String empName)
    {
        clearAndProvide1(employeeName, empName);
        waitTS(3);
        pressArrowDown();
        pressEnter();
        //selectDropdownOptionDD(empName); //locissue
    }

    public void selectStatus(String status)
    {
        clickOnElement1(statusDD);
        selectDropdownOption(status);
        clickOnElement1(statusDD);
        pressTab();
    }

    public void provideUserName(String uname)
    {
        //clearAndProvide1(username, uname);
        //JavaScriptUtils.provideValueJS(username, uname); //locissue
        Actions actions = new Actions(DriverFactory.getDriver());
        actions.sendKeys(uname).perform();
    }

    public void providePwd(String pwd)
    {
        clearAndProvide1(password, pwd);
    }

    public void provideConfirmPwd(String confirmPwd)
    {
        clearAndProvide1(confirmPassword, confirmPwd);
    }
    //endregion

    //region Update User

    //endregion

    //endregion

    //endregion
}