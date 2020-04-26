package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(wd, 20);
        wd.manage().window().maximize();
        wd.navigate().to("https://trello.com/");
        login("juliakliot.jk@gmail.com", "misha2406");
    }

    public void returnToHomePage() {
        click(By.cssSelector("[class='_2BQG4yPMt5s_hu _2hgn5meZL7bJdx _1ctYJ9-gOV_hrm _3Xj1tqB73NcWn3']"));
        click(By.cssSelector("[class='_2BQG4yPMt5s_hu _2hgn5meZL7bJdx _1ctYJ9-gOV_hrm _3Xj1tqB73NcWn3']"));

    }

    public void confirmTeamCreation()  {
        click(By.cssSelector("[type='submit']"));
        click(By.cssSelector(".eg0KI5SqghoOFd"));

    }

    public void fillForm() throws InterruptedException {
        type(By.cssSelector("[data-test-id='header-create-team-name-input'"),"Test_Team1");
        click(By.cssSelector("[id='teamTypeSelect']"));
        Thread.sleep(2000);
        click(By.cssSelector("[data-test-id^=header-create-team-type] li"));
    }

    public void initTeamCreation() {

        click(By.xpath("//*[@class='_33CvMKqfH4Yf0j']"));
    }

    public void ConfirmLogin() {
        // wait.until(ExpecteConditions.presenceOfElementLocated(By.id("login-submit"))).click();
        click(By.id("login-submit"));
    }

    public void fillLoginFormAtlassianAcc(String userEmail, String password) throws InterruptedException {
        type(By.name("user"), userEmail);
        click(By.cssSelector("#login.button-green"));
        Thread.sleep(3000);
        type(By.cssSelector("input#password"), password);

    }

    public void initLogin() {

        click(By.cssSelector("[href='/login']"));
    }


    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }



    public void click(By locator) {

        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
    }




    public void login(String email, String password) throws InterruptedException {
        initLogin();
        fillLoginFormAtlassianAcc(email, password);
        ConfirmLogin();
    }

    public void confirmBoardCreation() {
        click(By.cssSelector("[type='button']"));
    }

    public void fillBoardForm() {
        type(By.cssSelector("input._23NUW98LaZfBpQ"), "newBoard2");
        click(By.cssSelector("._1vk4y48RR5OmqE"));
        click(By.cssSelector("._1uK2vQ_aMRS2NU"));
    }

    public void initBoardCreation() {
        click(By.name("add"));
        click(By.cssSelector("._2DBw9GxD3tha0R"));
    }
    //  @AfterMethod
    public void tearDown() {
        wd.quit();
    }

    public void permanentlyDeleteBoard() {
        click(By.cssSelector(".js-delete"));
        confirm();

    }

    public void initBoardDeletionInMoreMenu() throws InterruptedException {
        clickCloseBoardFromMoreMenu();
        confirm();
    }

    public void confirm() {
        click(By.cssSelector(".js-confirm"));
    }

    public void clickCloseBoardFromMoreMenu() throws InterruptedException {
        Thread.sleep(3000);
        click(By.cssSelector(".js-close-board"));
    }

    public void clickMoreButton()  {


                click(By.cssSelector(".js-open-more"));
         }

    public void openFirstPersonalBoard() throws InterruptedException {
        Thread.sleep(2000);
             click(By.xpath("//*[@class='icon-lg icon-member']/../../..// li")); }
}
