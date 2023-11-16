package appium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;

public class login extends Base{
    public String username = "bob@example.com";
    public String password = "10203040";
    @BeforeTest
    @Override
    public void appconfigure() throws MalformedURLException {
        super.appconfigure();
    }


    @Test(priority = 1)
    public  void applogin(){
        driver.findElement(AppiumBy.accessibilityId("open menu")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement element=wait.until(e->e.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"menu item log in\"]")));
        element.click();
        driver.findElement(AppiumBy.accessibilityId("Username input field")).sendKeys(username);
        driver.findElement(AppiumBy.accessibilityId("Password input field")).sendKeys(password);
        driver.findElement(AppiumBy.accessibilityId("Login button")).click();
//        driver.findElement(By.xpath("(//android.widget.ImageView)[0]")).click();

//        driver.quit();
//        serviceBuilder.stop();
    }

}
