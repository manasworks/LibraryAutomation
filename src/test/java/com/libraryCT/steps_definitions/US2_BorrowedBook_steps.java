package com.libraryCT.steps_definitions;

import com.libraryCT.testbase.PagesInitializer;
import com.libraryCT.utils.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US2_BorrowedBook_steps extends PagesInitializer {

    int actualBorrowedBooks=0;

    @When("user take borrowed books number")
    public void user_take_borrowed_books_number() {
        BrowserUtils.sleep(2);
        actualBorrowedBooks = Integer.parseInt(dashboardPage.borrowedBooksNum.getText());
    }
    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {
        String query = "select count(*)  from book_borrow where is_returned=0;";
        DBUtils.runQuery(query);
        int expectedBorrowedBooks = Integer.parseInt(DBUtils.getCellValue(1, 1));
        Assert.assertEquals(expectedBorrowedBooks, actualBorrowedBooks);
    }

}
