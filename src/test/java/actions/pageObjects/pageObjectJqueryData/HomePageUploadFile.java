package actions.pageObjects.pageObjectJqueryData;

import actions.commons.BasePage;
import interfaces.jQueryUI.HomePageUploadUI;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePageUploadFile extends BasePage {
    WebDriver driver;

    public HomePageUploadFile(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isFilesLoaded(String fileName){
        waitForAllElementVisible(driver, HomePageUploadUI.FILENAME_LOADED, fileName);
        return objectIsDisplayed(driver, HomePageUploadUI.FILENAME_LOADED, fileName);
    }
    @Step("Click to Start Button")
    public void clickToStartButton(){
        List<WebElement> startButtons = getElements(driver, HomePageUploadUI.BUTTON_UPLOAD);
        for(WebElement startButton : startButtons){
           startButton.click();
           sleepInSecond(2);
        }

    }
    public boolean isFileLinkUploaded(String fileName){
        waitForAllElementVisible(driver, HomePageUploadUI.FILENAME_UPLOADED_LINK, fileName);
        return objectIsDisplayed(driver, HomePageUploadUI.FILENAME_UPLOADED_LINK, fileName);
    }
    public boolean isFileUploadedByName(String fileName){
        waitForAllElementVisible(driver, HomePageUploadUI.FILENAME_UPLOADED_IMAGE, fileName);
        return isImageLoaded(driver, HomePageUploadUI.FILENAME_UPLOADED_IMAGE, fileName);
    }

}
