package com.company.automation.pages;

import com.company.automation.selenium.BasePage;
import com.company.automation.selenium.SeleniumUtils;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends BasePage {

    @Autowired
    public SeleniumUtils seleniumUtils;

    @FindBy(id="twotabsearchtextbox")
    public WebElement searchTxb;

    @FindBy(id="nav-search-submit-button")
    public WebElement searchBtn;

    @Value("${app.url}")
    private String appURL;

    public void launchHomePage() {
        //driver.get(appURL);
        seleniumUtils.launchApplication(appURL);
        driver.manage().window().maximize();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void searchProduct(String input) {
        //searchTxb.sendKeys(input);
        //searchBtn.click();
        seleniumUtils.enterText(searchTxb, input);
        seleniumUtils.clickElement(searchBtn);
    }
}
