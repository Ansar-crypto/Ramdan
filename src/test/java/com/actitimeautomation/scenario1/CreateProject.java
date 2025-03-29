package com.actitimeautomation.scenario1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateProject {
    WebDriver driver;
    public CreateProject(WebDriver driver)
    {   this.driver=driver;
    }
    public void testproject(String projectname) throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='title ellipsis']")).click();
        driver.findElement(By.xpath("//div[text()='+ New Project']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='sectionDetails']/input")).click();
        driver.findElement(By.xpath("//div[@class='sectionDetails']/input")).sendKeys(projectname);
        driver.findElement(By.xpath("//table[@class='createTasksTable hideAddToTT']/descendant::input[2]")).click();
        driver.findElement(By.xpath("//table[@class='createTasksTable hideAddToTT']/descendant::input[2]")).sendKeys("PF holders");
        driver.findElement(By.xpath("//div[text()='Create Project']")).click();
    }
}