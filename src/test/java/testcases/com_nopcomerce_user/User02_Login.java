package testcases.com_nopcomerce_user;

import actions.commons.BasePage;
import actions.commons.BaseTest;
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
    private HomePage homePage ;
    private LoginPage loginPage ;
    private RegisterPage registerPage;
    private String invalidEmail;
    private String wrongEmail ="abcd";

    private String email ;

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        basePage = BasePage.getBasePageObject();
        homePage = new HomePage(driver);
        invalidEmail = basePage.getRandomEmail();
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        email = homePage.getRandomEmail();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
        homePage.clickToLoginLink();
    }
    public void Login_TC01(){
        System.out.println("Login_TC01");
        log.info("TC01-Login-Step1: Click to Login");
        loginPage.clickToLoginButton();
        log.info("TC01-Login-Step2: Verify mesage");
        checkEquals(loginPage.getErrorMessageAtEmail(),"Please enter your email");
    }
    public void Login_TC02(){
        System.out.println("Login_TC02");
        log.info("TC02-Login with wrong email -Step1: Enter wrong email: "+wrongEmail);
        loginPage.inputToTheEmail(wrongEmail);
        log.info("TC02-Login-Step2: Click to Login");
        loginPage.clickToLoginButton();
        log.info("TC02-Login-Step3: Verify message");
        checkEquals(loginPage.getErrorMessageAtEmail(),"Wrong email");
    }
    public void Login_TC03(){
        System.out.println("Login_TC03");
        log.info("TC03-Login-Step1: input valid email: "+invalidEmail);
        loginPage.inputToTheEmail(invalidEmail);
        log.info("TC03-Login-Step2: input password");
        loginPage.inputToThePassword("123456");
        log.info("TC03-Login-Step3: Click to Login");
        loginPage.clickToLoginButton();
        log.info("TC03-Login-Step4: Verify message");
       // checkEquals(loginPage.getErrorMessageLogin(),"Login was unsuccessful. Please correct the errors and try again. No customer account found");
        verifyEquals(loginPage.getErrorMessageLogin(),"Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found11111");
    }
    public void Login_TC04(){
        System.out.println("Precondition Create Account");
        System.out.println("Step1: HomePageFactory - Click To Register Page");
        //basePage.clickToElement(driver,"//a[@class='ico-register']");
        homePage.clickToRegisterLink();
        System.out.println("Step2: Input to require field");
        registerPage.inputToTheFirstName("Duy");
        registerPage.inputToTheLastName("Pham");
        registerPage.inputToTheEmail(email);
        registerPage.inputToThePassword("123456");
        registerPage.inputToTheConfirmPassword("123456");
        registerPage.clickToRegisterButton();
        System.out.println("Step3: Verify registration completed");
        checkEquals(registerPage.getSuccessMessage(),"Your registration completed");
        System.out.println("Login_TC04");
        homePage.clickToLoginLink();
        loginPage.inputToTheEmail(email);
        loginPage.clickToLoginButton();
        verifyEquals(loginPage.getErrorMessageLogin(),"Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect");
    }


    public void Login_TC05(){
        System.out.println("Login_TC05");
        log.info("TC05-Login-Step1: Input email: "+email);
        loginPage.inputToTheEmail(email);
        log.info("TC05-Login-Step2: Input password");
        loginPage.inputToThePassword("1234567");
        log.info("TC05-Login-Step3: Click to Login");
        loginPage.clickToLoginButton();
        log.info("TC05-Login-Step4: Verify message");
        verifyEquals(loginPage.getErrorMessageLogin(),"Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect");
    }
    public void Login_TC06(){
        System.out.println("Login_TC06");
        log.info("TC06-Login-Step1: Input email: "+email);
        loginPage.inputToTheEmail(email);
        log.info("TC06-Login-Step2: Input password");
        loginPage.inputToThePassword("123456");
        log.info("TC06-Login-Step3: Click to Login");
        loginPage.clickToLoginButton();
        log.info("TC06-Login-Step4: Verify message");
        verifyTrue(homePage.isMyAcountLinkDisplayed());
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
