package actions.common_nopcomerse;

import actions.commons.BasePage;
import actions.commons.BaseTest;
import actions.commons.Log;
import actions.pageObjects.pageObjectsUser.HomePage;
import actions.pageObjects.pageObjectsUser.LoginPage;
import actions.pageObjects.pageObjectsUser.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Set;

public class TC_01_register_login_cokie extends BaseTest  {
    private WebDriver driver;
    private HomePage homePage ;
    private LoginPage loginPage ;
    private RegisterPage registerPage;
    private String email = BasePage.getBasePageObject().getRandomEmail();
    public static Set<Cookie> loggedCookie;
    @BeforeClass(alwaysRun = true)
    @Parameters({"browser","url"})
    public void beforeClass(String browser, String url){
        driver = getBrowserDriver(browser,url);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        Log.info("Precondition Create Account");
        Log.info("Step1: HomePageFactory - Click To Register Page");
        //basePage.clickToElement(driver,"//a[@class='ico-register']");
        registerPage = homePage.clickToRegisterLink();
        Log.info("Step2: Input to require field");
        registerPage.inputToTheFirstName("Duy");
        registerPage.inputToTheLastName("Pham");
        registerPage.inputToTheEmail(email);
        registerPage.inputToThePassword("123456");
        registerPage.inputToTheConfirmPassword("123456");
        registerPage.clickToRegisterButton();
        Log.info("Step3: Verify registration completed");
        checkEquals(registerPage.getSuccessMessage(),"Your registration completed");
        driver.findElement(By.xpath("//a[text()='Continue']")).click();
        homePage.clickToLoginLink();
        Log.info("TC06-Login-Step1: Input email: "+email);
        loginPage.inputToTheEmail(email);
        Log.info("TC06-Login-Step2: Input password");
        loginPage.inputToThePassword("123456");
        Log.info("TC06-Login-Step3: Click to Login");
        loginPage.clickToLoginButton();
        Log.info("TC06-Login-Step4: Verify message");
        verifyTrue(homePage.isMyAcountLinkDisplayed());
        loggedCookie = homePage.getAllCookies(driver);
        driver.quit();
    }
    @Test
    public void TC_01(){
        System.out.println("run oll");
    }
}
