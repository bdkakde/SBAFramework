package com.company.automation.selenium;

import jakarta.annotation.PostConstruct;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class BasePage {

    @Autowired
    @Lazy
    protected WebDriver driver;

    @Autowired
    @Lazy
    protected WebDriverWait wait;

    @PostConstruct
    private void initializePage() {
        PageFactory.initElements(driver, this);
    }
}
