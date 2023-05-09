package testcases.com_nopcomerce_user;

import actions.commons.BasePage;
import actions.commons.BaseTest;
import actions.pageObjects.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class User02_Register_Login_Apply_Switch_UI extends BaseTest {
    private WebDriver  driver;
    private BasePage basePage;

    private HomePage homePage ;
    private LoginPage loginPage;
    private RegisterPage registerPage ;
    private MyAccountPage myAccountPage;
    private String email;
    private AddressesPage addressesPage;
    private ChangePasswordPage changePasswordPage;
    private CustomerInforPage customerInforPage;
    private MyProductReviewPage myProductReviewPage;

    @BeforeClass
    public void beforeClass(){
        driver = getBrowserDriver("chrome");
        basePage = BasePage.getBasePageObject();
        email =  basePage.getRandomEmail();
        homePage = PageGeneratorManager.getHomePageObject(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
    }

    @Test
    public void TC_01_Register_Success(){
        System.out.println("TC_01_Regis;ter_Success");
        System.out.println("Step1: HomePageFactory - Click To Register Page");
        //basePage.clickToElement(driver,"//a[@class='ico-register']");
        registerPage = homePage.clickToRegisterLink();
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
    public void TC_02_Login_Success(){
        System.out.println("TC_02_Login_Success");
        loginPage = homePage.clickToLoginLink();
        loginPage.inputToTheEmail(email);
        loginPage.inputToThePassword("123456");
        loginPage.clickToLoginButton();
        Assert.assertTrue(homePage.isMyAcountLinkDisplayed());
    }
    @Test
    public void TC_03_SwitchBetweenUI(){
        System.out.println("TC_03_SwitchBetweenUI");
        myAccountPage = homePage.clickToMyAccountLink();
        addressesPage = myAccountPage.openToTheAddressesPage(driver);
        changePasswordPage = addressesPage.openToTheChangePasswordPage(driver);
        customerInforPage = changePasswordPage.openToTheCustomerInfoPage(driver);
    }
    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
