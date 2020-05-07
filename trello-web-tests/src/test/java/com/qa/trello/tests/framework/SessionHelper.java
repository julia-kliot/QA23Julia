package com.qa.trello.tests.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {
    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void ConfirmLogin() {
         //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-submit"))).click();
        waitForElementLocatedAndClick(By.id("login-submit"), 20);
    }

    public void fillLoginFormAtlassianAcc(String userEmail, String password) throws InterruptedException {
        type(By.name("user"), userEmail);
        waitForElementLocatedAndClick(By.cssSelector("#login.button-green"), 20);
        Thread.sleep(3000);
        type(By.cssSelector("input#password"), password);

    }

    public void initLogin() {

        waitForElementLocatedAndClick(By.cssSelector("[href='/login']"), 20);
    }

    public void login(String email, String password) throws InterruptedException {
        initLogin();
        fillLoginFormAtlassianAcc(email, password);
        ConfirmLogin();
    }
}
