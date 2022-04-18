package com.libraryCT.steps_definitions;

import com.libraryCT.testbase.PagesInitializer;
import com.libraryCT.utils.*;
import io.cucumber.java.en.Given;
import org.junit.Assert;

public class Base extends PagesInitializer {

    @Given("user on the login page")
    public void user_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }

    @Given("Establish the database connection")
    public void establish_the_database_connection() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }

    @Given("user log in as a librarian")
    public void user_log_in_as_a_librarian() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        LibraryUtils.loginAsLibrarian();
        Assert.assertTrue( BrowserUtils.isElementDisplayed(dashboardPage.mainLogo) );
    }
}
