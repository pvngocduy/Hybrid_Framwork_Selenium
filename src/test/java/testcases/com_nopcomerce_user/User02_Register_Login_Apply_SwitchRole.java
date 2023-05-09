package testcases.com_nopcomerce_user;

import actions.commons.BaseTest;
import actions.pageObjects.pageObjectsAdmin.AdminLoginPage;
import actions.pageObjects.pageObjectsAdmin.DashBoardPage;
import actions.pageObjects.pageObjectsUser.HomePage;
import actions.pageObjects.pageObjectsUser.LoginPage;
import actions.pageObjects.pageObjectsUser.PageGeneratorManager;
import actions.pageObjects.pageObjectsUser.RegisterPage;
import interfaces.commonUI.BasePageUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class User02_Register_Login_Apply_SwitchRole extends BaseTest {
    private WebDriver  driver;
    private HomePage homePage ;
    private LoginPage loginPage;
    private RegisterPage registerPage ;

    private AdminLoginPage adminLoginPage;
    private DashBoardPage dashBoardPage;

    @BeforeClass
    public void beforeClass(){
        driver = getBrowserDriver("chrome");
        // driver.manage().window().maximize();
        homePage = PageGeneratorManager.getHomePageObject(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
        registerPage = homePage.clickToRegisterLink();
        loginPage = registerPage.registerUserPortal();
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

    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
