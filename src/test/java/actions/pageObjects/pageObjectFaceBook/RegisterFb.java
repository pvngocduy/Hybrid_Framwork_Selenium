package actions.pageObjects.pageObjectFaceBook;

import actions.commons.BasePage;
import interfaces.com_facebook_registerui.RegisterFbUi;
import org.openqa.selenium.WebDriver;

public class RegisterFb extends BasePage {
    WebDriver driver;
    public RegisterFb(WebDriver driver) {
        this.driver = driver;
    }
    public void clickToRegisterLink(){
        clickToElement(driver, RegisterFbUi.REGISTER_LINK);
    }
    public void inputToTheEmail(){
        sendKeyToElement(driver, RegisterFbUi.EMAIL_TEXTBOX, "abc@gmail.com");
    }
    public boolean isEmailConfirmDisplay(){
        return objectIsDisplayed(driver, RegisterFbUi.CONFIRM_EMAIL_TEXTBOX);
    }
    public boolean isConfirmEmailUnDisplay(){
        waitForElementUnDisplayInDom(driver, RegisterFbUi.CONFIRM_EMAIL_TEXTBOX);
        return isElementUndisplayed(driver,RegisterFbUi.CONFIRM_EMAIL_TEXTBOX );
    }
    public void clearTextInEmail(){
        getElement(driver,RegisterFbUi.EMAIL_TEXTBOX ).clear();
    }
    public void clickToCloseRegisterPopup(){
        clickToElement(driver, RegisterFbUi.CLOSE_BUTTON);
    }
}
