package com.actitimeautomation.scenario;

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


    }
}
