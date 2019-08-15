package com.framework.tests;

import com.framework.core.entity.ImageDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.framework.tests.TestInit.imageService;
import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("Verify image is uploaded")
@Slf4j
@Tag("API")
public class ImageTest {

    @Test
    public void demo2() {
        System.out.println("DEMO2!");
    }

    @Test
    public void demo3() {
        System.out.println("DEMO3!");
    }

    @Tag("API")
    @Test
    public void verifyImageIsUploaded() {
        Assertions.assertDoesNotThrow(() -> {
            ImageDto uploadedImageDto = imageService.uploadImage();
            ImageDto retrievedImageDto = imageService.getImage(uploadedImageDto.getId());
            assertEquals(uploadedImageDto.getId(), retrievedImageDto.getId(), "Image hash is not equal");
        });
    }



}


