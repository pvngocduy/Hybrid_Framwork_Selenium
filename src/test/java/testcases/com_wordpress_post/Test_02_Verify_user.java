package testcases.com_wordpress_post;

import actions.commons.BaseTest;
import actions.commons.Log;
import actions.pageObjects.pageObject_Wordpress_Admin.AdminDashboardPageObject;
import actions.pageObjects.pageObject_Wordpress_Admin.AdminLoginPageObject;
import actions.pageObjects.pageObject_Wordpress_Admin.PageWPGeneratorManager;
import actions.pageObjects.pageObject_Wordpress_Admin.User_Object.AdminUserManagerPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testdata.com_nopcomerce_data.AdminLoginPageVerifyData;

import java.sql.SQLException;

public class Test_02_Verify_user extends BaseTest {
    WebDriver driver;
    AdminLoginPageObject adminLoginPageObject;
    AdminDashboardPageObject adminDashboardPageObject;
    AdminUserManagerPageObject adminUserManagerPageObject;
    String username = AdminLoginPageVerifyData.LOGIN_USER_NAME;
    String password = AdminLoginPageVerifyData.LOGIN_PASSWORD;
    @BeforeClass
    @Parameters({"browser","url_admin", "url_user"})
    public void beforeClass(String browser, String url_admin, String url_user){
        driver = getBrowserDriver(browser, url_admin);
        adminLoginPageObject = PageWPGeneratorManager.getLoginPageObject(driver);
        Log.info("Precondition - Step1: Login To WP-Admin");
        adminLoginPageObject.inputToUserName(username);
        adminLoginPageObject.inputToPassword(password);
        Log.info("Precondition - Step2: Login with username: "+username+" and password: "+password);
        adminDashboardPageObject = adminLoginPageObject.clickToLoginButton();
        Log.info("Precondition - Step3: Verify Login Success");
        Assert.assertTrue(adminLoginPageObject.isDashboardDisplay());
    }
    @Test
    public void User_01_Verify_Number_User() throws SQLException {
        adminUserManagerPageObject = PageWPGeneratorManager.getUserManager(driver);
        System.out.println("Total user in DB: "+adminUserManagerPageObject.getTotalUserInDB());
        System.out.println("Total user:"+adminUserManagerPageObject.getTotalUser());
        Assert.assertEquals(adminUserManagerPageObject.getTotalUserInDB(),adminUserManagerPageObject.getTotalUser());
    }
    @AfterClass(alwaysRun = true)
    public void afterClass() throws InterruptedException {
        Thread.sleep(1000);
        closeBrowserDriver();
    }
}
