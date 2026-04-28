package com.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.DashboardPage;
import com.pages.LoginPage;
import com.utilities.data;

public class DashboardTest extends BaseTest {

    @Test(dataProvider = "ValidData", dataProviderClass = data.class)
    public void Dashboardpage(String username, String password) {

        LoginPage lp = new LoginPage(getDriver());
        lp.login(username, password);

        DashboardPage dp = new DashboardPage(getDriver());

        Assert.assertTrue(dp.getHomepageText().contains("Dashboard"));
    }

    @Test(dataProvider = "InvalidData", dataProviderClass = data.class)
    public void invalidLogin(String username, String password) {

        LoginPage lp = new LoginPage(getDriver());
        lp.login(username, password);

        String credit = getDriver()
                .findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"))
                .getText();

        Assert.assertTrue(credit.contains("Invalid credentials"));    }
}