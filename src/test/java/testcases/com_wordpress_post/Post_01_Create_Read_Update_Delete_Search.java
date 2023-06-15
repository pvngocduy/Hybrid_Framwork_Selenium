package testcases.com_wordpress_post;

import actions.Utils.extentreports.ExtentTestManager;
import actions.common_nopcomerse.TC_01_register_login_cokie;
import actions.common_wordpress.TC_01_wordpress_login_cokie;
import actions.commons.BasePage;
import actions.commons.BaseTest;
import actions.commons.Log;
import actions.pageObjects.pageObject_Wordpress_Admin.AdminDashboardPageObject;
import actions.pageObjects.pageObject_Wordpress_Admin.AdminLoginPageObject;
import actions.pageObjects.pageObject_Wordpress_Admin.PageWPGeneratorManager;
import actions.pageObjects.pageObject_Wordpress_Admin.Post_Object.AdminPostAddNewPageObject;
import actions.pageObjects.pageObject_Wordpress_Admin.Post_Object.AdminPostSearchPageObject;
import actions.pageObjects.pageObject_Wordpress_User.UserHomePageObject;
import actions.pageObjects.pageObject_Wordpress_User.UserPostDetailPageObject;
import actions.pageObjects.pageObjectsUser.HomePage;
import actions.pageObjects.pageObjectsUser.PageGeneratorManager;
import actions.pageObjects.pageObjectsUser.RegisterPage;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testdata.com_nopcomerce_data.AdminLoginPageVerifyData;

import java.lang.reflect.Method;

