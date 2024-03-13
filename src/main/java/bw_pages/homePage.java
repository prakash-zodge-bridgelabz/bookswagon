package bw_pages;

import bw_baseClass.base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage extends base {
    //Page factory
    @FindBy(id="ctl00_phBody_SignIn_txtEmail")
    WebElement txtUsername;
    @FindBy(id="ctl00_phBody_SignIn_txtPassword")
    WebElement txtPassword;
    @FindBy(id="ctl00_phBody_SignIn_btnLogin")
    WebElement btnLogin;
    @FindBy(id = "ctl00_lblUser")
    WebElement lblUsername;

    public String verifyUsername(){
        return lblUsername.getText();
    }

    @FindBy(partialLinkText = "My Orders")
    WebElement btnMyOrders;

    @FindBy(partialLinkText = "My Wishlist")
    WebElement btnMyWishlist;
    public homePage(){
        PageFactory.initElements(driver,this);
    }
    public String verifyHomePageTitle(){
        return driver.getTitle();
    }
    public myOrdersPage clickOnMyOrders(){
        btnMyOrders.click();
        return new myOrdersPage();
    }
    public myWishlistPage clickOnMyWishlist(){
        btnMyWishlist.click();
        return new myWishlistPage();
    }
    public String getUsername() throws InterruptedException {

        txtUsername.sendKeys("username");
        txtPassword.sendKeys("password");
        Thread.sleep(1000);
        btnLogin.click();
        Thread.sleep(1000);
        return lblUsername.getText().toString();
    }
}
