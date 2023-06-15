package actions.pageObjects.com_saulabs_sort;

import actions.commons.BasePage;
import interfaces.com_saulabs_ui.ProductPageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ProductPagePO extends BasePage {
    WebDriver driver;
    public ProductPagePO(WebDriver driver) {
        this.driver = driver;
    }
    public void SelectOptionSortByText(String textItem){
        waitForElementVisible(driver, ProductPageUI.DROPDOWN_LIST_ITEM_SORT);
        selectedItemInDefaultDropdown(driver,ProductPageUI.DROPDOWN_LIST_ITEM_SORT,textItem);
    }
    public boolean isProductNameSortByAsc(){
        return isDataSortByAsc(driver, ProductPageUI.LIST_PRODUCT_NAME);
    }
    public boolean isProductNameSortByDesc(){
        return isDataSortByDesc(driver, ProductPageUI.LIST_PRODUCT_NAME);
    }
    public boolean isProductPriceSortByAsc(){
        return isFloatDataSortByAsc(driver, ProductPageUI.LIST_PRODUCT_PRICE);
    }

    public boolean isProductPriceSortByDesc() {
        return isFloatDataSortByDesc(driver, ProductPageUI.LIST_PRODUCT_PRICE);
    }
}
