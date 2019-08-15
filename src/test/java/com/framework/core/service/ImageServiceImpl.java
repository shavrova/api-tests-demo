package com.framework.core.service;

import com.framework.core.dao.ImageDao;
import com.framework.core.entity.ImageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Slf4j
@Component("imageService")
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageDao imageDao;

    @Override
    public ImageDto getImage(String hash) throws IOException {
        return imageDao.getImageViaRest(hash);
    }


    @Override
    public ImageDto uploadImage() throws IOException{
        return imageDao.uploadRandomImageViaRest();
    }







}
