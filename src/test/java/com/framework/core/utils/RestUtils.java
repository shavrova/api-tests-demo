package com.framework.core.utils;


import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.File;

import static com.framework.tests.TestInit.config;
import static io.restassured.RestAssured.given;


@Slf4j
public class RestUtils {
    private static final String token = getAccessToken();


    public static String getAccessToken() throws JSONException {
        log.info("getting access token for user: " + config.getUsername() + ". grant_type : " + " password.");
        Response response = given().auth().preemptive().basic(config.getClientId(), config.getClientSecret())
                            .formParam("grant_type", "password")
                            .formParam("username", config.getUsername())
                            .formParam("password", config.getPassword())
                            .when()
                            .post(config.getTokenUri());

        JSONObject jsonObject = new JSONObject(response.getBody().asString());
        return jsonObject.get("access_token").toString();
    }

    public static String sendGetTo(String path){
        log.info("Sending GET request to " + config.getBaseUrl()+path);
        String responce = given(). accept("application/vnd.api+json")
                        .headers(
                                "Authorization",
                                "Bearer " + token)
                        .when()
                        .filter(new AllureRestAssured())
                        .get(config.getBaseUrl()+path.replace("{{username}}", config.getUsername()))
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .extract()
                        .response()
                        .asString();
        log.info("RESPONSE: " + responce);
        return responce;
    }

    public static String sendPostTo(String path){
        log.info("Sending POST request to " + config.getBaseUrl()+path);
        return given()
                .headers(
                        "Authorization",
                        "Bearer " + token)
                .baseUri(config.getBaseUrl())
                .basePath(path)
                .multiPart("image", new File("src/test/resources/image.jpg"), "application/octet-stream")
                .filter(new AllureRestAssured())
                .post()
                .then()
                .extract()
                .asString();
    }

}