public class Post_01_Create_Read_Update_Delete_Search extends BaseTest {
    WebDriver driver;
    AdminLoginPageObject adminLoginPageObject;
    AdminDashboardPageObject adminDashboardPageObject;
    AdminPostSearchPageObject adminPostSearchPageObject;
    AdminPostAddNewPageObject adminPostAddNewPageObject;
    UserPostDetailPageObject userPostDetailPageObject;
    UserHomePageObject userHomePageObject;
    String username = AdminLoginPageVerifyData.LOGIN_USER_NAME;
    String password = AdminLoginPageVerifyData.LOGIN_PASSWORD;
    String postSearchUrl;
    int randomeNumber = fakeIntergerNumber();
    String tilte = "Selenium "+randomeNumber;
    String body = "This is body "+randomeNumber;
    String updateTitle = "This is update Title "+randomeNumber;
    String updateBody = "This is update body "+randomeNumber;
    String url_admin, url_user;
    String author = "duypvn";
    @BeforeClass
    @Parameters({"browser","url_admin", "url_user"})
    public void beforeClass(String browser, String url_admin, String url_user){
        driver = getBrowserDriver(browser, url_admin);
        this.url_admin = url_admin;
        this.url_user = url_user;
        adminLoginPageObject = PageWPGeneratorManager.getLoginPageObject(driver);
        adminPostAddNewPageObject = PageWPGeneratorManager.getPostAddNewPageObject(driver);
        Log.info("Precondition - Step1: Login To WP-Admin");
        adminLoginPageObject.inputToUserName(username);
        adminLoginPageObject.inputToPassword(password);
        Log.info("Precondition - Step2: Login with username: "+username+" and password: "+password);
        adminDashboardPageObject = adminLoginPageObject.clickToLoginButton();
        Log.info("Precondition - Step3: Verify Login Success");
        Assert.assertTrue(adminLoginPageObject.isDashboardDisplay());
    }
    @Test
    public void Post_01_Create_Post(){
        adminPostSearchPageObject = adminDashboardPageObject.clickToPostSearchPO();
        postSearchUrl = adminPostAddNewPageObject.getPageUrl(driver);
        adminPostAddNewPageObject = adminPostSearchPageObject.clickToAdminPostAddNewPO();
        adminPostAddNewPageObject.inputToTheTilte(tilte);
        adminPostAddNewPageObject.inputToTheBody(body);
        adminPostAddNewPageObject.clickToButtonPublish();
        adminPostAddNewPageObject.sleepInSecond(5);
       // Assert.assertTrue(adminPostAddNewPageObject.isCreateSuccess("Post updated."));
    }
    @Test
    public void Post_02_Search_And_View_Post(){
        Log.info("Post02 - Step1: Open Post Search ");
        adminPostSearchPageObject = adminPostAddNewPageObject.openPostSearchPO(postSearchUrl);
        Log.info("Post02 - Step2: Input to Searchbox and click to Search ");
        adminPostSearchPageObject.searchByTitle(tilte);
        Log.info("Post02 - Step3: Verify Search Table Contains:" + tilte);
        verifyTrue(adminPostSearchPageObject.isPostSearchTableDisplay("title",tilte));
        Log.info("Post02 - Step4: Verify Search Table Contains:" + author);
        verifyTrue(adminPostSearchPageObject.isPostSearchTableDisplay("author",author));
        Log.info("Post02 - Step5: Open to Userhome Page");
        userHomePageObject = adminPostSearchPageObject.openUserHomePage(driver,url_user);
        Log.info("Post02 - Step6: Verify title, author, body in Homepage");
        verifyTrue(userHomePageObject.isDisplayTitle(tilte));
        verifyTrue(userHomePageObject.isDisplayAuthor(tilte,author));
        verifyTrue(userHomePageObject.isDisplayBody(tilte, body));
        Log.info("Post02 - Step7: Open to Post detail");
        userPostDetailPageObject = userHomePageObject.openToPageDetail(tilte);
        verifyTrue(userPostDetailPageObject.isDisplayTitle(tilte));
        verifyTrue(userPostDetailPageObject.isDisplayAuthor(author));
        verifyTrue(userPostDetailPageObject.isDisplayBody(tilte, body));
        verifyTrue(userPostDetailPageObject.isDisplayPostPublishDay(tilte,getToday()));
    }
    @Test
    public void Post_03_View_Post(){

    }
    @Test
    public void Post_04_Edit_Post(){
        adminDashboardPageObject = userPostDetailPageObject.openDashBoardPage(driver, url_admin);
        adminDashboardPageObject.openUrl(driver, postSearchUrl);
        adminPostSearchPageObject.searchByTitle(tilte);
        adminPostSearchPageObject.clickToEditPost(tilte);
        adminPostSearchPageObject.sleepInSecond(3);
        adminPostAddNewPageObject.editTheTitle(updateTitle);
        adminPostAddNewPageObject.editTheBody(updateBody);
        adminPostAddNewPageObject.clickToButtonUpdate();
        adminPostAddNewPageObject.sleepInSecond(5);
        adminPostSearchPageObject = adminPostAddNewPageObject.openPostSearchPO(postSearchUrl);
        adminPostSearchPageObject.searchByTitle(updateTitle);
        verifyTrue(adminPostSearchPageObject.isPostSearchTableDisplay("title",updateTitle));
        userHomePageObject = adminPostSearchPageObject.openUserHomePage(driver,url_user);
        userHomePageObject.searchPostByTitle(updateTitle);
        verifyTrue(userHomePageObject.isDisplayTitle(updateTitle));

    }
    @Test
    public void Post_05_Delete_Post(){
        adminDashboardPageObject = userHomePageObject.openDashBoardPage(driver, url_admin);
        adminDashboardPageObject.openUrl(driver, postSearchUrl);
        adminPostSearchPageObject.searchByTitle(updateTitle);
        adminPostSearchPageObject.clickToTheTrash(updateTitle);
        verifyTrue(adminPostSearchPageObject.isDisplayMessageDeleteSuccess());
        adminPostSearchPageObject.searchByTitle(updateTitle);
        verifyTrue(adminPostSearchPageObject.isPostNotFound());
    }
    @AfterClass(alwaysRun = true)
    public void afterClass() throws InterruptedException {
        Thread.sleep(1000);
        closeBrowserDriver();
    }
}
