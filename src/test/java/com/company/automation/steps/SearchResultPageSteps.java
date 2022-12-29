package com.company.automation.steps;

import com.company.automation.pages.SearchResultPage;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

public class SearchResultPageSteps {

    @Autowired
    public SearchResultPage srPage;

    @Then("I found search results")
    public void iFoundSearchResults() {

        boolean flag = srPage.checkSearchResult();
        if(flag) {
            Assert.assertTrue(true);
        } else {
            Assert.fail("Element not found!!!");
        }
    }
}
