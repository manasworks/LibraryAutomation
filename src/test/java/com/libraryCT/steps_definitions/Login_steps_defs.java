package com.libraryCT.steps_definitions;

import com.libraryCT.pages.DashboardPage;
import com.libraryCT.pages.LoginPage;
import com.libraryCT.utils.BrowserUtils;
import com.libraryCT.utils.LibraryUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_steps_defs {

    DashboardPage dashboardPage = new DashboardPage();
    LoginPage loginPage = new LoginPage();

    @When("user enters {string} and {string}")
    public void user_enters_and(String username, String password) {
        LibraryUtils.login(username, password);
    }

    @When("user click {string} button")
    public void user_click_button(String btName) {
        BrowserUtils.clickButton(btName);
    }

    @Then("Verify user see the {string} page")
    public void verify_user_see_the_page(String title) {
        Assert.assertTrue( BrowserUtils.isElementDisplayed(dashboardPage.mainLogo) );
    }

    @Then("Verify user see the error message")
    public void verify_user_see_the_error_message() {
        Assert.assertTrue( BrowserUtils.isElementDisplayed(loginPage.errorMessage) );
    }
}
