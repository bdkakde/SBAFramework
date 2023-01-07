package com.company.automation.selenium;

import com.company.automation.exceptions.ActionFailedException;
import com.company.automation.reporter.AllureReportManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class SeleniumActions extends BaseDriver {

    @Autowired
    AllureReportManager allureReportManager;

    @Value("${screenshot.path}")
    private String screenShotPath;

    @Value("${explicit.wait}")
    private int explicitWait;

    @Value("${implicit.wait}")
    private int implicitWait;

    private String locator(WebElement element) {
        String[] locator = element.toString().split("->");
        return locator[1].replace("]", "");
    }

    public void launchApplication(String url) {
        try {
            driver.get(url);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
            allureReportManager.passStep("Application [%s] opened successfully", url);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ActionFailedException(e.getMessage());
        }
    }

    public void enterText(WebElement element, String text) {
        try {
            waitForElementVisible(element);
            element.sendKeys(text);
            allureReportManager.passStep("Text [%s] entered into text box [%s] successfully", text, locator(element));
        } catch (Exception e) {
            e.printStackTrace();
            allureReportManager.failStep("Failed to enter text [%s] into text box [%s] ", text, locator(element));
            throw new ActionFailedException(e.getMessage());
        }
    }

    public void clickElement(WebElement element) {
        try {
            waitForElementVisible(element);
            element.click();
            Allure.step(String.format("Clicked on element [%s] successfully", locator(element)));
        } catch (Exception e) {
            e.printStackTrace();
            throw new ActionFailedException(e.getMessage());
        }
    }

    public void waitForElementVisible(WebElement element) {

        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWait));
            wait.until(ExpectedConditions.visibilityOf(element));
            if(element.isDisplayed()) {
                allureReportManager.passStep("Element [%s] found successfully", locator(element));
            } else {
                allureReportManager.failStep("Failed to found element [%s] ", locator(element));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError(e.getMessage());
        }
    }

    public boolean isElementVisible(WebElement element) {

        boolean flag = false;
        try {
          wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWait));
          wait.until(ExpectedConditions.visibilityOf(element));

          if(element.isDisplayed()) {
              allureReportManager.passStep("Element [%s] found successfully", locator(element));
              flag = true;
          } else {
              allureReportManager.failStep("Failed to find element [%s] ", locator(element));
          }
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError(e.getMessage());
        }
        return flag;
    }
 }

