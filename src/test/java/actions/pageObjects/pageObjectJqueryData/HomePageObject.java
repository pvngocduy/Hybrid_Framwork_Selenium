package actions.pageObjects.pageObjectJqueryData;

import actions.commons.BasePage;
import interfaces.jQueryUI.HomePageUI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HomePageObject extends BasePage {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void refreshCurrentPage(WebDriver driver){
        driver.navigate().refresh();
    }
    public void clickToPageByNumber(int numberPage){
        waitForElementVisible(driver, HomePageUI.PAGE_NUMBER_LINK, String.valueOf(numberPage));
        clickToElement(driver, HomePageUI.PAGE_NUMBER_LINK, String.valueOf(numberPage));
    }
    public boolean isPageSelected(int numberPage){
        waitForAllElementVisible(driver, HomePageUI.PAGE_NUMBER_SELECTED, String.valueOf(numberPage));
        return objectIsDisplayed(driver, HomePageUI.PAGE_NUMBER_SELECTED, String.valueOf(numberPage));
    }
    public void inputToHeaderByName(String headerName, String value){
        waitForAllElementVisible(driver, HomePageUI.HEADER_INPUT_FIELD, headerName);
        sendKeyToElement(driver, HomePageUI.HEADER_INPUT_FIELD , value, headerName);
        pressKeyToElement(driver, HomePageUI.HEADER_INPUT_FIELD, Keys.ENTER, headerName);
    }
    public void getAllDataOfTable(){
        int totalPageSize = getElementsSize(driver, HomePageUI.TOTAL_PAGE_SIZE);
        System.out.println("Number page of table: " + totalPageSize);
        List<String> allPageData = new ArrayList<String>();
        for(int i =1 ;i <= totalPageSize; i++){
            clickToPageByNumber(i);
            List<WebElement> allDataOfPage = getElements(driver, HomePageUI.ROW_ELEMENT);
            for(WebElement eachRow: allDataOfPage){
                allPageData.add(eachRow.getText());
            }
        }
        System.out.println("Number row of: "+allPageData.size());

        for(String value:allPageData){
            System.out.println("------------------------");
            System.out.println(value);
        }
    }
    public void getAllDataNotDuplicate(){
        int totalPageSize = getElementsSize(driver, HomePageUI.TOTAL_PAGE_SIZE);
        System.out.println("Number page of table: " + totalPageSize);
        Set<String> allPageData = new HashSet<String>();
        for(int i =1 ;i <= totalPageSize; i++){
            clickToPageByNumber(i);
            List<WebElement> allDataOfPage = getElements(driver, HomePageUI.ROW_COUNTRY_DATA);
            for(WebElement eachRow: allDataOfPage){
                allPageData.add(eachRow.getText());
            }
        }
        System.out.println("Number row of: "+allPageData.size());
        for(String value:allPageData){
            System.out.println("------------------------");
            System.out.println(value);
        }
    }
    public void inputToTextFieldByColumnAndRowIndex(String columnName, String rowNumber, String keyValue){
        int columnIndex = getElementsSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
        waitForElementClickable(driver, HomePageUI.TEXTBOX_BY_COLUMN_AND_ROW, rowNumber, String.valueOf(columnIndex));
        sendKeyToElement(driver, HomePageUI.TEXTBOX_BY_COLUMN_AND_ROW, keyValue, rowNumber, String.valueOf(columnIndex));
    }
    public void selectDropdownFieldByColumnAndRowIndex(String columnName, String rowNumber, String keyValue){
        int columnIndex = getElementsSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
        waitForElementClickable(driver, HomePageUI.DROPDOWN_BY_COLUMN_AND_ROW, rowNumber, String.valueOf(columnIndex));
        sendKeyToElement(driver, HomePageUI.DROPDOWN_BY_COLUMN_AND_ROW, keyValue, rowNumber, String.valueOf(columnIndex));
    }
}
