package com.company.automation.selenium;

import com.company.automation.exceptions.ActionFailedException;
import com.company.automation.reporter.AllureReportManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.function.Function;

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

    @Value("${page.timeout}")
    private int pageTimeout;

    private String locator(WebElement element) {
        String[] locator = element.toString().split("->");
        return locator[1].replace("]", "");
    }

    public void launchApplication(String url) {
        try {
            driver.get(url);
            //driver.manage().window().maximize();
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
            allureReportManager.failStep("Failed to click on element [%s] due to exception %s", element, e);
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
            for (WebElement element : elements) {
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

    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
    }

    public void waitForPageLoad(int timeout) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
    }

    public void explicitWait(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWait));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void fluentWait(WebElement element) {

        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofSeconds(1L))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
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
            if (actualText.equals(expectedText)) {
                flag = true;
                allureReportManager.passStep("Actual text [%s] and Expected text [%s] are matched", actualText, expectedText);
            }
        } catch (Exception e) {
            e.printStackTrace();
            allureReportManager.failStep("Actual text [%s] and Expected text [%s] are not matched matched", actualText, expectedText);
            throw new AssertionError(e.getMessage());
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

    public int getHttpResponseCode(String url) {
        int res = 0;
        // establish, open connection with URL
        HttpURLConnection cn = null;
        try {
            cn = (HttpURLConnection) new URL(url).openConnection();
            // set HEADER request
            cn.setRequestMethod("HEAD");
            // connection initiate
            cn.connect();
            //get response code
            res = cn.getResponseCode();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public WebDriverWait getWebDriverWait() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWait));
        return wait;
    }

    public void highLightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }

    public boolean waitForJSandJQueryToLoad() {

        WebDriverWait wait = getWebDriverWait();

        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long)((JavascriptExecutor)driver).executeScript("return jQuery.active") == 0);
                }
                catch (Exception e) {
                    // no jQuery present
                    return true;
                }
            }
        };

        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor)driver).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };

        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }
}

