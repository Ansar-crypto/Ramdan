package com.actitimeautomation.sample;

import Common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LoginPage;

import java.util.List;

public class GetAndInsertAllCustomerInExcel extends BaseClass {
    static WebDriver driver;
    public GetAndInsertAllCustomerInExcel(){
        launchbrowser("chrome");
        driver=super.driver;
    }
    public static void main (String [] args) throws Exception {
       new GetAndInsertAllCustomerInExcel();
       driver.get("https://online.actitime.com/autosoft/timetrack/enter.do");
       LoginPage loginPage=new LoginPage(driver);
       loginPage.login("ansar1@yopmail.com","Indian");
       Thread.sleep(5000);
       driver.findElement(By.xpath("//div[@id='container_tasks']/following::div[1]")).click();
       Thread.sleep(5000);
       //get all customer
        List< WebElement> allCustomers =driver.findElements(By.xpath("//div[contains(@class,'customerNode')]//div[@class='text']"));
       System.out.println(allCustomers.size());
       Object[][] data=new Object[allCustomers.size()][1];
       for (int i=0;i<=allCustomers.size()-1;i++){
           String customerName=allCustomers.get(i).getText();
           //System.out.println();
           data[i][0]=customerName;
       }
       ExcelHandling excelHandling=new ExcelHandling();
       String filepath="E:/XL selenium/Test.xlsx";
       excelHandling.writeExcelData(filepath,"customerData");
       driver.quit();
    }
}
