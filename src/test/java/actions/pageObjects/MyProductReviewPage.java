package actions.pageObjects;

import actions.commons.BasePage;
import org.openqa.selenium.WebDriver;

public class MyProductReviewPage extends BasePage {
    WebDriver driver;


    public MyProductReviewPage(WebDriver driver) {
        this.driver = driver;
    }
}
