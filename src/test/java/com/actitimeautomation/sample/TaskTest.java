package com.actitimeautomation.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class TaskTest {
    public static void main(String[] args) throws InterruptedException {
        //launch browser
        WebDriver driver = new ChromeDriver();
        //Nevigate to Website
        driver.get("https://online.actitime.com/autosoft/timetrack/enter.do");
        //Create object for login method
        LoginPage loginPage=new LoginPage(driver);
        //Call login method
        loginPage.login("ansar1@yopmail.com","Indian");
        //Wait for 5 sec
        Thread.sleep(5000);
        //Click on Task Module
        driver.findElement(By.xpath("//div[@id='container_tasks']/following::div[1]")).click();
        //Wait for 5 sec
        Thread.sleep(5000);
        //locate select all check box and verify it is displayed
        boolean selectAllCheckbox=driver.findElement(By.xpath("//tr[@class='headers']/td/div/div")).isDisplayed();
        if (selectAllCheckbox){
            //Click on select all checkbox
            driver.findElement(By.xpath("//tr[@class='headers']/td/div/div")).click();
            //Wait for 5 sec
            Thread.sleep(5000);
            //verify checkbox is selected or not

        }
    }
}