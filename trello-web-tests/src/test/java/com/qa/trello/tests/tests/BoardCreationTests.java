package com.qa.trello.tests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {
    @Test
    public void testBoardCreation() throws InterruptedException {
        Thread.sleep(7000);
      //int before = app.getBoard().getBoardsCount();
        app.getBoard().initBoardCreation();
        app. getBoard().fillBoardForm();
        app. getBoard().confirmBoardCreation();
        Thread.sleep(2000);
        app. getBoard().returnToHomePage();
       // int after = app.getBoard().getBoardsCount();
        //Assert.assertEquals(after, before + 1);


    }


}