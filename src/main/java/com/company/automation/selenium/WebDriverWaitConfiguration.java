package com.company.automation.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.time.Duration;

@Configuration
@Lazy
public class WebDriverWaitConfiguration {
    @Value("${explicit.wait}")
    private int explicitWait;

    @Bean
    @Scope("prototype")
    public WebDriverWait webdriverWait(WebDriver driver){
        return new WebDriverWait(driver, Duration.ofSeconds(explicitWait));
    }
}
