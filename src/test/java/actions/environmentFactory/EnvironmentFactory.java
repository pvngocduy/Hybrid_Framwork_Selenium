package actions.environmentFactory;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public interface EnvironmentFactory {
    public WebDriver createDriver() throws MalformedURLException;
}
