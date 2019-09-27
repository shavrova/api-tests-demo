package com.framework.tests;

import com.framework.core.config.Config;
import com.framework.core.config.GlobalConfiguration;
import com.framework.core.service.ImageService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestInit {

  private static AnnotationConfigApplicationContext context =  new AnnotationConfigApplicationContext(Config.class);
  public static ImageService imageService = context.getBean("imageService", ImageService.class);
  public static GlobalConfiguration config  = context.getBean("globalConfiguration", GlobalConfiguration.class);

}



