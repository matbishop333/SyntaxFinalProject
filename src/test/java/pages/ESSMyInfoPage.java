package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class ESSMyInfoPage extends CommonMethods {
    public ESSMyInfoPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='message warning fadable']")
    public WebElement warningMessage;

    @FindBy(id = "empPic")
    public WebElement profilePicture;

    @FindBy(id = "photofile")
    public WebElement chooseFileButton;

    @FindBy(id = "btnSave")
    public WebElement saveButton;
}
