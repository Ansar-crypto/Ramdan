package com.actitimeautomation.sample;

import Common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class TaskTest1 extends BaseClass {
    static WebDriver driver;

    public TaskTest1() {
        launchbrowser("chrome");
        driver = super.driver;
    }

    public static void main(String[] args) throws InterruptedException {
      new TaskTest1();
       // maximize the window
        driver.manage().window().maximize();
        //nevigate to link
        driver.get("https://online.actitime.com/autosoft/timetrack/enter.do");
        //wait for 5 sec
        Thread.sleep(5000);
        // create object
        LoginPage loginPage=new LoginPage(driver);
        //call login method
        loginPage.login("ansar1@yopmail.com","Indian");
        //wait for 5 sec
        Thread.sleep(5000);
       //click on task module
       driver.findElement(By.xpath("//div[@id='container_tasks']/following::div[1]")).click();
        //wait for 5 sec
        Thread.sleep(5000);
        //locate all check box and verify is displayed or not
        boolean selectAllcheckbox=driver.findElement(By.xpath("//tr[@class='headers']/descendant::div[2]")).isDisplayed();
        if (selectAllcheckbox) {
            driver.findElement(By.xpath("//tr[@class='headers']/descendant::div[2]")).click();
        }
        //wait for 5 sec
        Thread.sleep(5000);
        //verify checkbox is selected or not
       boolean isSelected= driver.findElement(By.xpath("//table[@class='taskRowsTable']/descendant::tr[1]//div[@class='img']")).isSelected();
        //wait for 5 sec
        Thread.sleep(5000);
       if (isSelected){
          System.out.println("All Checkbox are selected");
        } else{
           System.out.println("Unable select all checkbox");
        }
    }
}
