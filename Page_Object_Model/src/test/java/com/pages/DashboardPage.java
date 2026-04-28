package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
	WebDriver driver;
	By dashboardTitle = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	public String getHomepageText() {
		return driver.findElement(dashboardTitle).getText();
	}
}
