package utilities;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;


public class SeleniumActionsClass {


    WebDriver driver;
    Actions action;
    WaitsClass waitsClass;

    WebDriverWait wait;

    JavascriptExecutor jse;

    public SeleniumActionsClass(WebDriver actionClassDriver)
    {
        this.driver= actionClassDriver;
        waitsClass = new WaitsClass();
    }




    public void moveToElement(WebElement element)
    {
        action = new Actions(driver);
        action.moveToElement(element).click().build().perform();
    }

    public WebElement waitAndClick(WebElement element)
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(waitsClass.seconds));
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(element));
        return element1;
    }



    public void elementToClick(WebElement element)
    {
        element.click();

    }




    public void enterTextField(WebElement element ,String key)
    {
        element.sendKeys(key);

    }


    public void javaScriptClick(WebElement element)
    {
        jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();",element);

    }

    public void javaScriptEnterFields( WebElement element,String value)
    {
        jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].value='"+ value +"';", element);
    }

    public void scrollToElement(WebElement element)
    {
        jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",element);
    }


    public void readDataFromJson(String filePath,WebElement firstNameEle,WebElement lastNameEle,WebElement emailEle,WebElement passwordEle, WebElement confirmPasswordEle) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader(filePath);
        Object obj = jsonParser.parse(fileReader);
        JSONObject jsonObject = (JSONObject) obj;

        String firstName = jsonObject.get("FirstName").toString();
        String lastName = jsonObject.get("LastName").toString();
        String email = jsonObject.get("Email").toString();
        String password = jsonObject.get("Password").toString();

        enterTextField(firstNameEle,firstName);
        enterTextField(lastNameEle,lastName);
        enterTextField(emailEle,email);
        enterTextField(passwordEle,password);
       javaScriptEnterFields(confirmPasswordEle,password);

    }


    public void signIn(String filePath ,WebElement emailEle, WebElement passwordEle) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader(filePath);
        Object obj = jsonParser.parse(fileReader);
        JSONObject jsonObject = (JSONObject) obj;


        String email = jsonObject.get("Email").toString();
        String password = jsonObject.get("Password").toString();

        enterTextField(emailEle,email);
        enterTextField(passwordEle,password);
    }


}
