package com.vytrack.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BrowserUtils {


    public static void sleep(int seconds) {

        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public static void verifyTitle(WebDriver driver, String expected) {

        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expected);


    }

    public static void verifyURL(WebDriver driver, String expectedURL) {

        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);


    }
}