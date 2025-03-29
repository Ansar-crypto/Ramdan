package pages;

import Common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class CustomerPage1 extends BaseClass {
    WebDriver driver;


    public CustomerPage1(WebDriver driver){
        this.driver=driver;
        launchBrowser("firefox");
    }
    public By taskModule=By.xpath("//div[text()='Tasks']");
    public By addNewButton=By.xpath("//div[@class='title ellipsis']");
    public By navigateToNewCustomer= By.xpath("//div[@class='item createNewCustomer']");
    public By enterCustName=By.xpath("//div[@id='customerLightBox']/descendant::input[1]");
    public By createCustomer=By.xpath("//div[@class='components_button withPlusIcon']/descendant::div[1]");

    public By searchText=By.xpath("//div[@class='searchAndExportContainer']//input");

    public void createCustomer(String customerName) throws InterruptedException {
        driver.findElement(taskModule).click();
        Thread.sleep(5000);
        driver.findElement(addNewButton).click();
        driver.findElement(navigateToNewCustomer).click();
        Thread.sleep(5000);
        driver.findElement(enterCustName).sendKeys(customerName);
        Thread.sleep(5000);
        driver.findElement(createCustomer).click();
    }
    public void verifyCustomer(String customerName){
        driver.findElement(searchText).sendKeys(customerName);
        System.out.println(customerName);
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals("cyber success",customerName,"Expected customer not found");
    }
}