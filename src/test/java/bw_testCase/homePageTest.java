package bw_testCase;

import bw_baseClass.base;
import bw_pages.homePage;
import bw_pages.loginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class homePageTest extends base {
    loginPage l;
    homePage h;
    public homePageTest(){
        super();
    }
    @BeforeMethod
    public void setup(){
        initializations();
        l = new loginPage();
        h=l.login(prop.getProperty("ruchitaUsername"), prop.getProperty("ruchitaPassword"));
    }

    @Test
    public void verifyHomePageTitleTest(){
        String actualTitle = h.verifyHomePageTitle();
        System.out.println(actualTitle);
        String expectedTitle = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
        Assert.assertEquals(expectedTitle,actualTitle,"Not matched");
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
