package com.company.automation.pages;

import com.company.automation.selenium.BasePage;
import com.company.automation.selenium.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShoppingCartPage extends BasePage {

    private final Logger LOGGER = LoggerFactory.getLogger(ShoppingCartPage.class);
    @Autowired
    public SeleniumActions seleniumActions;

    @FindBy(xpath = "//div[@data-name='Active Items']//div[@class='sc-item-content-group']//input[@value='Delete']")
    public List<WebElement> deleteBtn;


    @FindBy(xpath = "//div[@data-name='Active Items']//div[@class='sc-item-content-group']//a[@class='a-link-normal sc-product-link']")
    public WebElement cartSavedProducts;

    @FindBy(xpath = "//h1[@class='a-spacing-mini a-spacing-top-base']")
    public WebElement cartEmptyHdr;

    public boolean verifyProductAddedToShoppingCart() {
        return seleniumActions.isElementVisible(cartSavedProducts);
    }

    public void removeProductsFromCart() {
        int count = 0;
        for (WebElement element : deleteBtn) {
            while (deleteBtn.size() > 0) {
                seleniumActions.clickElement(element);
                count++;
            }
        }
        System.out.println(count);
        LOGGER.info("All items in cart deleted successfully");
    }

    public boolean verifyCartIsEmpty() {
        return seleniumActions.isElementVisible(cartEmptyHdr);
    }
}
