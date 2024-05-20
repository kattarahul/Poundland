package com.tests;

import com.base.BaseClass;
import com.objectrepository.CreateAccountPage;
import com.objectrepository.HomePage;
import com.objectrepository.WishlistPage;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class FirstTestcase extends BaseClass {


    CreateAccountPage createAccount;
    WishlistPage wishlistPage;
    HomePage homePage;


    @BeforeMethod
    public void initialization()
    {
        createAccount = new CreateAccountPage(driver);
        wishlistPage = new WishlistPage(driver);
        homePage = new HomePage(driver);
    }

    @Test
    public void testcaseOne() throws IOException, ParseException, InterruptedException {
        createAccount.createNewAccountMethod();
        Assert.assertEquals(createAccount.successMsgText.getText() ,"Thank you for registering with Poundland.");
        homePage.addToWishlist();
        wishlistPage.verifyProductsAddedToWishlist();
//        Assert.assertTrue(wishlistPage.listOfProductsInWishlist.contains(homePage.listOfProducts));
        homePage.logout();

    }



}
