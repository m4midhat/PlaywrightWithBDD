package deriv.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/deriv/Features",
        glue = "deriv.Steps",//tags = {"~@Smoke"},
        plugin = { "json:target/cucumber-report/cucumber.json","pretty"}
)

public class TestRunner {
    private TestRunner() {

    }
}
