package com.framework.tests;

import com.framework.core.entity.ImageDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.framework.tests.TestInit.imageService;


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
            Assert.assertEquals("Image hash is not equal", uploadedImageDto.getId(), retrievedImageDto.getId());
        });
    }



}


