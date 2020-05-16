package com.qa.trello.tests.framework;

import com.qa.trello.model.Team;
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

    public void fillForm(Team team) throws InterruptedException {
        typeTeamName(team.getName());
        openListOfTeam();
        Thread.sleep(2000);
        selectTypeOfTeam();
    }

    private void selectTypeOfTeam() {
        waitForElementLocatedAndClick(By.cssSelector("[data-test-id^=header-create-team-type] li"), 20);

    }

    private void openListOfTeam() {
        waitForElementLocatedAndClick(By.cssSelector("[id='teamTypeSelect']"), 20);
    }

    private void typeTeamName(String nameOfTeam) {

        type(By.cssSelector("[data-test-id='header-create-team-name-input']"),nameOfTeam);
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
        fillForm(new Team().withName ("Test_Team1"));
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
