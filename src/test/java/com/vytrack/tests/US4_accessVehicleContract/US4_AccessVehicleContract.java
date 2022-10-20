package com.vytrack.tests.US4_accessVehicleContract;

import com.vytrack.base.TestBase;
import com.vytrack.pages.VyTrackLogin;
import com.vytrack.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US4_AccessVehicleContract {


    /**
      Story4:  As a user, I want to access to Vehicle contracts page

      AC1:
      Store managers and Sales managers access the Vehicle contracts page.
      Expected URL: https://qa2.vytrack.com/entity/Extend_Entity_VehicleContract
      Expected title: All - Vehicle Contract - Entities - System - Car - Entities - System

      Users
     1.storemanager91
     2.storemanager94
     3.salesmanager259
     4.salesmanager262

     Password:
     1.UserUser123
     */
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
    VyTrackLogin vyTrackLogin =new VyTrackLogin();

    @Test(priority = 1)
    public void contract_page_verification_as_manager() {

        Driver.getDriver().get(ConfigurationReader.get_Property("env2"));
        vyTrackLogin.inputUsername.sendKeys(ConfigurationReader.get_Property("StoreManager"));
        vyTrackLogin.inputPassword.sendKeys(ConfigurationReader.get_Property("Password"));
        vyTrackLogin.signInButton.click();


        WebElement fleetBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='nav-multilevel main-menu']/li[2]")));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(fleetBox).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Vehicle Contracts"))).click();


        wait.until(ExpectedConditions.titleContains(ConfigurationReader.get_Property("ExpectedTitle")));
        BrowserUtils.verifyTitle(Driver.getDriver(),ConfigurationReader.get_Property("ExpectedTitle"));
        BrowserUtils.verifyURL(Driver.getDriver(),ConfigurationReader.get_Property("ExpectedURL"));

    }



    /** AC2:
            AC2: Drivers should NOT able to access the Vehicle contracts page, the app should display “You do not have permission to perform this action.
     Users
     1.user178
     2.user183

     Password:
     1.UserUser123

     */
@Test(priority = 2)
    public void contract_page_verification_as_driver(){

    Driver.getDriver().get(ConfigurationReader.get_Property("env1"));
    vyTrackLogin.inputUsername.sendKeys(ConfigurationReader.get_Property("driver1"));
    vyTrackLogin.inputPassword.sendKeys(ConfigurationReader.get_Property("Password"));
    vyTrackLogin.signInButton.click();


    WebElement fleetBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='nav-multilevel main-menu']/li[1]")));
    Actions actions = new Actions(Driver.getDriver());
    actions.moveToElement(fleetBox).perform();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Vehicle Contracts"))).click();
    WebElement text =Driver.getDriver().findElement(By.xpath("//div[.='You do not have permission to perform this action.']"));


    String expected = ConfigurationReader.get_Property("ExpectedText");
    String actual = text.getText();
    Assert.assertEquals(actual, expected);




}

           }







