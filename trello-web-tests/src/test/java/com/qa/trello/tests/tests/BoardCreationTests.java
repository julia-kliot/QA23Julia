package com.qa.trello.tests.tests;

import com.qa.trello.model.Board;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BoardCreationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        Thread.sleep(3000);
        if (!app.getBoard().isOnBoardsPage()) {
            app.getBoard().waitForElementLocatedAndClick(By.cssSelector("[href$=boards]"), 20);
            // app.getBoard().goToBoardsPageURL("juliakliotjk");

        }
    }


    @DataProvider
    public Iterator<Object[]> validBoardsEasy() throws IOException {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"aaaaaaa", "blue"});
        list.add(new Object[]{"1111111", "green"});
        list.add(new Object[]{"dfghd_tyuui-bnvmcl", "red"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> validBoards() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader =
                new BufferedReader(new FileReader(new File("src/test/resources/boards.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(";");
            list.add(new Object[]{new Board().withName(split[0])});
            reader.readLine();
        }

        return list.iterator();
    }

    @Test(dataProvider = "validBoardsEasy")
    public void testBoardCreation(String boardName, String boardColor) throws InterruptedException {
        Thread.sleep(7000);
        Board board= new Board().withName(boardName).withColor(boardColor);
        //int before = app.getBoard().getBoardsCount();
        app.getBoard().initBoardCreation();
        app.getBoard().fillBoardForm(board);

        // .withColor("green"));
        app.getBoard().confirmBoardCreation();
        Thread.sleep(2000);
        app. getBoard().returnToHomePage();
        // int after = app.getBoard().getBoardsCount();
        //Assert.assertEquals(after, before + 1);


    }
    @Test(dataProvider = "validBoards")
    public void testBoardCreation(Board board) {
        //int before = app.getBoard().getBoardsCount();
        app.getBoard().initBoardCreation();
        app.getBoard().fillBoardForm(board);
        app.getBoard().confirmBoardCreation();
        app.getBoard().returnToHomePage();
        //int after = app.getBoard().getBoardsCount();

       // Assert.assertEquals(after, before + 1);

    }

    @Test
    public void testBoardCreationOld() throws InterruptedException {

          // int before = app.getBoard().getBoardsCount();
            // System.out.println(new File(".").getAbsolutePath());
            app.getBoard().initBoardCreation();
            app.getBoard().fillBoardForm(
                    new Board()
                            .withName("Test "+ System.currentTimeMillis())
                            .withColor("red"));
            app.getBoard().confirmBoardCreation();
           // app.getBoard().returnToHomePage();
            //int after = app.getBoard().getBoardsCount();

}
@Test
    public void getBoardsName(){
        app.getBoard().getBoardsList();

}
    }
