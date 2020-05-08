package com.qa.trello.tests.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {

        if (app.getTeam().getTeamCount() == 0) {

            app.getTeam().createTeam();
       }
}

    @Test
    public void TeamDeletionTests() throws InterruptedException {
        Thread.sleep(5000);
       // int before = app.getTeam().getTeamCount();
        app.getTeam().openFirstTeam();
        Thread.sleep(2000);
        app.getTeam().clickTeamSetting();
        app.getTeam().teamDeletion();
        app.getTeam().returnToHomePage();
        //int after = app.getTeam().getTeamCount();


        //System.out.println("was:  " + before + "now:  " + after);
       // Assert.assertEquals(after, before - 1);
    }


}



