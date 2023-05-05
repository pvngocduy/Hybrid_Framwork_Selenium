package actions.pageFactory;

import actions.commons.BasePage;
import actions.commons.BasePageFactory;
import interfaces.pageUi.LoginPageUI;
import interfaces.pageUi.RegisterPageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory extends BasePageFactory {
    WebDriver driver;
    @FindBy(xpath = "//div/button[@type='submit']")
    private WebElement loginButton;
    @FindBy(xpath = "//span[@id='Email-error']")
    private WebElement emailErrorMessage;
    @FindBy(xpath = "//div[@class = 'message-error validation-summary-errors']")
    private WebElement loginErrorMessage;
    @FindBy(xpath = "//input[@id='Email']")
    private WebElement emailTextBox;
    @FindBy(xpath = "//input[@id='Password']")
    private WebElement passwordTextBox;

    public LoginPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickToLoginButton(){
        clickToElement(loginButton);
    }
    public String getErrorMessageAtEmail() {
        return getTextElement(emailErrorMessage);
    }
    public String getErrorMessageLogin(){
        return getTextElement(loginErrorMessage);
    }
    public void inputToTheEmail(String textValue){
        sendKeyToElement(emailTextBox, textValue);
    }

    public void inputToThePassword(String textValue) {
        sendKeyToElement(passwordTextBox, textValue);
    }
}
