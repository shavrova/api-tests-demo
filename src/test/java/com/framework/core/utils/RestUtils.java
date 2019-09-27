package com.framework.core.utils;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;

import static com.framework.tests.TestInit.config;
import static io.restassured.RestAssured.given;


@Slf4j
public class RestUtils {

    public static String getAccessToken() {
        log.info(String.format("Retrieving access token for username %s. Grant type: password.", config.getUsername()));
        Response response = given()
                .auth().preemptive().basic(config.getClientId(), config.getClientSecret())
                .formParam("grant_type", "password")
                .formParam("username", config.getUsername())
                .formParam("password", config.getPassword())
                .when()
                .post(config.getTokenUri());
        JSONObject jsonObject = new JSONObject(response.getBody().asString());
        String token = jsonObject.get("access_token").toString();
        log.info("Retrieved access token: " + token);
        return token;
    }
}