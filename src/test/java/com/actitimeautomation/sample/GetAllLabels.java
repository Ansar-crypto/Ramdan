package com.actitimeautomation.sample;

import Common.BaseClass;
import Common.CommonUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class GetAllLabels extends BaseClass {
    WebDriver driver;

    CommonUtil commonUtil;

    @BeforeClass
    public void GetAllLabel() {
        launchbrowser("chrome");
        driver = super.driver;
        driver.navigate().to("https://www.amazon.in");
        commonUtil = new CommonUtil(driver);
    }

    @Test
    public void labels() {
            commonUtil.waitForAllElementToVisible(By.tagName("input"));
            //get all label elements
            List<WebElement> labelList = driver.findElements(By.tagName("input"));
            System.out.println(labelList.size());
            //iterate through each element label
            for (WebElement element : labelList) {
                String label = element.getAttribute("placeholder");
                if (label != null && !label.isBlank()) {
                    System.out.println(label);
                }
            }
            driver.quit();
        }
    }