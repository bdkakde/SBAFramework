package com.company.automation.selenium;

import com.company.automation.listerners.CustomCucumberListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

import java.io.File;
import java.net.Inet4Address;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

@Configuration
@Profile("!remote")
public class WebDriverFactory {

    private final Logger LOGGER = LoggerFactory.getLogger(WebDriverFactory.class);
    @Bean()
    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
    //@Scope("singleton")
    public WebDriver initializeChromeDriver() {
        LOGGER.info("--- Initializing chrome driver ----");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        WebDriverManager.chromedriver().disableCsp().setup();
        return new ChromeDriver(chromeOptions);
    }

    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "headless chrome")
    public WebDriver initializeHeadlessChromeDriver() {
        LOGGER.info("---- Execution on OS: " + System.getProperty("os.name"));
        LOGGER.info("--- Initializing headless chrome driver ----");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--headless");
        WebDriverManager.chromedriver().disableCsp().setup();
        return new ChromeDriver(chromeOptions);
    }

    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "remote chrome")
    public WebDriver initializeHeadlessRemoteChromeDriver() {

        LOGGER.info("--- Initializing headless chrome driver ----");
        LOGGER.info("--- Path: " + new File(".").getAbsolutePath());
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--headless");
        WebDriverManager.chromedriver().setup();
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
