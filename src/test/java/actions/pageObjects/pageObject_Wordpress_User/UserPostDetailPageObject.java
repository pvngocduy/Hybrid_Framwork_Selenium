package actions.pageObjects.pageObject_Wordpress_User;

import actions.commons.BasePage;
import actions.pageObjects.pageObject_Wordpress_Admin.PageWPGeneratorManager;
import interfaces.pageUI_wordpress_user.UserHomepageUI;
import interfaces.pageUI_wordpress_user.UserPostDetailPageUI;
import org.openqa.selenium.WebDriver;

public class UserPostDetailPageObject extends BasePage {
    WebDriver driver;
    public UserPostDetailPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDisplayTitle(String tilte) {
        waitForElementVisible(driver, UserPostDetailPageUI.USER_POST_TITLE, tilte);
        return objectIsDisplayed(driver, UserPostDetailPageUI.USER_POST_TITLE, tilte);
    }

    public boolean isDisplayAuthor(String author) {
        waitForElementVisible(driver, UserPostDetailPageUI.USER_POST_AUTHOR, author);
        return objectIsDisplayed(driver, UserPostDetailPageUI.USER_POST_AUTHOR,author);
    }

    public boolean isDisplayBody(String title, String body) {
        waitForElementVisible(driver, UserPostDetailPageUI.USER_POST_BODY,title, body);
        return objectIsDisplayed(driver, UserPostDetailPageUI.USER_POST_BODY,title, body);
    }
    public boolean isDisplayPostPublishDay(String title, String daytime) {
        waitForElementVisible(driver, UserPostDetailPageUI.USER_POST_CURRENT_DATE_BY_POST_TITLE,title, daytime);
        return objectIsDisplayed(driver, UserPostDetailPageUI.USER_POST_CURRENT_DATE_BY_POST_TITLE,title, daytime);
    }
    public UserPostDetailPageObject openToPageDetail(String title) {
        clickToElement(driver, UserPostDetailPageUI.USER_POST_TITLE, title );
        return PageWPGeneratorManager.getUserPostDetailPageObject(driver);
    }
}
