package com.objectrepository;

import com.popups.SignInPopUp;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.SeleniumActionsClass;

import java.io.FileReader;
import java.io.IOException;

public class CreateAccountPage {
    WebDriver driver;
    SeleniumActionsClass seleniumActionsClass;
    SignInPopUp signInPopUp;

    public CreateAccountPage(WebDriver createAccDriver)
    {
        this.driver = createAccDriver;
        PageFactory.initElements(driver,this);
        seleniumActionsClass = new SeleniumActionsClass(driver);
        signInPopUp = new SignInPopUp(driver);
    }


    @FindBy(xpath = "//button[text()='Accept All Cookies']")
    WebElement acceptAllBtn;

    @FindBy(css = "[data-testid='om-overlays-close']")
    WebElement closePopUpBtn;

    @FindBy(xpath = "//a[contains(text(),'sign in')]")
    WebElement signInIconBtn;

    @FindBy(linkText = "Create an Account")
    WebElement createAccountBtn;

    @FindBy(css = "#firstname")
    WebElement firstNameInputField;

    @FindBy(css = "#lastname")
    WebElement lastNameInputField;

    @FindBy(css = "#email_address")
    WebElement emailInputField;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordInputField;

    @FindBy(xpath = "//input[@id='password-confirmation']")
    WebElement confirmPasswordInputField;

    @FindBy(xpath = "//span[text()='Submit']")
    WebElement submitBtn;

    @FindBy(xpath = "//div[@data-ui-id='message-success']/div")
    public WebElement successMsgText;

    @FindBy(xpath = "//div[@data-ui-id='message-error']/div")
    WebElement errorMsgAlreadyAccText;


    @FindBy(xpath = "//div[@class='top-subnav']/div/form/fieldset/div/div/input[@id='email']")
    WebElement emailSignInInputField;

    @FindBy(xpath = "//div[@class='top-subnav']/div/form/fieldset/descendant::div/div/input[@type='password']")
    WebElement passwordSignInInputField;

    @FindBy(xpath = "//div[@class='top-subnav']/div/form/fieldset/descendant::div[@class='primary']/button")
    WebElement popupSignInBtn;

    @FindBy(xpath = "//fieldset[contains(@class,'fieldset login')]/descendant::div[@class='primary']/button")
    WebElement signInPopUpBtn;



    public void createNewAccountMethod() throws IOException, ParseException, InterruptedException {

        seleniumActionsClass.elementToClick(acceptAllBtn);
        seleniumActionsClass.waitAndClick(closePopUpBtn);
        seleniumActionsClass.elementToClick(closePopUpBtn);
        seleniumActionsClass.elementToClick(signInIconBtn);
        seleniumActionsClass.elementToClick(createAccountBtn);


        seleniumActionsClass.readDataFromJson(
                "src/main/TestData/createAccountDetails.json",
                firstNameInputField,
                lastNameInputField,
                emailInputField,
                passwordInputField,
                confirmPasswordInputField
        );

        Thread.sleep(10000);
        seleniumActionsClass.elementToClick(submitBtn);


    }



    public void signIn() throws IOException, ParseException {
        seleniumActionsClass.waitAndClick(acceptAllBtn);
        seleniumActionsClass.elementToClick(acceptAllBtn);
        seleniumActionsClass.waitAndClick(closePopUpBtn);
        seleniumActionsClass.elementToClick(closePopUpBtn);
        seleniumActionsClass.elementToClick(signInIconBtn);

        seleniumActionsClass.signIn("src/main/TestData/createAccountDetails.json",
                emailSignInInputField,
                passwordSignInInputField);

        seleniumActionsClass.elementToClick(signInPopUpBtn);

    }




}
