package com.actitimeautomation.sample;

import Common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptExample extends BaseClass {
    static WebDriver driver;

    public JavaScriptExample() {
        launchbrowser("chrome");
        driver=super.driver;
    }
    public static void main (String [] args) throws InterruptedException {

        new JavaScriptExample();
        driver.manage().window().maximize();
        //navigate to link
        driver.get("https://online.actitime.com/autosoft/timetrack/enter.do");
           //LoginPage loginPage=new LoginPage(driver);
            //loginPage.login("ansar1@yopmail.com","Indian");
        WebElement loginButton=driver.findElement(By.id("loginButton"));
        //type cast driver in to JavaScriptExcecuter
        JavascriptExecutor js=(JavascriptExecutor)driver;
        //enter text using javasript
        js.executeScript("argument[0].value='ansar1@yopmail.com';",driver.findElement(By.id("username")));
        js.executeScript("argument[0].value='Indian';",driver.findElement(By.id("pwd")));

       // driver.get("https://amazon.in");
       // js.executeScript("window.scrollBy(0,1000);");
       // Thread.sleep(3000);
       // js.executeScript("window.scrollBy(0,-500);");
       // Thread.sleep(3000);
       // js.executeScript("window.scrollBy(0,document.body.scrollHeight);");
       // Thread.sleep(3000);
        driver.quit();
    }
}
