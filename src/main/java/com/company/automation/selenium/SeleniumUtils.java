package com.company.automation.selenium;

import com.company.automation.exceptions.ActionFailedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class SeleniumUtils {
    
    @Autowired
    protected WebDriver driver;

    public void launchApplication(String url) {
        try {
            driver.get(url);
            //Allure.step(String.format("Application {} opened successfully", url));
        } catch (Exception e) {
            e.printStackTrace();
            throw new ActionFailedException(e.getMessage());
        }
    }

    public void enterText(WebElement element, String text) {
        try {
           element.sendKeys(text);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ActionFailedException(e.getMessage());
        }
    }

    public void clickElement(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ActionFailedException(e.getMessage());
        }
    }
}

