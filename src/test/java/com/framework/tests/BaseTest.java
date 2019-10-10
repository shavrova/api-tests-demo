package com.framework.tests;


import com.framework.core.config.SpringTestConfiguration;
import com.framework.core.service.ImageService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SpringTestConfiguration.class})
@ExtendWith(SpringExtension.class)
public class BaseTest {

    @Autowired
    ImageService imageService;
}
