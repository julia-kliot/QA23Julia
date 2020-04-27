package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {
    @Test
    public void testBoardCreation()  {

        initBoardCreation();
        fillBoardForm();
        confirmBoardCreation();
        returnToHomePage();



    }


}