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

    public RegisterPage clickToRegisterLink() {
        waitForAllElementVisible(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver, HomePageUI.REGISTER_LINK);
        return PageGeneratorManager.getRegisterPageObject(driver);
    }

    public LoginPage clickToLoginLink() {
        waitForAllElementVisible(driver, HomePageUI.LOGIN_LINK);
        clickToElement(driver, HomePageUI.LOGIN_LINK);
        return PageGeneratorManager.getLoginPageObject(driver);
    }
    public HomePage clickToLogoutLink() {
        waitForAllElementVisible(driver, HomePageUI.LOGOUT_LINK);
        clickToElement(driver, HomePageUI.LOGOUT_LINK);
        return PageGeneratorManager.getHomePageObject(driver);
    }
    public MyAccountPage clickToMyAccountLink() {
        waitForAllElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
        return PageGeneratorManager.getMyAccountPageObject(driver);
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
