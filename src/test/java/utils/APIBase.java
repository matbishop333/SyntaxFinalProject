package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIBase {
    public static RequestSpecification prepareRequest() {
        return RestAssured.given()
                .baseUri(APIConstants.BASE_URI)
                .contentType("application/json")
                .accept("application/json");
    }

    public static Response postRequest(String endpoint, Object payload) {
        return prepareRequest()
                .body(payload)
                .post(endpoint);
    }

    public static String getToken(String email, String password) {
        TokenPayload payload = new TokenPayload(email, password);

        Response response = prepareRequest()
                .body(payload)
                .post(APIConstants.GENERATE_TOKEN_URI);

        return response.jsonPath().getString("token");
    }



}
