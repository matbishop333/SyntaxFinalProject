package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.TokenCreationPayload;

public class APIBase {
    public static RequestSpecification prepareRequest() {
        RestAssured.baseURI = APIConstants.BASE_URI;

        return RestAssured
                .given()
                .contentType("application/json")
                .accept("application/json");
    }

    public static Response postRequest(String endpoint, Object payload) {
        return prepareRequest()
                .body(payload)
                .post(endpoint);
    }

    public static String getToken(String email, String password) {
        TokenCreationPayload payload = new TokenCreationPayload(email, password);

        Response response = prepareRequest()
                .body(payload)
                .post(APIConstants.GENERATE_TOKEN_URI);

        return response.jsonPath().getString("token");
    }




}
