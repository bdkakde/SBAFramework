package com.company.automation.steps;

import com.company.automation.selenium.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.spring.CucumberContextConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest()
public class CucumberHook {

    private final Logger LOGGER = LoggerFactory.getLogger(CucumberHook.class);
    @After
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            LOGGER.info("FAILED SCENARIO: " + scenario);
        }
    }
}
