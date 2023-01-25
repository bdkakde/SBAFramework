package com.company.automation.selenium;

import com.company.automation.exceptions.ActionFailedException;
import com.company.automation.reporter.AllureReportManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;

@Component
public class SeleniumActions extends BasePage {

    private final Logger LOGGER = LoggerFactory.getLogger(SeleniumActions.class);

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
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
            allureReportManager.passStep("Application [%s] opened successfully", url);
        } catch (Exception e) {
            e.printStackTrace();
            allureReportManager.failStep("Failed to open Application [%s]", url);
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
            allureReportManager.passStep("Clicked on element [%s] successfully", element);
        } catch (Exception e) {
            e.printStackTrace();
            allureReportManager.failStep("Failed to click on element [%s]", element);
            throw new ActionFailedException(e.getMessage());
        }
    }

    public void waitForElementVisible(WebElement element) {

        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWait));
            wait.until(ExpectedConditions.visibilityOf(element));
            if (element.isDisplayed()) {
                allureReportManager.passStep("Element [%s] found successfully", locator(element));
            } else {
                allureReportManager.failStep("Failed to found element [%s] ", locator(element));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError(e.getMessage());
        }
    }

    public void waitForElementsVisible(List<WebElement> elements) {

        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWait));
            wait.until(ExpectedConditions.visibilityOfAllElements(elements));
            for(WebElement element : elements) {
                if (element.isDisplayed()) {
                    allureReportManager.passStep("Element [%s] found successfully", locator(element));
                } else {
                    allureReportManager.failStep("Failed to found element [%s] ", locator(element));
                }
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

            if (element.isDisplayed()) {
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

    public void switchToNewWindow(int num) {
        try {
            int numWindow = driver.getWindowHandles().size();
            String[] window = driver.getWindowHandles().toArray(new String[numWindow]);
            driver.switchTo().window(window[num]);
        } catch (NoSuchWindowException e) {
            e.printStackTrace();
        }
    }

    public String getElementText(WebElement element) {
        try {
            waitForElementVisible(element);
            return element.getText();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ActionFailedException(e.getMessage());
        }
    }

    public boolean verifyElementText(WebElement element, String expectedText) {
        String actualText = "";
        boolean flag = false;
        waitForElementVisible(element);
        try {
           actualText = element.getText();
           if(actualText.equals(expectedText)) {
               flag = true;
               allureReportManager.passStep("Actual text [%s] and Expected text [%s] are matched", actualText, expectedText);
           }
        } catch (Exception e) {
            e.printStackTrace();
            allureReportManager.failStep("Actual text [%s] and Expected text [%s] are not matched matched", actualText, expectedText);
            throw new ActionFailedException(e.getMessage());
        }
        return flag;
    }

    public Actions getActions() {
        return new Actions(driver);
    }

    public void mouseHover(WebElement element) {
        try {
            waitForElementVisible(element);
            getActions().moveToElement(element).perform();
            allureReportManager.passStep("Mouse hover on Element [%s] successfully", locator(element));
        } catch (Exception e) {
            e.printStackTrace();
            allureReportManager.failStep("Failed to mouse hover on Element [%s] successfully", locator(element));
            throw new ActionFailedException(e.getMessage());
        }
    }

    public void sleep(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

