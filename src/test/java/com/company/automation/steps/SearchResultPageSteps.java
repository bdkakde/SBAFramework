package com.company.automation.steps;

import com.company.automation.pages.SearchResultPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

public class SearchResultPageSteps {

    @Autowired
    public SearchResultPage searchResultPage;

    @Then("I found search results")
    public void iFoundSearchResults() {

        boolean flag = searchResultPage.checkSearchResult();
        if(flag) {
            Assert.assertTrue(true);
        } else {
            Assert.fail("Element not found!!!");
        }
    }

    @And("user click on product")
    public void userClickOnProduct() {
        searchResultPage.clickProductLink();
    }
}
