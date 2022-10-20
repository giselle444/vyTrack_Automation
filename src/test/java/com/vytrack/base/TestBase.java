package com.vytrack.base;

import com.vytrack.utilities.Driver;
import com.vytrack.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
//    @BeforeMethod
//    public void setup() {
//
//        Driver.getDriver().manage().window().maximize();
//        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//
//    }

    @AfterMethod
    public void teardown() {Driver.getDriver().quit();
    }
}
