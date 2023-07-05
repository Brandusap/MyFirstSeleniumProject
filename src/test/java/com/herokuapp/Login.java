package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login {

    @Test
    public void loginTest(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);
        driver.manage().window().maximize();
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("tomsmith");
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("SuperSecretPassword!");
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login\"]/button/i"));
        loginButton.click();
        String secureUrl = "https://the-internet.herokuapp.com/secure";
        Assert.assertEquals(secureUrl, driver.getCurrentUrl());
        String successMessage = "You logged into a secure area!";
        WebElement successAlert = driver.findElement(By.id("flash"));
        successAlert.getText();
        Assert.assertTrue(successAlert.getText().contains(successMessage));


       // driver.close();

    }

}
