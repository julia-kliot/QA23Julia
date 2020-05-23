package com.qa.trello.tests.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfileHelper extends HelperBase {
    public ProfileHelper(WebDriver wd) {
        super(wd);
    }

    public void clickOnAvatar() {
        wd.findElement(By.xpath("//*[@data-test-id='header-member-menu-button']")).click();
    }

    public void selectProfileAndVisibility() {
        wd.findElement(By.xpath("//*[@data-test-id='header-member-menu-profile']"));
    }

    public void goToAtlassianProfile() {
        wd.findElement(By.cssSelector("a[href$=manage-profile]"));

    }
}
