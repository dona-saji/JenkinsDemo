package com.example.JenkinsDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;
    Login login;

    @BeforeTest
    public void browserLogin() throws InterruptedException
    {
        // Launch Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win110\\chromedriver.exe");
        // Instantiate a ChromeDriver class.
        driver = new ChromeDriver();
        login = new Login(driver);
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }


    @Test(priority = 1)
    public void testLoginWithInvalidData() throws InterruptedException {
        System.out.println("Invalid data login");
        System.out.println("****************************");
        login.loginWithInvalidData();
    }

    @Test(priority = 2)
    public void testLoginWithEmptyData() throws InterruptedException {
        System.out.println("Invalid data login");
        System.out.println("****************************");
        login.loginWithEmptyData();
    }

    @Test(priority = 3)
    public void testLoginWithValidData() throws InterruptedException {
        System.out.println("Invalid data login");
        System.out.println("****************************");
        login.loginWithValidData();
    }

    @Test(priority = 6)
    public void testHeadingVerification() {
        System.out.println("Heading verification");
        System.out.println("****************************");
        login.headingVerification();
    }

    @Test(priority = 7)
    public void testTitleVerification() {
        System.out.println("Title verification");
        System.out.println("****************************");
        login.titleVerification();
    }

    @Test(priority = 8)
    public void testUrlVerification() {
        System.out.println("URL verification");
        System.out.println("****************************");
        login.urlVerification();
    }

    @AfterTest()
    public void close() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
