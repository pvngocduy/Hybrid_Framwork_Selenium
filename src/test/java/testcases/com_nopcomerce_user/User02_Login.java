package testcases.com_nopcomerce_user;

import actions.commons.BasePage;
import actions.pageObjects.HomePage;
import actions.pageObjects.LoginPage;
import actions.pageObjects.RegisterPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

@Test
public class User02_Login {
    private WebDriver driver;
    private BasePage basePage;
    private HomePage homePage ;
    private LoginPage loginPage ;
    private String invalidEmail;
    private String wrongEmail ="abcd";
    private String existEmail ="demotest1@gmail.com";

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
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
        homePage.clickToLoginLink();
    }
    public void Login_TC01(){
        loginPage.clickToLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageAtEmail(),"Please enter your email");
    }
    public void Login_TC02(){
        loginPage.inputToTheEmail(wrongEmail);
        loginPage.clickToLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageAtEmail(),"Wrong email");
    }
    public void Login_TC03(){
        loginPage.inputToTheEmail(invalidEmail);
        loginPage.inputToThePassword("123456");
        loginPage.clickToLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageLogin(),"Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found");
    }
    public void Login_TC04(){
        loginPage.inputToTheEmail(existEmail);
        loginPage.clickToLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageLogin(),"Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect");
    }


    public void Login_TC05(){
        loginPage.inputToTheEmail(existEmail);
        loginPage.inputToThePassword("1234567");
        loginPage.clickToLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageLogin(),"Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect");
    }
    public void Login_TC06(){
        loginPage.inputToTheEmail(existEmail);
        loginPage.inputToThePassword("123456");
        loginPage.clickToLoginButton();
        Assert.assertTrue(homePage.isMyAcountLinkDisplayed());
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
