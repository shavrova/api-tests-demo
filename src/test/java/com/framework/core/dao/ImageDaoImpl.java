package com.framework.core.dao;

import com.framework.core.entity.ImageDto;
import com.framework.core.utils.RequestBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.stereotype.Component;

import static com.framework.core.utils.MappingUtils.convertResponseToObject;


@Slf4j
@Component
public class ImageDaoImpl implements ImageDao {


    @Override
    public ImageDto getImage(String hash){
        return convertResponseToObject(ImageDto.class, RequestBuilder.sendGetTo("3/image/" + hash));
    }


    public ImageDto uploadVideo(String extension){
        return convertResponseToObject(ImageDto.class, RequestBuilder.uploadVideo(extension));
    }

    @Override
    public ImageDto uploadImage(){
        return convertResponseToObject(ImageDto.class, RequestBuilder.uploadImage());
    }

    @Override
    public ImageDto uploadImage(String image) {
        String response;
        UrlValidator urlValidator = new UrlValidator();
        if(urlValidator.isValid(image)){
            response =  RequestBuilder.uploadFromURL(image);
        }
        else {
            response = RequestBuilder.uploadBase64(image);
        }
        return convertResponseToObject(ImageDto.class, response);
    }


    @Override
    public ImageDto uploadImage(byte [] bytes){
        return convertResponseToObject(ImageDto.class, RequestBuilder.uploadImage(bytes));
    }
}
