package com.company.automation.steps;

import com.company.automation.pages.ShoppingCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

public class ShoppingCartPageSteps {

    @Autowired
    public ShoppingCartPage shoppingCartPage;

    @Then("user verify product added to cart")
    public void userVerifyProductAddedToCart() {
        Assert.assertTrue(shoppingCartPage.verifyProductAddedToShoppingCart());
    }

    @And("user remove products from cart")
    public void userRemoveProductsFromCart() {
        shoppingCartPage.removeProductsFromCart();
    }

    @Then("user verify products removed from cart")
    public void userVerifyProductsRemovedFromCart() {
        Assert.assertTrue(shoppingCartPage.verifyCartIsEmpty());
    }
}
