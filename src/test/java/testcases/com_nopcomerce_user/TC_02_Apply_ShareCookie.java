package testcases.com_nopcomerce_user;

import actions.common_nopcomerse.TC_01_register_login_cokie;
import actions.commons.BasePage;
import actions.commons.BaseTest;
import actions.pageObjects.pageObjectsUser.HomePage;
import actions.pageObjects.pageObjectsUser.LoginPage;
import actions.pageObjects.pageObjectsUser.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC_02_Apply_ShareCookie extends BaseTest {
    private WebDriver driver;
    private BasePage basePage;
    private BaseTest baseTest;
    private HomePage homePage ;
    private LoginPage loginPage ;
    private RegisterPage registerPage;
    private String invalidEmail = "abc";
    private String wrongEmail ="abcd";

    private String email = BasePage.getBasePageObject().getRandomEmail(); ;

    @BeforeClass
    @Parameters({"browser","url"})
    public void beforeClass(String browser, String url){
        driver = getBrowserDriver(browser, url);
        homePage = new HomePage(driver);
        loginPage = homePage.clickToLoginLink();
        loginPage.setCookies(driver, TC_01_register_login_cokie.loggedCookie);
        System.out.println("In cookie: "+ TC_01_register_login_cokie.loggedCookie);
        loginPage.refreshCurrentPage(driver);
        loginPage.sleepInSecond(10);
    }
    @Test
    public void Login_TC01(){

    }
    @Test
    public void Login_TC02(){

    }
    @Test
    public void Login_TC03(){

    }
    @Test
    public void Login_TC04(){

    }

    @Test
    public void Login_TC05(){

    }
    @Test
    public void Login_TC06(){

    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        closeBrowserDriver();
    }
}
