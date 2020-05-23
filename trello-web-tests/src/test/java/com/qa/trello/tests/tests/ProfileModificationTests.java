package com.qa.trello.tests.tests;

import org.testng.annotations.Test;

public class ProfileModificationTests extends TestBase {

    @Test
    public void testChangeProfileAvatar() throws InterruptedException {
       app.getProfile().clickOnAvatar();
       Thread.sleep(3000);
    app.getProfile().selectProfileAndVisibility();
        Thread.sleep(5000);
    app.getProfile().goToAtlassianProfile();
    //iniChangeProfilePhoto();
    //upLoadPhoto();
    }
}
