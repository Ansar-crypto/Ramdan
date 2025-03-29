package com.actitimeautomation.framework;

import Common.BaseClass;
import Common.CommonUtil;
import Common.PropertyHandling;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CustomerPage;
import pages.LoginPage;

import java.io.IOException;

public class CustomerTest extends BaseClass {
    WebDriver driver;

    PropertyHandling propertyHandling;

    CustomerPage customerPage;

    @BeforeClass
    public void setup() throws IOException {
        propertyHandling = new PropertyHandling(driver);
       String browser= propertyHandling.getProperty("browser");
       launchBrowser(browser);
        driver=super.driver;
        driver.get(propertyHandling.getProperty("actitimeUrl"));
        LoginPage loginPage=new LoginPage(driver);
        String username=propertyHandling.getProperty("username");
        String password=propertyHandling.getProperty("password");
        loginPage.login(username,password);
        customerPage=new CustomerPage(driver);
    }
        @Test
    public void verifyCustomer() throws InterruptedException {
        customerPage.createCustomer("cyber success");
        customerPage.verifyCustomer("cyber success");
        }
        @Test
    public void verifyDelitCustomer() throws InterruptedException {
        customerPage.delitCustomer();
        }
}
