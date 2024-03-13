package bw_pages;

import bw_baseClass.base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myOrdersPage extends base {
    public myOrdersPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//h1[contains(text(),'My Orders')]")
    WebElement myOrdersPageHeading;

    public String verifyMyOrdersPageHeading(){
        return myOrdersPageHeading.getText();
    }
}
