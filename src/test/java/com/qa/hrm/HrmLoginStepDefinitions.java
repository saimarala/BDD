package com.qa.hrm;

import Pages.HomePage;
import factory.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import Pages.HrmLoginPage;

import java.time.Duration;

public class HrmLoginStepDefinitions {
    HrmLoginPage login;
    WebDriver driver;
    HomePage hm;


//    @Before
//    public void setup(){
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
//    }
//
//    @After
//    public void tearDown(){
//        if(driver!=null){
//            driver.quit();
//        }
//    }
    @Given(": Open the app")
    public void open_the_app() {
        BrowserFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

      //  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        login=new HrmLoginPage(BrowserFactory.getDriver());

    }

    @And(": I have entered a valid username and password")
    public void i_have_entered_a_valid_username_and_password() {
        login.setUserName("Admin");
        login.setPassword("admin123");
    }

    @And(": I have entered invalid {string} and {string}")
    public void i_have_entered_invalid_and(String username, String password) {
        login.setUserName(username);
        login.setPassword(password);
    }

    @When(": I click on the login button")
    public void i_click_on_the_login_button() {
        hm=login.setLogin();

    }

    @Then(": I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        Assert.assertTrue(hm.homepageUrl().isDisplayed());

    }

    @When(": Click on admin")
    public void click_on_admin() {
      hm.admin();
    }


    @Then(": Should be display admin page")
    public void Should_be_display_admin_page(){
        Assert.assertTrue(hm.adminPage().isDisplayed());
    }

//    @When(": Click on PIM")
//    public void click_on_pim() {
//        hm.pim();
//    }
//
//
//    @Then(": Should be display PIM page")
//    public void should_be_display_pim_page() {
//        Assert.assertTrue(hm.pimPage().isDisplayed());
//    }


}
