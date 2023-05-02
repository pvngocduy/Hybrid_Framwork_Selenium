package testcases.com_nopcomerce_user;

import actions.commons.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class User01_Register_Apply_BasePage {
    private WebDriver  driver;
    private BasePage basePage;
    private String email = "abc"+ fakeIntergerNumber() + "@mail.com";
    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        basePage = BasePage.getBasePageObject();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
    }
    @Test
    public void TC_01_Register_Empty_Data(){
        basePage.clickToElement(driver,"//a[@class='ico-register']");
        basePage.clickToElement(driver,"//button[@id='register-button']");
        Assert.assertEquals(basePage.getTextElement(driver,"//span[@id='FirstName-error']"), "First name is required.");
        Assert.assertEquals(basePage.getTextElement(driver,"//span[@id='LastName-error']"), "Last name is required.");
        Assert.assertEquals(basePage.getTextElement(driver,"//span[@id='Email-error']"), "Email is required.");
        Assert.assertEquals(basePage.getTextElement(driver,"//span[@id='Password-error']"), "Password is required.");
        Assert.assertEquals(basePage.getTextElement(driver,"//span[@id='ConfirmPassword-error']"), "Password is required.");
    }
    @Test
    public void TC_02_Register_Invalid_Email(){
        basePage.clickToElement(driver,"//a[@class='ico-register']");
        basePage.sendKeyToElement(driver, "//input[@id='FirstName']","Duy");
        basePage.sendKeyToElement(driver, "//input[@id='LastName']","Pham");
        basePage.sendKeyToElement(driver, "//input[@id='Email']","Duy");
        basePage.sendKeyToElement(driver, "//input[@id='Password']","123456");
        basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']","123456");
        basePage.clickToElement(driver, "//button[@id='register-button']");
        Assert.assertEquals(basePage.getTextElement(driver, "//span[@id='Email-error']"),"Wrong email");
    }
    @Test
    public void TC_03_Register_Success(){
        basePage.clickToElement(driver,"//a[@class='ico-register']");
        basePage.sendKeyToElement(driver, "//input[@id='FirstName']","Duy");
        basePage.sendKeyToElement(driver, "//input[@id='LastName']","Pham");
        basePage.sendKeyToElement(driver, "//input[@id='Email']",email);
        basePage.sendKeyToElement(driver, "//input[@id='Password']","123456");
        basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']","123456");
        basePage.clickToElement(driver, "//button[@id='register-button']");
        Assert.assertEquals(basePage.getTextElement(driver,"//div[@class='result']"),"Your registration completed");
    }
    @Test
    public void TC_04_Register_Existing_Email(){
        basePage.clickToElement(driver,"//a[@class='ico-register']");
        basePage.sendKeyToElement(driver, "//input[@id='FirstName']","Duy");
        basePage.sendKeyToElement(driver, "//input[@id='LastName']","Pham");
        basePage.sendKeyToElement(driver, "//input[@id='Email']","demotest1@gmail.com");
        basePage.sendKeyToElement(driver, "//input[@id='Password']","123456");
        basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']","123456");
        basePage.clickToElement(driver, "//button[@id='register-button']");
        Assert.assertEquals(basePage.getTextElement(driver,"//div[contains(@class, 'message-error')]//li"),"The specified email already exists");
    }
    @Test
    public void TC_05_Register_Password_Less_Than_6_Character(){
        basePage.clickToElement(driver,"//a[@class='ico-register']");
        basePage.sendKeyToElement(driver, "//input[@id='FirstName']","Duy");
        basePage.sendKeyToElement(driver, "//input[@id='LastName']","Pham");
        basePage.sendKeyToElement(driver, "//input[@id='Email']","demotest1@gmail.com");
        basePage.sendKeyToElement(driver, "//input[@id='Password']","12345");
        basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']","12345");
        basePage.clickToElement(driver, "//button[@id='register-button']");
        Assert.assertEquals(basePage.getTextElement(driver,"//span[@id='Password-error']"),"Password must meet the following rules:\n" +
                "must have at least 6 characters");
    }
    @Test
    public void TC_06_Register_Invalid_Password(){
        basePage.clickToElement(driver,"//a[@class='ico-register']");
        basePage.sendKeyToElement(driver, "//input[@id='FirstName']","Duy");
        basePage.sendKeyToElement(driver, "//input[@id='LastName']","Pham");
        basePage.sendKeyToElement(driver, "//input[@id='Email']","demotest1@gmail.com");
        basePage.sendKeyToElement(driver, "//input[@id='Password']","123456");
        basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']","1234567");
        basePage.clickToElement(driver, "//button[@id='register-button']");
        Assert.assertEquals(basePage.getTextElement(driver,"//span[@id='ConfirmPassword-error']"),"The password and confirmation password do not match.");

    }
    public int fakeIntergerNumber (){
        Random rd = new Random();
        return rd.nextInt(9999);
    }
    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
