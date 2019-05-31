package com.sb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

@Configuration
//@ImportResource("classpath:appConfig.xml")
//@Component
@ComponentScan ( {"com.sb.worker", "com.sb.endpoint", "com.sb.service"} )
public class RestServiceAppConfig {

}
