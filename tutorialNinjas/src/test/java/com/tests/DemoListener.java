package com.tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class DemoListener implements ITestListener {

    public void onTestStart(ITestResult result) {
        System.out.println(result.getName() + " test started");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Test PASSED: " + result.getName());
    }

    public void onTestFailure(ITestResult result) {

        System.out.println("Test FAILED: " + result.getName());
        Object currentClass = result.getInstance();
        WebDriver driver = ((BaseTest) currentClass).d;
        takeScreenshot(driver, result.getName());
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("Test SKIPPED: " + result.getName());
    }
    public void takeScreenshot(WebDriver driver, String testName) {
        try {
        	
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = System.getProperty("user.dir") + "/screenshots/"
                    + testName + "_" + System.currentTimeMillis() + ".png";
            File dest = new File(path);
            FileUtils.copyFile(src, dest);
            System.out.println("Screenshot saved at: " + path);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}