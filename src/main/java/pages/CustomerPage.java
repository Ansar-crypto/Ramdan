package pages;

import Common.BaseClass;
import Common.CommonUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class CustomerPage extends BaseClass{
    WebDriver driver;
    CommonUtil commonUtil1;
    @FindBy(xpath = "//div[text()='Tasks']")
    WebElement taskModule;
    @FindBy(xpath = "//div[@class='title ellipsis']")
    WebElement addNewButton;
    @FindBy(xpath ="//div[@class='item createNewCustomer']" )
    WebElement navigateToNewCustomer;
    @FindBy(xpath = "//div[@id='customerLightBox']/descendant::input[1]")
    WebElement enterCustName;
    @FindBy(xpath = "//div[text()='Create Customer']")
    WebElement createCustomer;
    @FindBy(xpath = "//div[@class='searchAndExportContainer']//input")
    WebElement searchText;
    @FindBy(xpath = "//div[@class='node customerNode editable selected editing']/descendant::div[6]")
    WebElement clickOnCustomer;
    @FindBy(xpath = "(//div[text()='ACTIONS'])[1]")
    WebElement clickOnAction;
    @FindBy(xpath = "(//div[text()='Delete'])[1]")
    WebElement clickOnDelit;
    @FindBy(xpath = "//span[text()='Delete permanently']")
    WebElement permanentDelit;

    public CustomerPage(WebDriver driver){
        this.driver=driver;
        launchBrowser("firefox");
        PageFactory.initElements(this.driver,this);
        commonUtil1=new CommonUtil(this.driver);
    }
    //public By taskModule=By.xpath("//div[text()='Tasks']");
   // public By addNewButton=By.xpath("//div[@class='title ellipsis']");
    // public By navigateToNewCustomer= By.xpath("//div[@class='item createNewCustomer']");
    //public By enterCustName=By.xpath("//div[@id='customerLightBox']/descendant::input[1]");
    //public By createCustomer=By.xpath("//div[@class='components_button withPlusIcon']/descendant::div[1]");

    //public By searchText=By.xpath("//div[@class='searchAndExportContainer']//input");

    public void createCustomer(String customerName) throws InterruptedException {
        taskModule.click();
        Thread.sleep(5000);
        addNewButton.click();

        navigateToNewCustomer.click();
        Thread.sleep(5000);
        enterCustName.sendKeys(customerName);
        Thread.sleep(5000);
        createCustomer.click();
    }
    public void verifyCustomer(String customerName){
      searchText.sendKeys(customerName);
        System.out.println(customerName);
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals("cyber success",customerName,"Expected customer not found");
    }
    public void delitCustomer() throws InterruptedException {
        Thread.sleep(3000);
        clickOnCustomer.click();
        Thread.sleep(3000);
        clickOnAction.click();
        Thread.sleep(3000);
        clickOnDelit.click();
        permanentDelit.click();
    }
}
