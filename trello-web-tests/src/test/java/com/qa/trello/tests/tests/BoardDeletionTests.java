package com.qa.trello.tests.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
       // if (!app.getBoard().isOnBoardsPage()) {
         //   app.getBoard().click(By.cssSelector("[href$=boards]"));

       //
        // }
        if (app.getBoard().getBoardsCount() == 0) {
            app.getBoard().createBoard();
        }
    }


    @Test
    public void TestBoardDeletion() throws InterruptedException {

        Thread.sleep(2000);
        int before = app.getBoard().getBoardsCount();
        app.getBoard().openFirstPersonalBoard();
        Thread.sleep(3000);
        app.getBoard().clickMoreButton();
        app.getBoard().initBoardDeletionInMoreMenu();
        app.getBoard().permanentlyDeleteBoard();
        app.getBoard().returnToHomePage();
        int after = app.getBoard().getBoardsCount();

        System.out.println("was:  " + before + "now:  " + after);
        Assert.assertEquals(after, before - 1);


    }


}
