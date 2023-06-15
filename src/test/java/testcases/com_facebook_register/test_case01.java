package testcases.com_facebook_register;

import actions.commons.BaseTest;
import actions.pageObjects.pageObjectFaceBook.RegisterFb;
import actions.Utils.extentreports.ExtentTestManager;
import com.aventstack.extentreports.Status;
import interfaces.com_facebook_registerui.RegisterFbUi;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class test_case01 extends BaseTest {
    WebDriver driver;
    RegisterFb register;
    @BeforeClass
    @Parameters({"browser","url"})
    public void beforeClass(String browser, String url){
        driver = getBrowserDriver(browser, url);
        register = new RegisterFb(driver);
    }
    @Test
    public void TC_01_VerifyConfirmEmailDisplay(Method method){
        ExtentTestManager.startTest(method.getName(), "Verify confirm email textbox display" );
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click to register link");
        register.clickToRegisterLink();
        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Input Email");
        register.inputToTheEmail();
        ExtentTestManager.getTest().log(Status.INFO,"Step 03: Verify Confirm Email Display");
        verifyTrue(register.isEmailConfirmDisplay());
        ExtentTestManager.getTest().log(Status.INFO,"Step 04: Clear text in Confirm Email Textbox");
        register.clearTextInEmail();
        register.sleepInSecond(3);
        ExtentTestManager.getTest().log(Status.INFO,"Step 05: Verify Confirm Email Textbox not display");
        //verifyFalse(register.isEmailConfirmDisplay());
        Assert.assertFalse(register.isEmailConfirmDisplay());
    }
    @Test
    public void TC_02_VerifyConfirmEmailNotDisplay(Method method){
        ExtentTestManager.startTest(method.getName(), "Verify confirm email textbox display" );
        ExtentTestManager.getTest().log(Status.INFO,"TC_02: Click to close popup register");
        register.clickToCloseRegisterPopup();
        register.sleepInSecond(3);
        ExtentTestManager.getTest().log(Status.INFO,"TC_02: Verify Confirm Email Textbox not display");
       // verifyTrue(register.isElementUndisplayed(driver, RegisterFbUi.CONFIRM_EMAIL_TEXTBOX));
        //verifyFalse(register.isElementUndisplayed(driver, RegisterFbUi.CONFIRM_EMAIL_TEXTBOX));
        Assert.assertFalse(register.isElementUndisplayed(driver, RegisterFbUi.CONFIRM_EMAIL_TEXTBOX));
    }
    @AfterClass(alwaysRun = true)
    public void afterClass() throws InterruptedException {
        Thread.sleep(1000);
        closeBrowserDriver();
    }
}
