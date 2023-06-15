package actions.commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;

import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.BeforeSuite;


import java.io.File;
import java.io.IOException;
import java.text.DateFormatSymbols;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;
public class BaseTest {
    private WebDriver driver;
    protected final Log log;
    public BaseTest(){
        log = LogFactory.getLog(getClass());
    }
    @BeforeSuite
    public void initBeforeSuite(){
        deleteAllFileInFolder();
        deleteAllFileInFolderScreenShot();
    }
    public WebDriver getDriverInstance(){
        return driver;
    }
    protected void closeBrowserDriver() {
        String cmd = null;
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            log.info("OS name = " + osName);

            String driverInstanceName = driver.toString().toLowerCase();
            log.info("Driver instance name = " + driverInstanceName);

            String browserDriverName = null;

            if (driverInstanceName.contains("chrome")) {
                browserDriverName = "chromedriver";
            } else if (driverInstanceName.contains("internetexplorer")) {
                browserDriverName = "IEDriverServer";
            } else if (driverInstanceName.contains("firefox")) {
                browserDriverName = "geckodriver";
            } else if (driverInstanceName.contains("edge")) {
                browserDriverName = "msedgedriver";
            } else if (driverInstanceName.contains("opera")) {
                browserDriverName = "operadriver";
            } else {
                browserDriverName = "safaridriver";
            }

            if (osName.contains("window")) {
                cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
            } else {
                cmd = "pkill " + browserDriverName;
            }

            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    protected WebDriver getBrowserDriver(String browserName, String url){
        if(browserName.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else if(browserName.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        }else if(browserName.equals("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }else if(browserName.equals("h_chrome")){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("window-size=1366x768");
            driver = new ChromeDriver(options);
        }
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }
    protected boolean checkTrue(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertTrue(condition);
            log.info(" -------------------------- PASSED -------------------------- ");
        } catch (Throwable e) {
            log.info(" -------------------------- FAILED -------------------------- ");
            pass = false;
            // Add lỗi vào ReportNGListener
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyTrue(boolean condition) {
        return checkTrue(condition);
    }

    protected boolean checkFailed(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertFalse(condition);
            log.info(" -------------------------- PASSED -------------------------- ");
        } catch (Throwable e) {
            log.info(" -------------------------- FAILED -------------------------- ");
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyFalse(boolean condition) {
        return checkFailed(condition);
    }

    protected boolean checkEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
            log.info(" -------------------------- PASSED -------------------------- ");
        } catch (Throwable e) {
            pass = false;
            log.info(" -------------------------- FAILED -------------------------- ");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        return checkEquals(actual, expected);
    }
    public void deleteAllFileInFolder(){
        try{
            String pathFolderDownload = GlobalConstant.PROJECT_PATH + "/allure-json";
            File file = new File(pathFolderDownload);
            File[] listOfFiles = file.listFiles();
            for(int i=0 ; i<listOfFiles.length; i++){
                System.out.println(listOfFiles[i].getName());
                new File(listOfFiles[i].toString()).delete();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void deleteAllFileInFolderScreenShot(){
        try{
            String pathFolderScreenshots = GlobalConstant.PROJECT_PATH + "/Screenshots";
            File file = new File(pathFolderScreenshots);
            File[] listOfFiles = file.listFiles();
            for(int i=0 ; i<listOfFiles.length; i++){
                System.out.println(listOfFiles[i].getName());
                new File(listOfFiles[i].toString()).delete();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static int fakeIntergerNumber (){
        Random rd = new Random();
        return rd.nextInt(9999);
    }
    protected String getCurrentDay() {
        DateTime nowUTC = new DateTime();
        int day = nowUTC.getDayOfMonth();
//        if (day < 10) {
//            String dayValue = "0" + day;
//            return dayValue;
//        }
        return day + "";
    }

//    protected String getCurrentMonth() {
//        DateTime now = new DateTime();
//        int month = now.getMonthOfYear();
//        if (month < 10) {
//            String monthValue = "0" + month;
//            return monthValue;
//        }
//        return month + "";
//    }
    protected String getCurrentMonth() {
        DateTime now = new DateTime();
        int month = now.getMonthOfYear();
        DateFormatSymbols symbols = new DateFormatSymbols(Locale.ENGLISH);
        String[] months = symbols.getMonths();
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month number: " + month);
        }
        return months[month - 1];
    }

    protected String getCurrentYear() {
        DateTime now = new DateTime();
        return now.getYear() + "";
    }
    protected String getToday(){
        return getCurrentMonth() + " " + getCurrentDay() + ", " + getCurrentYear();
    }

//    protected String getToday() {
//        return  getCurrentDay() + "/" + getCurrentMonth() + "/" + getCurrentYear();
//    }

}

