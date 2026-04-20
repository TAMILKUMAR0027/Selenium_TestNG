package com.TestNG;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviderDemo {
	WebDriver d;
	@DataProvider(name="testData")
	public Object[][]dataprov(){
		return new Object[][] {{"Tamil"},{"Jeeva"}};
	}
  @BeforeMethod
  public void setUp() {
	  System.out.println("Start test");
	  d=new ChromeDriver();
	  d.get("https://www.bing.com/");
	  d.manage().window().maximize();
  }
  @Test(dataProvider = "testData")
  public void search(String keyword) {
	 WebElement txt= d.findElement(By.id("sb_form_q"));
	 txt.sendKeys(keyword);
	  System.out.println(keyword);
	  txt.sendKeys(keyword);
	  System.out.println("Search result displayed");
  }
  @AfterMethod
  public void after() {
	  d.quit();
  }
}
