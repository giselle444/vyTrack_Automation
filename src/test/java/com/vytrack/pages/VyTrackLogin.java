package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VyTrackLogin {
    /**

     PageFactory class is a Selenium class that support POM
     It has method called initElements. Once it's called it will store all elements specified using @FindBy
     annotation with locator and it wll give elements to the classes when they called
     initElements method accept 2 arg
     WebDriver instance and Page class instance (this) means current instance of this class
     */
   public VyTrackLogin(){
       PageFactory.initElements(Driver.getDriver(), this);


    }
    @FindBy(xpath = "//input[@id = 'prependedInput']")
    public WebElement inputUsername;

    @FindBy (css = "input[type = 'password']")
    public WebElement inputPassword;

    @FindBy (css = "button#_submit")
    public WebElement signInButton;
}
