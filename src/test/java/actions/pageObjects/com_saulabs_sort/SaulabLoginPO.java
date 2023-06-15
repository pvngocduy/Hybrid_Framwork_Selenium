package actions.pageObjects.com_saulabs_sort;

import actions.commons.BasePage;
import interfaces.com_saulabs_ui.SaulabLoginUI;
import org.openqa.selenium.WebDriver;

public class SaulabLoginPO extends BasePage {
    WebDriver driver;
    public SaulabLoginPO(WebDriver driver) {
        this.driver = driver;
    }
    public void inputToTheField(String value, String nameField){
        waitForElementVisible(driver, SaulabLoginUI.LOGIN_ELEMENT_LOCATOR, nameField);
        sendKeyToElement(driver, SaulabLoginUI.LOGIN_ELEMENT_LOCATOR, value, nameField);
    }
    public void clickToLogin(String nameField){
        waitForElementVisible(driver, SaulabLoginUI.LOGIN_ELEMENT_LOCATOR, nameField);
        clickToElement(driver, SaulabLoginUI.LOGIN_ELEMENT_LOCATOR, nameField);
    }

}
