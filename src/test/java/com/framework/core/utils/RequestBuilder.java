package com.framework.core.utils;


import com.framework.core.config.GlobalConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;


@Component
public class RequestBuilder {

    @Autowired
    private GlobalConfiguration config;


    public RestTemplate setAuth() {

        ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
        resourceDetails.setGrantType("password");
        resourceDetails.setAccessTokenUri(config.getTokenUri());

        resourceDetails.setClientId(config.getClientId());
        resourceDetails.setClientSecret(config.getClientSecret());

        resourceDetails.setUsername(config.getUsername());
        resourceDetails.setPassword(config.getPassword());
        RestTemplate restTemplate = new OAuth2RestTemplate(resourceDetails);
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(config.getBaseUrl()));

        return restTemplate;
    }


    public HttpEntity<MultiValueMap<String, Object>> multipartImageRequestEntity(Object data) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("image", data);
        return new HttpEntity<>(body, headers);
    }

    public <T> HttpEntity<MultiValueMap<String, Object>> multipartImageRequestEntity(T data, String name, String title, String description) {
        HttpHeaders headers = new HttpHeaders();
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