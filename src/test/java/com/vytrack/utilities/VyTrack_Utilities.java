package com.vytrack.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VyTrack_Utilities {

    public static void login_as_manager(WebDriver driver, String username, String password){


        WebElement userNameBox = driver.findElement(By.xpath("//input[@id = 'prependedInput']"));
        userNameBox.sendKeys("storemanager94");
        WebElement passwordBox = driver.findElement(By.cssSelector("input[type = 'password']"));
        passwordBox.sendKeys("UserUser123");
        WebElement loginButton = driver.findElement(By.cssSelector("button#_submit"));
        loginButton.click();

    }
    public static void login_as_driver(WebDriver driver, String username, String password){


        WebElement userNameBox = driver.findElement(By.xpath("//input[@id = 'prependedInput']"));
        userNameBox.sendKeys("user178");
        WebElement passwordBox = driver.findElement(By.cssSelector("input[type = 'password']"));
        passwordBox.sendKeys("UserUser123");
        WebElement loginButton = driver.findElement(By.cssSelector("button#_submit"));
        loginButton.click();

    }
    public static void fleet_box(){

        Driver.getDriver().findElement(By.xpath("//ul[@class='nav-multilevel main-menu']/li[2]"));
    }
}
