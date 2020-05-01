package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {

        if (getTeamCount() == 0) {

            createTeam();
       }
}

    @Test
    public void TeamDeletionTests() throws InterruptedException {
        Thread.sleep(5000);
        int before = getTeamCount();
        openFirstTeam();
        Thread.sleep(2000);
        clickTeamSetting();
        teamDeletion();
        returnToHomePage();
        int after = getTeamCount();


        System.out.println("was:  " + before + "now:  " + after);
        Assert.assertEquals(after, before - 1);
    }


    public void openFirstTeam() {
        click(By.cssSelector("[data-test-id=home-team-tab-name]"));
    }

    public void clickTeamSetting() {
        click(By.cssSelector(".icon-gear.icon-sm"));
       // click(By.cssSelector(".js-org-account "));
    }

    public void teamDeletion() {
        click(By.cssSelector(".quiet-button"));
        confirm();
    }

}



