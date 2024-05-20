package com.tests;

import com.base.BaseClass;
import com.base.GetWebDriverClass;
import com.objectrepository.CartPage;
import com.objectrepository.CreateAccountPage;
import com.objectrepository.HomePage;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class SecondTestcase extends BaseClass {


    CreateAccountPage createAccountPage;
    HomePage homePage;
    CartPage cartPage ;





    @BeforeMethod
    public void initialization()
    {
        createAccountPage = new CreateAccountPage(driver);
        homePage =new HomePage(driver);
        cartPage = new CartPage( driver);

    }


    @Test
    public void testcaseTwo() throws IOException, ParseException, InterruptedException {
//        WebDriver driver = GetWebDriverClass.getDriver();
        createAccountPage.signIn();
        homePage.addToCart();
        cartPage.verifyProductsAddedToCart();
        Assert.assertEquals(cartPage.listOfProductsInCart,homePage.listOfProductsToCart);
        homePage.logout();
    }



}
