package com.libraryCT.steps_definitions;

import com.libraryCT.testbase.PagesInitializer;
import com.libraryCT.utils.BrowserUtils;
import com.libraryCT.utils.DBUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class US4_MostPopularUser_steps extends PagesInitializer {

    String mostPopularFromUI="";
    String mostPopularFromDB="";

    @When("user gets most popular user who reads the most")
    public void user_gets_most_popular_user_who_reads_the_most() {
        List<String> listUsers = new ArrayList<>();
        for (WebElement user : booksPage.borrowedStatus) {
            BrowserUtils.highlight(user);
            BrowserUtils.scrollToElement(user);
            listUsers.add(user.getText());
        }
        int max=0;
        for (String each : listUsers) {
            int f = Collections.frequency(listUsers, each);
            if (f>max){
                max=f;
                mostPopularFromUI=each;
            }
        }
    }

    @When("execute a query to find the most popular user from DB")
    public void execute_a_query_to_find_the_most_popular_user_from_db() {
        DBUtils.createConnection();
        String query="select full_name,count(*) from users u inner join book_borrow bb on u.id = bb.user_id\n" +
                "group by full_name\n" +
                "order by 2 desc";
        DBUtils.runQuery(query);
        mostPopularFromDB = DBUtils.getCellValue(1,1);
    }

    @Then("verify that most popular user from UI is matching to DB")
    public void verify_that_most_popular_user_from_ui_is_matching_to_db() {
        Assert.assertEquals(mostPopularFromUI, mostPopularFromDB);

        System.out.println("mostPopularFromUI = " + mostPopularFromUI);
        System.out.println("mostPopularFromDB = " + mostPopularFromDB);
    }
}
