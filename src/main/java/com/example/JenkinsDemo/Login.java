package com.example.JenkinsDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Login {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "username")
    WebElement username;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "submit")
    WebElement login;

    @FindBy(className = "wp-block-button__link")
    WebElement logout;

    @FindBy(className = "post-header")
    WebElement heading;

    public Login(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void loginWithInvalidData() throws InterruptedException {
        String usrName = "abc";
        String pswd = "123";
        dataLogin(usrName, pswd);
    }

    public void loginWithValidData() throws InterruptedException {
        String usrName = "student";
        String pswd = "Password123";
        dataLogin(usrName, pswd);
    }

    public void loginWithEmptyData() throws InterruptedException {
        dataLogin(" ", " ");
    }

    public void headingVerification() {
        String actualData = heading.getText();
        String expectedData = "Logged In Successfully";
        headingTitleUrlValidation(actualData, expectedData);
    }

    public void titleVerification()
    {
        String actual = driver.getTitle();
        String expected = "Logged In Successfully | Practice Test Automation";
        headingTitleUrlValidation(actual, expected);
    }

    public void urlVerification()
    {
        String actual = driver.getCurrentUrl();
        String expected = "https://practicetestautomation.com/logged-in-successfully/";
        headingTitleUrlValidation(actual, expected);
    }

    public void dataLogin(String name, String pswd) {
        try {
            Thread.sleep(2000);
            username.sendKeys(name);
            password.sendKeys(pswd);
            Thread.sleep(2000);
            login.click();
            Thread.sleep(2000);
            //logout.click();
            resultValidation();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void resultValidation() throws InterruptedException {
        String message = driver.getCurrentUrl();
        if (message.equals("https://practicetestautomation.com/practice-test-login/")) {
            System.out.println("Incorrect login");
        } else if (message.equals("https://practicetestautomation.com/logged-in-successfully/")){
            System.out.println("Correct login");
        }
    }

    public void headingTitleUrlValidation(String actualData, String expectedData) {

        try {
            Assert.assertEquals(actualData, expectedData, "hard: not equal");
            System.out.println("Correct data: " + expectedData);
        } catch (Throwable e)  {
            System.out.println("incorrect data: " + expectedData);
        }
    }
}