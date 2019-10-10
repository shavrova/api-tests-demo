package com.framework.core.service;

import com.framework.core.entity.ImageDto;

public interface ImageService {

    ImageDto getImage(String hash);

    <T> ImageDto postImage(T image);

    <T> ImageDto postImage(T image, String name, String title, String description);

    Boolean delete(String deleteHash);

}
