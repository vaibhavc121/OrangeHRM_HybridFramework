package utilities;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumServerUtils
{
    private static AppiumServiceBuilder appiumServiceBuilder;
    private static AppiumDriverLocalService appiumDriverLocalService;

    public static void startAppiumServer()
    {
        killAppiumSession();

        // Build Appium Service
        appiumServiceBuilder = new AppiumServiceBuilder();
        appiumServiceBuilder.withIPAddress("127.0.0.1");
        appiumServiceBuilder.usingPort(4723);
        appiumServiceBuilder.withArgument(GeneralServerFlag.LOG_LEVEL, "debug");

        // Start the server with builder
        appiumDriverLocalService = AppiumDriverLocalService.buildService(appiumServiceBuilder);
        appiumDriverLocalService.start();
    }

    public static void stopAppiumServer()
    {
        if(appiumDriverLocalService != null && appiumDriverLocalService.isRunning())
        {
            appiumDriverLocalService.stop();
        }
    }

    private static void killAppiumSession() {
        try {
            String command = "taskkill /F /IM node.exe /T";
            Runtime.getRuntime().exec(command);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //region Kill only Appium-related node processes
    private static void killAppiumSession1()
    {
        try {
            String[] command = {
                    "/bin/sh",
                    "-c",
                    "ps -ef | grep node | grep appium | awk '{print $2}' | xargs kill -9"
            };
            Runtime.getRuntime().exec(command);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    //endregion

}