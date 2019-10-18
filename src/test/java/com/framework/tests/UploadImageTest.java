package com.framework.tests;

import com.framework.core.utils.FileUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Verify image is uploaded")
@Tag("API")
public class UploadImageTest extends BaseTest {

    @Test
    @DisplayName("Verify binary image is uploaded successfully")
    public void uploadBinaryFile() {
        var uploadedImage = imageService.postImage(FileUtil.readFileAsBytes("src/test/resources/image.jpg"));
        var retrievedImage = imageService.getImage(uploadedImage.getId());
        assertEquals(uploadedImage.getId(), retrievedImage.getId(), "Image hash is not equal");
        assertEquals(uploadedImage.getSize(), retrievedImage.getSize(), "Uploaded and retrieved files have different size.");
    }

    @Test
    @DisplayName("Verify base64 data is uploaded successfully")
    public void uploadBase64data() {
        var uploadedImage = imageService.postImage(FileUtil.readFileAsString("src/test/resources/image-base64"));
        var retrievedImage = imageService.getImage(uploadedImage.getId());
        assertEquals(uploadedImage.getId(), retrievedImage.getId(), "Image hash is not equal");
        assertEquals(uploadedImage.getSize(), retrievedImage.getSize(), "Uploaded and retrieved files have different size.");
    }

    @Test
    @DisplayName("Verify image from URL is uploaded successfully")
    public void uploadFromURL() {
        var uploadedImage = imageService.postImage("https://www.w3schools.com/w3css/img_lights.jpg");
        var retrievedImage = imageService.getImage(uploadedImage.getId());
        assertEquals(uploadedImage.getId(), retrievedImage.getId(), "Image hash is not equal");
        assertEquals(uploadedImage.getSize(), retrievedImage.getSize(), "Uploaded and retrieved files have different size.");
    }


    @Test
    @DisplayName("Upload image with optional parameters")
    public void uploadImageWithOptionalParams() {
        var uploadedImage = imageService.postImage(
                FileUtil.readFileAsBytes("src/test/resources/image.jpg"),
                "Image name",
                "Image title",
                "Some interesting description");
        var retrievedImage = imageService.getImage(uploadedImage.getId());
        assertEquals(uploadedImage.getName(), retrievedImage.getName());
        assertEquals(uploadedImage.getTitle(), retrievedImage.getTitle());
        assertEquals(uploadedImage.getDescription(), retrievedImage.getDescription());
    }


    @Test
    @DisplayName("Verify image deleted successfully")
    public void deleteImage() {
        var uploadedImage = imageService.postImage("https://www.w3schools.com/w3css/img_lights.jpg");
        assertTrue(imageService.delete(uploadedImage.getDeleteHash()), "Image wasn't deleted.");
    }


}


