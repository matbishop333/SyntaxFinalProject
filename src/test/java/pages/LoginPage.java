package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "logInPanelHeading")
    public WebElement loginPanelHeading;

    @FindBy(id = "txtUsername")
    public WebElement userNameField;

    @FindBy(id = "txtPassword")
    public WebElement passwordField;

    @FindBy(id = "btnLogin")
    public WebElement loginButton;

    @FindBy(id = "spanMessage")
    public WebElement errorMessage;


}
