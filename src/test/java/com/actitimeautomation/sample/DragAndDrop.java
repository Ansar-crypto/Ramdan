package com.actitimeautomation.sample;

import Common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop extends BaseClass {
    static WebDriver driver;
    public DragAndDrop(){
        launchbrowser("chrome");
        driver=super.driver;
    }
    public static void main (String [] args) throws InterruptedException {
        new DragAndDrop();
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/#google_vignette");
        Thread.sleep(5000);
        String windowID=driver.getWindowHandle();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));

        WebElement sourceElement=driver.findElement(By.xpath("//ul[@id='gallery']/descendant::img[1]"));
        WebElement destElement=driver.findElement(By.id("trash"));
        //create an object of Actions class
        Actions actions=new Actions(driver);
        actions.dragAndDrop(sourceElement,destElement).build().perform();
        driver.switchTo().window(windowID);
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
