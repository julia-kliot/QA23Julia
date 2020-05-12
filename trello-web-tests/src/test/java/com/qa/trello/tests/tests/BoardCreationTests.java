package com.qa.trello.tests.tests;

import com.qa.trello.model.Board;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        Thread.sleep(3000);
       if (!app.getBoard().isOnBoardsPage()) {
            app.getBoard().waitForElementLocatedAndClick(By.cssSelector("[href$=boards]"), 20);
           // app.getBoard().goToBoardsPageURL("juliakliotjk");

       }
   }
    @Test
    public void testBoardCreation() throws InterruptedException {
        Thread.sleep(7000);
      //int before = app.getBoard().getBoardsCount();
        app.getBoard().initBoardCreation();
        app. getBoard().fillBoardForm(
                new Board()
                .withName("newBoard_3"+System.currentTimeMillis())
                .withColor("green"));
        app. getBoard().confirmBoardCreation();
        Thread.sleep(2000);
        //app. getBoard().returnToHomePage();
       // int after = app.getBoard().getBoardsCount();
        //Assert.assertEquals(after, before + 1);


    }


}