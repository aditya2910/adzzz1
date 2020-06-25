package com.codeisgood;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UrlInIncognito {

  public static void main(String[] args) {

    System.setProperty("webdriver.chrome.driver", "/Users/adityakumar/Downloads/chromedriver");

    // Initialize browser

    ChromeOptions options = new ChromeOptions();
    options.addArguments("--incognito");

    WebDriver driver=new ChromeDriver(options);
    // Open facebook
    driver.get("https://www.facebook.com");
    driver.manage().window().maximize();


  }

}
