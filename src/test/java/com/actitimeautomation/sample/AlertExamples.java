package com.actitimeautomation.sample;

import Common.BaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class AlertExamples extends BaseClass {
    static WebDriver driver;
    public AlertExamples(){
        launchbrowser("chrome");
        driver=super.driver;
    }
    public static void main (String [] args) throws InterruptedException {
        new AlertExamples();
        driver.get("https://google.in");
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("prompt('This is an first alert !');");
        Thread.sleep(10000);
        Alert alert=driver.switchTo().alert();
        //enter the text
        alert.sendKeys("hello");
        //get the text of alert
        String text=alert.getText();
        System.out.println(text);
        //driver.findElement( By.xpath("//textarea[@data-ved='0ahUKEwjM7qKT0tiHAxUrj68BHfzILWcQ39UDCAc']")).sendKeys("India");
        //driver.findElement(By.xpath("//span[@class='QCzoEc z1asCe MZy1Rb']")).click();
    }
}
