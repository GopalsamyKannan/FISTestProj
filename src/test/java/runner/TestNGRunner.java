package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions"},
        tags = "@UISmoke",
        //tags = "@APISmoke",
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class TestNGRunner extends AbstractTestNGCucumberTests {

    @Parameters("browser")
    @Test
    public void setBrowser(String browser) {
        System.setProperty("browser", browser); 
    }
}
