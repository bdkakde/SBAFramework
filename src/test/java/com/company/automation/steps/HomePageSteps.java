package com.company.automation.steps;

import com.company.automation.pages.HomePage;
import com.company.automation.pages.SearchResultPage;
import com.company.automation.utils.DataGenerator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

//@CucumberContextConfiguration
//@SpringBootTest()
public class HomePageSteps {

    @Autowired
    DataGenerator dataGenerator;
    @Autowired
    public HomePage homePage;

    @Given("user open home page")
    public void userOpenHomePage() {
       homePage.launchHomePage();
    }

    @When("I search product")
    public void iSearchProduct() {
        homePage.searchProduct(dataGenerator.getRandomProductName());
    }

    @When("user search product by name {string}")
    public void userSearchProductByName(String input) {
        homePage.searchProduct(input);
    }

    @Then("I see title as {string}")
    public void iSeeTitleAs(String expTitle) {
        String actTitle = homePage.getTitle();
        if(actTitle.equals(expTitle)) {
            Assert.assertEquals(actTitle, expTitle);
        } else {
            Assert.fail("Expected title [" + expTitle + "] and actual title ["  + actTitle +  "] did not matched!!!");
        }
    }

    @When("user login to application")
    public void userLoginToApplication() {
        homePage.loginToApplication();
    }

    @And("User click on cart link")
    public void userClickOnCartLink() {
        homePage.clickCartLink();
    }

    @Then("user verify if login successful")
    public void userVerifyIfLoginSuccessful() {
        Assert.assertTrue(homePage.verifyLoginSuccessful(), "Login failed");
    }
}
