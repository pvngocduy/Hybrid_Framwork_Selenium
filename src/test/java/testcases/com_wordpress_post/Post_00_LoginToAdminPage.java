package testcases.com_wordpress_post;

import actions.Utils.extentreports.ExtentTestManager;
import actions.commons.BaseTest;
import actions.pageObjects.pageObject_Wordpress_Admin.AdminLoginPageObject;
import actions.pageObjects.pageObject_Wordpress_Admin.PageWPGeneratorManager;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testdata.com_nopcomerce_data.AdminLoginPageVerifyData;

import java.lang.reflect.Method;

public class Post_00_LoginToAdminPage extends BaseTest {
    WebDriver driver;
    AdminLoginPageObject adminLoginPageObject;
    String username = AdminLoginPageVerifyData.LOGIN_USER_NAME;
    String password = AdminLoginPageVerifyData.LOGIN_PASSWORD;
    String userNotExist = "duypvn123";
    String passwordWrong ="1234567";
    @BeforeClass
    @Parameters({"browser","url_admin"})
    public void beforeClass(String browser, String url){
        driver = getBrowserDriver(browser, url);
        adminLoginPageObject = PageWPGeneratorManager.getLoginPageObject(driver);

    }
    @Test
    public void Login_01_Empty_Username(Method method){
        ExtentTestManager.startTest(method.getName(), "Login to Admin Page without data" );
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click to Login");
        adminLoginPageObject.clickToLoginButton();
        Assert.assertEquals(adminLoginPageObject.getMessageError(), AdminLoginPageVerifyData.MESSAGE_ERROR);

    }
    @Test
    public void Login_02_NotExist_Username(Method method){
        ExtentTestManager.startTest(method.getName(), "Login To With Not Exist Email" );
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Input Not Exist Email");
        adminLoginPageObject.inputToPassword(userNotExist);
        adminLoginPageObject.inputToPassword("123456");
        adminLoginPageObject.clickToLoginButton();
        System.out.println(adminLoginPageObject.getMessageErrorWithUserName(userNotExist));
        Assert.assertEquals(adminLoginPageObject.getMessageErrorWithUserName(userNotExist), "Error: The username duypvn123 is not registered on this site. If you are unsure of your username, try your email address instead.");

    }
    @Test
    public void Login_03_WrongPassword(Method method){
        ExtentTestManager.startTest(method.getName(), "Login To With Not Wrong Password" );
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Input UserName and Password");
        adminLoginPageObject.inputToUserName(username);
        adminLoginPageObject.inputToPassword(passwordWrong);
        Assert.assertEquals(adminLoginPageObject.getMessageErrorWithWrongPassword(username), "Error: The password you entered for the username duypvn is incorrect.");
    }
    @Test
    public void Login_04_LoginSucess(Method method){
        ExtentTestManager.startTest(method.getName(), "Login To AdminPage Not Sucess" );
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Input UserName and Password");
        adminLoginPageObject.inputToUserName(username);
        adminLoginPageObject.inputToPassword(password);
        adminLoginPageObject.clickToLoginButton();
        Assert.assertTrue(adminLoginPageObject.isDashboardDisplay());
    }
    @AfterClass(alwaysRun = true)
    public void afterClass() throws InterruptedException {
        Thread.sleep(1000);
        closeBrowserDriver();
    }
}
