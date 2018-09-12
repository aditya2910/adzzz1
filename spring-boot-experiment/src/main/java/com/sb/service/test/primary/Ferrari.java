package com.sb.service.test.primary;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("ferrari")
@Primary
public class Ferrari implements Car {

	@Override
	public void wheels() {
		System.out.println("I am ferrari wheel");
	}

}
