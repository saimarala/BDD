package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserFactory {
    public WebDriver driver;
 // public   WebDriverWait wait=new WebDriverWait(getDriver(),Duration.ofSeconds(60));
    static ThreadLocal<WebDriver> tDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return tDriver.get();

    }


    public WebDriver init_driver(String browserName) {
        if (browserName.contains("Chrome") || browserName.contains("GC") || browserName.contains("Google Chrome")) {
            ChromeOptions opt = new ChromeOptions();
           // opt.addArguments("--remote-allow-origins=*");
          //  opt.setHeadless(true);
           // opt.addArguments("--headless=new");
            //driver = new ChromeDriver(opt);
            tDriver.set(new ChromeDriver(opt));
        } else if (browserName.contains("Firefox")) {
            driver = new FirefoxDriver();
            tDriver.set(driver);
        } else if (browserName.contains("Safari")) {
            driver = new SafariDriver();
            tDriver.set(driver);
        } else if (browserName.contains("Edge")) {
            driver = new EdgeDriver();
            tDriver.set(driver);
        } else {
            driver = new ChromeDriver();
            tDriver.set(driver);
        }
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return getDriver();

    }
}
