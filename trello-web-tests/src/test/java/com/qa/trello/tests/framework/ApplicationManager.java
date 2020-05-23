package com.qa.trello.tests.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    BoardHelper board;
    TeamHelper team;
    SessionHelper session;
    String browser;
    ProfileHelper profile;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void init() throws InterruptedException {


        if (browser.equals(BrowserType.CHROME)) {

            wd = new ChromeDriver();
        }
        if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        }

        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //wait = new WebDriverWait(wd, 20);
        wd.manage().window().maximize();
        wd.navigate().to("https://trello.com/");
        session = new SessionHelper(wd);
        session.login("juliakliot.jk@gmail.com", "misha2406");
        Thread.sleep(3000);
        profile = new ProfileHelper(wd);
        board = new BoardHelper(wd);
        team = new TeamHelper(wd);
    }

    public void stop() {
        wd.quit();
    }

    public SessionHelper getSession() {
        return session;
    }

    public BoardHelper getBoard() {
        return board;
    }

    public TeamHelper getTeam() {
        return team;
    }

    public ProfileHelper getProfile() {
        return profile;
    }
}
