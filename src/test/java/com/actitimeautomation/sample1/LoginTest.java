package com.actitimeautomation.sample1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.get("https://online.actitime.com/autosoft/login.do");
        driver.manage().window().maximize();
        driver.findElement(By.id("username")).sendKeys("ansar1@yopmail.com");
        driver.findElement(By.name("pwd")).sendKeys("ndian");
        driver.findElement(By.xpath("//a[@id='loginButton']/div")).click();
        //wait for 5 sec
        Thread.sleep(5000);
        //get error msg
        String errorMsg1 = driver.findElement(By.xpath("//span[starts-with(text(),'Username or Password')]")).getText();
        if (errorMsg1.equals("Username or Password is invalid. Please try again.")) {
            System.out.println("Succesfully error message recieved");
        } else {
            throw new Exception("Actual and expected error msg not matched");
        }

        driver.findElement(By.name("pwd")).sendKeys("ndian");
        driver.findElement(By.xpath("//a[@id='loginButton']/div")).click();
        //wait for 5 sec
        Thread.sleep(5000);
        //get error msg
        if (driver.findElement(By.xpath("//span[starts-with(text(),'Username or Password')]")).isDisplayed()) {
            String errorMsg2 = driver.findElement(By.xpath("//span[starts-with(text(),'Username or Password')]")).getText();
            if (errorMsg2.equals("Username or Password is invalid. Please try again.")) {
                System.out.println("Succesfully error message recieved");
            } else {
                throw new Exception("Actual and expected error msg not matched");
            }
        }
    }
}