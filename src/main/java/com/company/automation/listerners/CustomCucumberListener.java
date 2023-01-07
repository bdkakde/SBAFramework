package com.company.automation.listerners;
import com.company.automation.reporter.AllureReportManager;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


public class CustomCucumberListener implements ConcurrentEventListener {

    @Autowired
    @Lazy
    AllureReportManager allureReportManager;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public void setEventPublisher(EventPublisher publisher) {

        publisher.registerHandlerFor(TestCaseStarted.class, this::scenarioStartedHandler);
        publisher.registerHandlerFor(TestCaseFinished.class, this::scenarioFinishHandler);

        publisher.registerHandlerFor(TestStepStarted.class, this::testStepStartedHandler);
        publisher.registerHandlerFor(TestStepFinished.class, this::testStepFinishedHandler);

        publisher.registerHandlerFor(TestRunFinished.class, this::testRunFinishedHandler);
    }

    private void scenarioStartedHandler(TestCaseStarted event) {
        if (event.getTestCase() != null) {
            TestCase testCase = event.getTestCase();
            String scenarioName = testCase.getName();
            LOGGER.info("Scenario [{}] started", scenarioName);
        }
    }

    private synchronized void scenarioFinishHandler(TestCaseFinished event) {
        if (event.getTestCase() != null) {
            TestCase testCase = event.getTestCase();
            String scenarioName = testCase.getName();
            LOGGER.info("Scenario [{}] completed", scenarioName);
        }
        //allureReportManager.setAllureEnvironmentInformation();
    }

    private  void testStepStartedHandler(TestStepStarted event) {
        if (event.getTestStep() instanceof PickleStepTestStep testStep) {
            String stepName = testStep.getStep().getText();
            LOGGER.info("STEP [{}] STARTED", stepName);
        }
    }

    private  void testStepFinishedHandler(TestStepFinished event) {
        if (event.getTestStep() instanceof PickleStepTestStep testStep) {
            String stepName = testStep.getStep().getText();
            LOGGER.info("STEP [{}] FINISHED", stepName);
        }
    }

    private void testRunFinishedHandler(TestRunFinished event) {

        //allureReportManager.setAllureEnvironmentInformation();
        if (event.getInstant() != null) {
            Instant instance = event.getInstant();
        }
    }
}
