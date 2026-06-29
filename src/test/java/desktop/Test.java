package desktop;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.options.WindowsOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Test
{
    public static void main(String[] args) throws MalformedURLException
    {
        // Use WindowsOptions for Windows-specific capabilities.
        WindowsOptions options = new WindowsOptions();

        // This is the crucial part: you must set the "app" capability.
        // Replace "C:\\Windows\\System32\\notepad.exe" with your app's path or App ID.
        options.setApp("C:\\Windows\\System32\\notepad.exe");

        // You can add other capabilities here if needed.
        options.setCapability("deviceName", "WindowsPC");

        WindowsDriver driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), options);

        // Add your test automation steps here.
        System.out.println("Driver session created successfully!");

        driver.quit();
    }
}