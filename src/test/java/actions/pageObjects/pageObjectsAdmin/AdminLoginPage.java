package actions.pageObjects.pageObjectsAdmin;

import actions.commons.BasePage;
import actions.pageObjects.pageObjectsUser.PageGeneratorManager;
import data_test.AdminLoginData;
import interfaces.pageAdminUI.AdminLoginPageUI;
import org.openqa.selenium.WebDriver;

public class AdminLoginPage extends BasePage {
    private WebDriver driver;

    public AdminLoginPage (WebDriver driver) {
        this.driver = driver;
    }
    public void inputToTheEmail(){
        sendKeyToElement(driver, AdminLoginPageUI.EMAIL, AdminLoginData.ADMIN_EMAIL);
    }
    public void inputToThePassword(){
        sendKeyToElement(driver, AdminLoginPageUI.PASSWORD, AdminLoginData.ADMIN_PASSWORD);
    }
    public void clickToLoginAdminPage(){
        clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
    }
    public DashBoardPage loginToAdminPage(){
        inputToTheEmail();
        inputToThePassword();
        clickToLoginAdminPage();
        return PageGeneratorManager.getDashBoardPageObject(driver);
    }
}
