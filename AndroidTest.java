import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;
import java.util.Map;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


public class AndroidTest  {
    @Test
    public void AndroidAppTest() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setDeviceName("emulator-5554");
        options.setApp("C:/Users/DELL/IdeaProjects/Appium2.0/apps/Android-MyDemoAppRN.1.3.0.build-244.apk");

        AndroidDriver driver = new AndroidDriver(new URL("http://10.0.0.119:4723"),options);
        Thread.sleep(4000);
        driver.findElement(AppiumBy.accessibilityId("open menu")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
        WebElement element=wait.until(e->e.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"menu item log in\"]")));
//        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"menu item log in\"]")).click();
        element.click();
        Thread.sleep(5000);
        driver.findElement(AppiumBy.accessibilityId("Username input field")).sendKeys("bob@example.com");
        driver.findElement(AppiumBy.accessibilityId("Password input field")).sendKeys("10203040");
        driver.findElement(AppiumBy.accessibilityId("Login button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc=\"store item\"])[1]/android.view.ViewGroup[1]/android.widget.ImageView\n")).click();
//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
        RemoteWebElement scrollView = (RemoteWebElement) wait.until(presenceOfElementLocated(By.xpath("//android.widget.ScrollView[@content-desc=\"product screen\"]/android.view.ViewGroup/android.widget.ImageView")));


        driver.executeScript("gesture: swipe", Map.of("elementId", scrollView.getId(),
                "percentage", 50,
                "direction", "up"));
//        Dimension size = driver.manage().window().getSize();
//        int startX = size.getWidth() / 2;
//        int startY = size.getHeight() / 2;
//        int endX = startX;
//        int endY = (int) (size.getHeight() * 0.25);
//        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
//        Sequence sequence = new Sequence(finger1, 1)
//                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
//                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
//                .addAction(new Pause(finger1, Duration.ofMillis(200)))
//                .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
//                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//
//        driver.perform(Collections.singletonList(sequence));
        Thread.sleep(2000);
        driver.findElement(AppiumBy.accessibilityId("Add To Cart button")).click();
        driver.quit();
    }
}
