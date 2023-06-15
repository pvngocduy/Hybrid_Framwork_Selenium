package actions.common_wordpress;

import actions.commons.BaseTest;
import actions.commons.Log;
import actions.pageObjects.pageObject_Wordpress_Admin.AdminDashboardPageObject;
import actions.pageObjects.pageObject_Wordpress_Admin.AdminLoginPageObject;
import actions.pageObjects.pageObject_Wordpress_Admin.PageWPGeneratorManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testdata.com_nopcomerce_data.AdminLoginPageVerifyData;

import java.util.Set;

public class TC_01_wordpress_login_cokie extends BaseTest  {
    private WebDriver driver;
    private AdminLoginPageObject adminLoginPageObject;
    private AdminDashboardPageObject dashBoardPage;
    String username = AdminLoginPageVerifyData.LOGIN_USER_NAME;
    String password = AdminLoginPageVerifyData.LOGIN_PASSWORD;
    public static Set<Cookie> loggedCookie;
    @BeforeTest(alwaysRun = true)
    @Parameters({"browser","url_admin"})
    public void beforeTest(String browser, String url){
        driver = getBrowserDriver(browser,url);
        adminLoginPageObject = PageWPGeneratorManager.getLoginPageObject(driver);
        dashBoardPage = PageWPGeneratorManager.getDashBoardPageObject(driver);
        Log.info("Step1: Login To WP-Admin");
        adminLoginPageObject.inputToUserName(username);
        adminLoginPageObject.inputToPassword(password);
        adminLoginPageObject.clickToLoginButton();
        Assert.assertTrue(adminLoginPageObject.isDashboardDisplay());
        loggedCookie = dashBoardPage.getAllCookies(driver);
        driver.quit();
    }
}
