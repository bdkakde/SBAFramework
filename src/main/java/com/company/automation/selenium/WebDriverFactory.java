package com.company.automation.selenium;

import com.company.automation.listerners.CustomCucumberListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("!remote")
public class WebDriverFactory {

    private final Logger LOGGER = LoggerFactory.getLogger(WebDriverFactory.class);
    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
    public WebDriver initializeChromeDriver() {
        LOGGER.info("--- Initializing chrome driver ----");
        WebDriverManager.chromedriver().disableCsp().setup();
        return new ChromeDriver();
    }

    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "headless chrome")
    public WebDriver initializeHeadlessChromeDriver() {
        LOGGER.info("--- Initializing headless chrome driver ----");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true);
        WebDriverManager.chromedriver().disableCsp().setup();
        return new ChromeDriver(chromeOptions);
    }

    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "edge")
    public WebDriver initializeEdgeDriver() {
        LOGGER.info("--- Initializing edge driver ----");
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }
}
