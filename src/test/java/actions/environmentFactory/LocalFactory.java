package actions.environmentFactory;

import actions.browserFactory.*;
import actions.commons.Browser;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LocalFactory implements EnvironmentFactory{
    private WebDriver driver;
    private String browserName;

    public LocalFactory(String browserName) {
        this.browserName = browserName;
    }
    @Override
    public WebDriver createDriver() {
        Browser browser = Browser.valueOf(browserName.toUpperCase());
        switch(browser){
            case CHROME: driver = new ChromeDriverManager().getBrowserDriver();
                break;
            case FIREFOX:
                driver = new FireFoxDriverManager().getBrowserDriver();
                break;
            case H_CHROME:
                driver = new HeadlessChromeDriverManager().getBrowserDriver();
                break;
            case EDGE:
                driver = new EdgeDriverManager().getBrowserDriver();
                break;
            default:
                new BrowserNotSupportedException(browserName);
        }
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}
