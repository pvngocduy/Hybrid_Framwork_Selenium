package actions.pageObjects;

import actions.commons.BasePage;
import org.openqa.selenium.WebDriver;

public class OrdersPage extends BasePage {
    WebDriver driver;


    public OrdersPage(WebDriver driver) {
        this.driver = driver;
    }
}
