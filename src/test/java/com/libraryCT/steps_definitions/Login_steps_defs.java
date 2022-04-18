package com.libraryCT.steps_definitions;

import com.libraryCT.testbase.PagesInitializer;
import com.libraryCT.utils.ConfigurationReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import static com.libraryCT.utils.BrowserUtils.*;
import static com.libraryCT.utils.LibraryUtils.*;

public class Login_steps_defs extends PagesInitializer {

    @When("user enters {string} and {string}")
    public void user_enters_and(String username, String password) {
        login(username, password);
    }

    @When("user click {string} button")
    public void user_click_button(String btName) {
        clickButton(btName);
    }

    @Then("Verify user see the {string} page")
    public void verify_user_see_the_page(String title) {
        Assert.assertTrue( isElementDisplayed(dashboardPage.mainLogo) );
    }

    @Then("Verify user see the error message")
    public void verify_user_see_the_error_message() {
        Assert.assertTrue( isElementDisplayed(loginPage.errorMessage) );
    }
}
