package com.company.automation.selenium;

import com.company.automation.exceptions.ActionFailedException;
import com.company.automation.reporter.AllureReportManager;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

@Component
public class SeleniumActions extends BasePage {

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
            allureReportManager.failStep("Failed to enter text %s into text box %s ", text, locator(element));
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
              allureReportManager.failStep("Failed to found element [%s] ", locator(element));

          }
        } catch (Exception e) {
            //getScreenshot();
            e.printStackTrace();
            throw new AssertionError(e.getMessage());
        }
        return flag;
    }

    public void getScreenshot() {

        System.out.println("********* Entering getScreenshot ************ ");
        File screenshotBase64Data = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        System.out.println("%%%%%%%%%%%%%%% " + screenShotPath);
        try {
            FileUtils.copyFile(screenshotBase64Data, new File("E:\\Workspace\\SBAFramework\\src\\test\\resources\\screenshots"));
            Path content = Paths.get(screenShotPath);
            System.out.println("%%%%%%%%%%%%%%% " + content);
            try (InputStream is = Files.newInputStream(content)) {
                Allure.addAttachment("methodName", is);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public String captureScreen() {
        String path;
        try {
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            path = screenShotPath + File.separator + source.getName();
            FileUtils.copyFile(source, new File(path));
        }
        catch(IOException e) {
            path = "Failed to capture screenshot: " + e.getMessage();
        }
        System.out.println("%%%%%%%%%%%%% " + path);
        return path;
    }
 }

