package testCases.admin;

import base.BaseTest;
import factory.LoggerFactory;
import models.admin.admin.AdminModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.admin.AdminPage;
import pageObjects.pim.PIMPage;
import testCases.pim.PIMTest;
import utilities.FileUtils;
import utilities.JsonUtils;
import utilities.RetryAnalyzer;

import java.util.List;

public class AdminTest extends BaseTest
{
    String adminFile = FileUtils.getDataFile("admin", "admin", "AdminData");
    List<AdminModel.AddUserModel> adminData = JsonUtils.convertJsonListDataModel(adminFile, "addUser", AdminModel.AddUserModel.class);

    @Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
    public void validateAddUser()
    {
        try
        {
            PIMTest pt = new PIMTest();
            pt.verifyAddEmployee();

            AdminPage ap = new AdminPage();

            for (AdminModel.AddUserModel data : adminData)
            {
                ap.clickOnAdmin();
                log("Clicked on Admin Menu");

                ap.clickUserManagement();
                log("Clicked on User Management");

                ap.clickUsers();
                log("Clicked on Users");

                ap.clickAdd();
                log("Clicked on Add button");

                ap.selectUserRole(data.userRole);
                log("Selected User Role: " + data.userRole);

                ap.selectEmployeeName(data.employeeName);
                log("Selected Employee Name: " + data.employeeName);

                ap.selectStatus(data.status);
                log("Selected Status: " + data.status);

                ap.provideUserName(data.username);
                log("Entered Username: " + data.username);

                ap.providePwd(data.password);
                log("Entered Password");

                ap.provideConfirmPwd(data.confirmPassword);
                log("Entered Confirm Password");

                ap.clickOnSave();
                log("Clicked on Save button");

                Assert.assertTrue(ap.validation(), "User not added successfully");
                log("Verified: User added successfully: " + data.username);
            }
        } catch (Exception e)
        {
            LoggerFactory.getLogger().error("Test failed due to exception: ", e);
            Assert.fail("Test case failed: " + e);
        }
    }
}