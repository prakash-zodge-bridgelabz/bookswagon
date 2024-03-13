package bw_testCase;

import bw_baseClass.base;
import bw_pages.homePage;
import bw_pages.loginPage;
import bw_pages.myOrdersPage;
import net.bytebuddy.build.Plugin;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class homePageTest extends base {
    loginPage l;
    homePage h;
    myOrdersPage m;
    public homePageTest(){
        super();
    }
    @BeforeMethod
    public void setup(){
        initializations();
        l = new loginPage();
        h=l.login(prop.getProperty("ruchitaUsername"), prop.getProperty("ruchitaPassword"));
        m = new myOrdersPage();
    }

    @Test(priority=1)
    public void verifyHomePageTitleTest(){
        String actualTitle = h.verifyHomePageTitle();
        System.out.println(actualTitle);
        String expectedTitle = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
        Assert.assertEquals(actualTitle,expectedTitle,"Not matched");
    }
    @Test(priority = 2)
    public void verifyUsernameTest(){
        String actualUsername = h.verifyUsername();
        System.out.println(actualUsername);
        String expectedUsername = "Ruchita";
        Assert.assertEquals(actualUsername,expectedUsername,"Username not matched");
    }

    @Test(priority=3)
    public void verifyMyOrdersLink(){
        m = h.clickOnMyOrders();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
