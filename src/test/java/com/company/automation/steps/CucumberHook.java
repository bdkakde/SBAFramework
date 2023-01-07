package com.company.automation.steps;

import com.company.automation.selenium.BaseDriver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.spring.CucumberContextConfiguration;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;

@CucumberContextConfiguration
@SpringBootTest()
public class CucumberHook extends BaseDriver {

    @After
    public void afterStep(Scenario scenario){
        if (scenario.isFailed()) {
            Allure.addAttachment(scenario.getName(), "image/png", new ByteArrayInputStream(
                    ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)), "png");
        }
    }
}
