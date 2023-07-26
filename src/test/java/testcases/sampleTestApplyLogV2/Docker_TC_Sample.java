package testcases.sampleTestApplyLogV2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Docker_TC_Sample {
    public WebDriver driver;
    @Test
    public void TC_01_Docker_Chrome() throws MalformedURLException {
        ChromeOptions browserOptions = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"),browserOptions);
        driver.get("https://www.facebook.com/");
        System.out.println("Title:"+driver.getTitle());
    }
    @Test
    public void TC_02_Docker_Firefox() throws MalformedURLException {
        FirefoxOptions browserOptions = new FirefoxOptions();
        driver = new RemoteWebDriver(new URL("http://localhost:4446/wd/hub"),browserOptions);
        driver.get("https://www.facebook.com/");
        System.out.println("Title:"+driver.getTitle());
    }
}
