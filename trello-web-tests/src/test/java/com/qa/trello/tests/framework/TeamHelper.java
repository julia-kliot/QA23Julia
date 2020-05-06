package com.qa.trello.tests.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class TeamHelper extends HelperBase {

    public TeamHelper(WebDriver wd) {
        super(wd);
    }

    public void confirmTeamCreation()  {
        click(By.cssSelector("[type='submit']"));
        click(By.cssSelector(".eg0KI5SqghoOFd"));

    }

    public void fillForm() throws InterruptedException {
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"),"Test_Team1");
        click(By.cssSelector("[id='teamTypeSelect']"));
        Thread.sleep(2000);
        click(By.cssSelector("[data-test-id^=header-create-team-type] li"));
    }

    public void initTeamCreation() {
        click(By.cssSelector("[class='icon-add icon-sm _2aV_KY1gTq1qWc']"));
       // click(By.xpath("//*[@class='_33CvMKqfH4Yf0j']"));
    }

    public void inviteTeamLater() {
        if (isElementPresent(By.cssSelector("[data-test-id=show-later-button]"))) {
            click(By.cssSelector("[data-test-id=show-later-button]"));
        }
    }

    public int getTeamCount() throws InterruptedException {
        Thread.sleep(7000);
        return wd.findElements(By.cssSelector("[data-test-id=home-team-tab-name]")).size();
    }

    public void createTeam() throws InterruptedException {

        initTeamCreation();
        fillForm();
        confirmTeamCreation();
        returnToHomePage();
    }

    public void teamDeletion() {
        click(By.cssSelector(".quiet-button"));
        confirm();
    }

    public void openFirstTeam() {click(By.cssSelector("[data-test-id=home-team-tab-name]"));
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
