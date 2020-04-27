package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardNameChangeTest extends TestBase {

                @BeforeMethod
        public void ensurePreconditions() throws InterruptedException {
            if (getBoardsCount() == 0) {
                createBoard();
            }
        }

        @Test
        public void changeBoardName() throws InterruptedException {
            openFirstPersonalBoard();
            Thread.sleep(2000);
            changeName();
            Thread.sleep(2000);
            returnToHomePage();
        }

        public void changeName() throws InterruptedException {
            click(By.cssSelector(".js-rename-board"));
            Thread.sleep(2000);
            wd.findElement(By.cssSelector("input.js-board-name-input")).sendKeys("My new board" + Keys.ENTER);
        }


}




