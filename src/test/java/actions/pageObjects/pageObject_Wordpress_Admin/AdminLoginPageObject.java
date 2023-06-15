package actions.pageObjects.pageObject_Wordpress_Admin;

import actions.commons.BasePage;

import interfaces.pageUI_wordpress_admin.AdminDashboardUI;
import interfaces.pageUI_wordpress_admin.AdminLoginUI;
import org.openqa.selenium.WebDriver;
import testdata.com_nopcomerce_data.AdminLoginPageVerifyData;

public class AdminLoginPageObject extends BasePage {
    WebDriver driver;
    public AdminLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public AdminDashboardPageObject clickToLoginButton(){
        clickToElement(driver, AdminLoginUI.SUBMIT_BUTTON);
        return PageWPGeneratorManager.getDashBoardPageObject(driver);
    }
    public void inputToUserName(String username){
        sendKeyToElement(driver, AdminLoginUI.USERNAME_TEXTBOX, username);
    }
    public void inputToPassword(String password){
        sendKeyToElement(driver, AdminLoginUI.PASSWORD_TEXTBOX, password);
    }
    public String getMessageError(){
        return getTextElement(driver, AdminLoginUI.ERROR_MESSAGE);
    }
    public String getMessageErrorWithUserName(String...value){
        String getMessageE = String.format(AdminLoginPageVerifyData.MESSAGE_USERNAME_NOT_EXIST, (Object[]) value );
        return getMessageE;
    }
    public String getMessageErrorWithWrongPassword(String...value){
        String getMessageE = String.format(AdminLoginPageVerifyData.MESSAGE_PASSWORD_NOT_EXACTLY, (Object[]) value );
        return getMessageE;
    }
    public Boolean isDashboardDisplay(){
        return objectIsDisplayed(driver, AdminDashboardUI.DASHBOARD_TEXT);
    }
}
