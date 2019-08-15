package com.framework.core.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Configuration
@PropertySource("classpath:config.properties")
public class GlobalConfiguration {

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

}
