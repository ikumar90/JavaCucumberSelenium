package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/ValidateNews.feature",
        glue={"stepDefinition"},
        plugin = {"pretty","html:target/cucumber-reports/Report.html"},
        publish=true
)
public class CucumberRunner {

}
