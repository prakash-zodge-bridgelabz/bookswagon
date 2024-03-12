package bw_listener;

import bw_baseClass.base;
import bw_utility.utility;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class listeners extends base implements ITestListener{
    public void onTestStart(ITestResult result) {
        System.out.println(".....onTestStart...... "+ result.getName());
        extent.attachReporter(spark);
    }
    public void onTestSuccess(ITestResult result) {
        System.out.println(".....onTestSuccess...... "+ result.getName());
        ExtentTest extentTest = extent.createTest(result.getName());
        extentTest.pass("Test pass...");
        extent.flush();
    }
    public void onTestFailure(ITestResult result) {
        System.out.println(".....onTestFailure...... "+ result.getName());
        ExtentTest extentTest = extent.createTest(result.getName());
        extentTest.fail("Test fail....");

        String fTName = result.getMethod().getMethodName();
        utility u = new utility();
        try{
            u.failedTest(fTName);
        }catch (IOException e){
            e.printStackTrace();
        }
        extentTest.addScreenCaptureFromPath("D:\\Quality Kiosk SDET\\Application Interface & E2E QA\\bookswagon\\screenshots");

        extent.flush();
    }
    public void onTestSkipped(ITestResult result) {
        System.out.println(".....onTestSkipped...... "+ result.getName());
        ExtentTest extentTest = extent.createTest(result.getName());
        extentTest.skip("Test skipp....");
        extent.flush();
    }
}
