package com.actitimeautomation.sampleTestNG;

import Common.BaseClass;
import com.actitimeautomation.sample.ExcelHandling;
import pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class DataProviderExample extends BaseClass {
    WebDriver driver;

    @BeforeClass(enabled = true)
    public void setup() {
        launchbrowser("chrome");
        driver = super.driver;
        driver.navigate().to("https://online.actitime.com/autosoft/timetrack/enter.do");
    }

    //@DataProvider
   // public Object[][] getTestData() {
    //    Object[][] obj = new Object[][]{
       //         {"username1", "password1"},
       //         {"username2", "password2"}
       // };
     //   return obj;
   // }

    @DataProvider
   public Object[][]getTestDataFromExcel() throws IOException {
        ExcelHandling excelHandling = new ExcelHandling();
        String filepath = "E:/XL selenium/Test.xlsx";
        Object[][] excelData = excelHandling.getExcelData(filepath, "sheet1");
        return excelData;
    }
    @Test(dataProvider = "getTestDataFromExcel")
    public void verifyLogin(Object username,Object password) throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login(username.toString(),password.toString());
        Thread.sleep(5000);
    }
   // @Test(dataProvider = "getSampleData",dataProviderClass = TestDataProvider.class)
  //  public void test(Object param1,Object param2,Object param3){
  //      System.out.println(param1+""+param2+""+param3);
  //  }
   }



