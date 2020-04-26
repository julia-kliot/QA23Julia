package com.qa.trello.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {

    @Test
    public void TestBoardDeletion() throws InterruptedException {

        openFirstPersonalBoard();
        clickMoreButton();
                initBoardDeletionInMoreMenu();
                permanentlyDeleteBoard();
                returnToHomePage();



    }

}
