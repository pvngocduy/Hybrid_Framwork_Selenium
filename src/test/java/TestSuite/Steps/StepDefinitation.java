package TestSuite.Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitation {
    WebDriver driver;
    @Given("I have a page url")
    public void i_have_a_page_url() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
    }
    @Given("I click to login")
    public void i_click_to_login() {

    }
    @Then("I login successful")
    public void i_login_successful() {

    }
}
