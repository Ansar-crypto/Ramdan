package com.actitimeautomation.sampleTestNG;

import org.testng.annotations.*;

public class TestNGAnnotations {
    {
        System.out.println("This is an instatnce block of annotation class");
    }
    public TestNGAnnotations()
    {
        System.out.println("This is an Constructor of annotation class");
    }
    @BeforeClass
            public void beforClass()
    {
        System.out.println("This is an before class");
    }
    @AfterClass
    public void afterClass()
    {
        System.out.println("This is an After class");
    }
    @BeforeMethod
    public void beforMethod()
    {
        System.out.println("This is an Before method");
    }
    @AfterMethod
            public void afterMethod()
    {
        System.out.println("This is an After method");
    }
    @Test
    public void test1()
    {
        System.out.println("This is an Test1 method from Test1 Annotation");
    }
    @Test
    public void test2()
    {
        System.out.println("This is an Test2 method from Test2 Annotation");
    }
    @Test
    public void test3()
    {
        System.out.println("This is an Test3 method from Test3 Annotation");
    }
}