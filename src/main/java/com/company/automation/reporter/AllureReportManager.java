package com.company.automation.reporter;

import com.company.automation.utils.Constants;
import com.company.automation.selenium.WebDriverFactory;
import com.company.automation.utils.EnvironmentUtils;
import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

@Component
public class AllureReportManager {

    @Autowired
    private EnvironmentUtils environmentUtils;

     public void setAllureEnvironmentInformation(WebDriver driver) {

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
                        .build(), System.getProperty("user.dir") + Constants.SEP + "allure-results" + Constants.SEP);
        System.out.println("Allure report environment is set up");
    }

    @Attachment(value = "Test screenshot", type = "image/jpg")
    public void takeScreenshotOfWebPage(WebDriver driver) {
        Allure.getLifecycle().addAttachment("screen", "image/jpg", null, ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));

    }


}
