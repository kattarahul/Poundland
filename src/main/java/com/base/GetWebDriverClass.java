package com.base;

import org.openqa.selenium.WebDriver;

public class GetWebDriverClass {

    private static WebDriver driver;
    static WebDriverFactory webDriverFactory;


    public GetWebDriverClass(WebDriver getDriver)
    {
        this.driver = getDriver;
    }


    public  static WebDriver getDriver()
    {
        if(driver==null)
        {
            webDriverFactory = new WebDriverFactory(driver);
            driver = webDriverFactory.setBrowser("chrome");
            driver.get("https://www.poundland.co.uk/");
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
