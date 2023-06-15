package actions.pageObjects.pageObject_Wordpress_Admin;

import actions.pageObjects.pageObject_Wordpress_Admin.Post_Object.AdminPostAddNewPageObject;
import actions.pageObjects.pageObject_Wordpress_Admin.Post_Object.AdminPostSearchPageObject;
import actions.pageObjects.pageObject_Wordpress_Admin.User_Object.AdminUserManagerPageObject;
import actions.pageObjects.pageObject_Wordpress_User.UserHomePageObject;
import actions.pageObjects.pageObject_Wordpress_User.UserPostDetailPageObject;
import actions.pageObjects.pageObjectsAdmin.AdminLoginPage;
import actions.pageObjects.pageObjectsAdmin.DashBoardPage;
import actions.pageObjects.pageObjectsUser.*;
import org.openqa.selenium.WebDriver;

public class PageWPGeneratorManager {
    public static AdminLoginPageObject getLoginPageObject(WebDriver driver){
        return new AdminLoginPageObject(driver);
    }
    public static AdminDashboardPageObject getDashBoardPageObject(WebDriver driver){
        return new AdminDashboardPageObject(driver);
    }
    public static AdminPostSearchPageObject getAdminPostSearchPageObject(WebDriver driver){
        return new AdminPostSearchPageObject(driver);
    }
    public static AdminPostAddNewPageObject getPostAddNewPageObject(WebDriver driver){
        return new AdminPostAddNewPageObject(driver);
    }
    public static UserHomePageObject getUserHomePageObject(WebDriver driver){
        return new UserHomePageObject(driver);
    }
    public static UserPostDetailPageObject getUserPostDetailPageObject(WebDriver driver){
        return new UserPostDetailPageObject(driver);
    }
    public static AdminUserManagerPageObject getUserManager(WebDriver driver){
        return new AdminUserManagerPageObject(driver);
    }
}
