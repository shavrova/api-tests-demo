package com.framework.core.service;

import com.framework.core.entity.ImageDto;
import com.framework.core.utils.RequestBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;


@Slf4j
@Component("imageService")
public class ImageServiceImpl implements ImageService {


    @Autowired
    RequestBuilder restTemplate;

    @Override
    public ImageDto getImage(String hash) {
        return restTemplate.setAuth().getForObject("3/image/" + hash, ImageDto.class);
    }

    @Override
    public <T> ImageDto postImage(T image) {
        try {
            return restTemplate.setAuth().postForObject("3/upload", restTemplate.multipartImageRequestEntity(image), ImageDto.class);
        } catch (HttpClientErrorException ex) {
            return new ImageDto(ex);
        }
    }

    @Override
    public <T> ImageDto postImage(T image, String name, String title, String description) {
        return restTemplate.setAuth().postForObject("3/upload", restTemplate.multipartImageRequestEntity(image, name, title, description), ImageDto.class);
    }

    @Override
    public Boolean delete(String deleteHash) {
        var result = restTemplate.setAuth().exchange("3/image/" + deleteHash, HttpMethod.DELETE, null,
                String.class);
        return result.getStatusCode().is2xxSuccessful();
    }


}
