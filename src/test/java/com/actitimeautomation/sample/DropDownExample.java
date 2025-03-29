package com.actitimeautomation.sample;

import Common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownExample extends BaseClass {
    static WebDriver driver;
    public DropDownExample(){
        launchbrowser("chrome");
        driver=super.driver;
    }
    public static void main (String [] args) throws Exception {
        new DropDownExample();
        driver.navigate().to("https://amazon.in");
        //create instance of search
       Select select=new Select (driver.findElement(By.id("searchDropdownBox")));
       System.out.println(select.isMultiple());
       //get all option of dropdown
       List<WebElement> valuelist=select.getOptions();
       System.out.println("Total value in dropdown is " + valuelist.size());
       for (WebElement element:valuelist){
       //get the text of value
         String value= element.getText();
         if (valuelist.equals("Music"));{
             select.selectByVisibleText(value);
             System.out.println(value);
             List<WebElement> selectedValues =select.getAllSelectedOptions();
             WebElement selectedVal =selectedValues.get(0);
             String val=selectedVal.getText();
             if (val.equals("music")){
                 System.out.println("Successfully selected music from dropdown");
             }
             else{
                 throw new Exception("Music value did not seleced from dropdown");
             }
             break;
           }
       }
       driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Harry Potter");
       //click on search i con
        driver.findElement(By.id("nav-search-submit-button")).click();
    }
}
