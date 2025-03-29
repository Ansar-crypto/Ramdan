package com.actitimeautomation.framework;

import Common.BaseClass;
import Common.CommonUtil;
import Common.PropertyHandling;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CustomerPage1;
import pages.LoginPage;
import pages.ProjectPage;
import pages.ProjectPage1;

import java.io.IOException;

public class ProjectTest1 extends BaseClass {
    WebDriver driver;

    PropertyHandling propertyHandling;

    ProjectPage1 projectPage1;

    CustomerPage1 customerPage1;

    CommonUtil commonUtil;

    @BeforeClass
    public void setup() throws IOException, InterruptedException {
        propertyHandling=new PropertyHandling(driver);
        String browser= propertyHandling.getProperty("browser");
        launchbrowser(browser);
        driver=super.driver;
        driver.get(propertyHandling.getProperty("actitimeUrl"));
        LoginPage loginPage=new LoginPage(driver);
        String username=propertyHandling.getProperty("username");
        String password=propertyHandling.getProperty("password");
        loginPage.login(username,password);
        driver.manage().window().maximize();
        Thread.sleep(5000);
        projectPage1=new ProjectPage1(driver);
        Thread.sleep(5000);
        customerPage1=new CustomerPage1(driver);
    }
    @Test
    public void createCustomer() throws InterruptedException {
        Thread.sleep(5000);
        customerPage1.createCustomer("my customer");
        Thread.sleep(5000);
    }
    @Test
    public void verifyProject() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(customerPage1.taskModule).click();
        Thread.sleep(5000);
        driver.findElement(customerPage1.addNewButton).click();
        Thread.sleep(5000);
        projectPage1.createProject("my project");
    }
    @Test
    public void verifyTask() throws InterruptedException {
        Thread.sleep(5000);
        projectPage1.createTask("my Task");
    }
}
