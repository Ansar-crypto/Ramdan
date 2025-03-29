package com.actitimeautomation.scenario1;

import Common.BaseClass;
import pages.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateUser extends BaseClass {
    @BeforeClass
    public void CreateUser() throws InterruptedException {
        launchbrowser("chrome");
        driver.get("https://online.actitime.com/autosoft/timetrack/enter.do");
        Thread.sleep(5000);
    }
        @Test
        public void loginActitime(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("Ansar1@yopmail.com","Indian");
    }


}

