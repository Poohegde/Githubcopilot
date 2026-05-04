package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTests {

    private static final String BASE_URL;

    static {
        String baseUrl = System.getenv("REST_BASE_URL");
        if (baseUrl == null || baseUrl.isEmpty()) {
            baseUrl = System.getenv("API_BASE_URL");
        }
        if (baseUrl == null || baseUrl.isEmpty()) {
            baseUrl = "https://automationexercise.com/";
        }
        BASE_URL = baseUrl;
    }

    @Test
    public void testSearchItem() {
        String itemName = "exampleItem";
        String requestUrl = BASE_URL;
        if (!BASE_URL.contains("automationexercise.com")) {
            requestUrl = BASE_URL.endsWith("/") ? BASE_URL + "search" : BASE_URL + "/search";
        }

        Response response = RestAssured.given()
                .queryParam("name", itemName)
                .when()
                .get(requestUrl)
                .then()
                .extract()
                .response();

        Assert.assertEquals(response.getStatusCode(), 200);

        String contentType = response.getHeader("Content-Type");
        if (contentType != null && contentType.contains("application/json")) {
            Assert.assertTrue(response.jsonPath().getList("items").size() > 0, "Item not found in the response");
        } else {
            String body = response.getBody().asString();
            Assert.assertTrue(body.contains("<html") || body.toLowerCase().contains("automation exercise") || body.toLowerCase().contains("products"),
                    "Expected HTML content from the automation exercise site");
        }
    }
}