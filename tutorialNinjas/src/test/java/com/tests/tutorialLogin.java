package com.tests;

import org.testng.annotations.Test;

import com.utilities.validData;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class tutorialLogin {
	private static final ThreadLocal<WebDriver> driver1 = new ThreadLocal<>();
	private static Logger log= LogManager.getLogger(tutorialLogin.class);
  @Test(dataProvider="validData",dataProviderClass=validData.class)
  public void valid_login(String username,String password) {
	  WebDriver d2=driver1.get();
	  d2.findElement(By.xpath("//span[@class='caret']")).click();
	  d2.findElement(By.xpath("//a[text()='Login']")).click();
	  d2.findElement(By.xpath("//input[@name='email']")).sendKeys(username);
	  d2.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	  d2.findElement(By.xpath("//input[@value='Login']")).click();
	  String expected="Edit your account information";
	  Assert.assertEquals(expected, d2.findElement(By.xpath("//a[text()='Edit your account information']")).getText());
	  log.info("Login sucessfull");
	  System.out.println("Login Successfull");
  }
  @Test(dataProvider="InvalidData",dataProviderClass=validData.class)
  public void Invalid_login(String username,String password) {
	  WebDriver d2=driver1.get();
	  d2.findElement(By.xpath("//span[@class='caret']")).click();
	  d2.findElement(By.xpath("//a[text()='Login']")).click();
	  d2.findElement(By.xpath("//input[@name='email']")).sendKeys(username);
	  d2.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	  d2.findElement(By.xpath("//input[@value='Login']")).click();
	 
	  String expected = "Warning: No match for E-Mail Address and/or Password.";
	  String actual = d2.findElement(By.xpath("//div[contains(@class,'alert-danger')]")).getText();
	  Assert.assertTrue(actual.contains(expected)); 
	  }
  @Parameters({"ValidKeyword"})
  @Test
  public void serachValid(String keyword) {
	  WebDriver d2 = driver1.get(); 
	   WebElement searchbar= d2.findElement(By.xpath("//input[@name='search']"));
	   searchbar.sendKeys(keyword);
	   searchbar.sendKeys(Keys.ENTER);
	   String expec="iMac";
	   try {
	   Assert.assertEquals(expec, d2.findElement(By.xpath("//a[text()='iMac']")).getText());
	   System.out.println("Seached Succesfully");
	   }catch (Exception e) {
		   System.out.println(e.getMessage());
		   log.error("Nothing is searched");
	   }
	    
  }
  @Parameters({"InValidKeyword"})
  @Test
  public void serach_InValid(String keyword) {
	  WebDriver d2 = driver1.get(); 
	   WebElement searchbar= d2.findElement(By.xpath("//input[@name='search']"));
	   searchbar.sendKeys(keyword);
	   searchbar.sendKeys(Keys.ENTER);
	   String expec="There is no product that matches the search criteria.";
	   try {
	   Assert.assertEquals(expec, d2.findElement(By.xpath("//p[text()='Tere is no product that matches the search criteria.']")).getText());
	   System.out.println("UnSeached Succesfully");
	   
	   }catch(Exception e) {
		   log.error("Aseertion is wrong");
	   }
  }
  @BeforeMethod
  public void beforeMethod() {
      driver1.set(new ChromeDriver());
      WebDriver d1 = driver1.get();
      d1.manage().window().maximize();
      d1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      log.info("Website launched");
      d1.get("https://tutorialsninja.com/demo/");
  }

  @AfterMethod
  public void afterMethod() {
      WebDriver d1=driver1.get();
      if(d1!=null) {
          d1.quit();  
      }
  }

}
