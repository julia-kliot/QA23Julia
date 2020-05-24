package com.qa.trello.tests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileModificationTests extends TestBase {

    @Test
    public void testChangeProfileAvatar() throws InterruptedException {
        long beforeScreenshot= System.currentTimeMillis();
        Thread.sleep(3000);
        app.getProfile().takeScreenshot(beforeScreenshot);
        app.getProfile().clickOnAvatar();
        Thread.sleep(3000);
        app.getProfile().selectProfileAndVisibility();
        Thread.sleep(5000);
        app.getProfile().goToAtlassianProfile();
        Thread.sleep(2000);
        app.getProfile().iniChangeProfilePhoto();
        app.getProfile().uploadPhoto();
        long afterScreenshot= System.currentTimeMillis();
        app.getProfile().takeScreenshot(afterScreenshot);
        app.getProfile().returnToTrello();
        app.getProfile().refreshPage();
       // Assert.assertTrue(app.getProfile().avatarAdded());
        logger.info("screenshot before: "+ beforeScreenshot + ".png" );
        logger.info("screenshot after: "+ afterScreenshot + ".png" );
    }
}
