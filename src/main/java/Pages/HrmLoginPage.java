package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HrmLoginPage {
    WebDriver driver;
    public WebDriverWait wait ;

    public HrmLoginPage(WebDriver driver) {

        this.driver = driver;
       this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    By userName = By.xpath("//input[@name='username']");
    By password = By.xpath("//input[@name='password']");
    By login = By.xpath("//button[@type='submit']");
    By error = By.xpath("//p[text()='Invalid credentials']");

    public void setUserName(String user) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userName)).sendKeys(user);
       // driver.findElement(userName).sendKeys(user);
    }

    public void setPassword(String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(pass);
       // driver.findElement(password).sendKeys(pass);
    }
    public HomePage setLogin(){
        wait.until(ExpectedConditions.elementToBeClickable(login)).click();
       // Utility.clickElement(driver,login);
       // driver.findElement(login).click();
        return new HomePage(driver);
    }

    public String  setErrorMsg(){
        return wait.until(ExpectedConditions.elementToBeClickable(error)).getText();
    }
}
