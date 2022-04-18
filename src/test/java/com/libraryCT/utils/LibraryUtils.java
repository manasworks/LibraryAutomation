package com.libraryCT.utils;

import com.libraryCT.testbase.PagesInitializer;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.libraryCT.pages.LoginPage.*;
import static com.libraryCT.utils.BrowserUtils.*;

public class LibraryUtils extends PagesInitializer {

    public static void loginAsStudent(){
        sendText(inputUsername, ConfigurationReader.getProperty("user1"));
        sendText(inputPassword, ConfigurationReader.getProperty("pass1"));
        click(signInButton);
        Assert.assertTrue( isElementDisplayed(dashboardPage.mainLogo) );
    }

    public static void loginAsLibrarian(){
        sendText(inputUsername, ConfigurationReader.getProperty("user2"));
        sendText(inputPassword, ConfigurationReader.getProperty("pass2"));
        click(signInButton);
        Assert.assertTrue( isElementDisplayed(dashboardPage.mainLogo) );
    }

    public static void login(String username, String password){
        sendText(inputUsername, username);
        sendText(inputPassword, password);
    }

    /**
     * Method waits and click the button by given ButtonName
     * @param link
     */
    public static void navigateTo(String link){
        try{
            WebElement element = Driver.getDriver().findElement(By.xpath("//*[text() = '"+link+"']/.."));
            getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
            if (ConfigurationReader.getProperty("highlight").equalsIgnoreCase("true")) {
                highlight(element);
            }
            element.click();
        } catch (NoSuchElementException e){
            System.err.println("Link not found");
            e.printStackTrace();
        }
    }



}
