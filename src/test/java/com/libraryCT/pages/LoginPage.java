package com.libraryCT.pages;


import com.libraryCT.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.libraryCT.constants.Constants.EXPLICIT_WAIT_TIME;


public class LoginPage{

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "inputEmail")
    public static WebElement inputUsername;

    @FindBy (id = "inputPassword")
    public static WebElement inputPassword;

    @FindBy (xpath = "//button")
    public static WebElement signInButton;

    @FindBy (xpath = "//div[@role='alert']")
    public WebElement errorMessage;






}
