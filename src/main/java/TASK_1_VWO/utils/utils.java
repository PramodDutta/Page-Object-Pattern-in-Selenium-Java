package TASK_1_VWO.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by pramo_000 on 08-04-2016.
 */
public class utils {

    public static final String BASE_URL = "http://app.vwo.com/#/campaign/108/summary?token=eyJhY2NvdW50X2lkIjoxNTA3MzQsImV4cGVyaW1lbnRfaWQiOjEwOCwiY3JlYXRlZF9vbiI6MTQ0NDgxMjQ4MSwidHlwZSI6ImNhbXBhaWduIiwidmVyc2lvbiI6MSwiaGFzaCI6IjJmZjk3OTVjZTgwNmFmZjJiOTI5NDczMTc5YTBlODQxIn0";
    public static WebDriver driver  = new FirefoxDriver();
    public static String[] getConfig()
    {
            String []temp = null;
        temp [0] = BASE_URL;
        temp [1] = "firefox";
        return temp;
    }

}
