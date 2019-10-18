package com.framework.tests;

import com.framework.core.utils.FileUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.jupiter.api.Assertions.assertThrows;


@DisplayName("Verify error is thrown")
@Tag("API")
public class UploadImageNegTest extends BaseTest {


    @Test
    @DisplayName("Verify zero bytes image size doesn't allowed")
    public void uploadZeroBitesImage() {
        assertThrows(HttpClientErrorException.class, () ->
                imageService.postImage(FileUtil.readFileAsBytes("src/test/resources/file-zero.jpg")));
    }


    @Test
    @DisplayName("Verify image size over 10MB doesn't allowed")
    public void uploadLargeImage() {
        assertThrows(HttpClientErrorException.class, () ->
                imageService.postImage(FileUtil.readFileAsBytes("src/test/resources/image-large.jpg")));
    }

}
