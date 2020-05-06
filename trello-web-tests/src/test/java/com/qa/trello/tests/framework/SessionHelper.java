package com.qa.trello.tests.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SessionHelper extends HelperBase {
    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void ConfirmLogin() {
         //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-submit"))).click();
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

    public void login(String email, String password) throws InterruptedException {
        initLogin();
        fillLoginFormAtlassianAcc(email, password);
        ConfirmLogin();
    }
}
