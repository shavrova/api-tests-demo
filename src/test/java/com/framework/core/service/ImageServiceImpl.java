package com.framework.core.service;

import com.framework.core.entity.ImageDto;
import com.framework.core.utils.RequestBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;


@Slf4j
@Component("imageService")
@SuppressWarnings("unchecked")
public class ImageServiceImpl implements ImageService {


    @Autowired
    RequestBuilder builder;

    @Override
    public ImageDto getImage(String hash) {
        var result = builder.getRestTemplate().exchange("3/image/" + hash, HttpMethod.GET, builder.authRequest(), ImageDto.class);
        return result.getBody();
    }

    @Override
    public <T> ImageDto postImage(T image) throws HttpClientErrorException {
        return builder.getRestTemplate().postForObject("3/upload", builder.multipartImageRequestEntity(image), ImageDto.class);
    }

    @Override
    public <T> ImageDto postImage(T image, String name, String title, String description) {
        return builder.getRestTemplate().postForObject("3/upload", builder.multipartImageRequestEntity(image, name, title, description), ImageDto.class);
    }

    @Override
    public Boolean delete(String deleteHash) {
        var result = builder.getRestTemplate().exchange("3/image/" + deleteHash, HttpMethod.DELETE, builder.authRequest(),
                String.class);
        return result.getStatusCode().is2xxSuccessful();
    }


}
