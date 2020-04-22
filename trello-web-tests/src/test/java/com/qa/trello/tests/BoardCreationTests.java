package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BoardCreationTests {
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
    public void testBoardCreation() throws InterruptedException {

        initLogin();
        fillLoginFormAtlassianAcc("juliakliot.jk@gmail.com", "misha2406");
        ConfirmLogin();
        initBoardCreation();
        fillBoardForm();
        confirmBoardCreation();
        returnToHomePage();

    }

    private void returnToHomePage() {
        click(By.cssSelector("[color='light']"));
    }

    private void confirmBoardCreation() {
        click(By.cssSelector("[type='button']"));
    }

    private void fillBoardForm() {
        type(By.cssSelector("input._23NUW98LaZfBpQ"), "newBoard2");
        click(By.cssSelector("._1vk4y48RR5OmqE"));
        click(By.cssSelector("._1uK2vQ_aMRS2NU"));
    }

    private void initBoardCreation() {
        click(By.name("add"));
        click(By.cssSelector("._2DBw9GxD3tha0R"));
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