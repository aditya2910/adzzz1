package com.demo.orgname.pf;


import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan ( {"com.demo.orgname.pf"} )
@EnableTransactionManagement
@EnableJpaRepositories
@Import(RepositoryRestMvcConfiguration.class)
@EnableAutoConfiguration
public class ServerPfAppConfig {
	private static final Logger logger = Logger.getLogger(ServerPfAppConfig.class.getName());

}
