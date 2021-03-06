package com.qa.trello.tests.framework;

import com.google.common.io.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class HelperBase {

    WebDriver wd;
    WebDriverWait wait ;

    public HelperBase(WebDriver wd) {

        this.wd = wd;
    }

    public void returnToHomePage() {
        waitForElementClickableAndClick(By.xpath("//*[@name='house']/.."),20);

        //click(By.cssSelector("[class='_2BQG4yPMt5s_hu _2hgn5meZL7bJdx _1ctYJ9-gOV_hrm _3Xj1tqB73NcWn3']"), 20);
       // click(By.cssSelector("[class='_2BQG4yPMt5s_hu _2hgn5meZL7bJdx _1ctYJ9-gOV_hrm _3Xj1tqB73NcWn3']"), 20);

    }

   public void waitForElementClickableAndClick(By locator, int timeOut)
   { wait=new WebDriverWait(wd, timeOut);
        // wd.findElement(locator).click();
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }


    public void type(By locator, String text) {
        waitForElementLocatedAndClick(locator, 20);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }


    public void waitForElementLocatedAndClick(By locator, int timeOut) {
        wait=new WebDriverWait(wd, timeOut);
        // wd.findElement(locator).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
    }




    public  boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }

    public void confirm() {


        }
        public void takeScreenshot(long timeMillis){
            File tmp = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
            File screenshot = new File("screen-"+timeMillis+ ".png");
            try {
                Files.copy(tmp,screenshot);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    public void refreshPage() {

        wd.navigate().refresh();
    }
}

