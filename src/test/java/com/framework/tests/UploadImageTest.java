package com.framework.tests;

import com.framework.core.entity.ImageDto;
import com.framework.core.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.framework.tests.TestInit.imageService;
import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("Verify image is uploaded")
@Slf4j
@Tag("API")
public class UploadImageTest {

    @Test
    @DisplayName("Verify binary image is uploaded successfully")
    public void uploadBinaryFile()throws IOException{
        ImageDto uploadedImage = imageService.post(Files.readAllBytes(Paths.get("src/test/resources/image.jpg")));
        ImageDto retrievedImage = imageService.get(uploadedImage.getId());
        assertEquals(uploadedImage.getId(), retrievedImage.getId(), "Image hash is not equal");
        assertEquals(uploadedImage.getSize(), retrievedImage.getSize(), "Uploaded and retrieved files have different size.");
    }

    @Test
    @DisplayName("Verify base64 data is uploaded successfully")
    public void uploadBase64data(){
        ImageDto uploadedImage = imageService.post(FileUtils.readFile("src/test/resources/image-base64"));
        ImageDto retrievedImage = imageService.get(uploadedImage.getId());
        assertEquals(uploadedImage.getId(), retrievedImage.getId(), "Image hash is not equal");
        assertEquals(uploadedImage.getSize(), retrievedImage.getSize(), "Uploaded and retrieved files have different size.");
    }

    @Test
    @DisplayName("Verify image from URL is uploaded successfully")
    public void uploadFromURL(){
        ImageDto uploadedImage = imageService.post("https://sample-videos.com/img/Sample-jpg-image-50kb.jpg");
        ImageDto retrievedImage = imageService.get(uploadedImage.getId());
        assertEquals(uploadedImage.getId(), retrievedImage.getId(), "Image hash is not equal");
        assertEquals(uploadedImage.getSize(), retrievedImage.getSize(), "Uploaded and retrieved files have different size.");
    }

}


