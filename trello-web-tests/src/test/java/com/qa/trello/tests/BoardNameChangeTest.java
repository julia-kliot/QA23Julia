package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardNameChangeTest extends TestBase {

                @BeforeMethod
        public void ensurePreconditions() throws InterruptedException {
                    if (!app.isOnBoardsPage()) {
                        app.click(By.cssSelector("[href$=boards]"));

                    }
                    if (app.getBoardsCount() == 0) {
                app.createBoard();
            }
        }

        @Test
        public void changeBoardName() throws InterruptedException {
            app.openFirstPersonalBoard();
            Thread.sleep(2000);
            changeName();
            Thread.sleep(2000);
            app.returnToHomePage();
        }

        public void changeName() throws InterruptedException {
            app.click(By.cssSelector(".js-rename-board"));
            Thread.sleep(2000);
            app.wd.findElement(By.cssSelector("input.js-board-name-input")).sendKeys("My new board" + Keys.ENTER);
        }


}




