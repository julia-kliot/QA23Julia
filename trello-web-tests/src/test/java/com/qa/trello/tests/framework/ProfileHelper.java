package com.qa.trello.tests.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfileHelper extends HelperBase {
    public ProfileHelper(WebDriver wd) {

        super(wd);
    }

    public void clickOnAvatar() {
        waitForElementLocatedAndClick(By.xpath("//*[@data-test-id='header-member-menu-button']"),20);
    }


    public void selectProfileAndVisibility() {
        waitForElementLocatedAndClick(By.xpath("//*[@data-test-id='header-member-menu-profile']"),20);
    }

    public void goToAtlassianProfile() {
        waitForElementLocatedAndClick(By.cssSelector("a[href$=manage-profile]"),20);

    }
}
