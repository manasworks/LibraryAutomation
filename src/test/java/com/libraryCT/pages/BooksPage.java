package com.libraryCT.pages;

import com.libraryCT.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BooksPage {
    public BooksPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//select[@name='tbl_books_length']")
    public WebElement showRecordsDropdown;

    @FindBy (xpath = "//th[text()='Borrowed By']")
    public WebElement filterBorrowedBy;

    @FindBy (xpath = "//td[7]")
    public List<WebElement> borrowedStatus;

    @FindBy (xpath = "//td[5]")
    public List<WebElement> genreStatus;

    @FindBy (xpath = "//input[@type='search']")
    public WebElement searchBooksInput;

    @FindBy (xpath = "//td[3]")
    public WebElement bookName;

    @FindBy (xpath = "//td[4]")
    public WebElement bookAuthor;

    @FindBy (xpath = "//td[6]")
    public WebElement bookYear;

    @FindBy (id = "book_categories")
    public WebElement bookCategories;
}
