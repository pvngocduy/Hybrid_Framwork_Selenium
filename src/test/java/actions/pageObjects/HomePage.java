package actions.pageObjects;

import actions.commons.BasePage;
import interfaces.pageUi.HomePageUI;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private WebDriver driver;
    private String email;

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
    public void clickToLogoutLink() {
        waitForAllElementVisible(driver, HomePageUI.LOGOUT_LINK);
        clickToElement(driver, HomePageUI.LOGOUT_LINK);
    }
    public boolean isMyAcountLinkDisplayed(){
        return objectIsDisplayed(driver,HomePageUI.MY_ACCOUNT_LINK);
    }
    public void setExistingEmail(String emailExist){
        email = emailExist;
    }
    public String getExistingEmail(){
        return email;
    }
}
