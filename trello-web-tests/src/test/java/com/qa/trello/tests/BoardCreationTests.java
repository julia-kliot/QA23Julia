package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {
    @Test
    public void testBoardCreation() throws InterruptedException {


        initBoardCreation();
        fillBoardForm();
        confirmBoardCreation();
        returnToHomePage();

    }


}