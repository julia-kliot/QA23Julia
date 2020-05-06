package com.qa.trello.tests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TeamBoardCreation extends TestBase {

    @Test
    public void TeamBoardCreation() throws InterruptedException {
        Thread.sleep(3000);
        int before = app. getTeam().getTeamCount();
        app.getTeam().initTeamCreation();
        app.getTeam().fillForm();
        app.getTeam().confirmTeamCreation();
        app.getTeam().inviteTeamLater();
        app.getTeam().returnToHomePage();
        int after = app.getTeam().getTeamCount();
        Assert.assertEquals(after, before + 1);





    }



}

