// DashboardTests.java
package com.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(DemoListener.class)
public class DashboardTests extends BaseTest {

    @Test(priority = 1)
    public void loginTest() {

        LoginPage lp = new LoginPage(d);
        lp.login("tamilkumar@gmail.com", "Kiot1234");

        String title = d.getTitle();

        Assert.assertTrue(title.contains("Account") || title.contains("My Account"));
    }
}