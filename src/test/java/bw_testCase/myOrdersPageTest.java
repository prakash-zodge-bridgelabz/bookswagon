package bw_testCase;

import bw_baseClass.base;
import bw_pages.homePage;
import bw_pages.loginPage;
import bw_pages.myOrdersPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class myOrdersPageTest extends base {
    loginPage l;
    homePage h;
    myOrdersPage m;
    public myOrdersPageTest(){
        super();
    }
    @BeforeMethod
    public void setup(){
        initializations();
        l = new loginPage();
        h=l.login(prop.getProperty("ruchitaUsername"), prop.getProperty("ruchitaPassword"));
        m = new myOrdersPage();
    }
    @Test(priority=6)
    @Severity(SeverityLevel.BLOCKER)
    public void verifyMyOrdersPageHeadingTest(){
        m=h.clickOnMyOrders();
        String actualHeading = m.verifyMyOrdersPageHeading();
        String expectedHeading = "My Orders";
        Assert.assertEquals(actualHeading,expectedHeading,"Heading not matched");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
