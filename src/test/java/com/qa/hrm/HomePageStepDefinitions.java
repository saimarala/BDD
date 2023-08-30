package com.qa.hrm;

import Pages.HomePage;
import factory.BrowserFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class HomePageStepDefinitions {
    HomePage hm;


    @When(": Click on PIM")
    public void click_on_pim() {
        hm=new HomePage(BrowserFactory.getDriver());
        hm.pim();
    }


    @Then(": Should be display PIM page")
    public void should_be_display_pim_page() {
        Assert.assertTrue(hm.pimPage().isDisplayed());
    }
}
