package com.qa.hrm;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Reporter;

public class testStepDef {

    @Given(": Open the test app")
    public void open_the_test_app() {
        Reporter.log("Open the app",true);
    }
    @Given(": start smoke")
    public void start_smoke() {
        Reporter.log("smoke",true);
    }
    @When(": click on login")
    public void click_on_login() {
        Reporter.log("login",true);
    }
    @Then(": login success")
    public void login_success() {
        Reporter.log("Success",true);
    }

    @Given(": start regression")
    public void start_regression() {
        Reporter.log("Start regression",true);
    }

    @Given(": start e2e")
    public void start_e2e() {
        Reporter.log("Start E2E",true);
    }

}
