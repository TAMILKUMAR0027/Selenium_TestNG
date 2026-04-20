package com.TestNG;

import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class demo {

    private static final ThreadLocal<WebDriver> driver1 = new ThreadLocal<>();
    private static final ThreadLocal<WebDriverWait> wait1 = new ThreadLocal<>();

    public WebDriver getDriver() {
        return driver1.get();
    }

    public WebDriverWait getWait() {
        return wait1.get();
    }

    @Parameters({"browser","url"})
    @BeforeMethod
    public void beforeTest(String browser,String url) {

        switch (browser) {
            case "firefox":
                driver1.set(new FirefoxDriver());
                break;
            case "chrome":
                driver1.set(new ChromeDriver());
                break;
            case "edge":
                driver1.set(new EdgeDriver());
                break;
            default:
                throw new RuntimeException("Invalid browser");
        }

        getDriver().manage().window().maximize();
        wait1.set(new WebDriverWait(getDriver(),Duration.ofSeconds(15)));
        getDriver().get(url);
    }

    @Parameters({"email","password"})
    @Test(priority=1)
    public void validation(String email,String password) {

        getWait().until(ExpectedConditions.elementToBeClickable(By.id("login2"))).click();

        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys(email);
        getDriver().findElement(By.id("loginpassword")).sendKeys(password);

        getDriver().findElement(By.xpath("//button[text()='Log in']")).click();

        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
        String acp=getDriver().findElement(By.id("nameofuser")).getText();

        Assert.assertTrue(acp.contains("Welcome"));
    }

    @Test(priority=2,dataProvider="testData",dataProviderClass=dpcalss.class)
    public void invalid_with_username(String emails,String password) {

        getWait().until(ExpectedConditions.elementToBeClickable(By.id("login2"))).click();

        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys(emails);
        getDriver().findElement(By.id("loginpassword")).sendKeys(password);

        getDriver().findElement(By.xpath("//button[text()='Log in']")).click();

        getWait().until(ExpectedConditions.alertIsPresent());
        Alert alert=getDriver().switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }

    @AfterMethod
    public void afterTest() {
        if(getDriver()!=null){
            getDriver().quit();
            driver1.remove();
            wait1.remove();
            System.out.println("Test Done");
        }
    }
}