package com.qa.trello.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TeamBoardCreation extends TestBase {

    @Test
    public void TeamBoardCreation() throws InterruptedException {
        Thread.sleep(3000);
        int before = app.getTeamCount();
        app.initTeamCreation();
        app.fillForm();
        app.confirmTeamCreation();
        app.inviteTeamLater();
        app.returnToHomePage();
        int after = app.getTeamCount();
        Assert.assertEquals(after, before + 1);





    }



}

