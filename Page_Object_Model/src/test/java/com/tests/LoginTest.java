package com.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.LoginPage;

public class LoginTest extends BaseTest {
	LoginPage lp;
  @Test
  public void login() {
	
	  LoginPage lp = new LoginPage(getDriver());
	  String loginpageTitle=lp.getLoginTitle();
	  Assert.assertTrue(loginpageTitle.contains("Login"));  }
}
