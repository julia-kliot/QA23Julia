package com.qa.trello.tests;

import org.testng.annotations.Test;

public class TeamBoardCreation extends TestBase {

    @Test
    public void TeamBoardCreation() throws InterruptedException {

        initTeamCreation();
        fillForm();
        confirmTeamCreation();
        returnToHomePage();





    }


}

