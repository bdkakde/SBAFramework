package com.company.automation.selenium;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

public class BasePage {


    @Autowired
    @Lazy
    protected WebDriver driver;

    @Autowired
    @Lazy
    protected WebDriverWait wait;

    @PostConstruct
    private void initPage() {
        PageFactory.initElements(driver, this);
    }
}
