package com.actitimeautomation.scenario1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateCustomer {
    WebDriver driver;

    public CreateCustomer(WebDriver driver)  {
        this.driver= driver;
    }
        public void custCreate(String epfoIndia) throws InterruptedException {
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
        }
    }


