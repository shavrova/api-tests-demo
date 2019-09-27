package com.framework.core.utils;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;

import static com.framework.core.utils.RestUtils.getAccessToken;
import static io.restassured.RestAssured.given;

import static com.framework.tests.TestInit.config;

public class RequestBuilder {

    private static final String token = getAccessToken();

    private static RequestSpecification baseRequest() {
        return given()
                .log().uri()
                .headers(
                        "Authorization",
                        "Bearer " + token)
                .baseUri(config.getBaseUrl())
                .filter(new AllureRestAssured());
    }


    private static RequestSpecification upload(){
        return baseRequest()
                .basePath("3/upload");
    }

    public static String uploadImage(byte[] bytes) {
        return upload()
                .multiPart("image", bytes)
                .post()
                .prettyPeek()
                .asString();
    }


    public static String sendGetTo(String path) {
        return baseRequest()
                .get(path)
                .prettyPeek()
                .asString();
    }

    public static Response get(String path) {
        return baseRequest()
                .get(path.replace("{{username}}", config.getUsername()))
                .prettyPeek();
    }



    public static String uploadImage() {
        return upload()
                .multiPart("image", new File("src/test/resources/image.jpg"))
                .post()
                .prettyPeek()
                .asString();
    }

    public static String uploadBase64(String image) {
        return upload()
                .multiPart("image", image)
                .filter(new AllureRestAssured())
                .post()
                .prettyPeek()
                .asString();
    }

    public static String uploadFromURL(String url) {
        return upload()
                .multiPart("image", url)
                .post()
                .prettyPeek()
                .asString();
    }

    public static String uploadVideo(String extension) {
        return upload()
                .multiPart("video", new File("src/test/resources/sample-video/" + "video" + extension))
                .post()
                .prettyPeek()
                .asString();
    }

}
