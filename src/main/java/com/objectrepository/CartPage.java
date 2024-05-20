package com.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.SeleniumActionsClass;

import java.util.ArrayList;
import java.util.List;

public class CartPage {

    WebDriver driver;
    SeleniumActionsClass seleniumActionsClass;

    public CartPage(WebDriver cartPageDriver){
        this.driver= cartPageDriver;
        PageFactory.initElements(driver,this);
        seleniumActionsClass = new SeleniumActionsClass(driver);
    }


    @FindBy


    public List<String> listOfProductsInCart;


    public void verifyProductsAddedToCart()
    {
        listOfProductsInCart = new ArrayList<>();
        List<WebElement> listOfProductsInWishlistEle = driver.findElements(By.xpath("//caption[text()='Shopping Cart Items']/parent::table/thead/following-sibling::tbody/descendant::strong/a"));

        for (WebElement element:listOfProductsInWishlistEle)
        {
            listOfProductsInCart.add(element.getText());

        }
        System.out.println(listOfProductsInCart);

    }



}
