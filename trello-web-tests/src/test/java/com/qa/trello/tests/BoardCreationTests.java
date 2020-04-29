package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {
    @Test
    public void testBoardCreation() throws InterruptedException {
        Thread.sleep(2000);
        int before = getBoardsCount();
        initBoardCreation();
        fillBoardForm();
        confirmBoardCreation();
        returnToHomePage();
        int after = getBoardsCount();


        Assert.assertEquals(after, before +1);


    }


}