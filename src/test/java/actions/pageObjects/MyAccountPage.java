package actions.pageObjects;

import actions.commons.BasePage;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage {
    WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }
}
