package com.actitimeautomation.sampleTestNG;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RegressionTest {

    @BeforeGroups(groups={"regression","sanity"})
    public void beforeGroup(){
        System.out.println("This is before group regression method");
    }
    @AfterGroups(groups = "regression")
    public void afterGroup(){
        System.out.println("This is after group regression method");
    }
    @Parameters({"browser","username","password"})
    @Test(groups = "regression")
    public void regression1(String browser,String username,String password){
        System.out.println("This is regression test1");
        System.out.println(browser);
        System.out.println(username);
        System.out.println(password);
    }
    @Test(groups = "regression")
    public void regression2(){
        System.out.println("This is regression test2");
    }
    @Test(groups = "regression")
    public void regression3(){
        System.out.println("This is regression Test3");
    }
    @Test(groups = "regression")
    public void regression4(){
        System.out.println("This is regression Test4");
    }
    @Test(groups = {"regression","sanity"})
    public void regression5(){
        System.out.println("This is regression Test5");

    }
}