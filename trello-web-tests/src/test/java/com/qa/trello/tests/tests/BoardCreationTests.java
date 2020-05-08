package com.qa.trello.tests.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {
    //@BeforeMethod
   // public void ensurePreconditions() throws InterruptedException {
       // if (!app.getBoard().isOnBoardsPage()) {
            //app.getBoard().waitForElementLocatedAndClick(By.cssSelector("[href$=boards]"), 20);
           // app.getBoard().goToBoardsPageURL("juliakliotjk");

      //  }
   // }
    @Test
    public void testBoardCreation() throws InterruptedException {
        Thread.sleep(7000);
      //int before = app.getBoard().getBoardsCount();
        app.getBoard().initBoardCreation();
        app. getBoard().fillBoardForm();
        app. getBoard().confirmBoardCreation();
        Thread.sleep(2000);
        //app. getBoard().returnToHomePage();
       // int after = app.getBoard().getBoardsCount();
        //Assert.assertEquals(after, before + 1);


    }


}