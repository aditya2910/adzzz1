package com.om.poc.deleteme;

public class ThreadWaitTest {

  public static void main(String [] args)
  {
    System.out.print("1 ");
    synchronized(args)
    {
      System.out.print("2 ");
      try
      {
        args.wait(); /* Line 11 */
        System.out.print("3 ");
      }
      catch(InterruptedException e){ }
    }
    System.out.print("4 ");
  }

}
