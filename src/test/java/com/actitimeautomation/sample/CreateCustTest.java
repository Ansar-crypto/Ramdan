package com.actitimeautomation.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class CreateCustTest {
    public static void main(String[]args) throws InterruptedException {  // Launch Browser
        WebDriver driver=new ChromeDriver();
        //nevigate to link
        driver.get("https://online.actitime.com/autosoft/tasks/tasklist.do");
        //Create Object for login class
        LoginPage loginPage=new LoginPage(driver);
        //Call login page
        loginPage.login("ansar1@yopmail.com","Indian");
        //Wait for 5 sec
        Thread.sleep(5000);
        //nevigate to add new button
        driver.findElement(By.xpath("//div[text()='Add New']")).click();
        //nevigate to create new customer
        driver.findElement(By.xpath("//div[@class='item createNewCustomer']")).click();
        //wait for 5 sec
        Thread.sleep(5000);
        //print customers name
        driver.findElement(By.xpath("//input[@class='inputFieldWithPlaceholder newNameField inputNameField']")).sendKeys("Infosys");
        //Print customer Description
        driver.findElement(By.xpath("//textarea[@placeholder='Enter Customer Description']")).sendKeys("Software Company");
        //Create customer
        driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
        //nevigate to create new customer
        driver.findElement(By.xpath("//div[text()='Add New']")).click();
        //wait for 5 sec
        Thread.sleep(5000);
        //nevigate to create new project
        driver.findElement(By.xpath("//div[@class='item createNewProject']")).click();
        //wait for 5 sec
        Thread.sleep(5000);
        //Print project name
        driver.findElement(By.xpath("//input[@class='projectNameField inputFieldWithPlaceholder inputNameField']")).sendKeys("Indian Nationality data collection");
        //wait for 5 sec
        Thread.sleep(5000);
        //close window
        driver.findElement(By.xpath("//div[@id='closeProjectLightBoxBtn']")).click();
        //wait for 5 sec
        Thread.sleep(5000);
        //create project click
       // driver.findElement(By.xpath("//div[text()='Create Project']")).click();
        //nevigate to add new button
        driver.findElement(By.xpath("//div[text()='Add New']")).click();
        //wait for 5 sec
        Thread.sleep(5000);
        //Click new task button
        driver.findElement(By.xpath("//div[@class='item createNewTasks']")).click();
        //wait for 5 sec
        Thread.sleep(5000);
        //Print new task name
        driver.findElement(By.xpath("//thead[@class='createTasksTableHead']//input")).sendKeys("Statewise identity");

    }
}
