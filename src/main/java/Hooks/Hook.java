package Hooks;

import factory.BrowserFactory;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hook {

    WebDriver driver;


    @Before
    public void startBrowser()
    {
        System.out.println("LOG:INFO - Before Hooks - Setting up browser");

        BrowserFactory browserFactory=new BrowserFactory();

        driver=browserFactory.init_driver("Chrome");


        System.out.println("LOG:INFO - Before Hooks - Browser is setup");
    }

    @After
    public void closeBrowser()
    {
        System.out.println("LOG:INFO - After Hooks - Closing the browser");
        driver.quit();
        System.out.println("LOG:INFO - After Hooks - Browser terminated");
    }

//    @AfterStep
//    public void tearDown(Scenario scenario)
//    {
//
//        System.out.println("LOG:INFO - After Steps - Running for steps");
//
//        String name=scenario.getName();
//
//        byte []screenshot= Utility.captureScreenshotInByte(driver);
//
//        scenario.attach(screenshot, "image/png", name);
//
//		/*if(scenario.isFailed())
//		{
//			String name=scenario.getName();
//
//			byte []screenshot=Utility.captureScreenshotInByte(driver);
//
//			scenario.attach(screenshot, "image/png", name);
//		}
//		*/
//
//
//    }

    @BeforeStep(order =1)

    public void bStep(){
        System.out.println("Before each step");
    }

    @AfterStep
    public void afStep(){
        System.out.println("After each step" );
    }

    @BeforeAll
    public static void beforeAll(){
       System.out.println("Before scenario only one time");
    }
    @AfterAll
    public static void afterAll(){
        System.out.println("After all the  scenario only one time");
    }

    @AfterStep("@E2E")

    public void aStep(){
        System.out.println("After each step");
    }

}


