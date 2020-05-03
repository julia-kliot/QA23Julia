package com.qa.trello.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {
    @Test
    public void testBoardCreation() throws InterruptedException {
        Thread.sleep(5000);
       int before = app.getBoardsCount();
        app.initBoardCreation();
        app.fillBoardForm();
        app.confirmBoardCreation();
        Thread.sleep(2000);
        app.returnToHomePage();
        int after = app.getBoardsCount();
        Assert.assertEquals(after, before + 1);


    }


}