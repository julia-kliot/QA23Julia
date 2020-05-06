package com.qa.trello.tests.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BoardHelper extends HelperBase {



    public BoardHelper(WebDriver wd) {
        super(wd);

    }

    public void confirmBoardCreation() {
        click(By.cssSelector("[type='button']"));
    }

    public void fillBoardForm() {
        type(By.cssSelector("[data-test-id='create-board-title-input']"), "newBoard_3");
        click(By.cssSelector("button.W6rMLOx8U0MrPx"));
        click(By.xpath("//li[1]/button[@class='_2jR0BZMM5cBReR']"));

    }

    public void initBoardCreation() {
        click(By.name("add"));
        click(By.cssSelector("._2DBw9GxD3tha0R"));
    }

    public void permanentlyDeleteBoard() {
        click(By.cssSelector(".js-delete"));
        confirm();

    }

    public void initBoardDeletionInMoreMenu() throws InterruptedException {
        clickCloseBoardFromMoreMenu();
        confirm();
    }

    public void clickCloseBoardFromMoreMenu() throws InterruptedException {
        Thread.sleep(3000);
        click(By.cssSelector(".js-close-board"));
    }

    public void clickMoreButton()  {


                click(By.cssSelector(".js-open-more"));
         }

    public void openFirstPersonalBoard() throws InterruptedException {
        Thread.sleep(2000);
             click(By.xpath("//*[@class='icon-lg icon-member']/../../..// li")); }

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

    public boolean isOnBoardsPage() {
        String url = wd.getCurrentUrl();
        return url.contains("boards");
    }
    public void changeName() throws InterruptedException {
        click(By.cssSelector(".js-rename-board"));
        Thread.sleep(2000);
        wd.findElement(By.cssSelector("input.js-board-name-input")).sendKeys("My new board" + Keys.ENTER);
    }
    public void openBoardPage() {
        click(By.cssSelector("[href$=boards]"));
    }
}
