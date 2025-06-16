package steps.ui;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonMethods;
import org.testng.Assert;
import utils.ConfigReader;
import utils.Constants;

import java.io.IOException;
import java.time.Duration;


public class LoginSteps extends CommonMethods {
    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        waitForElement(loginPage.loginPanelHeading);
        Assert.assertTrue(loginPage.loginPanelHeading.isDisplayed(), "Login page is not displayed");
    }
    @When("I enter a valid username")
    public void i_enter_a_valid_username() throws IOException {
        loginPage.userNameField.sendKeys(ConfigReader.get("username"));
    }
    @When("I enter a valid password")
    public void i_enter_a_valid_password() throws IOException {
        loginPage.passwordField.sendKeys(ConfigReader.get("password"));
    }
    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPage.loginButton.click();
    }
    @Then("I should be redirected to the dashboard page")
    public void i_should_be_redirected_to_the_dashboard_page() {
        Assert.assertTrue(dashboardPage.dashboardHeader.isDisplayed(), "Dashboard page is not displayed");
    }

    @When("I enter an invalid username")
    public void i_enter_an_invalid_username() {
        loginPage.userNameField.sendKeys("invalidUser");
    }

    @Then("I should see an error message indicating invalid credentials")
    public void i_should_see_an_error_message_indicating_invalid_credentials() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
        wait.until(ExpectedConditions.visibilityOf(loginPage.errorMessage));
        String actualMessage = loginPage.errorMessage.getText();
        Assert.assertEquals(actualMessage, "Invalid credentials");
    }

    @When("I enter an invalid password")
    public void i_enter_an_invalid_password() {
        loginPage.passwordField.sendKeys("invalidPass");
    }

}
