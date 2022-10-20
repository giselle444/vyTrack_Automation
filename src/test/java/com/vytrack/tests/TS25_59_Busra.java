package com.vytrack.tests;

import com.vytrack.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TS25_59_Busra extends TestBase {

    @Test(dataProvider = "loginCredentials")
    public void testDefaultRepeatDay1(String username,String password) throws InterruptedException {
//        Users are on the homepage
        driver.get("https://qa1.vytrack.com/user/login");


        WebElement usernameBox = driver.findElement(By.xpath("//input[@name='_username']"));
        usernameBox.sendKeys(username + Keys.ENTER);
        WebElement passwordBox = driver.findElement(By.xpath("//input[@name='_password']"));
        passwordBox.sendKeys(password + Keys.ENTER);

//        Click the “Calendar Events” under the Activities
//        WebElement activitiesBtn = driver.findElement(By.xpath("//span[@class='title title-level-1'][normalize-space()='Activities']"));
//        activitiesBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title title-level-1'][normalize-space()='Activities']"))).click();

//        WebElement calenderEventsBtn = driver.findElement(By.xpath("//span[.='Calendar Events']"));
//        calenderEventsBtn.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Calendar Events']"))).click();

//        Click the “Create Calendar Event” button
//        WebElement createCalenderEventBtn = driver.findElement(By.xpath("//*[@title='Create Calendar event']"));
//        createCalenderEventBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Create Calendar event']"))).click();


//        Check the Repeat checkbox
//        WebElement repeatBox = driver.findElement(By.xpath("//div[@data-page-component-name='calendar-event-recurrence']//div[@class='controls']//input[@data-name='recurrence-repeat']"));
//        repeatBox.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-page-component-name='calendar-event-recurrence']//div[@class='controls']//input[@data-name='recurrence-repeat']"))).click();


//        Verify the repeat number is 1
        WebElement repeatEveryBox = driver.findElement(By.xpath("//span[.='day(s)']/preceding-sibling::input[1]"));

        String actualValue = repeatEveryBox.getAttribute("value");
        System.out.println("actualValue = " + actualValue);
        Assert.assertEquals(actualValue,"1");


    }

    @Test(dataProvider = "loginCredentials")
    public void test_error_message_displayed_when_repeatDayBox_empty(String username,String password) throws InterruptedException{

        //        Users are on the homepage
        driver.get("https://qa1.vytrack.com/user/login");


        WebElement usernameBox1 = driver.findElement(By.xpath("//input[@name='_username']"));
        usernameBox1.sendKeys(username + Keys.ENTER);
        WebElement passwordBox2 = driver.findElement(By.xpath("//input[@name='_password']"));
        passwordBox2.sendKeys(password + Keys.ENTER);

//        Click the “Calendar Events” under the Activities
//        WebElement activitiesBtn = driver.findElement(By.xpath("//span[@class='title title-level-1'][normalize-space()='Activities']"));
//        activitiesBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title title-level-1'][normalize-space()='Activities']"))).click();

//        WebElement calenderEventsBtn = driver.findElement(By.xpath("//span[.='Calendar Events']"));
//        calenderEventsBtn.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Calendar Events']"))).click();

//        Click the “Create Calendar Event” button
//        WebElement createCalenderEventBtn = driver.findElement(By.xpath("//*[@title='Create Calendar event']"));
//        createCalenderEventBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Create Calendar event']"))).click();


//        Check the Repeat checkbox
//        WebElement repeatBox = driver.findElement(By.xpath("//div[@data-page-component-name='calendar-event-recurrence']//div[@class='controls']//input[@data-name='recurrence-repeat']"));
//        repeatBox.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-page-component-name='calendar-event-recurrence']//div[@class='controls']//input[@data-name='recurrence-repeat']"))).click();


//        Verify the app displays “This value should not be blank.” after clearing repeat day 1

        WebElement repeatEveryBox = driver.findElement(By.xpath("//span[.='day(s)']/preceding-sibling::input[1]"));
        repeatEveryBox.clear();

       WebElement actualErrorMessage = driver.findElement(By.xpath("//span[@id='temp-validation-name-266-error']/span"));

       String message = actualErrorMessage.getText();
        Assert.assertEquals(message,"This value should not be blank.");

        System.out.println("message.isDisplayed() = " + actualErrorMessage.isDisplayed());


    }

    @DataProvider(name="loginCredentials")
    public Object[][] testData(){
        return new Object[][]{
                {"user178","UserUser123"},
                {"user179","UserUser123"},
                {"user180","UserUser123"},
                {"user181","UserUser123"},
                {"user182","UserUser123"},
                {"user183","UserUser123"},
                {"storemanager91","UserUser123"},
                {"storemanager92","UserUser123"},
                {"storemanager93","UserUser123"},
                {"storemanager94","UserUser123"},
                {"salesmanager259","UserUser123"},
                {"salesmanager260","UserUser123"},
                {"salesmanager261","UserUser123"},
                {"salesmanager262","UserUser123"},

        };
    }
}
