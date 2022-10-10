package com.vytrack.base;

import com.vytrack.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");

//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
