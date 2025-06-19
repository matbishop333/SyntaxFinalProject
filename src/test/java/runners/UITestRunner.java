package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(
        features = "C:\\Users\\mathe\\IdeaProjects\\SyntaxFinalProject\\src\\test\\resources\\features\\ui",
        glue = {"steps", "hooks"},
        tags = "@smoke",
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"},
        monochrome = true,
        dryRun = false
)
public class UITestRunner extends AbstractTestNGCucumberTests {
}
