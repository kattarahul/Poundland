package com.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.SeleniumActionsClass;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class WishlistPage {

    WebDriver driver;
    SeleniumActionsClass seleniumActionsClass;

    public WishlistPage(WebDriver wishlistDriver)
    {
        this.driver =wishlistDriver;
        PageFactory.initElements(driver,this);
        seleniumActionsClass = new SeleniumActionsClass(driver);
    }




    public List<String> listOfProductsInWishlist;



        public void verifyProductsAddedToWishlist()
        {
            listOfProductsInWishlist = new ArrayList<>();
            List <WebElement> listOfProductsInWishlistEle = driver.findElements(By.xpath("//table[@class='list']/tbody/tr/following-sibling::tr/descendant::p/span[@class='product-name']"));

            for (WebElement element:listOfProductsInWishlistEle)
            {
                listOfProductsInWishlist.add(element.getText());

            }
            System.out.println(listOfProductsInWishlist);

        }





}




