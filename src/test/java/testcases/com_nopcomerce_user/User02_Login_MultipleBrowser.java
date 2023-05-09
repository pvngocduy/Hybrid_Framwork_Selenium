package testcases.com_nopcomerce_user;

import actions.commons.BasePage;
import actions.commons.BaseTest;
import actions.pageObjects.pageObjectsUser.HomePage;
import actions.pageObjects.pageObjectsUser.LoginPage;
import actions.pageObjects.pageObjectsUser.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Test

public class User02_Login_MultipleBrowser extends BaseTest {
    private WebDriver driver;
    private BasePage basePage;
    private HomePage homePage ;
    private LoginPage loginPage ;
    private RegisterPage registerPage;
    private String invalidEmail="111@gmail.com";
    private String wrongEmail ="abcd";

    private String email ;


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browser){
        basePage = BasePage.getBasePageObject();
        invalidEmail = basePage.getRandomEmail();
        driver = getBrowserDriver(browser);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        email = homePage.getRandomEmail();
        homePage.clickToLoginLink();
    }
    public void Login_TC01(){
        System.out.println("Login_TC01");
        loginPage.clickToLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageAtEmail(),"Please enter your email");
    }
    public void Login_TC02(){
        System.out.println("Login_TC02");
        loginPage.inputToTheEmail(wrongEmail);
        loginPage.clickToLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageAtEmail(),"Wrong email");
    }
    public void Login_TC03(){
        System.out.println("Login_TC03");
        loginPage.inputToTheEmail(invalidEmail);
        loginPage.inputToThePassword("123456");
        loginPage.clickToLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageLogin(),"Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found");
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
        Assert.assertEquals(registerPage.getSuccessMessage(),"Your registration completed");
        System.out.println("Login_TC04");
        homePage.clickToLoginLink();
        loginPage.inputToTheEmail(email);
        loginPage.clickToLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageLogin(),"Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect");
    }


    public void Login_TC05(){
        System.out.println("Login_TC05");
        loginPage.inputToTheEmail(email);
        loginPage.inputToThePassword("1234567");
        loginPage.clickToLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageLogin(),"Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect");
    }
    public void Login_TC06(){
        System.out.println("Login_TC06");
        loginPage.inputToTheEmail(email);
        loginPage.inputToThePassword("123456");
        loginPage.clickToLoginButton();
        Assert.assertTrue(homePage.isMyAcountLinkDisplayed());
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
