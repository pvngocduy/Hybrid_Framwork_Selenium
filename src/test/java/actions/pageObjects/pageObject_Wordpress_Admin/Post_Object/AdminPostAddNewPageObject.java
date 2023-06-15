package actions.pageObjects.pageObject_Wordpress_Admin.Post_Object;

import actions.commons.BasePage;
import actions.pageObjects.pageObject_Wordpress_Admin.PageWPGeneratorManager;
import interfaces.pageUI_wordpress_admin.AdminDashboardUI;
import interfaces.pageUI_wordpress_admin.pageUI_post_object.AdminPostAddNewUI;
import org.openqa.selenium.WebDriver;

public class AdminPostAddNewPageObject extends BasePage {
    WebDriver driver;

    public AdminPostAddNewPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void inputToTheTilte(String title){
        waitForAllElementVisible(driver, AdminPostAddNewUI.TITLE);
        sendKeyToElement(driver, AdminPostAddNewUI.TITLE, title);
    }
    public void inputToTheBody(String body){
        clickToElement(driver,AdminPostAddNewUI.BODY1);
        sendKeyToElement(driver, AdminPostAddNewUI.BODY2, body);
    }
    public void clickToButtonPublish(){
        clickToElement(driver, AdminPostAddNewUI.PUBLISH_BUTTON);
    }
    public void clickToButtonUpdate(){
        clickToElement(driver, AdminPostAddNewUI.UPDATE_BUTTON);
    }
    public Boolean isCreateSuccess(String textSuccess){
        waitForElementVisible(driver,AdminPostAddNewUI.MESSAGE_SUCCESS, textSuccess);
        return objectIsDisplayed(driver,AdminPostAddNewUI.MESSAGE_SUCCESS, textSuccess);
    }
    public AdminPostSearchPageObject  openPostSearchPO(String pageUrl){
        openUrl(driver,pageUrl);
        return PageWPGeneratorManager.getAdminPostSearchPageObject(driver);
    }
    public void editTheTitle(String editTitle){
        waitForAllElementVisible(driver, AdminPostAddNewUI.TITLE);
        clearValueInElementByDeleteKey(driver, AdminPostAddNewUI.TITLE);
        sendKeyToElement(driver, AdminPostAddNewUI.TITLE, editTitle);
    }
    public void editTheBody(String editBody){
        clickToElement(driver,AdminPostAddNewUI.BODY1);
        clearValueInElementByDeleteKey(driver, AdminPostAddNewUI.BODY2);
        sendKeyToElement(driver, AdminPostAddNewUI.BODY2, editBody);
    }
}
