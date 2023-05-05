package actions.pageFactory;

import actions.commons.BasePage;
import actions.commons.BasePageFactory;
import interfaces.pageUi.HomePageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory extends BasePageFactory {
    private WebDriver driver;
    private String email;

    public HomePageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@class='ico-register']")
    private WebElement registerLink;
    @FindBy(xpath = "//a[@class='ico-login']")
    private WebElement loginLink;
    @FindBy(xpath = "//a[@class='ico-logout']")
    private WebElement logoutLink;
    @FindBy(xpath = "//a[@class='ico-account']")
    private WebElement myAccountLink;
    public void clickToRegisterLink() {
        waitForAllElementVisible(driver, registerLink);
        clickToElement(registerLink);
    }

    public void clickToLoginLink() {
        waitForAllElementVisible(driver, loginLink);
        clickToElement(loginLink);
    }
    public void clickToLogoutLink() {
        waitForAllElementVisible(driver, logoutLink);
        clickToElement(logoutLink);
    }
    public boolean isMyAcountLinkDisplayed(){
        return objectIsDisplayed(myAccountLink);
    }
    public void setExistingEmail(String emailExist){
        email = emailExist;
    }
    public String getExistingEmail(){
        return email;
    }
}
