package testcases.com_nopcomerce_user;

import actions.Utils.extentreports.ExtentTestManager;
import actions.commons.BasePage;
import actions.commons.BaseTest;
import actions.pageObjects.pageObjectFaceBook.RegisterFb;
import actions.pageObjects.pageObjectsUser.HomePage;
import actions.pageObjects.pageObjectsUser.PageGeneratorManager;
import actions.pageObjects.pageObjectsUser.RegisterPage;
import com.aventstack.extentreports.Status;
import interfaces.com_facebook_registerui.RegisterFbUi;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class User03_ApplyPatternObject extends BaseTest {
    WebDriver driver;
    HomePage homePage;
    RegisterPage register;
    private String email = BasePage.getBasePageObject().getRandomEmail();
    private String password = "123456";
    private String firstName ="Duy";
    private String lastName = "Pham";
    @BeforeClass
    @Parameters({"browser","url"})
    public void beforeClass(String browser, String url){
        driver = getBrowserDriver(browser, url);
        homePage = PageGeneratorManager.getHomePageObject(driver);
        register = PageGeneratorManager.getRegisterPageObject(driver);

    }
    @Test
    public void TC_01_VerifyConfirmEmailDisplay(Method method){
        ExtentTestManager.startTest(method.getName(), "Register account on Nopcomerse" );
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click to register link");
        register.clickToElementByName(driver, "Register");
        register.clickToRadioButtonByName(driver,"Male");
        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Input First Name");
        register.inputToTextBoxById(driver, "FirstName", firstName);
        ExtentTestManager.getTest().log(Status.INFO,"Step 03: Input Last Name");
        register.inputToTextBoxById(driver,"LastName", lastName);
        register.selectDropdownByName(driver, "DateOfBirthDay", "27");
        register.selectDropdownByName(driver, "DateOfBirthMonth", "November");
        register.selectDropdownByName(driver, "DateOfBirthYear", "1996");
        ExtentTestManager.getTest().log(Status.INFO,"Step 04: Input Email");
        register.inputToTextBoxById(driver,"Email", email);
        register.clickToCheckboxByName(driver,"Newsletter");
        ExtentTestManager.getTest().log(Status.INFO,"Step 05: Input Password");
        register.inputToTextBoxById(driver,"Password", password);
        ExtentTestManager.getTest().log(Status.INFO,"Step 06: Input Confirm Password");
        register.inputToTextBoxById(driver,"ConfirmPassword", password);
        ExtentTestManager.getTest().log(Status.INFO,"Step 07: Click to Register button");
        register.sleepInSecond(3);
        register.clickToButtonByName(driver,"Register");
        ExtentTestManager.getTest().log(Status.INFO,"Step 08: Verify Register Success");
        Assert.assertEquals(register.getSuccessMessage(),"Your registration completed");
    }
    @Test
    public void TC_02_Login(Method method){
        ExtentTestManager.startTest(method.getName(), "Login To Nopcomerse" );
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click to login link");
        homePage.clickToElementByName(driver, "Log in");
        ExtentTestManager.getTest().log(Status.INFO,"Step 02: Input Email");
        homePage.inputToTextBoxById(driver,"Email", email);
        ExtentTestManager.getTest().log(Status.INFO,"Step 03: Input Password");
        homePage.inputToTextBoxById(driver,"Password", password);
        ExtentTestManager.getTest().log(Status.INFO,"Step 04: Click to Login button");
        homePage.sleepInSecond(3);
        homePage.clickToButtonByName(driver,"Log in");
        ExtentTestManager.getTest().log(Status.INFO,"Step 05: Verify Register Success");
        Assert.assertTrue(homePage.isMyAcountLinkDisplayed());
    }
    @Test
    public void TC_03_VerifyInfo(Method method){
        ExtentTestManager.startTest(method.getName(), "Verify Info" );
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click to My account link");
        homePage.clickToElementByName(driver, "My account");
        ExtentTestManager.getTest().log(Status.INFO,"Step 02: Verify First name");
        Assert.assertEquals((homePage.getTextBoxVauleById(driver,"FirstName")), firstName);
        ExtentTestManager.getTest().log(Status.INFO,"Step 03: Verify Last name");
        Assert.assertEquals((homePage.getTextBoxVauleById(driver,"LastName")), lastName);
        ExtentTestManager.getTest().log(Status.INFO,"Step 04: Verify Email");
        Assert.assertEquals((homePage.getTextBoxVauleById(driver, "Email")), email);
    }
    @AfterClass(alwaysRun = true)
    public void afterClass() throws InterruptedException {
        Thread.sleep(1000);
        closeBrowserDriver();
    }
}
