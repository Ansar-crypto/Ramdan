package com.actitimeautomation.sample;

import Common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class GetAllLinks extends BaseClass {
    static WebDriver driver;
    @BeforeClass
    public void GetAllLink(){
        launchbrowser("chrome");
        driver=super.driver;
    }
    @Test
            public void links()
    //public static void main (String [] args)
    {

        new GetAllLinks();
        driver.get("https://amazon.in");

       List<WebElement> tagElements=driver.findElements(By.tagName("a"));

       System.out.println(tagElements.size());
        driver.manage().window().maximize();
       for(WebElement element:tagElements){
           String link=element.getAttribute("href");
           System.out.println(link);
       }
       driver.quit();
    }

}
