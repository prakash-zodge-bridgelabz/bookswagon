package bw_testCase;


import bw_baseClass.base;
import bw_pages.homePage;
import bw_pages.loginPage;
import bw_pages.myOrdersPage;
import bw_pages.myWishlistPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class myWishlistPageTest extends base{
    loginPage l;
    homePage h;
    myOrdersPage m;
    myWishlistPage myWishlist;
    public myWishlistPageTest(){
        super();
    }
    @BeforeMethod
    public void setup(){
        initializations();
        l = new loginPage();
        h=l.login(prop.getProperty("ruchitaUsername"), prop.getProperty("ruchitaPassword"));
        m = new myOrdersPage();
        myWishlist = new myWishlistPage();
    }

    @Test(priority=1)
    public void verifyMWishlistHeadingTest(){
        myWishlist = h.clickOnMyWishlist();

        String actualHeading = myWishlist.verifyMWishlistHeading();
        String expectedHeading = "My Wishlist";
        Assert.assertEquals(actualHeading,expectedHeading,"Heading not matched");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
