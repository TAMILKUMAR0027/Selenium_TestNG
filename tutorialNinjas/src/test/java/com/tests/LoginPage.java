// LoginPage.java
package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver d;

    public LoginPage(WebDriver d) {
        this.d = d;
    }

    WebElement myAccount = d.findElement(By.xpath("//span[normalize-space()='My Account']"));
    WebElement loginLink = d.findElement(By.xpath("//a[normalize-space()='Login']"));
    WebElement emailBox = d.findElement(By.id("input-email"));
    WebElement passwordBox = d.findElement(By.id("input-password"));
    WebElement loginButton = d.findElement(By.xpath("//input[@value='Login']"));

    public void login(String email, String password) {
        myAccount.click();
        loginLink.click();
        emailBox.sendKeys(email);
        passwordBox.sendKeys(password);
        loginButton.click();
    }
    
	public void Invalid_login(String email, String password) {
		// TODO Auto-generated method stub
		myAccount.click();
        loginLink.click();
        emailBox.sendKeys(email);
        passwordBox.sendKeys(password);
        loginButton.click();
	}
}