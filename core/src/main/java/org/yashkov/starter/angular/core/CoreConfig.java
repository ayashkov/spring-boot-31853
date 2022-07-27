package org.yashkov.starter.angular.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Lazy;

@Configuration
@ComponentScan
@ImportResource("classpath*:context.xml")
@Lazy
public class CoreConfig {
}
