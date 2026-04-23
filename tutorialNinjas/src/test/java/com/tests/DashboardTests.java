package com.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.tests.DemoListener.class)
public class DashboardTests extends BaseTest {

    LoginPage objLogin;
    DashboardPage objDashboardPage;

    @Test(priority = 1)
    public void DashboardTest() {

        objLogin = new LoginPage(driver);
        objLogin.login("Admin", "admin123");

        objDashboardPage = new DashboardPage(driver);

        Assert.assertTrue(
            objDashboardPage.getHomePageText().contains("Dashboard")
        );
    }
}