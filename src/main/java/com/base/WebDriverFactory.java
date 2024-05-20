package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {

   private WebDriver driver;

    public WebDriverFactory (WebDriver webFactoryDriver)
    {
        this.driver = webFactoryDriver;
    }


    public WebDriver setBrowser(String browser)  {

        switch (browser){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Provide right browser name");
        }
        driver.manage().window().maximize();
        return driver;
    }




}
