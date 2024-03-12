package bw_baseClass;

import bw_utility.utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {
    public static WebDriver driver;
    public static Properties prop;
    public base(){
        try{
            prop = new Properties();
            FileInputStream ip = new FileInputStream("D:\\Quality Kiosk SDET\\Application Interface & E2E QA\\" +
                    "bookswagon\\src\\main\\java\\bw_configProperties\\config.properties");
            prop.load(ip);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void initializations(){
        String browserName = prop.getProperty("browser");
        if(browserName.equals("chrome")){
            driver = new ChromeDriver();
        }else if(browserName.equals("FF")){
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(utility.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(utility.IMPLICIT_WAIT,TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }
}
