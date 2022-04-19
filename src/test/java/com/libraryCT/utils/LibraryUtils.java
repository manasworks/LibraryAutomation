package com.libraryCT.utils;

import com.libraryCT.testbase.PagesInitializer;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LibraryUtils extends PagesInitializer {

    public static void loginAsStudent(){
        BrowserUtils.sendText(loginPage.inputUsername, ConfigurationReader.getProperty("user1"));
        BrowserUtils.sendText(loginPage.inputPassword, ConfigurationReader.getProperty("pass1"));
        BrowserUtils.click(loginPage.signInButton);
        Assert.assertTrue( BrowserUtils.isElementDisplayed(dashboardPage.mainLogo) );
    }

    public static void loginAsLibrarian(){
        BrowserUtils.sendText(loginPage.inputUsername, ConfigurationReader.getProperty("user2"));
        BrowserUtils.sendText(loginPage.inputPassword, ConfigurationReader.getProperty("pass2"));
        BrowserUtils.click(loginPage.signInButton);
        Assert.assertTrue( BrowserUtils.isElementDisplayed(dashboardPage.mainLogo) );
    }

    public static void login(String username, String password){
        BrowserUtils.sendText(loginPage.inputUsername, username);
        BrowserUtils.sendText(loginPage.inputPassword, password);
    }

    /**
     * Method waits and click the button by given ButtonName
     * @param link
     */
    public static void navigateTo(String link){
        try{
            WebElement element = Driver.getDriver().findElement(By.xpath("//*[text() = '"+link+"']/.."));
            BrowserUtils.getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
            if (ConfigurationReader.getProperty("highlight").equalsIgnoreCase("true")) {
                BrowserUtils.highlight(element);
            }
            element.click();
        } catch (NoSuchElementException e){
            System.err.println("Link not found");
            e.printStackTrace();
        }
    }



}
