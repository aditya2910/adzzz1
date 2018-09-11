package com.sb.service.test.primary;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Bmw implements Car {

	@Override
	public void wheels() {
		System.out.println("I am bmw wheel");
	}

}
