package com.qa.trello.tests;

import org.openqa.selenium.By;
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
        inviteTeamLater();
        returnToHomePage();
        int after = getTeamCount();
        Assert.assertEquals(after, before + 1);





    }



}

