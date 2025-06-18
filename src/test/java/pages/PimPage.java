package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class PimPage extends CommonMethods {
    public PimPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "btnAdd")
    public WebElement addEmployeeButton;

    @FindBy(id = "firstName")
    public WebElement firstNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(id = "employeeId")
    public WebElement employeeIdField;

    @FindBy(id = "btnSave")
    public WebElement saveButton;

    @FindBy(id="profile-pic")
    public WebElement profilePic;

    @FindBy(id = "personal_txtEmployeeId")
    public WebElement personalEmployeeIdField;

    public void clickSaveButton() {
        saveButton.click();
    }

    public void clickAddEmployeeButton() {
        addEmployeeButton.click();
    }
}
