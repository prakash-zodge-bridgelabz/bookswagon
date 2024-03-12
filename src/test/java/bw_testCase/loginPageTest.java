package bw_testCase;

import bw_baseClass.base;
import bw_pages.homePage;
import bw_pages.loginPage;
import bw_utility.utility;
//import org.junit.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
    public void multipleUserLoginTest(String username, String password){
        System.out.println("Multiple user login method running...");
        loginPage l = new loginPage();
        h=l.multipleUserLogin(username,password);
//        h = l.multipleUserLogin(prop.getProperty("username"),prop.getProperty("password"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
