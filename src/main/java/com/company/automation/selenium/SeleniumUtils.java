package com.company.automation.selenium;

import com.company.automation.exceptions.ActionFailedException;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class SeleniumUtils extends BasePage {

    public void launchApplication(String url) {
        try {
            driver.get(url);
            Allure.step(String.format("Application %s opened successfully", url));
        } catch (Exception e) {
            e.printStackTrace();
            throw new ActionFailedException(e.getMessage());
        }
    }

    public void enterText(WebElement element, String text) {
        try {
           element.sendKeys(text);
            Allure.step(String.format("Text %s entered in %s successfully", text, element));
        } catch (Exception e) {
            e.printStackTrace();
            throw new ActionFailedException(e.getMessage());
        }
    }

    public void clickElement(WebElement element) {
        try {
            element.click();
            Allure.step(String.format("Clicked on element %s successfully", element));
        } catch (Exception e) {
            e.printStackTrace();
            throw new ActionFailedException(e.getMessage());
        }
    }
}

