package com.libraryCT.pages;

import com.libraryCT.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    public DashboardPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//img[@class='d-inline-block align-top']")
    public WebElement mainLogo;

    @FindBy (id= "borrowed_books")
    public WebElement borrowedBooksNum;
}
