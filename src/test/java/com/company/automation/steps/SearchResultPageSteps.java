package com.company.automation.steps;

import com.company.automation.pages.HomePage;
import com.company.automation.pages.SearchResultPage;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

//@CucumberContextConfiguration
//@SpringBootTest()
public class SearchResultPageSteps {

    @Autowired
    public SearchResultPage srPage;

    @Then("I found search results")
    public void iFoundSearchResults() {
        Assert.assertTrue(srPage.checkSearchResult(), "Search results not found");
    }
}
