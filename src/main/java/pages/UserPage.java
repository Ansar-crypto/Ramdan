package pages;

import Common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;

public class UserPage extends BaseClass {
    WebDriver driver;
    public UserPage(WebDriver driver){
        this.driver=driver;
        launchbrowser("chrome");
    }
    //click on user module
    public By userModule= By.xpath("//div[text()='Users']");
    //click on new user
    public By newUser=By.xpath("//div[text()='New User']");
    //click first name text field....sendkeys
    public By firstName=By.xpath("//input[@id='createUserPanel_firstNameField']");
    //click on last name text field ....sendkeys
    public By lastName=By.xpath("//input[@id='createUserPanel_lastNameField']");
    //click on email text field....sendkeys
    public By mailId=By.xpath("//input[@id='createUserPanel_emailField']");
    //click on dropdown
    public By dropDown=By.xpath("//div[@id='createUserPanel_accessBoxRow']/following::div[9]");
    //select quality department
    public By qaDept=By.xpath("//div[@id='createUserPanel_accessToOtherProductSelectorPlaceholder']/following::div[21]");
    //create user
    public By createUser=By.xpath("//div[@class='components_button submitBtn']");
    //close the pop up window
    public By closePopUp=By.xpath("//div[@class='createUserPanel_accountCreatedContainer']/descendant::span[2]");
    //click on search user
    public By searchUser=By.xpath("//thead[@id='userListTableHeader']/descendant::div[21]");
    //click on search text field
    public By searchTextField=By.xpath("(//input[@placeholder='Start typing name...'])[1]");
    //click on user name
    public By clickUser=By.xpath("(//table[@class='userNameContainer'])[1]");
    //click on delit button
    public By clickOnDelitButton=By.xpath("//div[@class='deleteButton actionButton']/div");

    public void setFirstName(String first) throws InterruptedException {
        driver.findElement(userModule).click();
        Thread.sleep(5000);
        driver.findElement(newUser).click();
        Thread.sleep(5000);
        driver.findElement(firstName).sendKeys(first);
        Thread.sleep(5000);
    }
    public void setLastName(String last) throws InterruptedException {
        driver.findElement(lastName).sendKeys(last);
        Thread.sleep(5000);
    }
    public void setMailId(String mail) throws InterruptedException {
        driver.findElement(mailId).sendKeys(mail);
        Thread.sleep(5000);
        driver.findElement(dropDown).click();
        Thread.sleep(5000);
        driver.findElement(qaDept).click();
        Thread.sleep(5000);
        driver.findElement(createUser).click();
        Thread.sleep(3000);
        driver.findElement(closePopUp).click();
        Thread.sleep(3000);
        driver.findElement(searchUser).click();
    }
    public void delitUser(String delit) throws InterruptedException, AWTException {
        Thread.sleep(3000);
        driver.findElement(searchTextField).sendKeys(delit);
        Thread.sleep(3000);
        driver.findElement(clickUser).click();
        Thread.sleep(3000);
        driver.findElement(clickOnDelitButton).click();
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);

    }
}
