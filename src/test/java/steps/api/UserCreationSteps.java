package steps.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import payloads.UserCreationPayload;
import utils.APIBase;
import utils.APIConstants;
import utils.ConfigReader;

import java.io.IOException;

import static org.testng.AssertJUnit.assertTrue;

public class UserCreationSteps extends APIBase {
    Response response;

    @When("I send a POST request to create a new user with name, email, and password")
    public void i_send_a_post_request_to_create_a_new_user_with_name_email_and_password() throws IOException {
        String name = ConfigReader.get("apiName");
        String email = ConfigReader.get("apiEmail");
        String password = ConfigReader.get("apiPassword");

        UserCreationPayload payload = new UserCreationPayload(name, email, password);

        response = postRequest(APIConstants.CREATE_USER_URI, payload);
    }
    @Then("the response status code should be {int} or {int}")
    public void the_response_status_code_should_be(Integer int1, Integer int2) {
        int actualStatusCode = response.getStatusCode();
        assertTrue("Expected status code " + int1 + " or " + int2 + ", but got " + actualStatusCode,
                   actualStatusCode == int1 || actualStatusCode == int2);
    }
}
