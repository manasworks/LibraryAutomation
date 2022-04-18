package com.libraryCT.utils;

import com.libraryCT.testbase.PagesInitializer;
import org.junit.Assert;

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



}
