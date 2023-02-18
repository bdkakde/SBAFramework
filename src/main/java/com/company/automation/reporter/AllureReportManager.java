package com.company.automation.reporter;

import com.company.automation.listerners.CustomCucumberListener;
import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.model.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Objects;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

@Component
public class AllureReportManager {

    @Autowired
    EnvironmentUtils environmentUtils;

    @Autowired
    protected WebDriver driver;

    @Value("${screenshot.after.every.step}")
    private String screenShotAfterEveryStep;

    private final Logger LOGGER = LoggerFactory.getLogger(AllureReportManager.class);

    public void setAllureEnvironmentInformation() {

        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", environmentUtils.getBrowserName(driver))
                        .put("Browser Version", environmentUtils.getBrowserVersion(driver))
                        .put("Operating System", environmentUtils.getPlatform())
                        .put("OS Architecture", environmentUtils.getOSArchitecture())
                        .put("Java Version", environmentUtils.getJavaVersion())
                        .put("Web driver Version", environmentUtils.getWebDriverBuildVersion())
                        .put("Browser Driver Version", environmentUtils.getBrowserDriverVersion(driver))
                        .put("Executed By", environmentUtils.getSystemUser())
                        .put("Home Name", Objects.requireNonNull(environmentUtils.getHostName()))
                        .put("IP Address", Objects.requireNonNull(environmentUtils.getSystemIpAddress()))
                        .build(), System.getProperty("user.dir") + File.separator + "target" + File.separator + "allure-results" + File.separator);

    }

    public void passStep(String message, Object... arg) {
        Allure.step(String.format(message, arg), Status.PASSED);
    }

    public void failStep(String message, Object... arg) {
        Allure.step(String.format(message, arg), Status.FAILED);
    }

    @Attachment(value = "Test screenshot", type = "image/jpg")
    public void takeScreenShot() {
        Allure.getLifecycle().addAttachment("screen", "image/jpg", "jpg", ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
    }
}
