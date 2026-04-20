package com.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class dataProviderDemo2 {
	private static final ThreadLocal<WebDriver> d1=new ThreadLocal<WebDriver>();
	  @Test
  @BeforeMethod
  public void setUp() {
	  System.out.println("Start test");
	  d1.set(new ChromeDriver());
  }
  @Test(dataProvider = "testData",dataProviderClass = DataProviderclass.class)
  public void search(String keyword)throws InterruptedException {
	WebDriver d2=d1.get();
	d2.get("https://www.bing.com/");
	WebElement txt=d2.findElement(By.id("sb_form_q"));
	txt.sendKeys(keyword);
	System.out.println(keyword);
	txt.sendKeys(Keys.ENTER);
  }
  @AfterMethod
  public void after() {
	  WebDriver d2=d1.get();
	  d2.quit();
  }
}
