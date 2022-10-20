package com.vytrack.tests;

import com.vytrack.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class US01_MainModules_Daniela extends TestBase {

    public static void login(String email) {

        driver.get("https://qa1.vytrack.com/user/login");
        WebElement username = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        username.sendKeys(email);
        WebElement password = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        password.sendKeys("UserUser123");
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();
    }

    @Test(dataProvider = "managersCredentials")

    public void managersModulesTC1(String user, String expected) {

        login(user);
        int countModules = 0;
        List<WebElement> modules = driver.findElements(By.xpath("//span[@class='title title-level-1']"));
        List<String> modulesDisplayed = new ArrayList<>();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title title-level-1']")));
        for (WebElement each : modules) {
            modulesDisplayed.add(each.getText());
            countModules++;
        }
        System.out.println("Modules displayed for " + user + " = " + countModules);
        System.out.println(modulesDisplayed);
        List<String> expectedModules = List.of(expected.split(", "));
        Assert.assertEquals(expectedModules, modulesDisplayed, "User does not have access to the expected modules");
    }

    @Test(dataProvider = "driversCredentials")
    public void driversModulesTC2(String user, String expected) {

        login(user);
        int countModules = 0;
        List<WebElement> modules = driver.findElements(By.xpath("//span[@class='title title-level-1']"));
        List<String> modulesDisplayed = new ArrayList<>();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title title-level-1']")));
        for (WebElement each : modules) {
            modulesDisplayed.add(each.getText());
            countModules++;
        }
        System.out.println("Modules displayed for " + user + " = " + countModules);
        System.out.println(modulesDisplayed);
        List<String> expectedModules = List.of(expected.split(", "));
        Assert.assertEquals(expectedModules, modulesDisplayed, "User does not have access to the expected modules");
    }

    @DataProvider(name = "managersCredentials")
    public Object[][] testData1() {
        return new Object[][]{
                {"storemanager91", "Dashboards, Fleet, Customers, Sales, Activities, Marketing, Reports & Segments, System"},
                {"storemanager94", "Dashboards, Fleet, Customers, Sales, Activities, Marketing, Reports & Segments, System"},
                {"salesmanager259", "Dashboards, Fleet, Customers, Sales, Activities, Marketing, Reports & Segments, System"},
                {"salesmanager262", "Dashboards, Fleet, Customers, Sales, Activities, Marketing, Reports & Segments, System"}
        };
    }

    @DataProvider(name = "driversCredentials")
    public Object[][] testData() {
        return new Object[][]{
                {"user178", "Fleet, Customers, Activities, System"},
                {"user183", "Fleet, Customers, Activities, System"}
        };
    }

}
