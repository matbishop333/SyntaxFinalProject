package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class DashboardPage extends CommonMethods {
    public DashboardPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h1")
    public WebElement dashboardHeader;

    @FindBy(id = "menu_dashboard_index")
    public WebElement dashboardButton;

    @FindBy(id = "menu_pim_viewPimModule")
    public WebElement pimButton;

    public void clickDashboardButton() {
        dashboardButton.click();
    }

    public void clickPimButton() {
        pimButton.click();
    }
}
