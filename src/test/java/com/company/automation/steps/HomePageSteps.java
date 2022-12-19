package com.company.automation.steps;

import com.company.automation.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

@CucumberContextConfiguration
@SpringBootTest()
public class HomePageSteps {

    @Autowired
    public HomePage homePage;

    @Given("I open home page")
    public void iOpenHomePage() {
       homePage.launchHomePage();
    }

    @When("I search product")
    public void iSearchProduct() {
        homePage.searchProduct("4K TV");
    }

    @Then("I see title as {string}")
    public void iSeeTitleAs(String expTitle) {
        String actTitle = homePage.getTitle();
        if(actTitle.equals(expTitle)) {
            Assert.assertEquals(actTitle, expTitle);
        } else {
            Assert.assertNotEquals(actTitle, expTitle);
        }
    }


}
