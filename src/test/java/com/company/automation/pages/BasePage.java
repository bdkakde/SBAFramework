package com.company.automation.pages;

import jakarta.annotation.PostConstruct;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

public class BasePage {

    @Lazy
    @Autowired
    protected WebDriver driver;

    @PostConstruct
    public void initPage() {
        PageFactory.initElements(driver, this);
    }
}
