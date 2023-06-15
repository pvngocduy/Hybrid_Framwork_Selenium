package testcases.com_nopcomerce_user;

import actions.Utils.extentreports.ExtentTestManager;
import actions.commons.BasePage;
import actions.commons.BaseTest;
import actions.commons.Log;
import actions.pageObjects.pageObjectsUser.HomePage;
import actions.pageObjects.pageObjectsUser.LoginPage;
import actions.pageObjects.pageObjectsUser.RegisterPage;
import com.aventstack.extentreports.Status;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Test

public class User02_Login_Allure_Report extends BaseTest {
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
        loginPage = new LoginPage(driver);
    }
    @Step("Login without enter email")
    public void Login_TC01(Method method){
        ExtentTestManager.startTest(method.getName(), "Login without no input data" );
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click to Login link");
        homePage.clickToLoginLink();
        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click to Login Button");
        Log.info("TC01-Login-Step1: Click to Login");
        loginPage.clickToLoginButton();
        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Verify message");
        Log.info("TC01-Login-Step2: Verify mesage");
        Assert.assertEquals(loginPage.getErrorMessageAtEmail(),"Please enter your email");
    }
    @Step("Login enter wrong email")
    public void Login_TC02(Method method){
        ExtentTestManager.startTest(method.getName(), "Login enter wrong email" );
        ExtentTestManager.getTest().log(Status.INFO, "Step1: Enter wrong email: "+wrongEmail);
        Log.info("TC02-Login with wrong email -Step1: Enter wrong email: "+wrongEmail);
        loginPage.inputToTheEmail(wrongEmail);
        ExtentTestManager.getTest().log(Status.INFO, "Step2: Click to Login");
        Log.info("TC02-Login-Step2: Click to Login");
        loginPage.clickToLoginButton();
        Log.info("TC02-Login-Step3: Verify message");
        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Verify message");
        Assert.assertEquals(loginPage.getErrorMessageAtEmail(),"Wrong email");
    }
    @Step("Login enter valid email")
    public void Login_TC03(Method method){
        ExtentTestManager.startTest(method.getName(), "Login enter valid email" );
        Log.info("TC03-Login-Step1: input valid email: "+invalidEmail);
        loginPage.inputToTheEmail(invalidEmail);
        Log.info("TC03-Login-Step2: input password");
        loginPage.inputToThePassword("123456");
        Log.info("TC03-Login-Step3: Click to Login");
        loginPage.clickToLoginButton();
        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Verify message");
        Log.info("TC03-Login-Step4: Verify message");
       // checkEquals(loginPage.getErrorMessageLogin(),"Login was unsuccessful. Please correct the errors and try again. No customer account found");
        Assert.assertEquals(loginPage.getErrorMessageLogin(),"Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found");
    }
    @Step("Login incorrect infor")
    public void Login_TC04(Method method){
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
        Log.info("Login_TC04");
        homePage.clickToLoginLink();
        loginPage.inputToTheEmail(email);
        loginPage.clickToLoginButton();
        ExtentTestManager.getTest().log(Status.INFO, "Step 05: Verify message");
        Assert.assertEquals(loginPage.getErrorMessageLogin(),"Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect");
    }

    @Step("Login Login was unsuccessful")
    public void Login_TC05(Method method){
        ExtentTestManager.getTest().log(Status.INFO, "Step1: Input email: "+email);
        Log.info("TC05-Login-Step1: Input email: "+email);
        loginPage.inputToTheEmail(email);
        ExtentTestManager.getTest().log(Status.INFO, "Step2: Input password");
        Log.info("TC05-Login-Step2: Input password");
        loginPage.inputToThePassword("1234567");
        ExtentTestManager.getTest().log(Status.INFO, "Step3: Click to Login");
        Log.info("TC05-Login-Step3: Click to Login");
        loginPage.clickToLoginButton();
        ExtentTestManager.getTest().log(Status.INFO, "Step4: Verify message");
        Log.info("TC05-Login-Step4: Verify message");
        ExtentTestManager.getTest().log(Status.INFO, "Step 05: Verify message");
        Assert.assertEquals(loginPage.getErrorMessageLogin(),"Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect");
    }
    @Step("Login Login was successful")
    public void Login_TC06(Method method){
        Log.info("TC06-Login-Step1: Input email: "+email);
        ExtentTestManager.getTest().log(Status.INFO, "Step1: Input email: "+email);
        loginPage.inputToTheEmail(email);
        Log.info("TC06-Login-Step2: Input password");
        ExtentTestManager.getTest().log(Status.INFO, "Step2: Input password");
        loginPage.inputToThePassword("123456");
        Log.info("TC06-Login-Step3: Click to Login");
        ExtentTestManager.getTest().log(Status.INFO, "Step3: Click to Login");
        loginPage.clickToLoginButton();
        Log.info("TC06-Login-Step4: Verify message");
        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Verify user login success");
        Assert.assertTrue(homePage.isMyAcountLinkDisplayed());
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
