package actions.pageObjects.pageObject_Wordpress_User;

import actions.commons.BasePage;
import actions.pageObjects.pageObject_Wordpress_Admin.PageWPGeneratorManager;
import interfaces.pageUI_wordpress_user.UserHomepageUI;
import org.openqa.selenium.WebDriver;

public class UserHomePageObject extends BasePage {
    WebDriver driver;

    public UserHomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDisplayTitle(String tilte) {
        waitForElementVisible(driver, UserHomepageUI.USER_POST_TITLE, tilte);
        return objectIsDisplayed(driver, UserHomepageUI.USER_POST_TITLE, tilte);
    }

    public boolean isDisplayAuthor(String title,String author) {
        waitForElementVisible(driver, UserHomepageUI.USER_POST_AUTHOR,title, author);
        return objectIsDisplayed(driver, UserHomepageUI.USER_POST_AUTHOR,title, author);
    }

    public boolean isDisplayBody(String title, String body) {
        waitForElementVisible(driver, UserHomepageUI.USER_POST_BODY,title, body);
        return objectIsDisplayed(driver, UserHomepageUI.USER_POST_BODY,title, body);
    }

    public UserPostDetailPageObject openToPageDetail(String title) {
        clickToElement(driver, UserHomepageUI.USER_POST_TITLE, title );
        return PageWPGeneratorManager.getUserPostDetailPageObject(driver);
    }

    public boolean isDisplayPublishDay(String title,String daytime) {
        waitForElementVisible(driver, UserHomepageUI.USER_POST_CURRENT_DATE_BY_POST_TITLE,title, daytime);
        return objectIsDisplayed(driver, UserHomepageUI.USER_POST_CURRENT_DATE_BY_POST_TITLE,title, daytime);
    }
    public void inputToTheSearchBox(String title){
        waitForElementVisible(driver, UserHomepageUI.USER_SEARCH_POST);
        sendKeyToElement(driver, UserHomepageUI.USER_SEARCH_POST, title);
    }
    public void clickToTheSearchButton(){
        waitForElementClickable(driver, UserHomepageUI.USER_SEARCH_BUTTON);
        clickToElement(driver, UserHomepageUI.USER_SEARCH_BUTTON);
    }
    public void searchPostByTitle(String title){
        inputToTheSearchBox(title);
        clickToTheSearchButton();
    }
}
