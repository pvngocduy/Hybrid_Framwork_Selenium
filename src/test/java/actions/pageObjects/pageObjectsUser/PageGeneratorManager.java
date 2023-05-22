package actions.pageObjects.pageObjectsUser;

import actions.pageObjects.pageObjectsAdmin.AdminLoginPage;
import actions.pageObjects.pageObjectsAdmin.DashBoardPage;
import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    public static HomePage getHomePageObject(WebDriver driver){
        return new HomePage(driver);
    }
    public static LoginPage getLoginPageObject(WebDriver driver){
        return new LoginPage(driver);
    }
    public static RegisterPage getRegisterPageObject(WebDriver driver){
        return new RegisterPage(driver);
    }
    public static MyAccountPage getMyAccountPageObject(WebDriver driver){
        return new MyAccountPage(driver);
    }
    public static AddressesPage getAddressPageObject(WebDriver driver){
        return new AddressesPage(driver);
    }
    public static ChangePasswordPage getChangePasswordPageObject(WebDriver driver){
        return new ChangePasswordPage(driver);
    }
    public static CustomerInforPage getCustomerInforPageObject(WebDriver driver){
        return new CustomerInforPage(driver);
    }
    public static DownloadableProductPage getDownloadleProductPageObject(WebDriver driver){
        return new DownloadableProductPage(driver);
    }
    public static MyProductReviewPage getMyProductReviewPageObject(WebDriver driver){
        return new MyProductReviewPage(driver);
    }
    public static OrdersPage getOrdersPageObject(WebDriver driver){
        return new OrdersPage(driver);
    }
    public static RewardPointPage getRewardPageObject(WebDriver driver){
        return new RewardPointPage(driver);
    }
    public static StockSubcriptionPage getStockSubcriptionPageObject(WebDriver driver){
        return new StockSubcriptionPage(driver);
    }
    public static DashBoardPage getDashBoardPageObject(WebDriver driver) {
        return new DashBoardPage(driver);
    }
    public static AdminLoginPage getAdminLoginPage(WebDriver driver) {
        return new AdminLoginPage(driver);
    }
}
