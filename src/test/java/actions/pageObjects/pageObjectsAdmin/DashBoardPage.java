package actions.pageObjects.pageObjectsAdmin;

import actions.commons.BasePage;
import actions.pageObjects.pageObjectsUser.HomePage;
import actions.pageObjects.pageObjectsUser.PageGeneratorManager;
import interfaces.commonUI.BasePageUI;
import interfaces.pageAdminUI.DashBoardUI;
import org.openqa.selenium.WebDriver;

public class DashBoardPage extends BasePage {
    private WebDriver driver;

    public DashBoardPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isDashBoardDisplay(){
        return objectIsDisplayed(driver, DashBoardUI.DASHBOARD_TITLE);
    }
    public HomePage switchToUserPage(){
        openUrl(driver, BasePageUI.PORTAL_LINK);
        return PageGeneratorManager.getHomePageObject(driver);
    }
}
