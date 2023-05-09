package actions.pageObjects;

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

}
