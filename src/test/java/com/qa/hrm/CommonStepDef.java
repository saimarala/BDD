package com.qa.hrm;

import Pages.HomePage;
import Pages.HrmLoginPage;
import factory.BrowserFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class CommonStepDef {
    HrmLoginPage login;
    WebDriver driver;
    HomePage hm;
    String Author;

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

    @Given(": I have entered valid credentials {string} and {string}")
    public void test(String username, String password) {
        login.setUserName(username);
        login.setPassword(password);
    }

    @Given(": I have enter credentials {string} and {string}")
    public void i_have_enter_credentials_and(String username, String password) {
        // login=new HrmLoginPage(BrowserFactory.getDriver());
        login.setUserName(username);
        login.setPassword(password);
    }


    @When(": I click on the login button")
    public void i_click_on_the_login_button() {
        this.hm=login.setLogin();

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


    @Given(": I have enter login credentials")
    public void i_have_enter_login_credentials(DataTable dataTable) {
        List<Map<String,String>> credList=dataTable.asMaps();
        login.setUserName(credList.get(0).get("username"));
        login.setPassword(credList.get(0).get("password"));
       // throw new io.cucumber.java.S;

    }

    @Then(": Validate the error message")
    public void validate_the_error_message() {
        Assert.assertTrue(login.setErrorMsg().contains("Invalid credentials"));
    }



}
