package testcases.com_nopcomerce_user;

import actions.commons.BasePage;
import actions.commons.BaseTest;
import actions.pageObjects.HomePage;
import actions.pageObjects.RegisterPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class User01_Register_Apply_PageObjectModel extends BaseTest {
    private WebDriver  driver;
    private BasePage basePage;

    private HomePage homePage ;
    private RegisterPage registerPage ;
    private String email;
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browser){
        driver = getBrowserDriver(browser);
        basePage = BasePage.getBasePageObject();
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        email =  basePage.getRandomEmail();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
    }
    @Test
    public void TC_01_Register_Empty_Data(){
        System.out.println("TC_01_Register_Empty_Data");
        System.out.println("Step1: HomePageFactory - Click To Register Page");
        homePage.clickToRegisterLink();
        System.out.println("Step2: RegisterPageFactory - Click To Register Button");
        registerPage.clickToRegisterButton();
        System.out.println("Step3: RegisterPageFactory - Verify Message Error");
        Assert.assertEquals(registerPage.getErrorMessageAtFirstName(), "First name is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtLastName(), "Last name is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtEmail(), "Email is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtPassword(), "Password is required.");
        Assert.assertEquals(registerPage.getErrorMessageAtConfirmPassword(), "Password is required.");
    }
    @Test
    public void TC_02_Register_Invalid_Email(){
        System.out.println("TC_02_Register_Invalid_Email");
        System.out.println("Step1: HomePageFactory - Click To Register Page");
        homePage.clickToRegisterLink();
        System.out.println("Step2: Input to require field");
        registerPage.inputToTheFirstName("Duy");
        registerPage.inputToTheLastName("Pham");
        registerPage.inputToTheEmail("Duy");
        registerPage.inputToThePassword("123456");
        registerPage.inputToTheConfirmPassword("123456");
        System.out.println("Step3: Click to register");
        registerPage.clickToRegisterButton();
        System.out.println("Step4: Verify message error: Wrong email");
        Assert.assertEquals(registerPage.getErrorMessageAtEmail(),"Wrong email");
    }
    @Test
    public void TC_03_Register_Success(){
        System.out.println("TC_03_Register_Success");
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
    }
    @Test
    public void TC_04_Register_Existing_Email(){
        System.out.println("TC_04_Register_Existing_Email");
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
        Assert.assertEquals(registerPage.getMessageErrorExistEmail(),"The specified email already exists");
       // Assert.assertEquals(basePage.getTextElement(driver,"//div[contains(@class, 'message-error')]//li"),"The specified email already exists");
    }
    @Test
    public void TC_05_Register_Password_Less_Than_6_Character(){
        System.out.println("TC_05_Register_Password_Less_Than_6_Character");
        System.out.println("Step1: HomePageFactory - Click To Register Page");
        //basePage.clickToElement(driver,"//a[@class='ico-register']");
        homePage.clickToRegisterLink();
        System.out.println("Step2: Input to require field");
        registerPage.inputToTheFirstName("Duy");
        registerPage.inputToTheLastName("Pham");
        registerPage.inputToTheEmail(email);
        registerPage.inputToThePassword("12345");
        registerPage.inputToTheConfirmPassword("12345");
        registerPage.clickToRegisterButton();
        System.out.println("Step3: Verify registration completed");
        Assert.assertEquals(registerPage.getErrorMessageAtPassword(),"Password must meet the following rules:\n" +
                "must have at least 6 characters");
       // Assert.assertEquals(basePage.getTextElement(driver,"//span[@id='Password-error']"),"Password must meet the following rules:\n" +
         //       "must have at least 6 characters");
    }
    @Test
    public void TC_06_Register_Invalid_Password(){
        System.out.println("TC_06_Register_Invalid_Password");
        System.out.println("Step1: HomePageFactory - Click To Register Page");
        //basePage.clickToElement(driver,"//a[@class='ico-register']");
        homePage.clickToRegisterLink();
        System.out.println("Step2: Input to require field");
        registerPage.inputToTheFirstName("Duy");
        registerPage.inputToTheLastName("Pham");
        registerPage.inputToTheEmail(email);
        registerPage.inputToThePassword("123456");
        registerPage.inputToTheConfirmPassword("1234567");
        registerPage.clickToRegisterButton();
        System.out.println("Step3: Verify registration completed");
        Assert.assertEquals(registerPage.getErrorMessageAtConfirmPassword(),"The password and confirmation password do not match.");
       // Assert.assertEquals(basePage.getTextElement(driver,"//span[@id='ConfirmPassword-error']"),"The password and confirmation password do not match.");

    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
