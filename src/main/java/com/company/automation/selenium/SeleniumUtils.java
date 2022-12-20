package com.company.automation.selenium;

import com.company.automation.exceptions.ActionFailedException;
import com.company.automation.utils.Constants;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SeleniumUtils {
    
    @Autowired
    protected WebDriver driver;

    public void launchApplication(String url) {
        try {
            driver.get(url);
            Allure.step(String.format(Constants.APPLICATION_LAUNCH_SUCCESSFUL, url));
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

