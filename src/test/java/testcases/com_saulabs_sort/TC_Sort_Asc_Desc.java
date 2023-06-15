package testcases.com_saulabs_sort;

import actions.commons.BaseTest;
import actions.commons.Log;
import actions.pageObjects.com_saulabs_sort.ProductPagePO;
import actions.pageObjects.com_saulabs_sort.SaulabLoginPO;
import actions.pageObjects.pageObject_Wordpress_Admin.AdminDashboardPageObject;
import actions.pageObjects.pageObject_Wordpress_Admin.AdminLoginPageObject;
import actions.pageObjects.pageObject_Wordpress_Admin.PageWPGeneratorManager;
import actions.pageObjects.pageObject_Wordpress_Admin.Post_Object.AdminPostAddNewPageObject;
import actions.pageObjects.pageObject_Wordpress_Admin.Post_Object.AdminPostSearchPageObject;
import actions.pageObjects.pageObject_Wordpress_User.UserHomePageObject;
import actions.pageObjects.pageObject_Wordpress_User.UserPostDetailPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testdata.com_nopcomerce_data.AdminLoginPageVerifyData;

public class TC_Sort_Asc_Desc extends BaseTest {
    WebDriver driver;
    SaulabLoginPO saulabLoginPO;
    ProductPagePO productPagePO;
    String username = "standard_user";
    String password = "secret_sauce";
    @BeforeClass
    @Parameters({"browser","url"})
    public void beforeClass(String browser, String url){
        driver = getBrowserDriver(browser, url);
        saulabLoginPO = new SaulabLoginPO(driver);
        saulabLoginPO.inputToTheField(username, "user-name");
        saulabLoginPO.inputToTheField(password, "password");
        saulabLoginPO.clickToLogin("login-button");
    }
    @Test
    public void Post_01_Create_Post(){
        productPagePO = new ProductPagePO(driver);
        productPagePO.SelectOptionSortByText("Name (Z to A)");
        Assert.assertTrue(productPagePO.isProductNameSortByDesc());
        productPagePO.sleepInSecond(5);
        productPagePO.SelectOptionSortByText("Name (A to Z)");
        Assert.assertTrue(productPagePO.isProductNameSortByAsc());
        productPagePO.sleepInSecond(5);
        productPagePO.SelectOptionSortByText("Price (low to high)");
        Assert.assertTrue(productPagePO.isProductPriceSortByAsc());
        productPagePO.sleepInSecond(5);
        productPagePO.SelectOptionSortByText("Price (high to low)");
        Assert.assertTrue(productPagePO.isProductPriceSortByDesc());
        productPagePO.sleepInSecond(5);
    }
    @AfterClass(alwaysRun = true)
    public void afterClass() throws InterruptedException {
        Thread.sleep(1000);
        closeBrowserDriver();
    }
}
