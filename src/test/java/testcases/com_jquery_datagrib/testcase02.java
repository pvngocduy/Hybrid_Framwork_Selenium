package testcases.com_jquery_datagrib;

import actions.commons.BaseTest;
import actions.pageObjects.pageObjectJqueryData.HomePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testcase02 extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;

    @BeforeClass
    @Parameters({"browser","url"})
    public void beforeClass(String browser, String url){
        driver = getBrowserDriver(browser, url);
        homePage = new HomePageObject(driver);

    }
    @Test
    public void TC_01_inputDataToColumnAndRowByIndex(){
        HomePageObject homePageObject = new HomePageObject(driver);
        homePageObject.inputToTextFieldByColumnAndRowIndex("Contact Person","2","Duy");
        homePageObject.inputToTextFieldByColumnAndRowIndex("Contact Person","3","Duy");
        homePageObject.inputToTextFieldByColumnAndRowIndex("Company","1","Duy");
        homePageObject.selectDropdownFieldByColumnAndRowIndex("Country","1","G");

    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
