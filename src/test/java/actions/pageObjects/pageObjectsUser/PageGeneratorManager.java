package actions.pageObjects.pageObjectsUser;

import actions.pageObjects.pageObjectsAdmin.AdminLoginPage;
import actions.pageObjects.pageObjectsAdmin.DashBoardPage;
import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    public static HomePage getHomePageObject(WebDriver driver){
        return new HomePage(driver);
    }
    public static LoginPage getLoginPageObject(WebDriver driver){
        return new LoginPage(driver);
    }
    public static RegisterPage getRegisterPageObject(WebDriver driver){
        return new RegisterPage(driver);
    }
    public static MyAccountPage getMyAccountPageObject(WebDriver driver){
        return new MyAccountPage(driver);
    }

    public static DashBoardPage getDashBoardPageObject(WebDriver driver) {
        return new DashBoardPage(driver);
    }
    public static AdminLoginPage getAdminLoginPage(WebDriver driver) {
        return new AdminLoginPage(driver);
    }
}
