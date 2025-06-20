package steps.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import payloads.TokenCreationPayload;
import utils.APIBase;
import utils.APIConstants;
import utils.ConfigReader;

import java.io.IOException;

import static org.testng.AssertJUnit.assertTrue;

public class TokenCreationSteps extends APIBase {
    Response response;

    @When("I send a POST request to generate an authentication token with valid credentials")
    public void i_send_a_post_request_to_generate_an_authentication_token_with_valid_credentials() throws IOException {
        String email = ConfigReader.get("apiEmail");
        String password = ConfigReader.get("apiPassword");

        TokenCreationPayload payload = new TokenCreationPayload(email, password);
        response = postRequest(APIConstants.GENERATE_TOKEN_URI, payload);
    }
    @Then("the status code should be {int} or {int}")
    public void the_status_code_should_be_or(Integer int1, Integer int2) {
        int actualStatusCode = response.getStatusCode();
        assertTrue("Expected status code " + int1 + " or " + int2 + ", but got " + actualStatusCode,
                   actualStatusCode == int1 || actualStatusCode == int2);
    }
    @And("the response contains the key {string}")
    public void the_response_contains_the_key(String string) {
        String actualValue = response.jsonPath().getString(string);
        assertTrue("Expected key '" + string + "' to be present in the response, but it was not found.",
                   actualValue != null && !actualValue.isEmpty());
    }
}
