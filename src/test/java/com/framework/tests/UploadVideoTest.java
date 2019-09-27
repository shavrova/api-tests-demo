package com.framework.tests;


import com.framework.core.entity.ImageDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.framework.tests.TestInit.imageService;
import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("/upload endpoint tests. Upload Video")
@Slf4j
@Tag("API")
public class UploadVideoTest {


    @DisplayName("Verify that accepted video formats can be uploaded successfully")
    @ParameterizedTest(name = "{0} video file is uploaded")
    @CsvSource({".avi", ".flv", ".mkv", ".mov", ".mp4", ".mpeg", ".webm", ".wmv"})
    public void uploadAcceptedVideoFormat(String extension){
        ImageDto uploadedVideo = imageService.post(extension);
        ImageDto retrievedVideo = imageService.get(uploadedVideo.getId());
        assertEquals(uploadedVideo.getType(), retrievedVideo.getType(), "Uploaded and retrieved files have different type.");
        assertEquals(uploadedVideo.getSize(), retrievedVideo.getSize(), "Uploaded and retrieved files have different size.");
    }

}
