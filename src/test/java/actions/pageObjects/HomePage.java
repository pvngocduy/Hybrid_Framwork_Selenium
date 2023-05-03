package actions.pageObjects;

import actions.commons.BasePage;
import interfaces.pageUi.HomePageUI;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToRegisterLink() {
        waitForAllElementVisible(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver, HomePageUI.REGISTER_LINK);
    }

    public void clickToLoginLink() {
        waitForAllElementVisible(driver, HomePageUI.LOGIN_LINK);
        clickToElement(driver, HomePageUI.LOGIN_LINK);
    }
    public boolean isMyAcountLinkDisplayed(){
        return objectIsDisplayed(driver,HomePageUI.MY_ACCOUNT_LINK);
    }
}
