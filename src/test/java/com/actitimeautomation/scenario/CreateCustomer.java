package com.actitimeautomation.scenario;

import Common.BaseClass;
import pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateCustomer extends BaseClass {
   static WebDriver driver;
   public CreateCustomer(){
       launchbrowser("chrome");
       driver=super.driver;
   }
   public static void main (String [] args) throws InterruptedException {
       new CreateCustomer();
       driver.get("https://online.actitime.com/autosoft/timetrack/enter.do");
       //maximize the window
       driver.manage().window().maximize();
       //create object of login class
       LoginPage loginPage=new LoginPage(driver);
       //navigate to login page
       loginPage.login("ansar1@yopmail.com","Indian");
       //Wait for 5 sec
       Thread.sleep(5000);
       //Click on Task Module
       driver.findElement(By.xpath("//div[@id='container_tasks']/following::div[1]")).click();
       //Wait for 5 sec
       Thread.sleep(5000);
       //navigate to add new
       driver.findElement(By.xpath("//div[@class='title ellipsis']")).click();
       //nevigate to create new customer
       driver.findElement(By.xpath("//div[@class='item createNewCustomer']")).click();
       //wait for 5 sec
       Thread.sleep(5000);
       //print customers name
       driver.findElement(By.xpath("//input[@class='inputFieldWithPlaceholder newNameField inputNameField']")).sendKeys("EPFO India");
       //click on final add of customer
       driver.findElement(By.xpath("//div[@class='components_button withPlusIcon']/descendant::div[1]")).click();
       Thread.sleep(5000);
       CreateProject createProject=new CreateProject(driver);
       createProject.testproject("connectivity");
       Thread.sleep(5000);
       //call task method
       CreateTask createTask=new CreateTask(driver);
       createTask.testTask("task1");
   }
}
