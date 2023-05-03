package actions.pageObjects;

import actions.commons.BasePage;
import interfaces.pageUi.LoginPageUI;
import interfaces.pageUi.RegisterPageUI;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    WebDriver driver;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickToLoginButton(){
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
    }
    public String getErrorMessageAtEmail() {
        return getTextElement(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
    }
    public String getErrorMessageLogin(){
        return getTextElement(driver, LoginPageUI.LOGIN_ERROR_MESSAGE);
    }
    public void inputToTheEmail(String textValue){
        sendKeyToElement(driver, LoginPageUI.EMAIL_TEXT_BOX, textValue);
    }

    public void inputToThePassword(String textValue) {
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXT_BOX, textValue);
    }
}
