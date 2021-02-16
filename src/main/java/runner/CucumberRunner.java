package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/ValidateNews.feature",
        glue={"stepDefinition"},
        plugin = {"pretty", "html:target/Destination"} ,
        monochrome = true
)
public class CucumberRunner {

}
