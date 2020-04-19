package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TeamBoardCreation {
    WebDriver wd;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(wd, 20);
        wd.manage().window().maximize();
        wd.navigate().to("https://trello.com/");
    }

    @Test
    public void TeamBoardCreation() throws InterruptedException {
        initLogin();
        fillLoginFormAtlassianAcc("juliakliot.jk@gmail.com", "misha2406");
        ConfirmLogin();
        initTeamCreation();
        fillForm();
        confirmTeamCreation();
        returnToHomePage();
    }

    private void returnToHomePage() {
        click(By.cssSelector("[color='light']"));
    }

    private void confirmTeamCreation()  {
        click(By.cssSelector("[type='submit']"));
        click(By.cssSelector(".eg0KI5SqghoOFd"));

    }

    private void fillForm() throws InterruptedException {
        type(By.cssSelector("[data-test-id='header-create-team-name-input'"),"Test_Team1");
        Thread.sleep(3000);
        click(By.xpath("//*[@class='css-dmzcl _1T1MG_BX1zeaq8']"));
        click(By.id("teamTypeSelect"));
        click(By.cssSelector("[class='_38pq5NbRWAG39y']"));
    }

    private void initTeamCreation() {

        click(By.xpath("//*[@class='_33CvMKqfH4Yf0j']"));
    }

    private void ConfirmLogin() {
        // wait.until(ExpecteConditions.presenceOfElementLocated(By.id("login-submit"))).click();
        click(By.id("login-submit"));
    }

    private void fillLoginFormAtlassianAcc(String userEmail, String password) throws InterruptedException {
        type(By.name("user"), userEmail);
        click(By.cssSelector("#login.button-green"));
        Thread.sleep(3000);
        type(By.cssSelector("input#password"), password);


    }

    private void initLogin() {

        click(By.cssSelector("[href='/login']"));
    }

    private void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    private void click(By locator) {

        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
    }

    //  @AfterMethod
    public void tearDown() {
        wd.quit();
    }
}
