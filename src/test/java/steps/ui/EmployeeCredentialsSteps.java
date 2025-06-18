package steps.ui;

import io.cucumber.java.en.And;
import org.testng.Assert;
import utils.TestDataStorage;

import static utils.PageInitializer.pimPage;

public class EmployeeCredentialsSteps {
    @And("clicks on the create login details checkbox")
    public void clicks_on_the_create_login_details_checkbox() {
        Assert.assertTrue(pimPage.createLoginCheckbox.isDisplayed(), "Create login checkbox is not displayed");
        pimPage.createLoginCheckbox.click();
    }
    @And("enters a username and password")
    public void enters_a_username_and_password() {
        pimPage.usernameField.sendKeys("johndoedoejohn");
        pimPage.passwordField.sendKeys("qA2wsedrf!");
        pimPage.confirmPasswordField.sendKeys("qA2wsedrf!");
        Assert.assertTrue(pimPage.passwordHint.isDisplayed(), "Password hint is not displayed");
        TestDataStorage.createdUsername = "johndoedoejohn";
        TestDataStorage.createdPassword = "qA2wsedrf!";
    }
}
