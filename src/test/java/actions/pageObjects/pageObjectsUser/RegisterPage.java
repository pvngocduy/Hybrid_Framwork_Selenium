package actions.pageObjects.pageObjectsUser;


import actions.commons.BasePage;
import data_test.RegisterData;
import interfaces.pageUserUI.RegisterPageUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegisterPage extends BasePage {
    private WebDriver driver;
    private String email = "abc"+BasePage.fakeIntergerNumber()+"@gmail.com";
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return RegisterData.passWord;
    }
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
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
        waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXT_BOX);
        sendKeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXT_BOX, firstName);
    }

    public void inputToTheLastName(String lastName) {
        waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXT_BOX);
        sendKeyToElement(driver, RegisterPageUI.LAST_NAME_TEXT_BOX, lastName);
    }

    public void inputToTheEmail(String email) {
        waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXT_BOX);
        sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXT_BOX, email);
    }

    public void inputToThePassword(String password) {
        waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXT_BOX);
        sendKeyToElement(driver, RegisterPageUI.PASSWORD_TEXT_BOX, password);
    }

    public void inputToTheConfirmPassword(String confirmPassword) {
        waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXT_BOX);
        sendKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXT_BOX, confirmPassword);
    }

    public String getSuccessMessage() {
        return getTextElement(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }

    public String getMessageErrorExistEmail() {
        return getTextElement(driver, RegisterPageUI.EXIST_MAIL_ERROR_MESSAGE);
    }
    public LoginPage registerUserPortal() {
        inputToTheFirstName(RegisterData.firstName);
        inputToTheLastName(RegisterData.lastName);
        inputToTheEmail(email);
        inputToThePassword(RegisterData.passWord);
        inputToTheConfirmPassword(RegisterData.confirmPassword);
        clickToRegisterButton();
        Assert.assertEquals(getSuccessMessage(), "Your registration completed");
        return PageGeneratorManager.getLoginPageObject(driver);
    }
}
