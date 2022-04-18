package com.libraryCT.steps_definitions;

import com.libraryCT.testbase.PagesInitializer;
import com.libraryCT.utils.BrowserUtils;
import com.libraryCT.utils.DBUtils;
import com.libraryCT.utils.LibraryUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class US3_MostPopularGenre_steps extends PagesInitializer {

    String mostPopularFromUI="";
    String mostPopularFromDB="";

    @When("user goes to {string} page")
    public void user_goes_to_page(String page) {
        LibraryUtils.navigateTo(page);
    }

    @When("user selects {string} records from dropdown")
    public void user_selects_records_from_dropdown(String value) {
        BrowserUtils.selectDropDownValue(value, booksPage.showRecordsDropdown);
        BrowserUtils.click(booksPage.filterBorrowedBy);
        BrowserUtils.click(booksPage.filterBorrowedBy);
        BrowserUtils.sleep(2);
    }

    @When("user gets most popular book genre")
    public void user_gets_most_popular_book_genre() {
        List<String> listGenre = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            if (booksPage.borrowedStatus.get(i).getText().isBlank() || booksPage.borrowedStatus.get(i).getText().isEmpty()){
                break;
            } else {
                BrowserUtils.highlight(booksPage.genreStatus.get(i));
                BrowserUtils.scrollToElement(booksPage.genreStatus.get(i));
                listGenre.add(booksPage.genreStatus.get(i).getText());
            }
        }
        int max=0;
        for (String each : listGenre) {
            int freq = Collections.frequency(listGenre, each);
            if (freq>max){
                max=freq;
                mostPopularFromUI=each;
            }
        }
    }

    @When("execute a query to find the most popular book genre from DB")
    public void execute_a_query_to_find_the_most_popular_book_genre_from_db() {
        String query="select name from book_categories\n" +
                "where name = (\n" +
                "    select book_categories.name from books\n" +
                "    inner join book_borrow on books.id = book_borrow.book_id\n" +
                "    inner join book_categories on books.book_category_id = book_categories.id\n" +
                "    group by book_categories.name\n" +
                "    order by count(*) desc\n" +
                "    limit 1\n" +
                "    );";
        DBUtils.runQuery(query);
        mostPopularFromDB = DBUtils.getCellValue(1,1);
    }

    @Then("verify that most popular genre from UI is matching to DB")
    public void verify_that_most_popular_genre_from_ui_is_matching_to_db() {

        Assert.assertEquals(mostPopularFromUI, mostPopularFromDB);

        System.out.println("mostPopularFromUI = " + mostPopularFromUI);
        System.out.println("mostPopularFromDB = " + mostPopularFromDB);
    }
}
