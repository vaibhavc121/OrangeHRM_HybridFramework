package utilities;

import base.BaseTest;
import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testCases.HRMS.Global.BrokenLinksTest;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinksUtils
{
    private BrokenLinksUtils()
    {
    }

    public static void checkBrokenLinks()
    {
        // capture all the links from website
        List<WebElement> links = DriverFactory.getDriver().findElements(By.tagName("a"));
        System.out.println(links.size());
        int noofbrokenlinks = 0;
        int totalLinks = 0;

        for (WebElement link : links)
        {
            String hrefvalue = link.getAttribute("href");
            if (hrefvalue == null || hrefvalue.isEmpty())
            {
                System.out.println("value is null or empty so not possible to check");
                continue;
            }

            // hit url to the server
            try
            {

                URL linkUrl = new URL(hrefvalue); // converted href value from string to url format
                HttpURLConnection conn = (HttpURLConnection) linkUrl.openConnection(); // open connection to the server
                conn.connect(); // connect to the server and send request to the server
                if (conn.getResponseCode() >= 400)
                {
                    BaseTest.log(hrefvalue + " broken link");
                    noofbrokenlinks++;
                } else
                {
                    System.out.println(hrefvalue + " not a broken link");
                    totalLinks++;
                }
            } catch (Exception e)
            {
                // TODO: handle exception
            }
        }
        BaseTest.log("no of broken links: " + noofbrokenlinks);
        BrokenLinksTest.totalBrokenLinks = BrokenLinksTest.totalBrokenLinks + noofbrokenlinks;
        BrokenLinksTest.totalNonBrokenLinks = BrokenLinksTest.totalNonBrokenLinks + totalLinks;

//		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
//		System.out.println("Total links found: " + allLinks.size());
//
//		int brokenLinkCount = 0;
//
//		for (WebElement element : allLinks)
//		{
//			String href = element.getAttribute("href");
//
//			if (href == null || href.trim().isEmpty())
//			{
//				System.out.println("Skipped: Link is null or empty");
//				continue;
//			}
//
//			// Skip non-http(s) links
//			if (!href.startsWith("http"))
//			{
//				System.out.println("Skipped: Non-HTTP link -> " + href);
//				continue;
//			}
//
//			try
//			{
//				HttpURLConnection connection = (HttpURLConnection) (new URL(href).openConnection());
//				connection.setRequestMethod("HEAD"); // HEAD is faster than GET for checking links
//				connection.setConnectTimeout(3000); // Timeout in ms
//				connection.setReadTimeout(3000);
//				connection.setRequestProperty("User-Agent", "Mozilla/5.0");
//
//				connection.connect();
//				int responseCode = connection.getResponseCode();
//
//				if (responseCode >= 400)
//				{
//					System.out.println("Broken Link: " + href + " -> Response Code: " + responseCode);
//					brokenLinkCount++;
//				} else
//				{
//					System.out.println("Valid Link: " + href + " -> Response Code: " + responseCode);
//				}
//
//				connection.disconnect();
//
//			} catch (Exception e)
//			{
//				System.out.println("Exception while checking link: " + href + " -> " + e.getMessage());
//				brokenLinkCount++;
//			}
//		}
//
//		System.out.println("Total broken links: " + brokenLinkCount);
    }
}