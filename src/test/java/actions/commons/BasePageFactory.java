package actions.commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class BasePageFactory {
    // Selenium WebDriver Function
    public Duration duration = Duration.ofSeconds(30);
    public static BasePageFactory getBasePageObject(){
        return new BasePageFactory();
    }
    public void openUrl(WebDriver driver, String pageUrl){
        driver.get(pageUrl);
    }
    public String getPageTitle(WebDriver driver){
        return driver.getTitle();
    }
    public String getPageUrl(WebDriver driver){
        return driver.getCurrentUrl();
    }
    public String getPageSourceCode(WebDriver driver){
        return driver.getPageSource();
    }
    public void backToPage(WebDriver driver){
        driver.navigate().back();
    }
    public void forwardToPage(WebDriver driver){
        driver.navigate().forward();
    }
    public void refreshCurrentPage(WebDriver driver){
        driver.navigate().refresh();
    }
    public Alert waitForAlertPresent(WebDriver driver){
        WebDriverWait explicitWait = new WebDriverWait(driver, duration);
        return explicitWait.until(ExpectedConditions.alertIsPresent());
    }
    public void acceptAlert(WebDriver driver){
        waitForAlertPresent(driver).accept();
    }
    public void cancelAlert(WebDriver driver){
        waitForAlertPresent(driver).dismiss();
    }
    public void getTextlAlert(WebDriver driver){
        waitForAlertPresent(driver).getText();
    }
    public void sendKeyAlert(WebDriver driver, String textValue){
        waitForAlertPresent(driver).sendKeys(textValue);
    }

    public void switchToWindowByID(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            if (!runWindow.equals(parentID)) {
                driver.switchTo().window(runWindow);
                break;
            }
        }
    }

    public void switchToWindowByTitle(WebDriver driver, String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            driver.switchTo().window(runWindows);
            String currentWin = driver.getTitle();
            if (currentWin.equals(title)) {
                break;
            }
        }
    }

    public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            if (!runWindows.equals(parentID)) {
                driver.switchTo().window(runWindows);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }
    // Selenium Handle Element

    private By getByXpath(String locator){
        return By.xpath(locator);
    }
    private WebElement getElement(WebDriver driver, String locator){
        return driver.findElement(getByXpath(locator));
    }
    private List<WebElement> getElements(WebDriver driver, String locator){
        return driver.findElements(getByXpath(locator));
    }
    public void clickToElement(WebElement element){
        element.click();
    }
    public void sendKeyToElement(WebElement element, String keyValue){
        element.clear();
        element.sendKeys(keyValue);
    }
    public String getTextElement(WebElement element){
        return element.getText();
    }
    public void selectedItemInDefaultDropdown(WebDriver driver, String locator, String textItem){
        Select select = new Select(getElement(driver, locator));
        select.selectByValue(textItem);
    }
    public void getSelectedItemInDefaultDropdown(WebDriver driver, String locator, String textItem){
        Select select = new Select(getElement(driver, locator));
        select.selectByValue(textItem);
    }
    public boolean isDropdownMultiple(WebDriver driver, String locator){
        Select select = new Select(getElement(driver, locator));
        return select.isMultiple();
    }
    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
        getElement(driver, parentLocator).click();
        sleepInSecond(1);
        WebDriverWait explicitWait = new WebDriverWait(driver, duration);
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));
        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                 JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                sleepInSecond(1);
                item.click();
                sleepInSecond(1);
                break;
            }
        }
    }

    public void sleepInSecond(long time ) {
        try {
            Thread.sleep(time*1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public String getElementAttribute(WebDriver driver, String locator, String attributeName){
        return getElement(driver, locator).getAttribute(attributeName);
    }
    public String getElementCssValue(WebDriver driver, String locator, String attributeName, String propertyName){
        return getElement(driver, locator).getCssValue(propertyName);
    }
    public String getHexColorFromRGBA(String rgbaValue){
        return Color.fromString(rgbaValue).asHex();
    }
    public int getElementsSize(WebDriver driver, String locator){
        return getElements(driver, locator).size();
    }
    public void checkTheCheckBoxOrRadio(WebDriver driver, String locator){
        WebElement element = getElement(driver, locator);
        if(!element.isSelected()){
            element.click();
        }
    }
    public void unCheckTheCheckBoxOrRadio(WebDriver driver, String locator){
        WebElement element = getElement(driver, locator);
        if(element.isSelected()){
            element.click();
        }
    }
    public boolean isControlEnable(WebDriver driver, String locator){
        return getElement(driver, locator).isEnabled();
    }
    public boolean isControlSelected(WebDriver driver, String locator){
        return getElement(driver, locator).isSelected();
    }
    public void switchToFrameIframe(WebDriver driver, String locator){
        driver.switchTo().frame(getElement(driver,locator));
    }
    public void switchToDefaultContent(WebDriver driver){
        driver.switchTo().defaultContent();
    }
    public void hoverMouseToElement(WebDriver driver, String locator){
        Actions action = new Actions(driver);
        action.moveToElement(getElement(driver, locator)).perform();
    }


    public void scrollToBottomPage(WebDriver driver) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }


    public void highlightElement(WebDriver driver, String locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getElement(driver, locator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
        sleepInSecond(1);
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", getElement(driver, locator));
    }

    public void scrollToElement(WebDriver driver, String locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
    }


    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
    }

    public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
        WebDriverWait explicitWait = new WebDriverWait(driver, duration);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };

        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
    }

    public String getElementValidationMessage(WebDriver driver, String locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
    }

    public boolean isImageLoaded(WebDriver driver, String locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getElement(driver, locator));
        if (status) {
            return true;
        } else {
            return false;
        }
    }
    public void waitForAllElementVisible(WebDriver driver, WebElement element){
        WebDriverWait explicitWait = new WebDriverWait(driver, duration);
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(element));

    }
    public void waitForElementInvisible(WebDriver driver, WebElement element){
        WebDriverWait explicitWait = new WebDriverWait(driver, duration);
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(element));
    }
    public void waitForAllElementInvisible(WebDriver driver, WebElement element){
        WebDriverWait explicitWait = new WebDriverWait(driver, duration);
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(element));
    }
    public void waitForElementClickable(WebDriver driver, WebElement element) {
        WebDriverWait explicitWait = new WebDriverWait(driver, duration);
        explicitWait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public boolean objectIsDisplayed( WebElement element){
        return element.isDisplayed();
    }
    public int fakeIntergerNumber (){
        Random rd = new Random();
        return rd.nextInt(9999);
    }
    public String getRandomEmail(){
        return "abc"+ fakeIntergerNumber() + "@mail.com";
    }
}
