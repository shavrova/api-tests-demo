package com.framework.tests;

import com.framework.core.utils.FileUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UploadImageNegTest extends BaseTest {


    @Test
    @DisplayName("Verify uploading zero bytes image doesn't allowed")
    public void uploadZeroBitesImage() {
        var uploaded = imageService.postImage(FileUtil.readFileAsBytes("src/test/resources/file-zero.jpg"));
        assertNotNull(uploaded.getException(), "No error thrown by API.");
        assertTrue(uploaded.getException().getResponseBodyAsString().contains("Invalid URL"), "Error doesn't contain in response.");
    }


    @Test
    @DisplayName("Verify uploading zero bytes image doesn't allowed")
    public void uploadLargeImage() {
        var uploaded = imageService.postImage(FileUtil.readFileAsBytes("src/test/resources/file-large.jpg"));
        assertNotNull(uploaded.getException(), "No error thrown by API.");
        assertTrue(uploaded.getException().getResponseBodyAsString().contains("Invalid URL"), "Error doesn't contain in response.");
    }


}
