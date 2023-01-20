package com.company.automation.pages;

import com.company.automation.selenium.BasePage;
import com.company.automation.selenium.SeleniumActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends BasePage {

    @Autowired
    public SeleniumActions seleniumActions;

    @FindBy(id="twotabsearchtextbox")
    public WebElement searchTxb;

    @FindBy(id="nav-search-submit-button")
    public WebElement searchBtn;

    @Value("${app.url}")
    private String appURL;

    public void launchHomePage() {
        seleniumActions.launchApplication(appURL);
        driver.manage().window().maximize();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void searchProduct(String input) {
        seleniumActions.enterText(searchTxb, input);
        seleniumActions.clickElement(searchBtn);
    }
}
