package com.libraryCT.pages;


import com.libraryCT.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "inputEmail")
    public WebElement inputUsername;

    @FindBy (id = "inputPassword")
    public WebElement inputPassword;

    @FindBy (xpath = "//button")
    public WebElement signInButton;

    @FindBy (xpath = "//div[@role='alert']")
    public WebElement errorMessage;






}
