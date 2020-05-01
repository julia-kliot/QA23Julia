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

    private void openFirstTeam() {click(By.cssSelector("[data-test-id=home-team-tab-name]"));
    }


    public void clickTeamSetting() {
        click(By.cssSelector(".icon-gear.icon-sm"));
    }

    public void changeTeamProfile() {

        click(By.cssSelector("[name=edit]"));
    }

    public void changeTeamName() throws InterruptedException {
        Thread.sleep(2000);
        type(By.cssSelector("#displayName"), "New Trello Company");
        wd.findElement(By.cssSelector("#displayName")).sendKeys(Keys.ENTER);
    }

}
