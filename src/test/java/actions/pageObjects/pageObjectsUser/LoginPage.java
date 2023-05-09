package actions.pageObjects.pageObjectsUser;

import actions.commons.BasePage;
import interfaces.pageUserUI.LoginPageUI;
import interfaces.pageUserUI.RegisterPageUI;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    WebDriver driver;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickToLoginButton(){
        waitForElementVisible(driver,LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
    }
    public String getErrorMessageAtEmail() {
        return getTextElement(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
    }
    public String getErrorMessageLogin(){
        return getTextElement(driver, LoginPageUI.LOGIN_ERROR_MESSAGE);
    }
    public void inputToTheEmail(String textValue){
        waitForAllElementVisible(driver, LoginPageUI.EMAIL_TEXT_BOX);
        sendKeyToElement(driver, LoginPageUI.EMAIL_TEXT_BOX, textValue);
    }

    public void inputToThePassword(String textValue) {
        waitForAllElementVisible(driver, LoginPageUI.PASSWORD_TEXT_BOX);
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXT_BOX, textValue);
    }
    public HomePage userLoginToPortal(String email, String password){
        inputToTheEmail(email);
        inputToThePassword(password);
        clickToLoginButton();
        return PageGeneratorManager.getHomePageObject(driver);
    }

}
