package steps.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.APIBase;

public class UserCreationSteps extends APIBase {
    @When("I send a POST request to create a new user with name, email, and password")
    public void i_send_a_post_request_to_create_a_new_user_with_name_email_and_password() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @And("the response should contain the user's email")
    public void the_response_should_contain_the_user_s_email() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @And("I store the created user data for future tests")
    public void i_store_the_created_user_data_for_future_tests() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
