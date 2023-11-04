package Pages;

import factory.BrowserFactory;
import helper.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage  {

    WebDriver driver;
     WebDriverWait wait;
    public  HomePage(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }
    By dashboard = By.xpath("//h6[text()='Dashboard']");
    By admin = By.xpath("//span[text()='Admin']");
    By adminUser =By.xpath("//span[@class='oxd-topbar-header-breadcrumb']");
    By pim = By.xpath("//span[text()='PIM']");
    By empList = By.xpath("(//nav[@role='navigation'])[2]//a[text()='Employee List']");
    By report = By.xpath("(//nav[@role='navigation'])[2]//a[text()='Reports']");
    By search = By.xpath("//div[@class='oxd-autocomplete-wrapper']//input");
    By searchButton = By.xpath("//button[@type='submit']");
    By invalid = By.xpath("//span[contains(@class,'error-message')]");
    public WebElement homepageUrl() {
        //wait.until(ExpectedConditions.urlContains("dashboard/index"));
       WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(dashboard));
       return ele;
    }

    public void admin(){
        Utility.clickElements(admin);

    }
    public WebElement adminPage(){
        WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(adminUser));
        return ele;
    }
    public void pim(){
       // Utility.clickElements(pim);
        wait.until(ExpectedConditions.elementToBeClickable(pim)).click();
    }

    public WebElement pimPage(){
        WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(adminUser));
        return ele;
    }

    public WebElement empList(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(empList));
    }

    public void reports(String searchValue){
        wait.until(ExpectedConditions.visibilityOfElementLocated(report)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(search)).sendKeys(searchValue);

    }
   public String error(){
       wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton)).click();
       return wait.until(ExpectedConditions.visibilityOfElementLocated(invalid)).getText();
   }
}
