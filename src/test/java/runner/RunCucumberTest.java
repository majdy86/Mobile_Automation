package runner;

import cucumber.api.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
 @CucumberOptions(
        plugin = {"pretty", "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm", "junit:target/surefire-reports/Cucumber.xml", "html:target"},
        glue = {"stepdefs"},
        features = "src/test/resources/features"
)
public class RunCucumberTest {
}
