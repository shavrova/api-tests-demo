package com.framework.core.dao;

import com.framework.core.entity.ImageDto;

public interface ImageDao {

    ImageDto getImage(String hash);

    ImageDto uploadVideo(String extension);

    ImageDto uploadImage();

    ImageDto uploadImage(String image);

    ImageDto uploadImage(byte [] bytes);

}
