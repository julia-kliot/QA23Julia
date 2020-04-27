package com.telran.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginToJira2 {
    WebDriver wd;

    @BeforeClass
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.manage().window().maximize();

        //wd.get("http://jira.tel-ran.net/secure/Dashboard.jspa");
        wd.navigate().to("http://jira.tel-ran.net/secure/Dashboard.jspa");


    }

    @Test

    public void testJiraLogin() {
        type(By.name("os_username"), "juliakliot.jk");

        type(By.name("os_password"), "fghj");

        click(By.id("login"));
        String errorMessage = wd.findElement(By.id("usernameerror")).getText();
        Assert.assertEquals(errorMessage,"Sorry, your username and password are incorrect - please try again.");
        Assert.assertTrue(isElementPresent(By.id("usernameerror")));
    }

    private void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    private void click(By user) {
        wd.findElement(user).click();
    }

    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }

    @AfterClass
    public void tearDown() {
//wd.quit();
    }
}
