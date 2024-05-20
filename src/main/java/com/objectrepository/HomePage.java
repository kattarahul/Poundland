package com.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.SeleniumActionsClass;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    WebDriver driver;
    SeleniumActionsClass seleniumActionsClass;

    public HomePage(WebDriver homepageDriver)
    {
        this.driver= homepageDriver;
        PageFactory.initElements(driver,this);
        seleniumActionsClass= new SeleniumActionsClass(driver);
    }



    @FindBy(xpath = "//button[text()='Accept All Cookies']")
    WebElement acceptAllBtn;

    @FindBy(linkText = "sign in ")
    WebElement signInBtn;

    @FindBy(xpath = "//li[@class='menu-title']/following-sibling::li/a[text()='Garden']")
    WebElement gardenTextEle;
    @FindBy(linkText = "Hanging Baskets")
    WebElement hangingBasketsTextEle;
    @FindBy(css = "[class='top-nav__link']")
    WebElement myAccountBtn;
    @FindBy(linkText = "My Favourites")
    WebElement myFavouritesPageBtn;

    @FindBy(xpath = "//span[text()='Your Basket']/following-sibling::span[@class='cart-badge']")
    WebElement bagIconBtn;

    @FindBy(xpath = "//a[text()='Log out']")
    WebElement logoutBtn;

    @FindBy(css = "[class='amount']")
    WebElement scrollToProductEle;

//    [class='products list products-grid']
    public List<String> listOfProducts;

    public List<String> listOfProductsToCart;


    public void addToWishlist() {
        seleniumActionsClass.moveToElement(gardenTextEle);
        seleniumActionsClass.elementToClick(hangingBasketsTextEle);
        seleniumActionsClass.scrollToElement(scrollToProductEle);

        List<WebElement> webElementList = driver.findElements(By.xpath("//div[@class='amount']/parent::div/following-sibling::div/ol/li/div/following-sibling::div/descendant::a[@data-action='add-to-wishlist']/parent::div/parent::div/following-sibling::div/span/a"));
        List<WebElement> wishListIconEle = driver.findElements(By.cssSelector("[data-action='add-to-wishlist']"));

        listOfProducts = new ArrayList<>();


        int count = 0;
        for (int i = 0; i <= listOfProducts.size(); i++) {
            wishListIconEle.get(i).click();
            listOfProducts.add(webElementList.get(i).getText());
            count++;
            if (count == 3) {
                System.out.println("the count is : " + count);
                break;
            }

        }
        System.out.println(listOfProducts);

        seleniumActionsClass.elementToClick(myAccountBtn);
        seleniumActionsClass.elementToClick(myFavouritesPageBtn);

    }



    public void addToCart() {
        seleniumActionsClass.moveToElement(gardenTextEle);
        seleniumActionsClass.elementToClick(hangingBasketsTextEle);
        seleniumActionsClass.scrollToElement(scrollToProductEle);

        List<WebElement> webElementList = driver.findElements(By.xpath("//div[@class='amount']/parent::div/following-sibling::div/ol/li/div/following-sibling::div/descendant::a[@data-action='add-to-wishlist']/parent::div/parent::div/following-sibling::div/span/a"));
        List<WebElement> addProductToCartBtnEle = driver.findElements(By.cssSelector("[title='Add']"));

        listOfProductsToCart = new ArrayList<>();


        int count = 0;
        for (int i = 0; i <= listOfProductsToCart.size(); i++) {
            addProductToCartBtnEle.get(i).click();
            listOfProductsToCart.add(webElementList.get(i).getText());
            count++;
            if (count == 3) {
                System.out.println("the count is : " + count);
                break;
            }

        }
        System.out.println(listOfProductsToCart);
        seleniumActionsClass.elementToClick(bagIconBtn);
    }


    public void logout()
    {
        seleniumActionsClass.elementToClick(myAccountBtn);
        seleniumActionsClass.elementToClick(logoutBtn);

    }

}
