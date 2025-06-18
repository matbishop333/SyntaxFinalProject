package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class ESSDashboardPage extends CommonMethods {
    public ESSDashboardPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "menu_pim_viewMyDetails")
    public WebElement myInfoTab;


}
