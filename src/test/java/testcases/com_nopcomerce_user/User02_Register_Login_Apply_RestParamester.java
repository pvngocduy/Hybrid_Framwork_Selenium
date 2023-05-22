package testcases.com_nopcomerce_user;

import actions.commons.BasePage;
import actions.commons.BaseTest;
import actions.pageObjects.pageObjectsUser.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class User02_Register_Login_Apply_RestParamester extends BaseTest {
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
    private DownloadableProductPage downloadableProductPage;

    private OrdersPage ordersPage;
    private RewardPointPage rewardPointPage;
    private StockSubcriptionPage stockSubcriptionPage;

    @BeforeClass
    public void beforeClass(){
        driver = getBrowserDriver("chrome", "https://demo.nopcommerce.com/");
        basePage = BasePage.getBasePageObject();
        email =  basePage.getRandomEmail();
        homePage = PageGeneratorManager.getHomePageObject(driver);
        driver.manage().window().maximize();
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
        customerInforPage = (CustomerInforPage) basePage.openMyAccountPageByName(driver,"Customer info");
        addressesPage = (AddressesPage) basePage.openMyAccountPageByName(driver,"Addresses");
        changePasswordPage = (ChangePasswordPage) basePage.openMyAccountPageByName(driver,"Change password");
        downloadableProductPage = (DownloadableProductPage) basePage.openMyAccountPageByName(driver,"Downloadable products");
        myProductReviewPage = (MyProductReviewPage) basePage.openMyAccountPageByName(driver,"My product reviews");
        ordersPage = (OrdersPage) basePage.openMyAccountPageByName(driver,"Orders");
        rewardPointPage = (RewardPointPage) basePage.openMyAccountPageByName(driver,"Reward points");
        stockSubcriptionPage = (StockSubcriptionPage) basePage.openMyAccountPageByName(driver,"Back in stock subscriptions");
    }
    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
