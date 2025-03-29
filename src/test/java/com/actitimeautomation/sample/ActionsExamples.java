package com.actitimeautomation.sample;

import Common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsExamples extends BaseClass {
    static WebDriver driver;
    public ActionsExamples(){
        launchbrowser("chrome");
        driver=super.driver;
    }
    public static void main (String [] args) throws InterruptedException {
        new ActionsExamples();
        driver.get("https://online.actitime.com/autosoft/timetrack/enter.do");
        //put the UN credential
        Actions actions=new Actions(driver);
        actions.sendKeys(driver.findElement(By.id("username")),"Ansar1@yopmail.com").build().perform();
        actions.sendKeys(driver.findElement(By.name("pwd")),"Indian").build().perform();
        actions.click(driver.findElement(By.xpath("//a[@id='loginButton']//div"))).build().perform();
        // Wait for 5 sec
        Thread.sleep(5000);
        //go to task
        actions.click(driver.findElement(By.xpath("//div[@id='container_tasks']/following::div[1]"))).build().perform();
        //Wait for 5 sec
        Thread.sleep(5000);
        //scroll down till the Galaxy Corporation Project
        //actions.scrollToElement(driver.findElement(By.linkText("Galaxy Corporation"))).click(driver.findElement(By.name("Galaxy Corporation"))).build().perform();
        //actions.scrollToElement(driver.findElement(By.name("Galaxy Corporation"))).click(driver.findElement(By.name("Galaxy Corporation"))).build().perform();
        actions.scrollToElement(driver.findElement(By.xpath("//div[text()='Galaxy Corporation'and@class='text']"))).click(driver.findElement(By.xpath("//div[text()='Galaxy Corporation'and@class='text']"))).build().perform();
    }
}
