package utilities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

public class CommonActions
{

    public static void clkSave()
    {
        DriverFactory1.getDriver().findElement(By.xpath("//span[normalize-space()='Save']")).click();
    }

    public static void clkView()
    {
        DriverFactory1.getDriver().findElement(By.xpath("//span[normalize-space()='View']")).click();
    }

    public static void clkApprove()
    {
        DriverFactory1.getDriver().findElement(By.xpath("//span[normalize-space()='Approve']")).click();
        DriverFactory1.getDriver().navigate().back();
    }

    public static void clkNew()
    {
        DriverFactory1.getDriver().findElement(By.xpath("//span[normalize-space()='New']")).click();
    }

    public static void setDropdownValue(String value) throws InterruptedException
    {
        while (true)
        {
            List<WebElement> valueslist = DriverFactory1.getDriver().findElements(By.xpath("//div[@class='grid-row-template']"));
            for (WebElement valuenm : valueslist)
            {
                String actvalue = valuenm.getText();
                if (actvalue.contains(value))
                {
                    valuenm.click();
                    return;
                }
            }
            DriverFactory1.getDriver().findElement(By.xpath("//i[@class='dx-icon dx-icon-next-icon']")).click();
            Thread.sleep(3000);
        }
    }

    public static void setDropdownValueOffice365(String value)
    {
        List<WebElement> valueslist = DriverFactory1.getDriver()
                .findElements(By.xpath("//tr[@class='dxeListBoxItemRow_Office365']"));
        for (WebElement valuenm : valueslist)
        {
            String actvalue = valuenm.getText();
            if (actvalue.contains(value))
            {
                valuenm.click();
                break;
            }
        }
    }

    public static String formattedDateMMM()
    {
        // need date in "dd-MMM-yyyy" format
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        String formattedDate = currentDate.format(formatter);
        return formattedDate;
    }

    public static String formattedDateMM()
    {
        // need date in "dd-MMM-yyyy" format
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = currentDate.format(formatter);
        return formattedDate;
    }

    public static void filterCell2(String name)
    {
        DriverFactory1.getDriver().findElement(By.xpath(
                        "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]"))
                .sendKeys(name);
        DriverFactory1.getDriver().findElement(By.xpath(
                        "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]"))
                .sendKeys(Keys.ENTER);
    }

    public static void filterCell5(String name)
    {
        DriverFactory1.getDriver().findElement(By.xpath(
                        "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/table[1]/tbody[1]/tr[2]/td[5]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]"))
                .sendKeys(name);
        DriverFactory1.getDriver().findElement(By.xpath(
                        "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/table[1]/tbody[1]/tr[2]/td[5]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]"))
                .sendKeys(Keys.ENTER);
    }

    public static void filterCell6(String name)
    {
        DriverFactory1.getDriver().findElement(By.xpath(
                        "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/table[1]/tbody[1]/tr[2]/td[6]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]"))
                .sendKeys(name);
    }

    public static void filterCell7(String name)
    {
        DriverFactory1.getDriver().findElement(By.xpath(
                        "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/table[1]/tbody[1]/tr[2]/td[7]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]"))
                .sendKeys(name);
    }

    public static void filterCell8(String name)
    {
        DriverFactory1.getDriver().findElement(By.xpath(
                        "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/table[1]/tbody[1]/tr[2]/td[8]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]"))
                .sendKeys(name);
    }

    public static void filterCell9(String name)
    {
        DriverFactory1.getDriver().findElement(By.xpath(
                        "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/table[1]/tbody[1]/tr[2]/td[9]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]"))
                .sendKeys(name);
    }

    public static void filterCell10(String name)
    {
        DriverFactory1.getDriver().findElement(By.xpath(
                        "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[5]/div[1]/table[1]/tbody[1]/tr[2]/td[10]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]"))
                .sendKeys(name);
    }

    public static String result5()
    {
        String result = DriverFactory1.getDriver().findElement(By.xpath(
                        "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]"))
                .getText();
        return result;
    }

    public static String result6()
    {
        String result = DriverFactory1.getDriver().findElement(By.xpath(
                        "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[6]/span[1]/a[1]"))
                .getText();
        return result;
    }

    public static String result7()
    {
        String result = DriverFactory1.getDriver().findElement(By.xpath(
                        "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[7]/span[1]/a[1]"))
                .getText();
        return result;
    }

    public static String result8()
    {
        String result = DriverFactory1.getDriver().findElement(By.xpath(
                        "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[8]"))
                .getText();
        return result;
    }

    public static String result9()
    {
        String result = DriverFactory1.getDriver().findElement(By.xpath(
                        "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[9]"))
                .getText();
        return result;
    }

    public static String result10()
    {
        String result = DriverFactory1.getDriver().findElement(By.xpath(
                        "/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[10]"))
                .getText();
        return result;
    }

    public static boolean IsTxnCreated()
    {
        String message = DriverFactory1.getDriver().findElement(By.xpath("//div[@class='dx-toast-message']")).getText();
        // return message;
        if (message.contains("created successfully"))
        {
            return true;
        } else
        {
            return false;
        }
    }

    public static void WaitUntil(By locator)
    {
        // Creating FluentWait instance
        FluentWait<WebDriver> fluentWait = new FluentWait<>(DriverFactory1.getDriver()).withTimeout(Duration.ofSeconds(10)) // Maximum
                // wait
                // time
                // of
                // 10
                // seconds
                .pollingEvery(Duration.ofMillis(500)) // Poll every 500ms
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class); // Ignore these
        // exceptions

        // Applying FluentWait
        WebElement element = fluentWait.until(new Function<WebDriver, WebElement>()
        {
            @Override
            public WebElement apply(WebDriver driver)
            {
                try
                {
                    WebElement el = driver.findElement(locator);

                    // Check if the element is visible and enabled
                    if (el.isDisplayed() && el.isEnabled())
                    {
                        return el; // Return the element if it's ready
                    } else
                    {
                        return null; // Keep polling if conditions aren't met
                    }
                } catch (StaleElementReferenceException e)
                {
                    return null; // If element is stale, return null so FluentWait retries
                }
            }
        });

        // Click after ensuring element is ready
        element.click();
    }
}