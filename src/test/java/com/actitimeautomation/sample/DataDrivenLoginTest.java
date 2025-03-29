package com.actitimeautomation.sample;

import Common.BaseClass;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import java.io.IOException;

public class DataDrivenLoginTest extends BaseClass {
    static WebDriver driver;
    public DataDrivenLoginTest(){
        launchbrowser("chrome");
        driver=super.driver;
    }
    public static void main (String [] args) throws IOException, InterruptedException {
        new DataDrivenLoginTest();
        driver.navigate().to("https://online.actitime.com/autosoft/timetrack/enter.do");
        LoginPage loginPage=new LoginPage(driver);

        ExcelHandling excelHandling=new ExcelHandling();
        String filepath="E:/XL selenium/Test.xlsx";
       Object[][] excelData=excelHandling.getExcelData(filepath,"Test");
       for (int i=0;i<=excelData.length-1;i++){
          String username=excelData[i][0].toString();
           String password=excelData[i][1].toString();
           loginPage.login(username,password);
           Thread.sleep(5000);
       }
    }
}
