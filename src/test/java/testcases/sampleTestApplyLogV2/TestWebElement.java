package testcases.sampleTestApplyLogV2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestWebElement {
    @Test
    public void TC_01_CountTextInTextBox() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.get("https://demo.nopcommerce.com/");
        WebElement form = driver.findElement(By.xpath("//form[@id='small-search-box-form']"));
        WebElement element = form.findElement(By.xpath("//input[@placeholder='Search store']"));
        element.sendKeys("hellovietnam");
        Thread.sleep(5000);
        element.submit();
        Thread.sleep(5000);
    }
    @Test
    public void TC_02_CountTextInTextBox() throws InterruptedException {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.get("https://demo.nopcommerce.com/camera-photo");
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='products-orderby']"));
        Select select = new Select(dropdown);
        select.selectByValue("5");
        select.selectByVisibleText("Price: High to Low");
        String textSelected = select.getFirstSelectedOption().getText();
        Assert.assertEquals(textSelected,"Price: High to Low");
        System.out.println(textSelected);
        List<WebElement> list = select.getOptions();
        Boolean checkMulti = select.isMultiple();
        if(!checkMulti){
            System.out.println("Không cho phép multi select");
        }else{
            System.out.println("Cho phép multi select");
        }
        System.out.println("Số giá trị: "+list.size());
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String opacity = (String) jsExecutor.executeScript("return window.getComputedStyle(arguments[0]).getPropertyValue('opacity');", dropdown);

// In ra kết quả
        System.out.println("Opacity: " + opacity);
        driver.quit();
    }
}
