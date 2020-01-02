package com.om.poc.java.resourcetrycatch;

/**
 * A try-with-resources block can still have the catch and finally blocks – which will work in the same way as with a traditional try block.
 *
 */
public class AutoCloseableTest {

  public static void main(String[] args) throws Exception {
    try (AutoCloseableResourcesFirst af = new AutoCloseableResourcesFirst();
        AutoCloseableResourcesSecond as = new AutoCloseableResourcesSecond()) {

      // Resources that were defined/acquired first will be closed last
      af.doSomething();
      as.doSomething();
    }
  }
}
