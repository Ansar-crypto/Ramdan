package com.actitimeautomation.sample;

import Common.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.LoginPage;

import java.awt.*;

public class KeyBoardExamples extends BaseClass {
    static WebDriver driver;
   public KeyBoardExamples(){
       launchbrowser("chrome");
       driver=super.driver;
   }
   public static void main (String [] args) throws AWTException, InterruptedException {
       new KeyBoardExamples();
       Thread.sleep(5000);
       driver.get("https://online.actitime.com/autosoft/timetrack/enter.do");
       LoginPage loginPage=new LoginPage(driver);
       loginPage.login("Ansar1@yopmail.com","Indian");
       //wait for 5 sec
       Thread.sleep(5000);
       driver.manage().window().maximize();
       Actions actions=new Actions(driver);
       actions.keyDown(Keys.ENTER).build().perform();
       actions.keyUp(Keys.ENTER).build().perform();
      /* Robot robot =new Robot();
       robot.mouseMove(500,500);
      // mouse left button press
       robot.mousePress(KeyEvent.VK_LEFT);
       robot.mouseRelease(KeyEvent.VK_LEFT);
       robot.keyPress(KeyEvent.VK_ENTER);
       robot.keyRelease(KeyEvent.VK_ENTER);
       //press control+Plus button at a time
       robot.keyPress(KeyEvent.VK_CONTROL);
       robot.keyPress(KeyEvent.VK_PLUS);
       robot.keyPress(KeyEvent.VK_PLUS);
       robot.keyRelease(KeyEvent.VK_PLUS);
       robot.keyRelease(KeyEvent.VK_CONTROL);

       robot.mouseWheel(600);
       robot.mouseWheel(-600);*/
   }
}
