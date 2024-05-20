package com.base;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseClass {

   public WebDriver driver;
    WebDriverFactory webDriverFactory;


    @Parameters({"browserName","url"})
    @BeforeClass
    public void initializeBrowser(String browserName ,String url)
    {
        webDriverFactory = new WebDriverFactory(driver);
         driver = webDriverFactory.setBrowser(browserName);
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
//    @Parameters("url")
//   @BeforeClass
//   public void launchApplication(String url)
//   {
//       driver.get(url);
//       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//   }

   @AfterClass
    public void closeApplication()
   {
       GetWebDriverClass.closeDriver();

   }


}
