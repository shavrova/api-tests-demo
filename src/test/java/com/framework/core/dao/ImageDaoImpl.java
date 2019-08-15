package com.framework.core.dao;

import com.framework.core.entity.ImageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static com.framework.core.utils.MappingUtils.convertResponseToObject;
import static com.framework.core.utils.RestUtils.sendGetTo;
import static com.framework.core.utils.RestUtils.sendPostTo;


@Slf4j
@Component
public class ImageDaoImpl implements ImageDao {


    @Override
    public ImageDto getImageViaRest(String hash) throws IOException{
        return convertResponseToObject(ImageDto.class, sendGetTo("3/image/" + hash));
    }


    @Override
    public ImageDto uploadRandomImageViaRest() throws IOException {
        return convertResponseToObject(ImageDto.class, sendPostTo("3/upload"));
    }

}
