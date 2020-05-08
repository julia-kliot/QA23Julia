package com.qa.trello.tests.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ApplicationManager    {
    WebDriver wd;
    BoardHelper board;
    TeamHelper team;
    SessionHelper session;


    public void init() throws InterruptedException {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
       //wait = new WebDriverWait(wd, 20);
        wd.manage().window().maximize();
        wd.navigate().to("https://trello.com/");
        session = new SessionHelper(wd);
        session.login("juliakliot.jk@gmail.com", "misha2406");

        board= new BoardHelper(wd);
        team= new TeamHelper(wd);
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


}
