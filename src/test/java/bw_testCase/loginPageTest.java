package bw_testCase;

import bw_baseClass.base;
import bw_pages.homePage;
import bw_pages.loginPage;
import bw_utility.utility;
//import org.junit.Test;
import org.testng.annotations.*;

//@Listeners(bw_listener.listeners.class)
public class loginPageTest extends base {
    loginPage l;
    homePage h;
    @DataProvider
    public Object[][] getLoginTestData(){
        Object[][] data = utility.getTestData("loginDetails");
        return data;
    }

    public loginPageTest(){
        super();
    }

    @BeforeMethod
    public void setup(){
        initializations();
        l = new loginPage();
    }

    @Test(dataProvider = "getLoginTestData", priority=1)
    public void multipleUserLoginTest(String username, String password) throws InterruptedException {
        System.out.println("Multiple user login method running...");
        loginPage l = new loginPage();
        h=l.multipleUserLogin(username,password);
    }

    @Test(priority = 2)
    public void singleUserLogin(){
        h = l.login(prop.getProperty("ruchitaUsername"), prop.getProperty("ruchitaPassword"));

    }

    String homePageTitle = "\n" +
            "\tOnline BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com ";

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
