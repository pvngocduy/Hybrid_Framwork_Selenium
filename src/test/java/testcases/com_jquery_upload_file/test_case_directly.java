package testcases.com_jquery_upload_file;

import actions.commons.BaseTest;
import actions.pageObjects.pageObjectJqueryData.HomePageUploadFile;
import interfaces.jQueryUI.HomePageUploadUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class test_case_directly extends BaseTest {
    private String csharpFileNam = "CSharp.png";
    private String javaFileNam = "Java.png";
    private String pythonFileNam = "Python.png";
    private String rubyFileNam = "Ruby.png";
    private String[] multipleFile = {csharpFileNam, javaFileNam, pythonFileNam, rubyFileNam};

    private WebDriver driver;
    private HomePageUploadFile homePage;

    @BeforeClass
    @Parameters({"browser","url"})
    public void beforeClass(String browser, String url){
        driver = getBrowserDriver(browser, url);
        homePage = new HomePageUploadFile(driver);

    }
    @Test
    public void TC_01_uploadMultipleFile(){
        homePage.uploadMultipleFiles(driver, multipleFile);
        homePage.clickToStartButton();
        for(String value : multipleFile){
           // Assert.assertTrue(homePage.isFilesLoaded(value));
            verifyTrue(homePage.isFileLinkUploaded(value));
            verifyTrue(homePage.isFileUploadedByName(value));
        }

    }
    @Test
    public void TC_02_uploadSingleFile(){
        homePage.uploadMultipleFiles(driver, csharpFileNam);
        Assert.assertTrue(homePage.isFilesLoaded(csharpFileNam));
        homePage.clickToStartButton();
        Assert.assertTrue(homePage.isFileLinkUploaded(csharpFileNam));
        Assert.assertTrue(homePage.isFileUploadedByName(csharpFileNam));
    }
    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
