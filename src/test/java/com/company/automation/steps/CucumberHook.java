package com.company.automation.steps;

import com.company.automation.reporter.AllureReportManager;
import com.company.automation.selenium.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.spring.CucumberContextConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@CucumberContextConfiguration
@SpringBootTest()
public class CucumberHook {

}
