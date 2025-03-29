package com.actitimeautomation.framework;

import Common.BaseClass;
import Common.PropertyHandling;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CustomerPage;
import pages.LoginPage;
import pages.ProjectPage;

import java.io.IOException;

public class ProjectTest extends BaseClass {
    WebDriver driver;

    PropertyHandling propertyHandling;

    ProjectPage projectPage;

@BeforeClass
    public void setup() throws IOException {
    propertyHandling=new PropertyHandling(driver);
    String browser= propertyHandling.getProperty("browser");
    launchbrowser(browser);
    driver=super.driver;
    driver.get(propertyHandling.getProperty("actitimeUrl"));
    LoginPage loginPage=new LoginPage(driver);
    String username=propertyHandling.getProperty("username");
    String password=propertyHandling.getProperty("password");
    loginPage.login(username,password);
    projectPage=new ProjectPage(driver);
}
@DataProvider
public Object[][] getTestData()
{   Object[][] obj=new Object[][]
        {
                {"Training Project1","Basework1"}
        };
    return obj;
}
@Test(priority = 1,dataProvider = "getTestData")
    public void createProject(Object projectName,Object taskName) throws InterruptedException {
    projectPage.CreateProject(projectName.toString());
}
@Test(priority = 2,dataProvider = "getTestData")
    public void createTask(Object projectName,Object taskName) throws InterruptedException {
     projectPage.createTask(taskName.toString()); ;
    }
}
