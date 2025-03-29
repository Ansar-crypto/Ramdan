package pages;

import Common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectPage extends BaseClass {
    WebDriver driver;

    public ProjectPage(WebDriver driver) {
        this.driver = driver;
        launchbrowser("chrome");
    }
        public By taskModule=By.xpath("//div[text()='Tasks']");
        //click on add new button
        public By addNewButton=(By.xpath("//div[@class='title ellipsis']"));
        //click on project
        public By clickOnProject=(By.xpath("//div[text()='+ New Project']"));
        //inter project name sendkeys
        public By projectName=(By.xpath("//div[@class='sectionDetails']/input"));
        //click on select project
        public By clickDropdown=(By.xpath("//div[text()='-- Please Select Customer to Add Project for  --']/following::div[5]"));
        //click on project name
        public By clickOnProjectName=(By.xpath("//div[@class='comboboxButton focused']/following::div[7]"));
        //(By.xpath("//div[@class='sectionDetails']/input")).sendKeys(projectname);
        //click on task text feild
        public By taskTextFeild= (By.xpath("//table[@class='createTasksTable hideAddToTT']/descendant::input[2]"));
        //task sendkeys
        public By createTask=(By.xpath("//table[@class='createTasksTable hideAddToTT']/descendant::input[2]"));
        //click on create task and project together
        public By createTaskAndProject= (By.xpath("//div[text()='Create Project']"));

        public void CreateProject(String projectName1) throws InterruptedException {
            driver.findElement(taskModule).click();
            driver.findElement(addNewButton).click();
            driver.findElement(clickOnProject).click();
            Thread.sleep(5000);
            driver.findElement(projectName).sendKeys(projectName1);
            Thread.sleep(5000);
        }
        public void createTask(String taskName) throws InterruptedException {
            driver.findElement(taskTextFeild).click();
            Thread.sleep(5000);
            driver.findElement(createTask).sendKeys(taskName);
            //driver.findElement(clickDropdown).isDisplayed();
            Thread.sleep(5000);
            driver.findElement(clickDropdown).click();
            Thread.sleep(5000);
            driver.findElement(clickOnProjectName).click();
            Thread.sleep(5000);
            driver.findElement(createTaskAndProject).click();
        }

}
