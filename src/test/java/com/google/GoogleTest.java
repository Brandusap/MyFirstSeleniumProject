package com.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest {

    @Test
    public void googleTest(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://www.google.com/";
        driver.get(url);
        driver.manage().window().maximize();
        Assert.assertEquals(url,driver.getCurrentUrl());
        driver.close();

    }
}
