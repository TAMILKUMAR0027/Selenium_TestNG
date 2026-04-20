package com.TestNG;

import org.testng.annotations.Test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class demoblaze {
	private static final ThreadLocal<WebDriver> d1=new ThreadLocal<WebDriver>();
  
    WebDriverWait wait;
    @Parameters({"browser" , "url"})
    @BeforeMethod
    public void beforeTest(String browser, String url) {
    	WebDriver d=d1.get();
    	
    	switch(browser) {
    
    	case "firefox":
    		
    		d=new ChromeDriver();
    		break;
    	case "chrome":
    		d=new ChromeDriver();
    		break;
    	
    	}

       
        d.manage().window().maximize();

        wait = new WebDriverWait(d, Duration.ofSeconds(15));

        d.get(url);
    }

    @Parameters({"username", "pass"})
    @Test(priority = 1)
    public void validation(String username, String pass) {
    	WebDriver d2=d1.get();

        d2.findElement(By.id("login2")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys(username);
        d2.findElement(By.id("loginpassword")).sendKeys(pass);

        d2.findElement(By.xpath("//button[text()='Log in']")).click();
    }

    @DataProvider(name="testData",parallel = true)
	public Object[][]dataprov(){
		return new Object[][] {{"Tamil","#$56"},{"Rishwanth","1234"}};
	}

    @Test(priority = 2, dataProvider = "testData")
    public void invalid_with_username(String username1, String pass1) throws Exception {
    	WebDriver d3=d1.get();
        d3.findElement(By.id("login2")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys(username1);
        d3.findElement(By.id("loginpassword")).sendKeys(pass1);

        d3.findElement(By.xpath("//button[text()='Log in']")).click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = d3.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        throw new Exception();
    }

   


    @AfterMethod
    public void afterTest() {
    	WebDriver d4=d1.get();
        d4.quit();
    }
}