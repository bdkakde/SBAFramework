package com.company.automation.steps;

import com.company.automation.pages.ProductDetailsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

public class ProductDetailsPageSteps {

    @Autowired
    public ProductDetailsPage productDetailsPage;

    @And("user click on add to cart")
    public void userClickOnAddToCart() {
        productDetailsPage.clickAddToCartBtn();
    }

    @Then("user verify product added message")
    public void userVerifyProductAddedMessage() {
        Assert.assertTrue(productDetailsPage.verifyProductAddedMessage());
    }

    @And("user click on proceed to checkout")
    public void userClickOnProceedToCheckout() {
        productDetailsPage.clickOnProceedToCheckoutBtn();
    }

    @And("user click on cart button")
    public void userClickOnCartButton() {
        productDetailsPage.clickOnCartBtn();
    }
}
