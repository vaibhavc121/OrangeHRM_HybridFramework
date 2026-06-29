package testCases.pim;

import base.BaseTest;
import factory.LoggerFactory;
import models.pim.pim.PIMModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.pim.PIMPage;
import utilities.*;

import java.util.List;

public class EmployeeTest extends BaseTest
{
    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
    public void verifyAddEmployee()
    {
        try
        {
            String pimFile = FileUtils.getDataFile("pim", "pim", "PIMData");
            List<PIMModel.EmployeeModel> pimData = JsonUtils.convertJsonListDataModel(pimFile, "addEmployee", PIMModel.EmployeeModel.class);

            PIMPage pp= new PIMPage();
            for (PIMModel.EmployeeModel data:pimData)
            {
               pp.clickPIMMenu();
               log("Clicked on PIM Menu");

                pp.clickAddEmployee();
                log("Clicked on Add Employee");

                pp.enterFirstName(data.firstName);
                log("Entered First Name: " + data.firstName);

                pp.enterMiddleName(data.middleName);
                log("Entered Middle Name: " + data.middleName);

                pp.enterLastName(data.lastName);
                log("Entered Last Name: " + data.lastName);

                pp.enterEmployeeId(DataUtils.randomAlphaNumeric());
                log("Entered Employee ID");

                pp.clickOnSave();
                log("Clicked on Save button");

                Assert.assertTrue(pp.validation(), "Employee not added successfully");
                log("Verified: Employee added successfully: " + data.firstName + " " + data.lastName);


            }

        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}