package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamChangeTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (getTeamCount() == 0) {
            createTeam();
        }
    }
    @Test
    public void changeTeamTests() throws InterruptedException {

        openFirstTeam();
        clickTeamSetting();
        changeTeamProfile();
        changeTeamName();
        returnToHomePage();
    }





}
