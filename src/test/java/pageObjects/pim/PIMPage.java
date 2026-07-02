package pageObjects.pim;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.DataUtils;
import utilities.JavaScriptUtils;

public class PIMPage extends BasePage
{
    //region Locators

    @FindBy(xpath = "//span[text()='PIM']")
    private WebElement pimMenu;

    //region Add Employee
    @FindBy(xpath = "//a[text()='Add Employee']")
    private WebElement addEmployee;
    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstName;
    @FindBy(xpath = "//input[@name='middleName']")
    private WebElement middleName;
    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastName;
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    private WebElement empid;
    //endregion

    //endregion

    //region Action Methods
    public void clickPIMMenu()
    {
        clickOnElement1(pimMenu);
    }

    public void clickAddEmployee()
    {
        clickOnElement1(addEmployee);
    }

    public void enterFirstName(String fName)
    {
        waitTS(3);
        clearAndProvide1(firstName, fName);
    }

    public void enterMiddleName(String mName)
    {
        clearAndProvide1(middleName, mName);
    }

    public void enterLastName(String lName)
    {
        clearAndProvide1(lastName, lName);
    }

    public void enterEmployeeId(String id)
    {
        JavaScriptUtils.provideValueJS(empid, DataUtils.randomAlphaNumeric());
        //clearAndProvide1(empid, id);
    }

    //endregion
}