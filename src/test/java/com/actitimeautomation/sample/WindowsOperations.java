package com.actitimeautomation.sample;

import Common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowsOperations extends BaseClass {
   WebDriver driver;
    @BeforeClass
    public void setup(){
        launchbrowser("chrome");
        driver=super.driver;
    }
    @Test
        public void verifyWindowHandling()
    {
        //new WindowsOperations();
        //nevigate to website
        driver.get("https://online.actitime.com/autosoft/timetrack/enter.do");
        driver.findElement(By.xpath("//td[@id='copyRight']//a")).click();
        String parentWindowID=driver.getWindowHandle();
        System.out.println(parentWindowID);

        Set<String> allWindowIDs=driver.getWindowHandles();
        System.out.println(allWindowIDs);
        //iterate through all ids
        for (String id:allWindowIDs){
            //check if id is not equal to parent id
            if (!id.equals(parentWindowID)){
                System.out.println(" Second tab ID " + id);
                //switch to second window
                driver.switchTo().window(id);
                //print the title
                String chiledWindowTitle=driver.getTitle();
                System.out.println(chiledWindowTitle);
                //close second tab
                driver.close();
                break;
            }
        }
        driver.switchTo().window(parentWindowID);
        System.out.println("Parent window id"+driver.getTitle());

    }
    @AfterClass
    public void teamDown(){
        driver.quit();
}
}
