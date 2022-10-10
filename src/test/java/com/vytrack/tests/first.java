package com.vytrack.tests;

import com.vytrack.base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class first extends TestBase {

    @Test
    public void googleTitle(){

        driver.get("https://google.com");
        String expectedTitle="Google";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle, "Google title is not matching!");
    }


}
