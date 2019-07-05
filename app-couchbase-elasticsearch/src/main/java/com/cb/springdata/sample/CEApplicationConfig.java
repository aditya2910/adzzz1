package com.cb.springdata.sample;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

@Configuration
public class CEApplicationConfig extends AbstractCouchbaseConfiguration {

	@Override
	protected List<String> getBootstrapHosts() {
		return Collections.singletonList("127.0.0.1");
	}

	@Override
	protected String getBucketName() {
		return "PracticeBucket";
	}

	@Override
	protected String getBucketPassword() {
		return "adminadmin";
	}
	
	

}
