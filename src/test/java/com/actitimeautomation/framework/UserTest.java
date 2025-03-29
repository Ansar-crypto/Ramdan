package com.actitimeautomation.framework;

import Common.BaseClass;
import Common.PropertyHandling;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.UserPage;

import java.awt.*;
import java.io.IOException;

public class UserTest extends BaseClass {
    WebDriver driver;

    PropertyHandling propertyHandling;

    UserPage userPage;
    @BeforeClass
    public void setup() throws IOException, InterruptedException {
        propertyHandling=new PropertyHandling(driver);
        String browser=propertyHandling.getProperty("browser");
        launchbrowser(browser);
        driver=super.driver;
        driver.get(propertyHandling.getProperty("actitimeUrl"));
        LoginPage loginPage=new LoginPage(driver);
        String username= propertyHandling.getProperty("username");
        String password= propertyHandling.getProperty("password");
        loginPage.login(username,password);
        driver.manage().window().maximize();
        Thread.sleep(5000);
        userPage=new UserPage(driver);
    }
    @DataProvider
    public Object[][] getTestData(){
        Object[][]obj=new Object[][]
                {
                        {"Ansar","Shaikh","ansar2@yopmail.com","Ansar"}
                };
        return obj;
    }
    @Test(priority = 1,dataProvider = "getTestData")
    public void userFirstName(Object first1,Object last1,Object mail1,Object delit) throws InterruptedException {
        userPage.setFirstName(first1.toString());
        Thread.sleep(5000);
    }
    @Test(priority = 2,dataProvider = "getTestData")
    public void userLastName(Object first1,Object last1,Object mail1,Object delit) throws InterruptedException {
        userPage.setLastName(last1.toString());
        Thread.sleep(5000);
    }
    @Test(priority = 3,dataProvider = "getTestData")
    public void userMailID(Object first1,Object last1,Object mail1,Object delit) throws InterruptedException {
        userPage.setMailId(mail1.toString());
        Thread.sleep(5000);
    }
    @Test(priority = 4,dataProvider = "getTestData")
    public void delitUse(Object first1,Object last1,Object mail1,Object delit) throws InterruptedException, AWTException {
        userPage.delitUser(delit.toString());
    }
}
