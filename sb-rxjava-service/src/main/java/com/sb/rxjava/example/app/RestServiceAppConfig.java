package com.sb.rxjava.example.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

@Configuration
//@ImportResource("classpath:appConfig.xml")
//@Component
@ComponentScan ( {"com.sb.rxjava.example.app.service"} )
public class RestServiceAppConfig {

}
