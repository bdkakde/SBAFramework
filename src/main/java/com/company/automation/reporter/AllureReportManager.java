package com.company.automation.reporter;

import com.company.automation.selenium.BasePage;
import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Objects;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

@Component
public class AllureReportManager extends BasePage {

    @Autowired
    private EnvironmentUtils environmentUtils;

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
                        .build(), System.getProperty("user.dir") + File.separator + "allure-results" + File.separator);

    }
    public void passStep(String message, Object... arg) {
        Allure.step(String.format(message, arg), Status.PASSED);
    }

    public void failStep(String message, Object... arg) {
        Allure.step(String.format(message, arg), Status.FAILED);
    }

}
