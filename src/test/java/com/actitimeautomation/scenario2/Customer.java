package com.actitimeautomation.scenario2;

import Common.CommonUtil;
import Common.BaseClass;
import pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Customer extends BaseClass {
    WebDriver driver;
    CommonUtil commonUtil;
    @BeforeClass
    public void setup() throws InterruptedException {
        launchbrowser("chrome");
        driver=super.driver;
        driver.get("https://online.actitime.com/autosoft1/timetrack/enter.do");
        CommonUtil commonUtil1= new CommonUtil(driver);
        this.commonUtil=commonUtil1;
        driver.manage().window().maximize();
    }
    @Test(priority = 1)
    public void loginVerify() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("ansar2@yopmail.com", "Indian");
        driver.findElement(By.xpath("//a[@id='loginButton']/div")).click();
    }

    @DataProvider
    public Object[][] getTestData() {
        Object[][] obj = new Object[][]{
               {"Ansar"}
                //,{"Aditya"}
                //,{"Ketan"},{"Tejas"},{"Muskan"}
        };
        return obj;
    }

    @Test(priority = 2, dataProvider = "getTestData")
    public void createCust(Object custName) throws InterruptedException {
        //fluent wait
        commonUtil.waitForElementToPresent(By.xpath("//div[text()='Tasks']"));
        //Thread.sleep(5000);
        driver.findElement(By.xpath("//div[text()='Tasks']")).click();
        //navigate to add new
        driver.findElement(By.xpath("//div[@class='title ellipsis']")).click();
        //nevigate to create new customer
        driver.findElement(By.xpath("//div[@class='item createNewCustomer']")).click();
        //fluent wait
        commonUtil.waitForElementToPresent(By.xpath("//input[@class='inputFieldWithPlaceholder newNameField inputNameField']"));
        //print customers name
        driver.findElement(By.xpath("//input[@class='inputFieldWithPlaceholder newNameField inputNameField']")).sendKeys(custName.toString());
        //fluent wait
        commonUtil.waitForElementToPresent(By.xpath("//div[@class='components_button withPlusIcon']/descendant::div[1]"));
        //click on final add of customer
        driver.findElement(By.xpath("//div[@class='components_button withPlusIcon']/descendant::div[1]")).click();
       // driver.findElement(By.xpath("//div[@class='searchAndExportContainer']//input")).click();
       // driver.findElement(By.xpath("//div[@class='searchAndExportContainer']//input")).sendKeys("Ansar1");
       // boolean name1 = driver.findElement(By.xpath("//div[text()='There are no customers or projects']")).isDisplayed();
        //if (name1 == false) {
        //    System.out.println("Customer name Ansar is present");
       // } else {
       //     System.out.println("Customer name Ansar is not present");
       // }
    }
            @Test(priority = 3,dataProvider = "getTestData")
                    public void verifyCustomer(Object custName) throws InterruptedException {
                driver.findElement(By.xpath("//div[@class='searchAndExportContainer']//input")).click();
                //fluent wait
                commonUtil.waitForElementToPresent(By.xpath("//div[@class='searchAndExportContainer']//input"));

                driver.findElement(By.xpath("//div[@class='searchAndExportContainer']//input")).sendKeys(custName.toString());
                boolean name1 = driver.findElement(By.xpath("//div[text()='There are no customers or projects']")).isDisplayed();
                if (name1 == false) {
                    System.out.println("Customer is present");
                } else {
                    System.out.println("Customer is not present");
                }
             }
             @Test(priority = 4,dataProvider ="getTestData" )
                public void delitCustomer(Object custName) throws InterruptedException {
                driver.findElement(By.xpath("//div[@class='searchAndExportContainer']//input")).click();
                 //fluent wait
                 commonUtil.waitForElementToPresent(By.xpath("//div[@class='searchAndExportContainer']//input"));
                driver.findElement(By.xpath("//div[@class='searchAndExportContainer']//input")).sendKeys(custName.toString());

                //boolean name2 = driver.findElement(By.xpath("//div[text()='There are no customers or projects']")).isDisplayed();
                 //if (name2 == false) {
                     //click on customer name
                     driver.findElement(By.xpath("//div[@class='filteredContainer']/descendant::div[@class='title']//span")).click();
                     //click on setting customer
                     driver.findElement(By.xpath("//div[@id='taskListBlock']/descendant::div[7]")).click();
                     WebElement element= driver.findElement(By.xpath("//div[@class='edit_customer_sliding_panel sliding_panel components_panelContainer']"));
                        JavascriptExecutor js=(JavascriptExecutor)driver;
                        js.executeScript("arguments[0].setAttribute('style','display:none)",element);
                     //click on action
                     driver.findElement(By.xpath("//div[@class='actionButtonWrapper pressed']/descendant::div[3]")).click();
                     //click on delit customer
                     driver.findElement(By.xpath("//div[@style='display: none; top: 148px; left: -1px;']/descendant::div[7]")).click();
                    //fluent wait
                     commonUtil.waitForElementToPresent(By.xpath("//span[text()='Warning: Customer deletion cannot be undone.']/following::span[2]"));
                     //click on confirmation to delit customer
                     driver.findElement(By.xpath("//span[text()='Warning: Customer deletion cannot be undone.']/following::span[2]")).click();

                     //finally to delit the customer
                     System.out.println("Customer is Deleted Succesfully");
                // } else {
                   //  System.out.println("Customer is not Delited Succesfully");
                // }
             }
        }
