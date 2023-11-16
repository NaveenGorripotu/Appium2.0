package appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Base {
    public AndroidDriver driver;

    public AppiumDriverLocalService serviceBuilder;
//    public String username = "bob@example.com";
//    public String password = "10203040";

    @BeforeTest
    public  void appconfigure() throws MalformedURLException {
        //run appium server automatically

        serviceBuilder= new AppiumServiceBuilder()
        .withAppiumJS(new File("C:\\Users\\DELL\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
        .withIPAddress("10.0.0.119").usingPort(4723)
        .withTimeout(Duration.ofSeconds(100)).build();
        serviceBuilder.start();


        //create capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");//optional
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);//optional
        options.setDeviceName("Pixel API 28");
        options.setApp("C:/Users/DELL/IdeaProjects/Appium2.0/apps/Android-MyDemoAppRN.1.3.0.build-244.apk");
        //create an object for AndroidDriver
        driver = new AndroidDriver(new URL("http://10.0.0.119:4723"),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @AfterTest
    public void quit() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
        serviceBuilder.stop();
    }
}

