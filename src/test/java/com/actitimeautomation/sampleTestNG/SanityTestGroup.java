package com.actitimeautomation.sampleTestNG;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SanityTestGroup {
    @BeforeGroups(groups={"regression","sanity"})
    public void beforeGroup(){
        System.out.println("This is before group sanity method");
    }
    @AfterGroups(groups = "sanity")
    public void afterGroup(){
        System.out.println("This is after group sanity method");
    }
    @Test(groups = "sanity")
    public void sanityTest1(){
        System.out.println("This is sanity test1");
    }
    @Parameters({"browser","username","password"})
    @Test(groups = "sanity")
    public void sanityTest2(String browser,String username,String password){
        System.out.println("This is sanity test2");
        System.out.println(browser);
        System.out.println(username);
        System.out.println(password);
    }
    @Test(groups = "sanity")
    public void sanityTest3(){
        System.out.println("This is sanity Test3");
    }
    @Test(groups = "sanity")
    public void sanityTest4(){
        System.out.println("This is sanity Test4");
    }
    @Test(groups = {"regression","sanity"})
    public void sanityTest5(){
        System.out.println("This is sanity Test5");
    }


}
