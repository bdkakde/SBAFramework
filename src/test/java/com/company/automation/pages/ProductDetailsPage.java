package com.company.automation.pages;

import com.company.automation.selenium.BasePage;
import com.company.automation.selenium.SeleniumActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDetailsPage extends BasePage {

    @Autowired
    public SeleniumActions seleniumActions;

    @FindBy(id = "add-to-cart-button")
    public WebElement addToCartBtn;

    @FindBy(xpath = "//span[@id='attach-sidesheet-checkout-button']")
    public WebElement proceedToCheckoutBtn;

    @FindBy(id = "attach-sidesheet-view-cart-button")
    public WebElement cartBtn;
    @FindBy(xpath = "//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']")
    public WebElement cartAddedText;

    public void clickAddToCartBtn() {
        seleniumActions.switchToNewWindow(1);
        seleniumActions.clickElement(addToCartBtn);
    }

    public ShoppingCartPage clickOnProceedToCheckoutBtn() {
        seleniumActions.clickElement(proceedToCheckoutBtn);
        return new ShoppingCartPage();
    }

    public ShoppingCartPage clickOnCartBtn() {
        seleniumActions.clickElement(cartBtn);
        return new ShoppingCartPage();
    }

    public boolean verifyProductAddedMessage() {
        return seleniumActions.verifyElementText(cartAddedText, "Added to Cart");
    }


}
