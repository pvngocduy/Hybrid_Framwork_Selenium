package actions.pageObjects;

import actions.commons.BasePage;
import org.openqa.selenium.WebDriver;

public class AddressesPage extends BasePage {
    WebDriver driver;


    public AddressesPage(WebDriver driver) {
        this.driver = driver;
    }
}
