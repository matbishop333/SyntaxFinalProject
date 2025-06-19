package steps.ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.ESSDashboardPage;
import utils.CommonMethods;
import utils.ConfigReader;
import utils.TestDataStorage;

import java.io.IOException;

public class ProfilePictureSteps extends CommonMethods {

    @Given("the user is logged in with valid ESS credentials")
    public void theUserIsLoggedInWithValidESSCredentials() throws IOException {
        loginPage.userNameField.sendKeys(ConfigReader.get("createdUserName"));
        loginPage.passwordField.sendKeys(ConfigReader.get("createdUserPassword"));
        loginPage.loginButton.click();
    }

    @And("click on the my info tab")
    public void click_on_the_my_info_tab() {
        essDashboardPage.myInfoTab.click();
    }
    @And("click on the profile picture")
    public void click_on_the_profile_picture() {
        essMyInfoPage.profilePicture.click();
    }

    @And("then select a profile picture file")
    public void then_select_a_profile_picture_file() {
        essMyInfoPage.chooseFileButton.sendKeys(TestDataStorage.validProfilePictureFilePath);
    }
    @And("click on the upload button")
    public void click_on_the_upload_button() {
        essMyInfoPage.saveButton.click();
    }
    @Then("I should see a success message indicating the profile picture has been uploaded successfully")
    public void i_should_see_a_success_message_indicating_the_profile_picture_has_been_uploaded_successfully() {
        WebElement message = essMyInfoPage.successMessage;
        String text = message.getText();

        try {
            WebElement toast = driver.findElement(By.className("message"));
            String toastText = toast.getText();
            System.out.println("Captured message: " + toastText);
            Assert.assertTrue(toastText.contains("Successfully Uploaded"));
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            Assert.fail("Success message not found or disappeared too quickly.");
        }


    }

    @And("then select a profile picture file that is too large")
    public void thenSelectAProfilePictureFileThatIsTooLarge() {
        essMyInfoPage.chooseFileButton.sendKeys(TestDataStorage.invalidProfilePictureFilePath);


    }

    @Then("I should see a failure message indicating the profile picture was too large to upload")
    public void iShouldSeeAFailureMessageIndicatingTheProfilePictureWasTooLargeToUpload() {
        WebElement message = essMyInfoPage.warningMessage;
        String text = message.getText();

        try {
            WebElement toast = driver.findElement(By.className("message"));
            String toastText = toast.getText();
            System.out.println("Captured message: " + toastText);
            Assert.assertTrue(toastText.contains("Failed to Save: File Size Exceeded"));
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            Assert.fail("Success message not found or disappeared too quickly.");
        }
    }
}
