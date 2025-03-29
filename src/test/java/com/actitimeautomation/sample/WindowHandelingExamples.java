package com.actitimeautomation.sample;

import Common.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WindowHandelingExamples extends BaseClass {
static WebDriver driver;
@BeforeClass
public void WindowHandelingExample(){
    launchbrowser("chrome");
    driver=super.driver;
}
@Test
        public void windowHandle()
//public static void main (String[]args)
{
   new WindowHandelingExamples();
   driver.manage().window().maximize();
    driver.get("https://online.actitime.com/autosoft/timetrack/enter.do");
    //get the id of current page
       String parentTabID=driver.getWindowHandle();
    //open new tab
    driver.switchTo().newWindow(WindowType.WINDOW);
    //navigate to redbus
    driver.navigate().to("https://bmw.in");
    //print title of current page
    System.out.println(driver.getTitle());
    //print url of current page
    //String url=driver.getCurrentUrl();
    System.out.println(driver.getCurrentUrl());
    //close current page
    driver.close();
    //switch control to default page
    driver.switchTo().window(parentTabID);
    //print parent page title
    System.out.println(driver.getTitle());
    //get url of current page
    //String url2=driver.getCurrentUrl();
    System.out.println(driver.getCurrentUrl());
    //close the program
    driver.close();
}
}