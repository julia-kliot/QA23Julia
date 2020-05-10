package com.qa.trello.tests.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BoardHelper extends HelperBase {



    public BoardHelper(WebDriver wd) {
        super(wd);

    }

    public void confirmBoardCreation() {
        waitForElementLocatedAndClick(By.cssSelector("[type='button']"), 20);
    }

    public void fillBoardForm() {
        type(By.cssSelector("[data-test-id='create-board-title-input']"), "newBoard_3");
        waitForElementLocatedAndClick(By.cssSelector("button.W6rMLOx8U0MrPx"), 20);
        waitForElementLocatedAndClick(By.xpath("//li[1]/button[@class='_2jR0BZMM5cBReR']"), 20);

    }

    public void initBoardCreation() {
        waitForElementLocatedAndClick(By.name("add"), 20);
        waitForElementLocatedAndClick(By.cssSelector("._2DBw9GxD3tha0R"), 20);
    }

    public void permanentlyDeleteBoard() {
        waitForElementLocatedAndClick(By.cssSelector(".js-delete"), 30);
        confirm();

    }

    public void initBoardDeletionInMoreMenu() throws InterruptedException {
        clickCloseBoardFromMoreMenu();
        confirm();
    }

    public void clickCloseBoardFromMoreMenu() throws InterruptedException {
        Thread.sleep(3000);
        waitForElementLocatedAndClick(By.cssSelector(".js-close-board"), 20);
    }

    public void clickMoreButton()  {
        WebElement moreButton = new WebDriverWait(wd, 30).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".js-open-more")));
        if(!moreButton.isDisplayed()) {
            wd.findElement(By.cssSelector(".board-header-btn.mod-show-menu.js-show-sidebar")).click();
        }
        wd.findElement(By.cssSelector(".js-open-more")).click();

    }

                //waitForElementLocatedAndClick(By.cssSelector(".js-open-more"), 50);


    public void openFirstPersonalBoard() throws InterruptedException {
        Thread.sleep(2000);
             waitForElementLocatedAndClick(By.xpath("//*[@class='icon-lg icon-member']/../../..// li"), 20); }

    public int getBoardsCount() throws InterruptedException {

        Thread.sleep(2000);
        return wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..// li")).size()-1;
    }

    public void createBoard() {

        initBoardCreation();
        fillBoardForm();
        confirmBoardCreation();
        returnToHomePage();
    }

    public boolean isOnBoardsPage() throws InterruptedException {
        Thread.sleep(3000);
       String url = wd.getCurrentUrl();
      return url.contains("boards");
    }



    public void changeName() throws InterruptedException {
        waitForElementLocatedAndClick(By.cssSelector(".js-rename-board"), 20);
        Thread.sleep(2000);
        wd.findElement(By.cssSelector("input.js-board-name-input")).sendKeys("My new board" + Keys.ENTER);
    }
    public void openBoardPage() {
        waitForElementLocatedAndClick(By.cssSelector("[href$=boards]"), 20);
    }

    public void goToBoardsPageURL(String username){
        wd. navigate().to("https://trello.com/"+username+"/boards");
    }
}
