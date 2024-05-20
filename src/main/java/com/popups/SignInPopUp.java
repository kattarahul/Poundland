package com.popups;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.SeleniumActionsClass;

import java.io.FileReader;
import java.io.IOException;

public class SignInPopUp {

    WebDriver driver;
    SeleniumActionsClass seleniumActionsClass;

    public SignInPopUp(WebDriver signIPopUpDriver)
    {
        this.driver = signIPopUpDriver;
        seleniumActionsClass = new SeleniumActionsClass(driver);
    }



    @FindBy(xpath = "//button[text()='Accept All Cookies']")
    WebElement acceptAllBtn;

    @FindBy(css = "[data-testid='om-overlays-close']")
    WebElement closePopUpBtn;

    @FindBy(xpath = "//a[contains(text(),'sign in')]")
    WebElement signInIconBtn;

    @FindBy(id = "#email")
    WebElement emailSignInInputField;

    @FindBy(css = "[name='login[password]']")
    WebElement passwordSignInInputField;

    @FindBy(xpath = "//div[@class='top-subnav']/div/form/fieldset/descendant::div[@class='primary']/button")
    WebElement popupSignInBtn;



    public void signIn(String filePath , WebElement emailEle, WebElement passwordEle) throws IOException, ParseException
    {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader(filePath);
        Object obj = jsonParser.parse(fileReader);
        JSONObject jsonObject = (JSONObject) obj;

        String email = jsonObject.get("Email").toString();
        String password = jsonObject.get("Password").toString();

        seleniumActionsClass.enterTextField(emailEle,email);
        seleniumActionsClass.enterTextField(passwordEle,password);
    }





}
