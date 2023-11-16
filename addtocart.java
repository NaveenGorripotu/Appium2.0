package appium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class addtocart extends login{

    @BeforeTest
    @Override
    public void appconfigure() throws MalformedURLException {
        super.appconfigure();
    }

    public void applogin() {
        super.applogin();
    }

    @Test(priority = 2)
    public void addCart() throws InterruptedException {
        driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc=\"store item\"])[1]/android.view.ViewGroup[1]/android.widget.ImageView\n")).click();
        WebElement element = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Add To Cart\"));"));
        element.click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//        RemoteWebElement scrollView = (RemoteWebElement) wait.until(presenceOfElementLocated(By.xpath("//android.widget.ScrollView[@content-desc=\"product screen\"]/android.view.ViewGroup/android.widget.ImageView")));
//        driver.executeScript("gesture: swipe", Map.of("elementId", scrollView.getId(),
//                "percentage", 50,
//                "direction", "up"));
//        driver.findElement(AppiumBy.accessibilityId("Add To Cart button")).click();
//        Thread.sleep(2000);
//        driver.quit();
//        serviceBuilder.stop();
    }
}
