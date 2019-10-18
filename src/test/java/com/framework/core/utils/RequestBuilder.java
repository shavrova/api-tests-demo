package com.framework.core.utils;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.util.ArrayList;
import java.util.List;


@Component
@Configuration
@PropertySource("classpath:config.properties")
public class RequestBuilder {

    @Value("${app.token.uri}")
    private String tokenUri;

    @Value("${app.username}")
    private String username;

    @Value("${app.password}")
    private String password;

    @Value("${app.client.id}")
    private String clientId;

    @Value("${app.client.secret}")
    private String clientSecret;

    @Value("${app.base.url}")
    private String baseUrl;

    private RestTemplate restTemplate;


    public RequestBuilder() {
        restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));

        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new RequestResponseLoggingInterceptor());
        restTemplate.setInterceptors(interceptors);

    }

    public RestTemplate getRestTemplate() {
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(baseUrl));

        return restTemplate;
    }

    private String getToken() {
        ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
        resourceDetails.setGrantType("password");
        resourceDetails.setAccessTokenUri(tokenUri);

        resourceDetails.setClientId(clientId);
        resourceDetails.setClientSecret(clientSecret);

        resourceDetails.setUsername(username);
        resourceDetails.setPassword(password);

        System.out.println("PASSWORD: " + password);
        return new OAuth2RestTemplate(resourceDetails).getAccessToken().getValue();
    }


    private HttpHeaders setTokenAuthorization(HttpHeaders headers) {
        headers.setBearerAuth(getToken());
        return headers;
    }


    public HttpEntity authRequest() {
        return new HttpEntity(setTokenAuthorization(new HttpHeaders()));
    }


    public HttpEntity<MultiValueMap<String, Object>> multipartImageRequestEntity(Object data) {
        HttpHeaders headers = new HttpHeaders();
        setTokenAuthorization(headers);
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("image", data);
        return new HttpEntity<>(body, headers);
    }

    public <T> HttpEntity<MultiValueMap<String, Object>> multipartImageRequestEntity(T data, String name, String title, String description) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(getToken());
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("image", data);
        body.add("type", "URL");
        body.add("name", name);
        body.add("title", title);
        body.add("description", description);
        return new HttpEntity<>(body, headers);
    }

}