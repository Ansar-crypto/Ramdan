package pages;

import Common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DepartmentPage extends BaseClass {
    WebDriver driver;

    public DepartmentPage(WebDriver driver){
    this.driver=driver;
    launchbrowser("chrome");
    }
    //click on user module
    public By userModule= By.xpath("//div[text()='Users']");
    //click on department
    public By department=By.xpath("//div[@class='importUsersMount']/following::div[3]");
    //click on new department text field....sendkeys
    public By departmentTextField=By.xpath("//input[@id='groupManagementLightBox_newGroupInput']");
    //click on create department
    public By createDepartment=By.xpath("//button[@id='groupManagementLightBox_addGroupButton']");

    public void createDept(String deptName) throws InterruptedException {

        driver.findElement(userModule).click();
        Thread.sleep(3000);
        driver.findElement(department).click();
        Thread.sleep(3000);
        driver.findElement(departmentTextField).sendKeys(deptName);
        Thread.sleep(3000);
        driver.findElement(createDepartment).click();
    }
}
