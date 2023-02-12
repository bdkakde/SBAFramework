package com.company.automation.listerners;

import com.company.automation.reporter.AllureReportManager;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;



public class CustomCucumberListener implements ConcurrentEventListener {


    private final Logger LOGGER = LoggerFactory.getLogger(CustomCucumberListener.class);

    @Override
    public void setEventPublisher(EventPublisher publisher) {

        publisher.registerHandlerFor(TestRunStarted.class, this::testRunStartedHandler);
        publisher.registerHandlerFor(TestRunFinished.class, this::testRunFinishedHandler);

        publisher.registerHandlerFor(TestCaseStarted.class, this::scenarioStartedHandler);
        publisher.registerHandlerFor(TestCaseFinished.class, this::scenarioFinishHandler);

        publisher.registerHandlerFor(TestStepStarted.class, this::testStepStartedHandler);
        publisher.registerHandlerFor(TestStepFinished.class, this::testStepFinishedHandler);


    }

    private void scenarioStartedHandler(TestCaseStarted event) {
        if (event.getTestCase() != null) {
            TestCase testCase = event.getTestCase();
            String scenarioName = testCase.getName();
            LOGGER.info("********************************************************************");
            LOGGER.info("Scenario [{}] started", scenarioName);
            LOGGER.info("********************************************************************");
        }
    }

    private synchronized void scenarioFinishHandler(TestCaseFinished event) {
        if (event.getTestCase() != null) {
            TestCase testCase = event.getTestCase();
            String scenarioName = testCase.getName();
            LOGGER.info("********************************************************************");
            LOGGER.info("Scenario [{}] completed", scenarioName);
            LOGGER.info("SCENARIO : " + scenarioName + " -> " + event.getResult().getStatus());
            LOGGER.info("********************************************************************");
        }

    }

    private void testStepStartedHandler(TestStepStarted event) {
        if (event.getTestStep() instanceof PickleStepTestStep testStep) {
            String stepName = testStep.getStep().getText();
            LOGGER.info("STEP [{}] STARTED", stepName);
        }
    }

    private void testStepFinishedHandler(TestStepFinished event) {
        if (event.getTestStep() instanceof PickleStepTestStep testStep) {
            String stepName = testStep.getStep().getText();
            LOGGER.info("STEP [{}] {}", stepName, event.getResult().getStatus());
        }
    }

    private void testRunFinishedHandler(TestRunFinished event) {

        if (event.getInstant() != null) {
            Instant instance = event.getInstant();
        }
    }

    private synchronized void testRunStartedHandler(TestRunStarted event) {

        if (event.getInstant() != null) {
            Instant instance = event.getInstant();
        }
    }
}
