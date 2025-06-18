package pages;

import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class ESSDashboardPage extends CommonMethods {
    public ESSDashboardPage() {
        PageFactory.initElements(driver, this);
    }

}
