package com.sb.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
//@ImportResource("classpath:appConfig.xml")
//@Component
@ComponentScan ( {"com.sb.worker", "com.sb.endpoint", "com.sb.service"} )
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class RestServiceAppConfig extends TraceableAspect {

	@PostConstruct
    public void init(){
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.warn("###-AOP-### TraceableAspect initialized for this application");
    }
}
