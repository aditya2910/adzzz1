package com.sb.start;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan ( {"com.sb.worker", "com.sb.endpoint", "com.sb.service.logging"} )
public class SampleAppConfig {

}
