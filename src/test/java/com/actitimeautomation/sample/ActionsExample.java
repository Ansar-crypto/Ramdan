package com.actitimeautomation.sample;

import Common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class ActionsExample extends BaseClass {
    static WebDriver driver;

    public ActionsExample()
    {
        launchbrowser("chrome");
        driver=super.driver;
    }
    public static void main (String [] args){
        new ActionsExample();
        driver.get("https://online.actitime.com/autosoft/timetrack/enter.do");
        Actions actions=new Actions(driver);

        actions.sendKeys(driver.findElement(By.id("username")),"Ansar1@yopmail.com").build().perform();
        actions.sendKeys(driver.findElement(By.name("pwd")),"Indian").build().perform();
        actions.click(driver.findElement(By.xpath("//a[@id='loginButton']//div"))).build().perform();
    }
}
