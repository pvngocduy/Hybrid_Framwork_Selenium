package TestSuite;

import io.cucumber.core.exception.CucumberException;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        plugin = {"pretty"},
        glue = {
                "classpath:TestSuite"
        },
        features = {
                "classpath:features/demotestlogin.feature"
        }
)
public class RunCucumberTest {

}
