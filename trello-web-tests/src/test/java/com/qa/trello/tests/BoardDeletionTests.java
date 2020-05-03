package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (!app.isOnBoardsPage()) {
            app.click(By.cssSelector("[href$=boards]"));

        }
        if (app.getBoardsCount() == 0) {
            app.createBoard();
        }
    }


    @Test
    public void TestBoardDeletion() throws InterruptedException {

        Thread.sleep(2000);
        int before = app.getBoardsCount();
        app.openFirstPersonalBoard();
        app.clickMoreButton();
        app.initBoardDeletionInMoreMenu();
        app.permanentlyDeleteBoard();
        app.returnToHomePage();
        int after = app.getBoardsCount();

        System.out.println("was:  " + before + "now:  " + after);
        Assert.assertEquals(after, before - 1);


    }


}
