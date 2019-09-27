package com.framework.core.service;

import com.framework.core.entity.ImageDto;

public interface ImageService {

    ImageDto get(String hash);

    ImageDto postVideo(String extension);

    ImageDto post();

    ImageDto post(String image);

    ImageDto post(byte [] bytes);
}
