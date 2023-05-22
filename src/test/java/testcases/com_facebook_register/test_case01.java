package testcases.com_facebook_register;

import actions.commons.BaseTest;
import actions.pageObjects.pageObjectFaceBook.RegisterFb;
import actions.pageObjects.pageObjectJqueryData.HomePageObject;
import interfaces.com_facebook_registerui.RegisterFbUi;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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
    public void TC_01_VerifyConfirmEmailDisplay(){
        register.clickToRegisterLink();
        register.inputToTheEmail();
        verifyTrue(register.isEmailConfirmDisplay());
        register.clearTextInEmail();
        register.sleepInSecond(3);
        verifyFalse(register.isEmailConfirmDisplay());
    }
    @Test
    public void TC_02_VerifyConfirmEmailNotDisplay(){
        register.clickToCloseRegisterPopup();
        register.sleepInSecond(3);
        verifyTrue(register.isElementUndisplayed(driver, RegisterFbUi.CONFIRM_EMAIL_TEXTBOX));
    }
    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
