package actions.environmentFactory;

import actions.browserFactory.BrowserNotSupportedException;
import actions.commons.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class GridFactory implements EnvironmentFactory{
    private WebDriver driver;
    private String browserName;
    private String ipAddress;
    private String portNumber;
    private String url;

    public GridFactory(String browserName, String ipAddress, String portNumber, String url) {
        this.browserName = browserName;
        this.ipAddress = ipAddress;
        this.portNumber = portNumber;
        this.url = url;
    }

    @Override
    public WebDriver createDriver() throws MalformedURLException{
        Browser browser = Browser.valueOf(browserName.toUpperCase());
        DesiredCapabilities caps = new DesiredCapabilities();
        switch(browser){
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                caps.setBrowserName("chrome");
                caps.setPlatform(Platform.ANY);
                chromeOptions.merge(caps);
                driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/wd/hub",ipAddress,portNumber)),chromeOptions);
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                caps.setBrowserName("firefox");
                caps.setPlatform(Platform.ANY);
                firefoxOptions.merge(caps);
                driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/wd/hub",ipAddress,portNumber)),firefoxOptions);
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                break;
            case H_CHROME:
                break;
            default:
                new BrowserNotSupportedException(browserName);
        }
        driver.get(url);
        return driver;
    }
}
