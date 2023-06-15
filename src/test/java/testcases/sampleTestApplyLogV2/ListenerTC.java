package testcases.sampleTestApplyLogV2;

import actions.commons.BaseTest;
import actions.commons.Log;
import actions.Utils.listeners.TestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class ListenerTC extends BaseTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = getBrowserDriver("chrome","https://anhtester.com" );
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test(priority = 1)
    public void homePage() throws Exception {
        Log.info("Mở trang web");
        driver.get("https://anhtester.com");
        //step này cố tình Fail để chụp màn hình lại
        Log.info("Verify title");
        Assert.assertEquals(driver.getTitle(), "Anh Tester - Automation Test");
    }

    @Test(priority = 2)
    public void loginPage() throws Exception {
        Log.info("Tìm element");
        driver.findElement(By.id("btn-login")).click();
    }
    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}