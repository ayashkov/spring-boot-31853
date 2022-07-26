package org.yashkov.sbe.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.yashkov.sbe.core.CoreConfig;

@SpringBootApplication
@EnableHypermediaSupport(type = HypermediaType.HAL)
@Import(CoreConfig.class)
public class WebApp {
    public static void main(String[] args)
    {
        SpringApplication.run(WebApp.class, args);
    }
}
