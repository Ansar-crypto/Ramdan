package com.actitimeautomation.scenario1;

import Common.BaseClass;
import pages.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MainExecution extends BaseClass {
    @BeforeClass
    public void setup() throws InterruptedException {
        launchbrowser("chrome");
        driver.get("https://online.actitime.com/autosoft/timetrack/enter.do");
        Thread.sleep(5000);
        driver.manage().window().maximize();
    }
    @Test
            public void loginVerify() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("ansar1@yopmail.com","Indian");
        Thread.sleep(5000);
    }
    @Test
    public void testCustomer() throws InterruptedException {
        CreateCustomer createCustomer=new CreateCustomer(driver);
        createCustomer.custCreate("EPFO India-1");
        Thread.sleep(5000);
    }
    @Test
    public void testProject() throws InterruptedException {
        CreateProject createProject=new CreateProject(driver);
        createProject.testproject("State Wise PF Holder List");
        Thread.sleep(5000);
    }
}
