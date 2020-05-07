package com.qa.trello.tests.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class TeamHelper extends HelperBase {

    public TeamHelper(WebDriver wd) {
        super(wd);
    }

    public void confirmTeamCreation()  {
        waitForElementLocatedAndClick(By.cssSelector("[type='submit']"), 20);
        waitForElementLocatedAndClick(By.cssSelector(".eg0KI5SqghoOFd"), 20);

    }

    public void fillForm() throws InterruptedException {
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"),"Test_Team1");
        waitForElementLocatedAndClick(By.cssSelector("[id='teamTypeSelect']"), 20);
        Thread.sleep(2000);
        waitForElementLocatedAndClick(By.cssSelector("[data-test-id^=header-create-team-type] li"), 20);
    }

    public void initTeamCreation() {
        waitForElementLocatedAndClick(By.cssSelector("[class='icon-add icon-sm _2aV_KY1gTq1qWc']"), 20);
       // click(By.xpath("//*[@class='_33CvMKqfH4Yf0j']"));
    }

    public void inviteTeamLater() {
        if (isElementPresent(By.cssSelector("[data-test-id=show-later-button]"))) {
            waitForElementLocatedAndClick(By.cssSelector("[data-test-id=show-later-button]"), 20);
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
        waitForElementLocatedAndClick(By.cssSelector(".quiet-button"), 20);
        confirm();
    }

    public void openFirstTeam() {
        waitForElementLocatedAndClick(By.cssSelector("[data-test-id=home-team-tab-name]"), 20);
    }

    public void clickTeamSetting() {
        waitForElementLocatedAndClick(By.cssSelector(".icon-gear.icon-sm"), 20);
    }

    public void changeTeamProfile() {

        waitForElementLocatedAndClick(By.cssSelector("[name=edit]"), 20);
    }

    public void changeTeamName() throws InterruptedException {
        Thread.sleep(2000);
        type(By.cssSelector("#displayName"), "New Trello Company");
        wd.findElement(By.cssSelector("#displayName")).sendKeys(Keys.ENTER);
    }
}
