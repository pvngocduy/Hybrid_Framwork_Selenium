package actions.pageFactory;


import actions.commons.BasePage;
import interfaces.pageUserUI.RegisterPageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageFactory extends BasePage {
    private WebDriver driver;
    public RegisterPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickToRegisterButton() {
        waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
    }
    public String getErrorMessageAtFirstName() {
        return getTextElement(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
    }

    public String getErrorMessageAtLastName() {
        return getTextElement(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
    }

    public String getErrorMessageAtEmail() {
        return getTextElement(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
    }

    public String getErrorMessageAtPassword() {
        return getTextElement(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
    }

    public String getErrorMessageAtConfirmPassword() {
        return getTextElement(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
    }

    public void inputToTheFirstName(String firstName) {
        sendKeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXT_BOX, firstName);
    }

    public void inputToTheLastName(String lastName) {
        sendKeyToElement(driver, RegisterPageUI.LAST_NAME_TEXT_BOX, lastName);
    }

    public void inputToTheEmail(String email) {
        sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXT_BOX, email);
    }

    public void inputToThePassword(String password) {
        sendKeyToElement(driver, RegisterPageUI.PASSWORD_TEXT_BOX, password);
    }

    public void inputToTheConfirmPassword(String confirmPassword) {
        sendKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXT_BOX, confirmPassword);
    }

    public String getSuccessMessage() {
        return getTextElement(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }

    public String getMessageErrorExistEmail() {
        return getTextElement(driver, RegisterPageUI.EXIST_MAIL_ERROR_MESSAGE);
    }

}
