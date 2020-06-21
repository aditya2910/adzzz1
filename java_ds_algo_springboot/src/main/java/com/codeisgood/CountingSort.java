package com.codeisgood;

import java.awt.*;
import java.net.URI;
import java.util.Arrays;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CountingSort {

  public static void main(String[] args) {
    int[] input = {2,5,9,8,2,8,7,10,4,3};
    countingSort(input, 1, 10);
    Arrays.stream(input).forEach(x -> System.out.print(x + " "));


    try {
      Desktop desktop = java.awt.Desktop.getDesktop();
      URI oURL = new URI("https://www.youtube.com/watch?v=j5H7gTUC4jk");
      desktop.browse(oURL);
    } catch (Exception e) {
      e.printStackTrace();
    }





    System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");

    // Initialize browser

    ChromeOptions options = new ChromeOptions();
    options.addArguments("--incognito");

    WebDriver driver=new ChromeDriver(options);
    // Open facebook
    driver.get("https://www.facebook.com");
    driver.manage().window().maximize();
  }

  private static void countingSort(int[] input, int min, int max) {
    int[] countingArray = new int[(max - min) + 1];

    for (int i = 0; i < input.length; i++) {
      int no = input[i];
      countingArray[no-1] = countingArray[no - 1] + 1;
    }

    int counter = 0;
    for (int i = 0; i < countingArray.length; i++) {
      int no = countingArray[i];
      for (int j = 0; j < no; j++) {
        input[counter] = i+1;
        counter++;
      }
    }
  }
}
