package com.qa.trello.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamChangeTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (app.getTeamCount() == 0) {
            app.createTeam();
        }
    }
    @Test
    public void changeTeamTests() throws InterruptedException {

        app.openFirstTeam();
        app.clickTeamSetting();
        app.changeTeamProfile();
        app.changeTeamName();
        app.returnToHomePage();
    }





}
