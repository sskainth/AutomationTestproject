package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
features ={"src/test/resources/testdesigen"},
        glue = {"stepdefination","hooks"},
        tags = "@searchnewphone",
        plugin = {"pretty","html:target/test-results/report.html",}
)


public class Runner {


}
