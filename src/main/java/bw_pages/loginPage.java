package bw_pages;

import bw_baseClass.base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage extends base {
    //Page factory
    @FindBy(id="ctl00_phBody_SignIn_txtEmail")
    WebElement txtUsername;
    @FindBy(id="ctl00_phBody_SignIn_txtPassword")
    WebElement txtPassword;
    @FindBy(id="ctl00_phBody_SignIn_btnLogin")
    WebElement btnLogin;
    //Initializing the page objects
    public loginPage(){
        PageFactory.initElements(driver,this);
    }
    //Actions:
    public homePage multipleUserLogin(String username, String password){
        txtUsername.sendKeys(username);
        txtPassword.sendKeys(password);
        btnLogin.click();

        return new homePage();
    }
}
