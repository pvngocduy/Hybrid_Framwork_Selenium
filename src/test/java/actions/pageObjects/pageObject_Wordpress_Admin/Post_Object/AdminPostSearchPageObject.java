package actions.pageObjects.pageObject_Wordpress_Admin.Post_Object;

import actions.commons.BasePage;
import actions.pageObjects.pageObject_Wordpress_Admin.PageWPGeneratorManager;
import interfaces.pageUI_wordpress_admin.pageUI_post_object.AdminPostSearchUI;
import interfaces.pageUI_wordpress_user.UserHomepageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AdminPostSearchPageObject extends BasePage {
    WebDriver driver;
    public AdminPostSearchPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public AdminPostAddNewPageObject clickToAdminPostAddNewPO(){
        clickToElement(driver, AdminPostSearchUI.ADD_NEW);
        return PageWPGeneratorManager.getPostAddNewPageObject(driver);
    }
    public String getPostSearchUrl(){
        return driver.getCurrentUrl();
    }

    public void inputToTheSearchBox(String tilte) {
        waitForElementVisible(driver, AdminPostSearchUI.SEARCH_POST_INPUT);
        sendKeyToElement(driver, AdminPostSearchUI.SEARCH_POST_INPUT, tilte);
    }
    public void clickToTheSearchBtn(){
        clickToElement(driver, AdminPostSearchUI.SEARCH_POST_BUTTON);
    }
    public void searchByTitle(String tilte){
        inputToTheSearchBox(tilte);
        clickToTheSearchBtn();
    }
    public boolean isPostSearchTableDisplay(String headerId, String cellValue) {
        int headerIndex = getElementsSize(driver, AdminPostSearchUI.TABLE_HEADER_INDEX_BY_NAME, headerId ) + 1;
        waitForElementVisible(driver, AdminPostSearchUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex), cellValue );
        return objectIsDisplayed(driver,AdminPostSearchUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex), cellValue );
    }
    public void clickToEditPost(String title){
        Actions actions = new Actions(driver);
        WebElement element = getElement(driver, AdminPostSearchUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, "2", title );
        actions.moveToElement(element);
        //WebElement element2 = driver.findElement(By.xpath("//table[contains(@class,'table-view-list posts')]//tbody//tr//*[2]//a[text()='Edit']"));
        actions.moveToElement(getElement(driver, AdminPostSearchUI.EDIT_POST)).click().perform();
    }
    public void clickToTheTrash(String title){
        Actions actions = new Actions(driver);
        WebElement element = getElement(driver, AdminPostSearchUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, "2", title );
        actions.moveToElement(element);
        actions.moveToElement(getElement(driver, AdminPostSearchUI.DELETE_POST)).click().perform();
    }
    public boolean isDisplayMessageDeleteSuccess() {
        waitForElementVisible(driver, AdminPostSearchUI.MOVE_TO_TRASH_SUCCESS_MESSAGE);
        return objectIsDisplayed(driver, AdminPostSearchUI.MOVE_TO_TRASH_SUCCESS_MESSAGE);
    }
    public boolean isPostNotFound() {
        waitForElementVisible(driver, AdminPostSearchUI.TEXT_SEARCH_NOT_FOUND);
        return objectIsDisplayed(driver, AdminPostSearchUI.TEXT_SEARCH_NOT_FOUND);
    }

}
