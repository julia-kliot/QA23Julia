package com.qa.trello.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TeamBoardCreation extends TestBase {

    @Test
    public void TeamBoardCreation() throws InterruptedException {
        Thread.sleep(3000);
        int before = getTeamCount();
        initTeamCreation();
        fillForm();
        confirmTeamCreation();
        returnToHomePage();
        int after = getTeamCount();
        Assert.assertEquals(after, before + 1);





    }


}

