package testcases.com_nopcomerce_user;

import actions.commons.BasePage;
import actions.commons.BaseTest;
import actions.pageObjects.HomePage;
import actions.pageObjects.LoginPage;
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
public class User02_Login_MultipleBrowser extends BaseTest {
    private WebDriver driver;
    private BasePage basePage;
    private HomePage homePage ;
    private LoginPage loginPage ;
    private String invalidEmail;
    private String wrongEmail ="abcd";

    private String existEmail ="abcdef@gmail.com";

    @BeforeClass
    public void beforeClass(){
        basePage = BasePage.getBasePageObject();
        invalidEmail = basePage.getRandomEmail();
        driver = getBrowserDriver("firefox");
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
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
