package testcases.com_nopcomerce_user;

import actions.commons.BasePageFactory;
import actions.pageFactory.HomePageFactory;
import actions.pageFactory.LoginPageFactory;
import actions.pageFactory.RegisterPageFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Test
public class User02_Login_PageFactory {
    private WebDriver driver;
    private BasePageFactory basePage;
    private HomePageFactory homePage ;
    private LoginPageFactory loginPage ;
    private RegisterPageFactory registerPage;
    private String invalidEmail;
    private String wrongEmail ="abcd";

    private String email ;

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        basePage = BasePageFactory.getBasePageObject();
        homePage = new HomePageFactory(driver);
        invalidEmail = basePage.getRandomEmail();
        loginPage = new LoginPageFactory(driver);
        registerPage = new RegisterPageFactory(driver);
        email = homePage.getRandomEmail();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
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
