package com.actitimeautomation.sampleTestNG;

import org.testng.annotations.*;

public class TestAnnotation {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("this is before suite");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("this is after suite");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("this is before Test");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("this is After Test");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("this is before class");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("this is after class");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("this is before method");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("this is After method");
    }
    @Test(enabled = true)
    public void verifyLogin(){
        System.out.println("this is login method");
    }
    @Test(priority=1)
    public void login(){
        System.out.println("this is login method priority 1");
    }
    @Test(priority=2, dependsOnMethods="login")
    public void verifyTask() throws Exception {
        System.out.println("this is Verify task method");
        throw new Exception("this is new exception");
    }
    @Test(priority=3,dependsOnMethods={"login"},enabled = true)
    public void Logout(){
        System.out.println("this is login method priority 1");
    }

}
