package com.framework.core.dao;

import com.framework.core.entity.ImageDto;

import java.io.IOException;

public interface ImageDao {

    ImageDto getImageViaRest(String hash) throws IOException;

    ImageDto uploadRandomImageViaRest() throws IOException;

}
