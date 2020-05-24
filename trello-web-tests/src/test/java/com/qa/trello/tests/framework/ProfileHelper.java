package com.qa.trello.tests.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
        String trello = wd.getWindowHandle();
        System.out.println(trello);
        waitForElementLocatedAndClick(By.cssSelector("a[href$=manage-profile]"),20);
        List<String>availableWindows= new ArrayList<>(wd.getWindowHandles());
        if(!availableWindows.isEmpty()){
            wd.switchTo().window(availableWindows.get(1));
        }
        //now Selenium on Atlassian page
        String atlassianAcc = wd.getWindowHandle();
        System.out.println(atlassianAcc);
    }

    public void iniChangeProfilePhoto() {
        WebElement avatar = wd.findElement(By.xpath("//*[@data-test-selector='profile-avatar']"));
        new Actions(wd).moveToElement(avatar).perform();
        waitForElementLocatedAndClick(By.xpath("//*[@data-test-selector='trigger-avatar-picker']"),20);
    }
    public void attachFile(By locator, File file){
        wd.findElement(locator).sendKeys(file.getAbsolutePath());
    }

    public void uploadPhoto() throws InterruptedException {
        attachFile(By.cssSelector("button #image-input"),
                new File("C:\\Users\\user\\Documents\\GitHub\\QA23Julia\\trello-web-tests\\src\\test\\resources\\bear.jpg"));
        Thread.sleep(2000);
        waitForElementLocatedAndClick(By.xpath("//*[@class='css-1yx6h60']"),20);
    }

   //public boolean avatarAdded() {
       // return isElementPresent()
    }

