package actions.pageObjects.pageObject_Wordpress_Admin;

import actions.commons.BasePage;
import actions.pageObjects.pageObject_Wordpress_Admin.Post_Object.AdminPostSearchPageObject;
import actions.pageObjects.pageObject_Wordpress_Admin.User_Object.AdminUserManagerPageObject;
import interfaces.pageUI_wordpress_admin.pageUI_post_object.AdminPostAddNewUI;
import org.openqa.selenium.WebDriver;

public class AdminDashboardPageObject extends BasePage {
    WebDriver driver;
    public AdminDashboardPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public AdminPostSearchPageObject clickToPostSearchPO(){
        clickToElement(driver, AdminPostAddNewUI.POST_MENU);
        return PageWPGeneratorManager.getAdminPostSearchPageObject(driver);
    }
    public AdminUserManagerPageObject clickToUser(){
        clickToElement(driver, AdminPostAddNewUI.POST_MENU);
        return PageWPGeneratorManager.getUserManager(driver);
    }
}
