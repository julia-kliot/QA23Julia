package com.qa.trello.tests.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardNameChangeTest extends TestBase {

                @BeforeMethod
        public void ensurePreconditions() throws InterruptedException {
                    if (!app.getBoard().isOnBoardsPage()) {
                      //  app.getBoard().waitForElementLocatedAndClick (By.cssSelector("[href$=boards]"),20);
                        app.getBoard().goToBoardsPageURL("juliakliotjk");

                    }
                    if (app.getBoard().getBoardsCount() == 0) {
                app.getBoard().createBoard();
            }
        }



    @Test
        public void changeBoardName() throws InterruptedException {
            app.getBoard().openFirstPersonalBoard();
            Thread.sleep(2000);
            app.getBoard().changeName();
            Thread.sleep(2000);
            app.getBoard().returnToHomePage();
        }


}




