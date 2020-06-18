package com.om.poc.deleteme2;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("dev")
@Component
public class DevCar implements Car {
  @Override
  public void driveSpeed() {
    //logic
  }
}
