package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
        (
        features = "C:\\Users\\mathe\\IdeaProjects\\SyntaxFinalProject\\src\\test\\resources\\features\\api",
        glue ="steps.api",
        tags = "@usercreation",
        plugin = {"pretty", "html:target/cucumber-api-reports.html", "json:target/cucumber-api.json"}
        )

public class APITestRunner extends AbstractTestNGCucumberTests {
}
