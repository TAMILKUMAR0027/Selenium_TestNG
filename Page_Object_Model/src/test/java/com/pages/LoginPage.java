package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
  WebDriver driver;
  By username=By.xpath("//input[@placeholder='Username']");
  By passowrd=By.xpath("//input[@placeholder='Password']");
  By loginBtn=By.xpath("//button[@type='submit']");
  By titleTxt=By.xpath("//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']");
  public LoginPage(WebDriver driver) {
	  this.driver=driver;
  }
  public void setUsername(String user) {
	  driver.findElement(username).sendKeys(user);
  }
  public void setpassword(String pass) {
	  driver.findElement(passowrd).sendKeys(pass);
	  }
  public void clickLogin() {
	  driver.findElement(loginBtn).click();
  }
  public String getLoginTitle() {
	  return driver.findElement(titleTxt).getText();
  }
  public void login(String user,String pass) {
	    this.setUsername(user);
	    this.setpassword(pass);
	    this.clickLogin();
	}
}
