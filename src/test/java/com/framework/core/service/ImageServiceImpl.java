package com.framework.core.service;

import com.framework.core.dao.ImageDao;
import com.framework.core.entity.ImageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Slf4j
@Component("imageService")
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageDao imageDao;

    @Override
    public ImageDto get(String hash) {
        return imageDao.getImage(hash);
    }

    @Override
    public ImageDto postVideo(String extension){
        return imageDao.uploadVideo(extension);
    }

    @Override
    public ImageDto post() {
        return imageDao.uploadImage();
    }

    @Override
    public ImageDto post(String image) {
        return imageDao.uploadImage(image);
    }

    @Override
    public ImageDto post(byte [] bytes ) {
        return imageDao.uploadImage(bytes);
    }


}
