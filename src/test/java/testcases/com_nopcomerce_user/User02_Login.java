package testcases.com_nopcomerce_user;

import actions.commons.BasePage;
import actions.commons.BaseTest;
import actions.commons.Log;
import actions.pageObjects.pageObjectsUser.HomePage;
import actions.pageObjects.pageObjectsUser.LoginPage;
import actions.pageObjects.pageObjectsUser.RegisterPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

@Test

public class User02_Login extends BaseTest {
    private WebDriver driver;
    private BasePage basePage;
    private BaseTest baseTest;
    private HomePage homePage ;
    private LoginPage loginPage ;
    private RegisterPage registerPage;
    private String invalidEmail = "abc";
    private String wrongEmail ="abcd";

    private String email = BasePage.getBasePageObject().getRandomEmail();

    @BeforeClass
    @Parameters({"browser","url"})
    public void beforeClass(String browser, String url){
        driver = getBrowserDriver(browser, url);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }
    public void Login_TC01(){
        homePage.clickToLoginLink();
        Log.info("TC01-Login-Step1: Click to Login");
        loginPage.clickToLoginButton();
        Log.info("TC01-Login-Step2: Verify mesage");
        checkEquals(loginPage.getErrorMessageAtEmail(),"Please enter your email");
    }
    public void Login_TC02(){
        Log.info("TC02-Login with wrong email -Step1: Enter wrong email: "+wrongEmail);
        loginPage.inputToTheEmail(wrongEmail);
        Log.info("TC02-Login-Step2: Click to Login");
        loginPage.clickToLoginButton();
        Log.info("TC02-Login-Step3: Verify message");
        checkEquals(loginPage.getErrorMessageAtEmail(),"Wrong email");
    }
    public void Login_TC03(){
        Log.info("TC03-Login-Step1: input valid email: "+invalidEmail);
        loginPage.inputToTheEmail(invalidEmail);
        Log.info("TC03-Login-Step2: input password");
        loginPage.inputToThePassword("123456");
        Log.info("TC03-Login-Step3: Click to Login");
        loginPage.clickToLoginButton();
        Log.info("TC03-Login-Step4: Verify message");
       // checkEquals(loginPage.getErrorMessageLogin(),"Login was unsuccessful. Please correct the errors and try again. No customer account found");
        verifyEquals(loginPage.getErrorMessageLogin(),"Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found");
    }
    public void Login_TC04(){
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
        verifyEquals(loginPage.getErrorMessageLogin(),"Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect");
    }


    public void Login_TC05(){
        System.out.println("Login_TC05");
        Log.info("TC05-Login-Step1: Input email: "+email);
        loginPage.inputToTheEmail(email);
        Log.info("TC05-Login-Step2: Input password");
        loginPage.inputToThePassword("1234567");
        Log.info("TC05-Login-Step3: Click to Login");
        loginPage.clickToLoginButton();
        Log.info("TC05-Login-Step4: Verify message");
        verifyEquals(loginPage.getErrorMessageLogin(),"Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect");
    }
    public void Login_TC06(){
        Log.info("TC06-Login-Step1: Input email: "+email);
        loginPage.inputToTheEmail(email);
        Log.info("TC06-Login-Step2: Input password");
        loginPage.inputToThePassword("123456");
        Log.info("TC06-Login-Step3: Click to Login");
        loginPage.clickToLoginButton();
        Log.info("TC06-Login-Step4: Verify message");
        verifyTrue(homePage.isMyAcountLinkDisplayed());
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
