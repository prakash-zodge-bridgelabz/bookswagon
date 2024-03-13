package bw_pages;

import bw_baseClass.base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myWishlistPage extends base {
    public myWishlistPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//h1[contains(text(),'My Wishlist')]")
    WebElement myWishlistHeading;

    public String verifyMWishlistHeading(){
        return myWishlistHeading.getText();
    }
}
