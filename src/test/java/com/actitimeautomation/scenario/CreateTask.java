package com.actitimeautomation.scenario;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateTask {
    WebDriver driver;
    public CreateTask(WebDriver driver){
        this.driver= driver;
    }
    public void testTask(String taskname){
        driver.findElement(By.xpath("//table[@class='createTasksTable hideAddToTT']/descendant::input[2]")).sendKeys(taskname);
        driver.findElement(By.xpath("//div[text()='Create Project']")).click();
    }
}
