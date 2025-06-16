package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.CommonMethods;

import java.io.IOException;

public class Hooks extends CommonMethods {
    @Before
    public void setUp() throws IOException {
        openBrowser();
        initializePageObjects();
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
