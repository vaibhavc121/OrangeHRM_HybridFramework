package desktop;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.options.WindowsOptions;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class CalculatorTest
{

    private static final String WINAPPDRIVER_URL = "http://127.0.0.1:4723";
    private static final String CALCULATOR_APP_ID = "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App";
    private WindowsDriver driver;

    @BeforeClass(groups = "regression")
    public void setUp() throws MalformedURLException
    {
        WindowsOptions options = new WindowsOptions();
        options.setApp(CALCULATOR_APP_ID);
        options.setCapability("deviceName", "WindowsPC");

        driver = new WindowsDriver(new URL(WINAPPDRIVER_URL), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterClass(groups = "regression")
    public void tearDown()
    {
        if (driver != null)
        {
            driver.quit();
        }
    }

    @Test(groups = "regression")
    public void addTwoNumbers()
    {
        driver.findElement(By.name("One")).click();
        driver.findElement(By.name("Plus")).click();
        driver.findElement(By.name("Seven")).click();
        driver.findElement(By.name("Equals")).click();

        String result = driver.findElement(AppiumBy.accessibilityId("CalculatorResults")).getText();
        Assert.assertTrue(result.contains("8"), "Result should be 8 but was: " + result);
    }
}