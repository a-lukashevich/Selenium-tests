package com.alex.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainPageTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        if (!System.getProperty("os.name").contains("Mac")) {
            throw new IllegalArgumentException("Safari is available only on Mac");
        }
        driver = new SafariDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void titleTest() throws InterruptedException {
        String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        driver.get("https://www.amazon.com");
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
