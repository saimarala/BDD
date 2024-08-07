package helper;

import factory.BrowserFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Utility extends BrowserFactory {


    static WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));


    public static void clickElement(WebDriver driver, By locator) {
        try {
            driver.findElement(locator).click();
        } catch (Exception e) {

            try {
                System.out.println("Trying with actions class click");
                Actions act = new Actions(driver);
                act.moveToElement(driver.findElement(locator)).click().build().perform();
            } catch (Exception e1) {

                System.out.println("Trying with JS Click");
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click()", driver.findElement(locator));
            }

        }

    }


    public static void clickElements(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
        } catch (Exception e) {

            try {
                System.out.println("Trying with actions class click");
                Actions act = new Actions(getDriver());
                act.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(locator))).click().perform();
            } catch (Exception e1) {

                System.out.println("Trying with JS Click");
                JavascriptExecutor js = (JavascriptExecutor) getDriver();
                js.executeScript("arguments[0].click()", wait.until(ExpectedConditions.elementToBeClickable(locator)));
            }

        }

    }


    public static WebElement highlightElement(WebDriver driver, WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].setAttribute('style','background: yellow; border:2px solid red;')", element);

        waitForSeconds(1);

        js.executeScript("arguments[0].setAttribute('style','border:2px solid white;')", element);

        return element;
    }

    public static WebElement highlightElement(WebDriver driver, By locator) {

        WebElement element = driver.findElement(locator);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].setAttribute('style','background: yellow; border:2px solid red;')", element);

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        js.executeScript("arguments[0].setAttribute('style','border:2px solid white;')", element);

        return element;
    }


    public static Alert waitForAlert(WebDriver driver) {
        Alert alt = null;

        for (int i = 0; i <= 15; i++) {
            try {
                alt = driver.switchTo().alert();
                break;
            } catch (NoAlertPresentException e) {
                System.out.println("No Alert Found- Waiting for Alert");

                waitForSeconds(1);
            }
        }

        return alt;
    }


    public static Alert waitForAlert(WebDriver driver, int time) {
        Alert alt = null;

        for (int i = 0; i <= time; i++) {
            try {
                alt = driver.switchTo().alert();
                break;
            } catch (NoAlertPresentException e) {
                System.out.println("No Alert Found- Waiting for Alert");

                waitForSeconds(1);
            }
        }

        return alt;
    }

    public static void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {

        }
    }

    // Sample Code
    public static void multipleScreenshot(int timeInterval, int totalDuration) {
        for (int i = 0; i < totalDuration; i++) {

            try {
                Thread.sleep(timeInterval);
            } catch (InterruptedException e) {

            }

        }

    }


    public static byte[] captureScreenshotInByte(WebDriver driver) {

        TakesScreenshot ts = (TakesScreenshot) driver;

        byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

        return screenshot;
    }


    public static String captureScreenshotInBase64(WebDriver driver) {

        TakesScreenshot ts = (TakesScreenshot) driver;

        String base64 = ts.getScreenshotAs(OutputType.BASE64);

        return base64;

    }

    public static void captureScreenshot(WebDriver driver) {
        try {
            FileHandler.copy(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), new File("./screenshots/Screenshot_" + getCurrentTime() + ".png"));
        } catch (IOException e) {
            System.out.println("Something went wrong " + e.getMessage());
        }
    }

    public static String getCurrentTime() {
        String date = new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy").format(new Date());

        return date;
    }

    public static void captureScreenshotOfFullPage(WebDriver driver, WebElement element) {

    }

    public static void captureScreenshotOfWebElement(WebElement element) throws IOException {
        FileHandler.copy(element.getScreenshotAs(OutputType.FILE), new File(System.getProperty("user.dir") + "/screenshots/screenshot.png" + getCurrentTime()));
    }


}
