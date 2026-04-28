package com.tests;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static Logger log=LogManager.getLogger(BaseTest.class);
    public WebDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod
    public void setup() {

        EdgeOptions opt = new EdgeOptions();

        WebDriver edriver = new EdgeDriver(opt);

        driver.set(edriver);

        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        log.info("Url is launched");
    }

    @AfterMethod
    public void tearDown() {

        getDriver().quit();
        driver.remove();
    }
}