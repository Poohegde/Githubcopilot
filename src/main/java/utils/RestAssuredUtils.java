package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestAssuredUtils {

    public RestAssuredUtils() {
        String apiBaseUrl = System.getenv("REST_BASE_URL");
        if (apiBaseUrl == null || apiBaseUrl.isEmpty()) {
            apiBaseUrl = System.getenv("API_BASE_URL");
        }
        RestAssured.baseURI = apiBaseUrl;
    }

    public Response getRequest(String endpoint) {
        return given()
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    public Response postRequest(String endpoint, Object body) {
        return given()
                .contentType("application/json")
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }

    public Response putRequest(String endpoint, Object body) {
        return given()
                .contentType("application/json")
                .body(body)
                .when()
                .put(endpoint)
                .then()
                .extract()
                .response();
    }

    public Response deleteRequest(String endpoint) {
        return given()
                .when()
                .delete(endpoint)
                .then()
                .extract()
                .response();
    }

    public int getStatusCode(Response response) {
        return response.getStatusCode();
    }

    public String getResponseBody(Response response) {
        return response.getBody().asString();
    }
}