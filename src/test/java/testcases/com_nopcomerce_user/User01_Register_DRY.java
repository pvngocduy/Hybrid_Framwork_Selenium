package testcases.com_nopcomerce_user;

import actions.commons.BasePage;
import actions.commons.GlobalConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class User01_Register_DRY  {
    private WebDriver  driver;
    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
    }
    @Test
    public void TC_01_Register_Empty_Data(){
        driver.findElement(By.cssSelector("a.ico-register")).click();
        driver.findElement(By.id("register-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("span#FirstName-error")).getText(), "First name is required.");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#LastName-error")).getText(), "Last name is required.");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Email is required.");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(), "Password is required.");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(), "Password is required.");
    }
    @Test
    public void TC_02_Register_Invalid_Email(){
        driver.findElement(By.cssSelector("a.ico-register")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Duy");
        driver.findElement(By.id("LastName")).sendKeys("Pham");
        driver.findElement(By.id("Email")).sendKeys("demotest");
        driver.findElement(By.id("Password")).sendKeys("June@2019");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("June@2019");
        driver.findElement(By.id("register-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("#Email-error")).getText(),"Wrong email");
    }
    @Test
    public void TC_03_Register_Success(){
        driver.findElement(By.cssSelector("a.ico-register")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Duy");
        driver.findElement(By.id("LastName")).sendKeys("Pham");
        driver.findElement(By.id("Email")).sendKeys("demotest1@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("June@2019");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("June@2019");
        driver.findElement(By.id("register-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector(".result")).getText(),"Your registration completed");
    }
    @Test
    public void TC_04_Register_Existing_Email(){
        driver.findElement(By.cssSelector("a.ico-register")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Duy");
        driver.findElement(By.id("LastName")).sendKeys("Pham");
        driver.findElement(By.id("Email")).sendKeys("demotest@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("June@2019");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("June@2019");
        driver.findElement(By.id("register-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector(".message-error")).getText(),"The specified email already exists");
    }
    @Test
    public void TC_05_Register_Password_Less_Than_6_Character(){
        driver.findElement(By.cssSelector("a.ico-register")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Duy");
        driver.findElement(By.id("LastName")).sendKeys("Pham");
        driver.findElement(By.id("Email")).sendKeys("demotest@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("June@");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("June@");
        Assert.assertEquals(driver.findElement(By.cssSelector("#Password-error")).getText(),"Password must meet the following rules:\n" +
                "must have at least 6 characters");
    }
    @Test
    public void TC_06_Register_Invalid_Password(){
        driver.findElement(By.cssSelector("a.ico-register")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Duy");
        driver.findElement(By.id("LastName")).sendKeys("Pham");
        driver.findElement(By.id("Email")).sendKeys("demotest@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("June@2019");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("June@019");
        driver.findElement(By.id("register-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("#ConfirmPassword-error")).getText(),"The password and confirmation password do not match.");

    }
//    @Test
//    public void TC08(){
//        String[] fileName = {"CSharp.png","Java.png", "Python.png"};
//        String filePath = GlobalConstant.UPLOADFILE;
//        String fullFileName = "";
//        for(String file: fileName){
//            fullFileName = fullFileName + filePath + file + "\n";
//        }
//        fullFileName = fullFileName.trim();
//        System.out.println(fullFileName);
//    }
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
