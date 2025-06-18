package steps.ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import utils.CommonMethods;
import utils.ConfigReader;
import utils.DBUtility;

import java.io.IOException;
import java.sql.ResultSet;

public class AddEmployeeSteps extends CommonMethods {
    @Given("the user is logged in with valid credentials")
    public void the_user_is_logged_in_with_valid_credentials() throws IOException {
        loginPage.userNameField.sendKeys(ConfigReader.get("username"));
        loginPage.passwordField.sendKeys(ConfigReader.get("password"));
        loginPage.loginButton.click();
    }
    @And("User navigates to the PIM")
    public void user_navigates_to_the_pim() {
        waitForElement(dashboardPage.pimButton);
        dashboardPage.pimButton.click();
    }
    @And("the user clicks on Add button")
    public void the_user_clicks_on_add_button() {
        waitForElement(pimPage.addEmployeeButton);
        pimPage.addEmployeeButton.click();
    }
    @And("enters the employee's first name {string} and last name {string}")
    public void enters_the_employee_s_first_name_and_last_name(String string, String string2) {
        pimPage.firstNameField.sendKeys(string);
        pimPage.lastNameField.sendKeys(string2);
    }
    @And("the user clicks on Save button")
    public void the_user_clicks_on_save_button() {
        pimPage.saveButton.click();
    }
    @Then("the user will be taken to the employee personal details page")
    public void the_user_will_be_taken_to_the_employee_personal_details_page() {
        String expectedEmployeeName = "john doe";
        String actualEmployeeName = pimPage.profilePic.getText().toLowerCase();
        Assert.assertEquals(actualEmployeeName, expectedEmployeeName, "Employee name does not match!");
    }

    @And("enters a unique employee id {string}")
    public void enters_a_unique_employee_id(String string) {
        pimPage.employeeIdField.clear();
        pimPage.employeeIdField.sendKeys(string);
    }
    @And("the user will be taken to the employee personal details page and sees the employee id {string}")
    public void the_user_will_be_taken_to_the_employee_personal_details_page_and_sees_the_employee_id(String string) {
        String actualEmployeeId = pimPage.personalEmployeeIdField.getAttribute("value");
        Assert.assertEquals(actualEmployeeId, string, "Employee ID does not match!");
    }

    @Then("the employee with ID {string} should be present in the database")
    public void theEmployeeWithIDShouldBePresentInTheDatabase(String string) {
        try {
            DBUtility.connectToDB();
            String query = "SELECT * FROM hs_hr_employees WHERE employee_id = '" + string + "'";
            ResultSet resultSet = DBUtility.executeQuery(query);
            Assert.assertTrue(resultSet.next(), "Employee with ID " + string + " not found in the database.");
            DBUtility.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Database operation failed: " + e.getMessage());
        }
    }
}
