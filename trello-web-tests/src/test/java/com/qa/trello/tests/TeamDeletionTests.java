package com.qa.trello.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {

        if (app.getTeamCount() == 0) {

            app.createTeam();
       }
}

    @Test
    public void TeamDeletionTests() throws InterruptedException {
        Thread.sleep(5000);
        int before = app.getTeamCount();
        app.openFirstTeam();
        Thread.sleep(2000);
        app.clickTeamSetting();
        app.teamDeletion();
        app.returnToHomePage();
        int after = app.getTeamCount();


        System.out.println("was:  " + before + "now:  " + after);
        Assert.assertEquals(after, before - 1);
    }


}



