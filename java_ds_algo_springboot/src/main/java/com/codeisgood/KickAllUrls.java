package com.codeisgood;


import java.awt.Desktop;
import java.net.URI;
import java.util.Arrays;

public class KickAllUrls {

  public static void main(String[] args) {
    String[] urls = {
        "https://www.youtube.com/watch?v=VqjXQL7EerE",
        "https://www.youtube.com/watch?v=HDGmKuu4rGA",
        "https://www.youtube.com/watch?v=n9d49cZHQc4",
        "https://www.youtube.com/watch?v=0ebDEoZr4X8",
        "https://www.youtube.com/watch?v=j5H7gTUC4jk",
        "https://www.youtube.com/watch?v=hBbecURfhko",
        "https://www.youtube.com/watch?v=t75LZxiW5B8",
        "https://www.youtube.com/watch?v=dh7ds0Fb5rk",
        "https://www.youtube.com/watch?v=R_XR67gmny4",
        "https://www.youtube.com/watch?v=VT-k8JHlK-g",
        "https://www.youtube.com/watch?v=ntPzyQF_ygk"
    };

    Arrays.stream(urls).forEach(url -> openUrlInBrowser(url));
  }

  private static void openUrlInBrowser(final String url) {
    try {
      Desktop desktop = java.awt.Desktop.getDesktop();
      URI oURL = new URI(url);
      desktop.browse(oURL);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
