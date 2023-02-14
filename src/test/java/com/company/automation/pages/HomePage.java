package com.company.automation.pages;

import com.company.automation.selenium.BasePage;
import com.company.automation.selenium.SeleniumActions;
import com.company.automation.utils.PasswordUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class HomePage extends BasePage {

    @Autowired
    public SeleniumActions seleniumActions;

    @FindBy(xpath = "//a[@id='nav-link-accountList']")
    public WebElement signInAccountLink;

    @FindBy(xpath = "//div[@class='nav-signin-tt nav-flyout'][contains(@style,'display: block;')]")
    public WebElement signInLink;

    @FindBy(id = "ap_email")
    public WebElement emailOrPhoneNumberTxb;

    @FindBy(id = "continue")
    public WebElement continueBtn;

    @FindBy(id = "ap_password")
    public WebElement passwordTxb;

    @FindBy(id = "signInSubmit")
    public WebElement signInBtn;

    @FindBy(xpath = "//input[@type='text' and @id='twotabsearchtextbox']")
    public WebElement searchTxb;

    @FindBy(id = "nav-search-submit-button")
    public WebElement searchBtn;

    @FindBy(id = "nav-cart-count-container")
    public WebElement cartLink;

    @FindBy(xpath = "//span[.='Hello, Baban']")
    public WebElement loginSuccessful;

    @Value("${app.url}")
    private String appURL;

    public void launchHomePage() {
        seleniumActions.launchApplication(appURL);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void loginToApplication() {

        seleniumActions.clickElement(signInAccountLink);
        seleniumActions.enterText(emailOrPhoneNumberTxb, "9923374848");
        seleniumActions.clickElement(continueBtn);
        seleniumActions.enterText(passwordTxb, PasswordUtils.getDecodedPassword("Z2hhdHJhaTEyIUA="));
        seleniumActions.clickElement(signInBtn);
    }

    public boolean verifyLoginSuccessful() {
        seleniumActions.sleep(10);
        seleniumActions.waitForElementVisible(loginSuccessful);
        seleniumActions.takeSnapShot(new File(".").getPath());
        return seleniumActions.isElementVisible(loginSuccessful);
    }

    public SearchResultPage searchProduct(String input) {
        seleniumActions.sleep(5);
        seleniumActions.enterText(searchTxb, input);
        seleniumActions.clickElement(searchBtn);
        return new SearchResultPage();
    }

    public ShoppingCartPage clickCartLink() {
        seleniumActions.clickElement(cartLink);
        return new ShoppingCartPage();
    }
}
