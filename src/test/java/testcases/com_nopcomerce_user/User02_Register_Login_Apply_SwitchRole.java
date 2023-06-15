package testcases.com_nopcomerce_user;

import actions.commons.BaseTest;
import actions.Utils.helpers.RecordVideo;
import actions.pageObjects.pageObjectsAdmin.AdminLoginPage;
import actions.pageObjects.pageObjectsAdmin.DashBoardPage;
import actions.pageObjects.pageObjectsUser.HomePage;
import actions.pageObjects.pageObjectsUser.LoginPage;
import actions.pageObjects.pageObjectsUser.PageGeneratorManager;
import actions.pageObjects.pageObjectsUser.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class User02_Register_Login_Apply_SwitchRole extends BaseTest {
    private WebDriver  driver;
    private HomePage homePage ;
    private LoginPage loginPage;
    private RegisterPage registerPage ;

    private AdminLoginPage adminLoginPage;
    private DashBoardPage dashBoardPage;

    @BeforeClass
    public void beforeClass() throws Exception {
        driver = getBrowserDriver("chrome","https://demo.nopcommerce.com/");
        // driver.manage().window().maximize();
        homePage = PageGeneratorManager.getHomePageObject(driver);
        registerPage = homePage.clickToRegisterLink();
        loginPage = registerPage.registerUserPortal();
        RecordVideo.startRecord("ManageDocument");
    }

    @Test
    public void TC_01_Login_Success(){
        homePage.clickToLoginLink();
        homePage = loginPage.userLoginToPortal(registerPage.getEmail(), registerPage.getPassword());
    }
    @Test
    public void switchToAdminPage(){
        adminLoginPage = homePage.switchToAdminPage();
        dashBoardPage = adminLoginPage.loginToAdminPage();
        Assert.assertTrue(dashBoardPage.isDashBoardDisplay());

    }
    @Test
    public void switchToUserPage(){
        homePage = dashBoardPage.switchToUserPage();

    }

    @AfterClass
    public void afterClass() throws Exception {
        Thread.sleep(1000);
        RecordVideo.stopRecord();
        driver.quit();
    }
}
