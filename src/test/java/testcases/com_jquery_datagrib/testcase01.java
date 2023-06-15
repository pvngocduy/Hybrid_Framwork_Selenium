package testcases.com_jquery_datagrib;

import actions.commons.BaseTest;
import actions.pageObjects.pageObjectJqueryData.HomePageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testcase01 extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;

    @BeforeClass
    @Parameters({"browser","url"})
    public void beforeClass(String browser, String url){
        driver = getBrowserDriver(browser, url);
        homePage = new HomePageObject(driver);

    }

    @Test
    public void TC_01_switchBetwenPageByNumber(){
        homePage.clickToPageByNumber(5);
        Assert.assertTrue(homePage.isPageSelected(5));
        homePage.clickToPageByNumber(10);
        Assert.assertTrue(homePage.isPageSelected(10));
        homePage.clickToPageByNumber(15);
        Assert.assertTrue(homePage.isPageSelected(15));
        homePage.clickToPageByNumber(20);
        Assert.assertTrue(homePage.isPageSelected(20));
    }
    @Test
    public void TC_02_inputTextToHeaderField(){
        homePage.inputToHeaderByName("Females","11111");
        homePage.inputToHeaderByName("Country","11111");
        homePage.inputToHeaderByName("Males","11111");
        homePage.inputToHeaderByName("Total","11111");
    }
    @Test
    public void TC_03_getAllDataOfTable(){
        homePage.refreshCurrentPage(driver);
        homePage.getAllDataOfTable();
    }
    @Test
    public void TC_04_getAllDataOfTableNotDuplicateWithCountry(){
        homePage.refreshCurrentPage(driver);
        homePage.getAllDataNotDuplicate();
    }
    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
