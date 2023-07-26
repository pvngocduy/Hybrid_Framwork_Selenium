package testcases.com_facebook_register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testHandleSwitchWindows {
    public static void main(String[] args) throws InterruptedException {
        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();

        // Mở trang web
        driver.get("https://onehousing.vn/");
        Thread.sleep(5000);
        String mainWindow = driver.getWindowHandle();
        // Tìm và nhấn vào button để mở màn hình mới
        WebElement button = driver.findElement(By.xpath("//*[@id=\"om-header\"]/div/div[2]/div/div/button[2]"));

        button.click();


        // Chuyển sang cửa sổ mới
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
        Thread.sleep(5000);
        // Thực hiện các thao tác trên màn hình mới
        driver.findElement(By.xpath("//input[@data-placeholder='Số điện thoại của bạn']")).sendKeys("0988059625");
        // Trở về cửa sổ trước đó
        driver.switchTo().window(mainWindow);
        driver.findElement(By.xpath("//span//div[contains(text(),'Liên hệ')]")).click();
        // Tiếp tục thao tác trên cửa sổ trước đó
        Thread.sleep(5000);
        // Đóng trình duyệt
    }
}
