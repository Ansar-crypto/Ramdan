package com.actitimeautomation.scenario1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewUser {
    WebDriver driver;
    public NewUser(WebDriver driver){
        this.driver=driver;
    }
    public void createUser(){
        //navigate to crete user
        driver.findElement(By.xpath("//div[@id='container_users']/following::div[1]")).click();
        driver.findElement(By.xpath("//div[@class='components_button withPlusIcon']/div[1]")).click();
        driver.findElement(By.id("createUserPanel_firstNameField")).sendKeys("Ansar");
        driver.findElement(By.id("createUserPanel_lastNameField")).sendKeys("Shaikh");
        driver.findElement(By.id("createUserPanel_emailField")).sendKeys("ansar1@yopmail.com");
    }
}
