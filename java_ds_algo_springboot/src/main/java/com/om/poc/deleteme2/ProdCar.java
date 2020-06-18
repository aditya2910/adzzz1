package com.om.poc.deleteme2;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("prod")
@Component
public class ProdCar  implements Car {
  @Override
  public void driveSpeed() {

  }
}
