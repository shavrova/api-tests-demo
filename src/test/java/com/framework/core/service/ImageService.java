package com.framework.core.service;

import com.framework.core.entity.ImageDto;

import java.io.IOException;

public interface ImageService {

    ImageDto getImage(String hash) throws IOException;

    ImageDto uploadImage() throws IOException;


}
